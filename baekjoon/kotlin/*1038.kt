package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 5 감소하는 수
// 브루트포스의 방법으로 문제를 해결하면 됨
// 총 개수: 10개의 숫자(0~9) 중에서 1개 이상을 뽑는 모든 조합의 수는 2¹⁰ - 1 = 1023개 입니다. (0을 포함하면 1024개)
// 만들 수 있는 감소하는 수의 총 개수는 1023개 밖에 되지 않습니다. (0부터 시작하면 0번째~1022번째)
// n번쨰 수이기 떄문에 1022번째 까지 확인
fun main(){
    val n = readln().toInt()
    if (n > 1022) {
        println(-1)
        return
    }
    val list = mutableListOf<Long>(0,1,2,3,4,5,6,7,8,9) // 초기값
    val queue = ArrayDeque<Long>()
    for(i in 1 .. 9) // 초기에 큐에 넣어줌
        queue.add(i.toLong())

    // bfs 방법으로 모든 수를 구하기
    while (queue.isNotEmpty()){
        val poll = queue.removeFirst()
        val last = poll % 10 // 맨 마지막 자리 수

        for(i in 0 until last){ // 감소하는 수가 되도록 맨 마지막 자리수 보다 작은 숫자들만 넣음
            val new = poll * 10 + i
            list.add(new)
            queue.add(new)
        }
    }

    println(list[n])

}