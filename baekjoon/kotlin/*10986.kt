package com.kguard.tobecomebetter.baekjoon


// 골드 3
// 누적 합에서 나머지 갯수를 세는 배열을 만들어서, 나머지가 같은 누적합 끼리 뺴면 나누어 떨어지는 한 쌍을 만들 수 있음
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toLong() }
    var count: Long = 0
    val sum = MutableList<Long>(n + 1) { 0 } // 누적 합에서 수를 나눈 나머지
    val rest = MutableList<Long>(m) { 0 } // 나머지의 갯수를 세는 배열 -> 인덱스가 나머지를 가르킴
    for (i in 1..n) {
        sum[i] = (sum[i - 1] + list[i - 1]) % m
        if (sum[i].toInt() == 0)  // 0 번째 부터 i 번째 까지의 합에서 수를 나눈 나머지가 0이면 count++
            count++
        rest[sum[i].toInt()]++  // 나머지가 같은 누적합을 모아 놓기
    }
    for (i in rest.indices) {
        count += rest[i] * (rest[i] - 1) / 2 // 나머지가 같은 누적합에서 2개를 짝지은 경우의 수
    }
    println(count)
}
/*
fun main() {
    val n = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var count = 0
    var sum = arrayOf<Int>()
    sum += 0
    for (i in 0 until n[0])
        sum += (sum[i] + list[i])
    for (i in 1 until sum.size) {
        for (j in 0 until i) {
            if ((sum[i] - sum[j]) % n[1] == 0) {
                count++
            }
        }
    }
    println(count)
}*/
