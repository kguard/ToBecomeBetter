package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 실버 5 배열 합치기
// 정렬, 두 포인터
// 배열을 합치지 않고 투 포인터를 이용해서 출력하기
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuffer()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }
    val b = br.readLine().split(" ").map { it.toInt() }
    var aIndex = 0
    var bIndex = 0
    while (aIndex < n && bIndex < m) {
        if (a[aIndex] < b[bIndex])
            sb.append("${a[aIndex++]} ")
        else
            sb.append("${b[bIndex++]} ")
    }
    if (aIndex < n)
        for (i in aIndex until n)
            sb.append("${a[i]} ")
    else if (bIndex < m)
        for (i in bIndex until m)
            sb.append("${b[i]} ")

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}

// 기존 풀이 -> 배열을 합쳐서 출력 함
//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter

//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val bw = BufferedWriter(OutputStreamWriter(System.out))
//    val sb = StringBuffer()
//    val (n, m) = br.readLine().split(" ").map { it.toInt() }
//    val a = br.readLine().split(" ").map { it.toInt() }.toMutableList()
//    br.readLine().split(" ").map { a.add(it.toInt()) }
//    a.sorted().forEach { sb.append("$it ") }
//    bw.write(sb.toString())
//    bw.flush()
//    bw.close()
//}