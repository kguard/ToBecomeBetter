// DFS, BFS 문제
// DFS로 구현
// 정사각형의 판을 하나씩 돌면서 찾으려는 숫자의 x,y좌표를 모음 (dfs로 탐색)
// dfs에서는 상하좌우로 이동하며 원하는 숫자가 있는지 탐색
// 찾은 좌표들을 가지고, 딱 맞는 2차원 배열을 생성
// 2차원 배열 들의 블록을 하나씩 돌려보며 맞는 구멍이 있는지 확인
// 있으면 넓이를 더하고, 구멍을 매우고, 다음 블록으로 넘어감
class Solution {

    private fun rotate(board: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> { // 2차원 배열을 90도로 돌리는 함수
        val rotated = MutableList(board[0].size) { MutableList(board.size) { 0 } }
        for (i in board.indices)
            for (j in board[0].indices)
                rotated[j][board.size - i - 1] = board[i][j]
        return rotated
    }

    private val moveHeight = mutableListOf(1, -1, 0, 0) // 아래, 위로 이동 하는 부분
    private val moveWidth = mutableListOf(0, 0, 1, -1) // 오른쪽, 왼쪽으로 이동하는 부분
    fun dfs( // 깊이 우선 탐색
        list: Array<IntArray>,
        find: Int,
        x: Int,
        y: Int,
        check: MutableList<Pair<Int, Int>>,
        visited: MutableList<MutableList<Boolean>>  // 2차원 배열을 만들 좌표를 구하는 함수
    ) {
        visited[x][y] = true // 처음 위치 방문
        check.add(Pair(x, y)) // x, y 좌표 추가
        for (i in 0 until 4) { // 상하좌우로 움직이기 위해 반복
            val nx = moveHeight[i] + x // 아래, 위
            val ny = moveWidth[i] + y // 오른쪽, 왼쪽
            if (nx in list.indices && ny in list.indices && list[nx][ny] == find && !visited[nx][ny]) //  상하좌우로 움직인 좌표가 인덱스 안에 있고, 움직인 좌표가 찾는 숫자 이고, 방문하지 않았으면
                dfs(list, find, nx, ny, check, visited) // 깊이 탐색
        }
    }

    private fun findBlock( // 맞는 모든 블록의 좌표들
        board: Array<IntArray>,
        find: Int
    ): MutableList<MutableList<Pair<Int, Int>>> {
        val visited = MutableList(board.size) { MutableList(board.size) { false } } // 방문했는지 확인하는 리스트
        val exBoard = mutableListOf<MutableList<Pair<Int, Int>>>() // 블록들을 좌표로 해 놓은 것들
        for (i in board.indices) // 보드를 돌면서
            for (j in board.indices)
                if (board[i][j] == find && !visited[i][j]) { // 보드의 값이 원하는 값이고, 방문하지 않았으면
                    val check = mutableListOf<Pair<Int, Int>>()
                    dfs(board, find, i, j, check, visited) // 보드의 값을 기준으로 블록을 인덱스로 찾기
                    exBoard.add(check)
                }
        return exBoard
    }

    private fun makeBlock(check: MutableList<Pair<Int, Int>>): MutableList<MutableList<Int>> { // 만든 좌표를 가지고 딱 맞는 2차원 배열을 만드는 함수
        val height = check.maxOf { it.first } - check.minOf { it.first } + 1 // 딱 맞는 2차원 배열을 만들기 위해서 최대값 - 최소값 +1 -> 열 갯수
        val width = check.maxOf { it.second } - check.minOf { it.second } + 1// 행 갯수
        val block = MutableList(height) { MutableList(width) { 0 } } // 2차원 배열 생성
        for (t in check)
            block[check.maxOf { it.first } - t.first][check.maxOf { it.second } - t.second] = 1 // 좌표들을 지정된 위치에 저장
        return block
    }


    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        var answer = 0
        val exTable = findBlock(table, 1) // table 에서 1인 것들의 인덱스로 된 블록들
        val exBoard = findBlock(game_board, 0).map { makeBlock(it) }.toMutableList() // game_board에서 0인 것들의 블록들을 2차원 배열들로 구현 한것들
        for(i in exTable){
            var t = makeBlock(i) // 각 인덱스로 된 블록을 2차원 배열로 생성
            for(r in 0 until 4){
                t = rotate(t) // 90도로 돌리는거 360도 까지
                if(t in exBoard){ // 돌린것들이 구멍에 맞는게 있으면
                    for(a in t)
                        answer+= a.count { it ==1 } // 넓이를 더하기
                    exBoard.remove(t) // 구멍을 메우기
                    break // 다른 구멍에 넣지 않기 위해서 다음으로 넘어감
                }
            }
        }
        return answer
    }
}

