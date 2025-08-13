package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 실버 4 비밀번호 찾기
// 자료 구조, 해시를 사용한 집합과 맵
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val hash = hashMapOf<String,String>()
    repeat(n) {
        val (a,b) = br.readLine().split(" ")
        hash[a] = b
    }
    repeat(m) {
        bw.write("${hash[br.readLine()]}\n")
    }
    bw.flush()
    bw.close()
}