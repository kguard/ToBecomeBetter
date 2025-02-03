package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

// 실버 4 solved.ac
// 수학, 구현, 정렬
// 위에 15%, 아래 15%를 제거 해서 나머지로 평균 구하기
// 위 아래 각각 15%를 제거 하지 않고 리스트 슬라이싱으로 문제 해결 -> 시간초과
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Int>()
    if (n == 0)
        println(0)
    else {
        repeat(n) {
            list.add(br.readLine().toInt())
        }
        val p = (n * 15 / 100.0).roundToInt()
        list.sort()
//        repeat(p) {  시간 초과 -> remove는 시간 복잡도가 O(n)
//            list.removeAt(0)
//            list.removeAt(list.lastIndex)
//        }
        println( list.slice(p..n-(p+1)).average().roundToInt()) // 리스트 슬라이싱을 사용해서 범위 구함
    }
}