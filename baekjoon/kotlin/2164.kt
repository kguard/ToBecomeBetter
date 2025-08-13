package com.kguard.tobecomebetter.baekjoon

//( max - 2.0 * log2(max) -1 ) * 2
// 알정 규칙이 있음
// 1 / 2 / 2 4 / 2 4 6 8 / 2 4 6 8 10 12 14 16
import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.pow

fun main() {
    val max = readln().toDouble()
    val t1 =2.0.pow(ceil(log2(max)).toInt()-1)
    println(((max-t1)*2).toInt())
}