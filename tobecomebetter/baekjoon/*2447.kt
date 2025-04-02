package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 골드 3 별 찍기 - 10
// 분할 정복, 재귀
// 문제를 좌표로 푸는 것이 맞음
private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
    val n = br.readLine().toInt()
    for (y in 0 until n) {
        for (x in 0 until n) {
            star(x, y, n)
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}

private fun star(x: Int, y: Int, s: Int) { // 재귀 방식으로 풀기
    if ((x / s) % 3 == 1 && (y / s) % 3 == 1)
        bw.write(" ")
    else if (s / 3 == 0)
        bw.write("*")
    else
        star(x, y, s / 3) // 제귀 하는 부분
}