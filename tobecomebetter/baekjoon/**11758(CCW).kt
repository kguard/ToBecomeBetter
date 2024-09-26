package com.kguard.tobecomebetter.baekjoon

// 골드 5 CCW
// 기하학
// CCW(Counter Clock Wise)
// 3개의 점을 이은 직선이 반시계 방향이면 1 직선이면 0 시계 방향이면 -1을 출력
// 3개의 점으로 2개의 벡터 값을 구해서 행렬을 이용해서 외적을 구했을 때 양수면 반시계 방향, 음수면 시계 방향, 0 이면 직선
fun main(){
    val a = readln().split(" ").map { it.toInt() }.let { Pair(it[0],it[1]) }
    val b = readln().split(" ").map { it.toInt() }.let { Pair(it[0],it[1]) }
    val c = readln().split(" ").map { it.toInt() }.let { Pair(it[0],it[1]) }
    val result = (b.first - a.first) * (c.second - b.second) - (c.first - b.first) *  (b.second - a.second)
    when{
        result > 0 -> println(1)
        result == 0 -> println(0)
        else -> println(-1)
    }
}