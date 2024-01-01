package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val mapper = mutableMapOf<String, String>()
    val rMapper = mutableMapOf<String,String>()

    repeat(a) {
        val a = br.readLine()
        mapper[a] = (it+1).toString()
        rMapper[(it+1).toString()] = a
    }
    repeat(b){
        val q = br.readLine()
        if(q[0].isDigit()) // 문자열이 숫자인지 확인 하는 함수  isalpha(): 문자열이 문자인지 확인 하는 함수
            bw.write("${rMapper[q]}\n")
        else
            bw.write("${mapper[q]}\n")
    }
    bw.flush()
    bw.close()
}