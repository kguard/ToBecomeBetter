package com.kguard.tobecomebetter.baekjoon

import kotlin.math.sqrt

// 골드 4 방사형 그래프
// 브루트포스 알고리즘, 기하학
// CCW와 다른 알고리즘을 같이 적용해서 문제 해결해야 된다 함
// https://burningfalls.github.io/algorithm/boj-25308/
fun main(){
    val rate = readln().split(" ").map { it.toInt() }.toMutableList()
    val list = MutableList(8){0}
    val visited = MutableList(8){false}
    var result = 0
    fun check() : Boolean{
        for(i in 0 .. 7)
        {
            // 삼각형 넓이 공식을 이용하여  (a1 * a3) / (a1 + a3) * 루트2 <= a2 이어야지 볼록 다각형이 형성됨
            val a = list[i] * list[(i+2)%8] * sqrt(2.0)
            val b =  (list[i]+ list[(i+2)%8]) * list[(i+1)%8]
            if(a > b)
                return false
        }
        return true
    }

    // 순열을 구하는 함수 -> 8! 이기 때문에 모든 순열을 이용해서 문제 해결
    // dfs룰 이용해서 모든 순열 구하기 -> 어려움, 이해 필요
    fun permutation(depth : Int){
        if(depth == 8){
            if(check())
                result += 1
            return
        }
        for(i in 0.. 7){
            if(!visited[i]){
                list[depth] = rate[i]
                visited[i] = true
                permutation(depth+1)
                visited[i] = false
            }
        }
    }
    permutation(0)
    println(result)
}