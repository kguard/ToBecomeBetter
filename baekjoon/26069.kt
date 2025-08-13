package com.kguard.tobecomebetter.baekjoon
//실버 4
fun main() {
    val set = mutableSetOf<String>()
    repeat(readln().toInt())
    {
        val n = readln().split(" ")
        if("ChongChong" in n)
            set.addAll(n)
        n.forEach {
            if(it in set)
                set.addAll(n)
        }
    }
    println(set.size)
}