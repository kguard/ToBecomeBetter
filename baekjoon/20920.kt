package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 실버 3
// sortedWith 사용법
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val count = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<String>()
    repeat(count[0])
    { list.add(br.readLine()) }
    val result =
        list.filter { it.length >= count[1] }.groupingBy { it }.eachCount().toList().sortedWith(
            compareByDescending<Pair<String, Int>> { it.second }.thenByDescending { it.first.length }
                .thenBy { it.first })
    for (i in result)
        bw.write("${i.first}\n")
    bw.flush()
    bw.close()
}