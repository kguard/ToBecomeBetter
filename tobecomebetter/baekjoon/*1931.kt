package com.kguard.tobecomebetter.baekjoon

//실버 1
// 그리디 알고리즘
// 종료 시간이 빠를 수록 좋음
// 종료 시간을 기준으로 정렬
// 시작 시간이 겹치지 않으면서 제일 빨리 끝나는 시간을 찾아야 됨
// 시작 시간이 종료 시간과 같거나 크면 count +1
fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    var count = 0
    var prevEnd = -1
    repeat(n)
    {
        val (a, b) = readln().split(" ").map { it.toInt() }
        list.add(Pair(a, b))
    }
    list.sortWith(compareBy({ it.second }, { it.first }))
    for (i in list) {
        if (i.first >= prevEnd) {
            prevEnd = i.second
            count++
        }
    }
    println(count)
}