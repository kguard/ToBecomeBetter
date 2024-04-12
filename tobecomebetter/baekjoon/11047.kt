package com.kguard.tobecomebetter.baekjoon

//실버 4
// 그리디 알고리즘 -> 최적의 수를 사용해서 문제 해결
// 숫자를 내림차순으로 정령한 다음 몫과 나머지를 이용해서 문제 해결
fun main() {
    var (n, k) = readln().split(" ").map { it.toInt() }
    val money = mutableListOf<Int>()
    var count = 0
    repeat(n) {
        money.add(readln().toInt())
    }
    money.reverse()
    while (k != 0) {
        for (i in money) {
            if (k / i > 0) {
                count += k / i
                k %= i
                break
            }
        }
    }
    println(count)
}