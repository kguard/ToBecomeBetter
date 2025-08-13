package com.kguard.tobecomebetter.baekjoon
//실버3
import kotlin.math.round

fun main() {
    val size = readln().toInt()
    val list = mutableListOf<Int>()
    repeat(size)
    { list.add(readln().toInt()) }
    list.sort()
    val a = list.groupingBy { it }.eachCount().toList().sortedByDescending { it.second } // 리스트의 각 원소들의 개수를 세워준다음 갯수별로 내림차순으로 정렬
    println(round(list.average()).toInt()) // round() -> 반올림을 구하는 함수
    println(list[size / 2])
    println(
        if (a.size > 1) {
            if (a[0].second == a[1].second)
                a[1].first
            else
                a[0].first
        } else
            a[0].first
    )
    println(list.last() - list.first())
}