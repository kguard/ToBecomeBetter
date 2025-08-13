package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 골드 1 합성함수와 쿼리
// 자료 구조, 희소 배열
// sparse table 을 구하는 문제
// st는 각 function의 결과를 저장해 놓은 2차원 배열
// x 축은 각 function의 결과, y축은 2의 진수들을 의미
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val m = br.readLine().toInt()
    val function = br.readLine().split(" ").map { it.toInt() }
    val q = br.readLine().toInt()
    val st = Array(20) { Array(m+1) { 0 } }  //log2(500000) => 19 -> 각 y축 별로 2의 진수를 뜻함
    for (i in 1..m)
        st[0][i] = function[i - 1]  // 초기에 function 집어 넣기
    for (i in 1..19)
        for (j in 1..m)
            st[i][j] = st[i - 1][st[i - 1][j]] // st의 현재 index는 이전거의 index를 의미
    repeat(q) {
        var (n, x) = br.readLine().split(" ").map { it.toInt() }
        for (i in 0..19)
            if (n and (1 shl i) >= 1) // n을 이진수를 변환하여 각 자리수가 1인 부분에서
                x = st[i][x] // 계속해서 변경해주기
        bw.write("$x\n")
    }
    bw.flush()
    bw.close()
}
