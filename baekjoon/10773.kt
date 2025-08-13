package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stack = mutableListOf<Int>()
    repeat(br.readLine().toInt())
    {
        when(val n = br.readLine())
        {
            "0" -> stack.removeLast()
            else -> stack.add(n.toInt())
        }
    }
    bw.write("${stack.sum()}")
    bw.flush()
    bw.close()
}