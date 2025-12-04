package com.kguard.tobecomebetter.baekjoon.kotlin

// 실버 1 완전 이진 트리
// LNR - 중위 순회
// 재귀
fun main(){
    val k = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()
    val result = Array(k+1){mutableListOf<Int>()}
    result[1].add(list[list.size/2])
    fun check(now : Int, size : Int, level: Int){
        if(level == k) {
            result[level].add(list[now-1])
            result[level].add(list[now+1])
            return
        }
        result[level].add(list[now-(size/2+1)])
        result[level].add(list[now+(size/2+1)])
        check(now-(size/2+1), size/2, level+1)
        check(now+(size/2+1), size/2, level+1)
    }
    check(list.size/2,list.size/2,2)
    for (i in 1 .. k)
        println(result[i].joinToString(" "))
}