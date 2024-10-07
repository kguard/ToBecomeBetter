package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 실버 5 집합
// 구현, 비트마스킹
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val m = br.readLine().toInt()
    val set = mutableSetOf<Int>()
    repeat(m){
        when(val command = br.readLine()){
            "all" -> { repeat(20) {set.add(it+1)} }
            "empty" -> {set.clear()}
            else -> {
                val (cm , num) = command.split(" ")
                when(cm){
                    "add" ->{set.add(num.toInt())}
                    "remove" -> {set.remove(num.toInt())}
                    "check" -> {if(num.toInt() in set) bw.write("1\n") else  bw.write("0\n")}
                    "toggle" -> {if(num.toInt() in set) set.remove(num.toInt()) else set.add(num.toInt())}
                }
            }
        }
    }
    bw.flush()
    bw.close()
}