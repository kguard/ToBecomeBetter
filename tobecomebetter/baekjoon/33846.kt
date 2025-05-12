package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 실버 5 삽입 정렬을 해볼까
// 정렬
// 문제는 삽입정렬이지만 그냥 kotlin에서 제공하는 sort()를 사용해서 문제 해결
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, t) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    a.sort(0,t)
    a.forEach { bw.write("$it ") }
    bw.flush()
    bw.close()
}

//private fun insertionSort(a: IntArray, t: Int) {
//    for (i in 1..t) {
//        var loc = i - 1 // 새로운 숫자와 계속 비교될 인덱스의 시작
//        val newItem = a[i]
//        // 이 지점에서 a[0..i-1]은 이미 정렬되어 있는 상태
//        while (0 <= loc && newItem < a[loc]) {  // loc가 맨 처음 보다 크고, 새로운 숫자가 이전 숫자들 보다 작을 때 반복
//            a[loc + 1] = a[loc] // 새로운 숫자가 이전 숫자보다 크기 떄문에 숫자를 옮기기
//            loc--
//        }
//        if (loc + 1 != i) // i번째가 마지막이지 않으면 -> 새로운 숫자가 제일 큰 숫자 이면 실행X -> 새로운 숫자 위치 잡기
//            a[loc + 1] = newItem
//    }
//    a.forEach { print("$it ") }
//}
