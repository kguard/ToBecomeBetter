package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

//골드 5
private val br = BufferedReader(InputStreamReader(System.`in`))
private val bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
    val n = br.readLine().toInt()
    bw.write("${2.0.pow(n).toInt() - 1}\n")
    hanoi(n, 1, 3)  // n개를 1번에서 3번까지 이동
    bw.flush()
    bw.close()
}

fun hanoi(n: Int, start: Int, end: Int) {
    if (n == 1) {
        bw.write("$start $end\n")
        return
    }
    hanoi(n - 1, start, 6 - start - end) // n-1 개를 1번에서 2번으로 이동
    bw.write("$start $end\n") // n번째의 말을 3번으로 이동
    hanoi(n - 1, 6 - start - end, end) // n-1개를 2번에서 3번으로 이동
}