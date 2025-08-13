package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 실버 1
// 2차원 배열에 대한 누적 합으로 구해야됨
// [x][y]= [x-1][y]+[x][y-1]-[x-1][y-1]
// (x1,y1) 에서 (x2,y2) 까지의 크기는 [x2][y2] 에서 해당 되지 않는 [x2][y1-1] 와 [x2][y1-1]를 빼주고 [x1-1][y1-1]은 두번 빼지니 한 번 더함
// [x2][y2] - [x2][y1-1] - [x2][y1-1] + [x1-1][y1-1]
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val sum = Array(n + 1) { IntArray(n + 1) { 0 } }
    for (i in 1..n) {
        val list = br.readLine().split(" ").map { it.toInt() }
        for (j in 1..n)
            sum[i][j] = list[j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1]
    }
    repeat(m) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1]}\n")
    }
    bw.flush()
    bw.close()
}

// 각 줄에 대한 누적 합을 이용해서 문제를 해결하려 함 -> 실패
/*
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val sum = mutableListOf<MutableList<Int>>()
    repeat(n) {
        val t = mutableListOf<Int>()
        val l = readln().split(" ").map { it.toInt() }
        t.add(0)
        for (i in 0 until n)
            t.add(t[i] + l[i])
        sum.add(t)
    }
    repeat(m) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
//        println(sum[x1 - 1][y2] - sum[x1 - 1][y1 - 1] + sum[x2 - 1][y2] - sum[x2 - 1][y1 - 1])
        var count = 0
        for (i in x1 - 1..<x2) {
            count += sum[i][y2] - sum[i][y1 - 1]
        }
        println(count)
    }
}*/
