package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.PriorityQueue


// 골드 4 카드 정렬하기
// 작은 수가 반복되는게 정답이 최소가 되는 경우
// 근데 단순히 한번 정렬 후에 하면 더한 값이 나중 값보다 클 수 있기 때문에 그러면 안됨
// 정렬 -> 계산을 반복하면 터짐
fun main() {
    val n = readln().toInt()
    val pq = PriorityQueue<Int>()
    var sum = 0
    repeat(n) {
        pq.add(readln().toInt())
    }
    while (pq.size >= 2) {
        val a = pq.poll()
        val b = pq.poll()
        sum += a + b
        pq.offer(a+b)
    }
    println(sum)
}