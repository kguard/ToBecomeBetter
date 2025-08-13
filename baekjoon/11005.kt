package com.kguard.tobecomebetter.baekjoon

fun main(){
    val a = readln().split(" ")
    val sum = mutableListOf<String>()
    var whole = a[0].toLong()
    while(whole >= a[1].toInt() )
    {
        sum.add((whole % a[1].toInt()).toString())
        whole /= a[1].toInt()
    }
    sum.add((whole % a[1].toInt()).toString())
    sum.replaceAll {
        if(it.toInt() >= 10)
            (it.toInt() + 55).toChar().toString()
        else
            (it.toInt() + 48).toChar().toString()
    }
    for(i in sum.reversed())
        print(i)
}