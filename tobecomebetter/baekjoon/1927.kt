package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue

// 실버 2
// 우선순위 큐, 자료구조
fun main(){
    val n = readln().toInt()
    val queue = PriorityQueue<Int>()
    repeat(n){
        val a = readln().toInt()
        if(a == 0){
            if(queue.isEmpty())
                println(0)
            else
                println(queue.poll())
        }
        else
            queue.add(a)
    }
}