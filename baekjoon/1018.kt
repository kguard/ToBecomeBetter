package com.kguard.tobecomebetter.baekjoon

fun main() {
    val size = readln().split(" ").map { it.toInt() }
    val board = mutableListOf<MutableList<String>>()
    repeat(size[0]) {
        val a = readln().split("").toMutableList()
        a.removeLast()
        a.removeFirst()
        board.add(a)
    }
    val counts = mutableListOf<Int>()
    for (i in 0 until size[0] - 7) {
        for (j in 0 until size[1] - 7) {
            // 전체 구조에 따라서 시작 지점의 색이 검은색이 유리한지, 하얀색이 유리한지 달라 질 수 있음
            var count_black = 0 // 시작 지점의 색이 검은 색일 떄 바뀌는 카운트
            var count_white = 0  // 시작 지점의 색이 하얀 색일 떄 바뀌는 카운트
            for (q in i..i + 7) {
                for (w in j..j + 7) {
                    if ((q + w) % 2 == 0) {  // 짝수 번째 일때, 시작 지점과 색이 같아야함
                        if (board[q][w] == "W") // 내색이 하얀색일 경우
                            count_black++ // 시작 지점의 색이 검은 색일 경우 색을 하얀색->검은색으로
                        else  // 내색이 검은색일 경우
                            count_white++  // 시작 지점의 색이 하얀 색일 경우 검은색->하얀색으로,
                    } else { // 홀 수 번째 일떄, 시작 지점과 색이 달라야함
                        if (board[q][w] == "W") // 내 색이 하얀색일 경우
                            count_white++ // 시작 지점의 색이 하얀색 이면 하얀색->검은색 으로
                        else // 내 색이 검은색일 경우
                            count_black++  // 시작 지점의 색이 검은 색일 경우 검은색->하얀색,
                    }
                }
            }
            counts.add(count_black)
            counts.add(count_white)
        }
    }
    print(counts.min())
}