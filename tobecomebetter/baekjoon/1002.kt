package com.kguard.tobecomebetter.baekjoon

import kotlin.math.abs
import kotlin.math.hypot

// 실버 3 터렛
// 수학, 기하학, 많은 조건 분기
// 두 좌표가 주어지고 각 좌표에서 점과의 거리가 각각 주어졌을 때 점이 존재 할 수 있는 좌표의 수
// 두 좌표를 중심으로 거리가 반지름인 원이 두개 있다고 생각하고 풀면됨
// 두 원의 교차 하면 2개, 두 원이 내접하거나 외접하면 1개, 한 원이 다른 원 완전 내부에 있거나 두 원이 떨어져 있거나 중심은 같은데 반지름이 다르면 0개, 두 원이 동심원에 반지름도 같으면 -1(무한개)
fun main(){
    val t = readln().toInt()
    repeat(t){
        val list = readln().split(" ").map { it.toInt() } // list[0] == x1 , list[1] == y1, list[2] == r1, list[3] == x2, list[4] == y2, list[5] == r2
        val xyDist = hypot(abs(list[0]-list[3]).toDouble(), abs(list[1]-list[4]).toDouble()) // 두 원의 중심의 거리
        val rDistFar = list[2] + list[5].toDouble() // 두 반지름의 합
        val rDistShort = abs(list[2] - list[5]).toDouble() // 두 반지름의 차이
        if(rDistShort == 0.0 && xyDist ==0.0) // 두 점이 동심원이고 반지름의 차이가 없음 -> 무한개
            println(-1)
        else if(xyDist > rDistShort && xyDist < rDistFar) // 두 원의 중심의 거리가 반지름의 차이보다 크고, 합 보다 작으면 교차하는 것이니 2개
            println(2)
        else if(xyDist == rDistFar || xyDist == rDistShort) // 두 원의 중심의 거리가 반지름의 차이와 같거나 반지름의 합과 같으면 내접 또는 외접하는 것이니 1개
            println(1)
        else if(xyDist > rDistFar || xyDist < rDistShort || xyDist == 0.0) // 두 원의 중심의 거리가 반지름의 합보다 크면 외부에 있고, 두 원의 중심의 거리가 반지름의 차보다 작으면 완전 내부에 있고, 반지름에 차이가 있는데 두 원의 중심의 거리가 0 이면 동심원이니 0개
            println(0)
    }
}