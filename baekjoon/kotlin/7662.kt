package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.TreeMap

// 골드 4 이중 우선순위 큐
// TreeMap을 이용해서 문제 해결
// 각 숫자를 key 로 삼고, 숫자가 나온 횟수를 value로 삼아서 알아서 정렬 되도록
fun main(){
    repeat(readln().toInt()){
        val map = TreeMap<Long,Int>()
        repeat(readln().toInt()){
            val command = readln().split(" ")
            if(command[0] == "I"){
                val key = command[1].toLong()
                map[key] = map.getOrDefault(key,0) + 1 // 숫자 있으면 기존 +1
            }
            else{ // D 일때
                if(map.isNotEmpty()) {
                    if (command[1].toInt() == 1) {
                        val key = map.lastKey()
                        map[key]?.let { it1 -> map[key] = it1 - 1 }
                        if(map[key] == 0)
                            map.remove(key)
                    } else {
                        val key = map.firstKey()
                        map[key]?.let { it1 -> map[key] = it1 - 1 }
                        if(map[key] == 0)
                            map.remove(key)
                    }
                }
            }
        }
        println(
            if(map.isNotEmpty()){
                "${map.lastKey()} ${map.firstKey()} "
            }
            else
                "EMPTY"
        )
    }
}