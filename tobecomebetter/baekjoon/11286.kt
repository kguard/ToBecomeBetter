package com.kguard.tobecomebetter.baekjoon

import java.util.*
import kotlin.math.abs


// 실버 1
// 자료 구조, 우선 순위 큐
// 정렬 기준이 중요한 문제
fun main() {
    val n = readln().toInt()
//    val queue = PriorityQueue<Int>(compareBy<Int> { abs(it) }.thenBy { it }) // 절대값 순으로 정렬 한 다음에, 절대 값이 같은 경우 더 작은 값이 먼저 오도록 설정
    val queue = PriorityQueue<Int>(Comparator { a, b ->
        when { // a 가 새로운 값 b가 기존 값
            // 우선 순위를 리턴, 더 작을 수록 먼저 출력
            abs(a) == abs(b) -> a - b // 절대 값이 같은 경우 라면, 더 작은 값이 앞으로 나와야 하기 때문에, a-b가 양수면 a를 나중에 저장 하고, 음수이면 a를 먼저 저 (오름차순)
            else -> abs(a) - abs(b) // 절대 값이 더 작은 거 먼저 저장, a>b 이면 a를 나중에 저장, a<b이면 a를 먼저 저장 (오름차순 정렬 생각)
        }
    })
    repeat(n) {
        val a = readln().toInt()
        if (a == 0) {
            if (queue.isEmpty())
                println(0)
            else
                println(queue.poll())
        } else {
            queue.add(a)
        }
    }
}