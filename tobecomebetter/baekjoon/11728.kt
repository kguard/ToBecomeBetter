package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 실버 5 배열 합치기
// 정렬, 두 포인터
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuffer()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    br.readLine().split(" ").map { a.add(it.toInt()) }
    a.sorted().forEach { sb.append("$it ") }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}