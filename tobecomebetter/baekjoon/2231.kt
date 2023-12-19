package com.kguard.tobecomebetter.baekjoon

// 각 자리가 최소 (n- 자릿수*9 부터 시작) 이다.
// https://st-lab.tistory.com/98

fun main() {
    val n = readln()
    var result = n.toInt()
    for (i in n.toInt() downTo 0) {
        val list = i.toString().split("").toMutableList()
        list.removeAll(listOf(""))
        val sum = i + list.sumOf { it.toInt() }
        if (sum == n.toInt() && result > i)
            result = i
    }
    if (result == n.toInt())
        result = 0
    println(result)
}
//fun main() {
//    val n = readln()
//    var result = 0
//    for (i in 0..n.toInt()) {
//        val list = i.toString().split("").toMutableList()
//        list.removeAll(listOf(""))
//        val sum = i + list.sumOf { it.toInt() }
//        if (sum == n.toInt()) {
//            result = i
//            break
//        }
//    }
//    println(result)
//}