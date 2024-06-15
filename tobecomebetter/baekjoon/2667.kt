package com.kguard.tobecomebetter.baekjoon

// 실버 1 단지번호붙이기
// 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
// 상하좌우로 이동하며 dfs 실행
fun main(){
    val n = readln().toInt()
    val list = mutableListOf<MutableList<Int>>()
    val visited = MutableList(n){MutableList(n){false}}
    val count = mutableListOf<Int>()
    var c = 0
    repeat(n){
        val a = readln().split("").toMutableList()
        a.removeFirst()
        a.removeLast()
        list.add(a.map { it.toInt() }.toMutableList())
    }
    val moveHeight = mutableListOf(1, -1, 0, 0) // 아래, 위로 이동 하는 부분
    val moveWidth = mutableListOf(0, 0, 1, -1) // 오른쪽, 왼쪽으로 이동하는 부분
    fun dfs(x : Int, y: Int){
        visited[x][y] = true
        c++
        for (i in 0 until 4) { // 상하좌우로 움직이기 위해 반복
            val nx = moveHeight[i] + x // 아래, 위
            val ny = moveWidth[i] + y // 오른쪽, 왼쪽
            if (nx in list.indices && ny in list.indices && list[nx][ny] == 1 && !visited[nx][ny]) //  상하좌우로 움직인 좌표가 인덱스 안에 있고, 움직인 좌표가 찾는 숫자 이고, 방문하지 않았으면
                dfs(nx,ny) // 깊이 탐색
        }
    }
    for(i in list.indices)
        for(j in list.indices)
            if(list[i][j] == 1 && !visited[i][j]) {
                c = 0
                dfs(i, j)
                count.add(c)
            }
    println(count.size)
    count.sorted().forEach { println(it) }
}