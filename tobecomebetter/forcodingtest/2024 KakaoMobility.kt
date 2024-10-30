package com.kguard.tobecomebetter.forcodingtest

fun main(){
    // 1. union - find를 참고하여서 문제 해결 -> 재귀 함수
//    val t = listOf(0,0,0,0,2,3,3)
//    val a = listOf(2,5,6)
//    val set = mutableSetOf<Int>()
//    set.add(0)
//    fun find(x: Int) { // 0 이 나올때 까지 find 함수를 반복
//         if (t[x] == 0) {
//            set.add(x)
//        } // 찾는 값에 대한 부모가 같음 -> 자기 자신
//        else {
//            set.add(t[x])
//           find(t[x])
//        }
//    }
////    set.add(find(6))
//
//    a.forEach { set.add(it)
//    find(it)}
//    println(set)

    // 2.
//    var count = 1
//    val sk1 = mutableListOf(4,2,7,3,1,8,6,5,9,10)
//    val sk = mutableListOf(4,2,7,3,1,8,6,5,9,10)
//    val round = MutableList(sk.size){1}
//    while(true){
//        if(sk.size == 2){ // 마지막 라운드가 되면 라운드 수 넣고 끝내기
//            for(i in sk)
//                round[sk1.indexOf(i)] = count
//            break
//        }
//        println(count)
//        for(i in 0 until sk.size-1 step 2){ // 2개씩 짝 지어서 더 작은 값을 0 으로 만들어 버리기
//            println(sk.size)
//            println(sk)
//            val min = (min(sk[i],sk[i+1]))
//            round[ sk1.indexOf(min)]=count // 더 작은값 부분에 라운드수 추가
//            sk[sk.indexOf(min)] = 0
//        }
//        sk.removeAll(listOf(0))
//        count++
//    }
//    println(round)
    //3.
    // 일단 2차원 배열로 생성, 그 다음 화살표를 확인 하여서 화살표에 해당 하는 좌표를 다 기억 했다가 한번에 X로 변경, 그 후 bfs를 실행하여 문제 해결
    val b= arrayOf("X.....>","..v..X.",".>..X..","A......")
    val board = mutableListOf<MutableList<String>>()
    var a = Pair(0,0)
    val change = mutableSetOf<Pair<Int,Int>>()
    b.forEach { val l = it.split("").toMutableList()
            l.removeFirst()
            l.removeLast()
            board.add(l)
    }
    for(i in board.indices)
        for(j in board[i].indices){
            when(board[i][j])
            {
                ">" -> {
                    for (t in j+1 until board[i].size) {
                        println(board[i][t] )
                        if(board[i][t] == "." || board[i][t] == "A" )
                            change.add(Pair(i,t))
                        else{ break }

                    }
                }
                "<" ->  for(t in j-1 downTo 0){
                    if(board[i][t] == "." || board[i][t] == "A" )
                        change.add(Pair(i,t))
                    else{ break }
                }
                "^" -> for(t in i-1 downTo  0){
                    if(board[t][j] == "." || board[t][j] == "A" )
                        change.add(Pair(t,j))
                    else{ break }
                }
                "v" -> for(t in i+1 until board.size){
                    if(board[t][j] == "." || board[t][j] == "A" )
                        change.add(Pair(t,j))
                    else{ break }
                }
                "A" -> a = Pair(i,j)

            }
        }
    for(i in change) board[i.first][i.second] = "X"
    if(board[a.first][a.second] == "X")
        println(false)
    else{
        val moveHeight = mutableListOf(1, -1, 0, 0) // 아래, 위로 이동 하는 부분
        val moveWidth = mutableListOf(0, 0, 1, -1) // 오른쪽, 왼쪽으로 이동하는 부분
        val queue = mutableListOf<Pair<Int, Int>>()
        val visited = MutableList(board.size) { MutableList(board[0].size) { false } }
        queue.add(a)
        visited[a.first][a.second] = true
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            for (i in 0 until 4) { // 상하좌우로 움직이기 위해 반복
                val ny = moveHeight[i] + poll.first // 아래, 위
                val nx = moveWidth[i] + poll.second // 오른쪽, 왼쪽
                if (ny in 0 until board.size && nx in 0 until board[0].size && board[ny][nx] == "." && !visited[ny][nx]) //  상하좌우로 움직인 좌표가 인덱스 안에 있고, 움직인 좌표가 찾는 숫자 이고, 방문하지 않았으면
                {
                    queue.add(Pair(ny, nx))
                    visited[ny][nx] = true
                }
            }
        }
        println(visited[board.size - 1][board[0].size - 1])
    }
    for(i in board)
        println(i)

}