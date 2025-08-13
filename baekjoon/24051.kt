package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 알고리즘 수업 - 삽입 정렬 1
// 구현, 정렬, 시뮬레이션
// 삽입정렬 알고리즘
private fun insertionSort(a: IntArray, k: Int): Int {
    var count = 0
    for (i in 1 until a.size) {
        var loc = i - 1 // 새로운 숫자와 계속 비교될 인덱스의 시작
        val newItem = a[i]
        // 이 지점에서 a[0..i-1]은 이미 정렬되어 있는 상태
        while (0 <= loc && newItem < a[loc]) {  // loc가 맨 처음 보다 크고, 새로운 숫자가 이전 숫자들 보다 작을 때 반복
            a[loc + 1] = a[loc] // 새로운 숫자가 이전 숫자보다 크기 떄문에 숫자를 옮기기
            count++
            if (count == k) return a[loc]
            loc--
        }
        if (loc + 1 != i) { // i번째가 마지막이지 않으면 -> 새로운 숫자가 제일 큰 숫자 이면 실행X -> 새로운 숫자 위치 잡기
            a[loc + 1] = newItem
            count++
            if (count == k) return newItem
        }
    }
    return -1
}

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }.toIntArray()
    println(insertionSort(a, k))
}