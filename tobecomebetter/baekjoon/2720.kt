package com.kguard.tobecomebetter.baekjoon

fun main() {
    val a = readln().toInt()
    repeat(a)
    {
        var money = readln().toInt()
        val q = money / 25
        money -= q*25
        val d = money / 10
        money -= d*10
        val n = money / 5
        money -= n*5
        val p = money / 1
        println("$q $d $n $p")
    }
}