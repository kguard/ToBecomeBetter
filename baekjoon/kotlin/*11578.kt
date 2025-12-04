package com.kguard.tobecomebetter.baekjoon.kotlin

import kotlin.math.min

fun main(){
    val (n,m) = readln().split(" ").map { it.toInt() }
    val check = MutableList(n+1){0} // 이전에 같은 문제를 풀었을 수도 있기 때문에 푼 횟수 자체를 카운트
    check[0] = 1
    val p = mutableListOf<MutableList<Int>>()
    repeat(m){
        val l = readln().split(" ").map { it.toInt() }
        p.add(l.subList(1, l.size).toMutableList())
    }
    val indexes = mutableSetOf<Int>()
    var count  = Int.MAX_VALUE
    fun combine(index : Int){

        if(check.all { it >= 1 }){
            count = min(count,indexes.size)
            return
        }

        for(i in index until m){
            if(i !in indexes){
                indexes.add(i)
                for(j in p[i])
                    check[j] ++ // 횟수를 더해줌
                combine(i)
                for(j in p[i])
                    check[j]-- // 횟수를 빼줌
                indexes.remove(i)
            }
        }

    }
    combine(0)
    print(if(count == Int.MAX_VALUE) -1 else count)

}