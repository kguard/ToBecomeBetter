package com.kguard.tobecomebetter.swea

fun main(){
    val tc = readln().toInt()
    repeat(tc){
        val (n,k) = readln().split(" ").map { it.toInt() }
        val list = readln().split(" ").map { it.toInt() }
        val list2 = mutableListOf<Pair<Int,Int>>()
        var count = 0
        for(i in 0 until n)
            for(j in 0 until n)
                list2.add(Pair(list[i],list[j]))
        list2.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        for(i in list2) {
//            if (count == k) {
//                println(i.first + i.second)
//                break
//            }
//            else
//                count ++
            println(i)
        }
    }
}