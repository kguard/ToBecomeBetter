package com.kguard.tobecomebetter.baekjoon

fun main() {
    val count = readln().toInt()
    for (i in 1..count) {
        repeat(((2 * count - 1) - (2 * i - 1)) / 2)
        {
            print(" ")
        }
        repeat(2 * i - 1)
        {
            print("*")
        }
        println()
    }
    for (i in count - 1 downTo (1)) {
        repeat(((2 * count - 1) - (2 * i - 1)) / 2)
        {
            print(" ")
        }
        repeat(2 * i - 1)
        {
            print("*")
        }
        if(i == 1)
            break
        println()
    }
}