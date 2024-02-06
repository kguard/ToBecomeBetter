package com.kguard.tobecomebetter.baekjoon
//실버 4
fun main() {
    val count = readln().toInt()
    var result = 0
    val set = mutableSetOf<String>()
    repeat(count)
    {
        val chat = readln()
        if (chat == "ENTER") {
            result += set.size
            set.clear()
        }
        else
            set.add(chat)
    }
    result += set.size
    println(result)
}