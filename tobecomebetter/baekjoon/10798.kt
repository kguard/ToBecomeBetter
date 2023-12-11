package com.kguard.tobecomebetter.baekjoon

fun main() {
    val list = mutableListOf<MutableList<String>>()
    var sol: String = ""
    repeat(5)
    {
        val t = readln().split("").toMutableList()
        t.removeFirst()
        t.removeLast()
        list.add(t.toMutableList())
    }
    val max = list.maxBy { it.size }.size
    for (i in list) {
        if (i.size < max) {
            repeat(max - i.size)
            {
                i.add("")
            }
        }
    }
    for (i in 0 until max) {
        for (j in list)
            sol += j[i]
    }
    println(sol)
}