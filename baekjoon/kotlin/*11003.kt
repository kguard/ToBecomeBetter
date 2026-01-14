package com.kguard.tobecomebetter.baekjoon.kotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

// 골드 1 최소값 찾기
// 자료 구조에 대해서 되게 민감한 문제
// 결국 덱을 사용하는 문제였지만, 안에 로직을 잘 정하는 부분이 중요했음
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out)) 
    val (n, l) = br.readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(br.readLine())
    val d = IntArray(n)
    for (i in 0 until n)
        d[i] = st.nextToken().toInt()
    val slice = ArrayDeque<Int>()
    val sb = StringBuilder()
    for (i in 0 until n) { // 인덱스를 기준으로 탐색

        if (slice.isNotEmpty() && slice.first() < i - l + 1) // 기간 안에 있는지 확인
            slice.removeFirst()

        while (slice.isNotEmpty() && d[slice.last()] >= d[i]) { // 어쩌피 지금 나보다 큰것들은 최소 값이 될 수 없으니 삭제
            slice.removeLast()
        }
        slice.add(i) // 덱에 추가
        sb.append(d[slice.first()]).append(" ") // 맨 앞에 있는 값이 결국 최소 값이 됨
    }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}