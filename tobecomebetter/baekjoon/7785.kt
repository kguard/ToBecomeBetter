package com.kguard.tobecomebetter.baekjoon

fun main(){
    val whole = readln().toInt()
    val persons = mutableSetOf<String>()
    repeat(whole)
    {
        val a = readln().split(" ")
        if(a[1] == "enter")
            persons.add(a[0])
        else if(a[1]== "leave")
            persons.remove(a[0])
    }
    for(i in persons.sortedDescending())
        println(i)
}