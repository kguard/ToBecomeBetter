package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.StringTokenizer

// 골드 2 오름세
// LIS를 구해야하는 문제
// LIS를 구할때 N은 최대 100,000이기 떄문에 dp를 사용하면 O(n^2)이기 떄문에 시간초과
// 이분 탐색 방법을 사용하면 됨
// 리스트 입력 받을 때 빈칸으로 받아져서 문제 발생 -> 입력이 더러움
fun main() {
    while (true) {
        val n = readlnOrNull()?.trim()
        if (n.isNullOrBlank()) break
        val st = StringTokenizer(readln()," ")
        val p = mutableListOf<Long>()
        while (st.hasMoreTokens()){
            p.add(st.nextToken().toLong())
        }
        val l = MutableList(n.toInt()) { 0L }
        var max = 0
        p.forEach { value ->
            var pos = l.binarySearch(value,0,max)  // l 배열의 [0, max) 범위에서 it이  들어갈 위치를 찾는다.

            if (pos < 0)
                pos = -(pos+1)

            l[pos] = value

            if (max == pos)
                max++
        }
        println(max)
    }
}