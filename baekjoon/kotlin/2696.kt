package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.PriorityQueue
import kotlin.math.ceil

// 골드 2? 중앙값 구하기
// 그냥 입력 받을 떄마다 정렬 해버림
/*
fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val list = mutableListOf<Int>()
        repeat((ceil(n/10.0)).toInt()){
            val r = readln().split(" ").map { it.toInt() }
            list.addAll(r)
        }
        val answer = mutableListOf<Int>()
        val temp = mutableListOf<Int>()
        for(i in list.indices){
            temp.add(list[i])
            temp.sort()
            if(i % 2== 0){
                answer.add(temp.toMutableList()[temp.size/2])
            }
        }
        println(answer.size)
        answer.chunked(10).forEach {
            println(it.joinToString(" "))
        }
    }
}
*/


// 우선 순위큐 (heap)을 2개 이용해서 문제를 해결
// max 는 중간 보다 큰 값이 오름차순으로 정렬 되어 있음
// min 은 중간 보다 작은 값들이 내림차순으로 정렬 되어 있음
fun main() {
    val t = readln().toInt()
    val max = PriorityQueue<Int>() // 오름차순
    val min = PriorityQueue<Int>(Comparator.reverseOrder()) // 내림차순
    repeat(t) {
        val n = readln().toInt()
        val list = mutableListOf<Int>()
        repeat((ceil(n / 10.0)).toInt()) {
            val r = readln().split(" ").map { it.toInt() }
            list.addAll(r)
        }
        max.clear()
        min.clear()
        println((n + 1) / 2)
        for (i in list.indices) {
            max.offer(list[i])
            if (max.isNotEmpty()) { // 균형을 맞추기
                if (max.size - min.size > 1)
                    min.offer(max.poll())
            }
//            println("max :$max")
//            println("min :$min")
//            println()

            while (max.peek() != null && min.peek() != null && max.peek() < min.peek()) {
                val temp = max.poll()
                max.offer(min.poll())
                min.offer(temp)
            }

            if (i % 2 == 0)
                print("${max.peek()} ")
        }
        println()
    }
}