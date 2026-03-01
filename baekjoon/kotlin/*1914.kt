package com.kguard.tobecomebetter.baekjoon.kotlin

import java.math.BigInteger

/*
    골드 5 하노이 탑
    재귀로 푸는 함수
    유명한 하노이 탑 문제
    무조건 실행시간은 2의 n승 - 1 번 실행됨
    실행 되는 위치를 찾기 위해서 기본적으로 마지막(맨 밑)에 있는게 목적지로 가야 함
    그러기 위해서는
    1. 위의 있는 원판들이 중간 단계의 기둥으로 가야됨
    2. 맨 밑에 잇는 원판이 목적지로 가야함
    3. 중간 단계로 이동했던 것들을 그 위로 옮기는 식으로 가야 함
 */
fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    val k = BigInteger("2").pow(n) - BigInteger.ONE // 2의 n승 -1은 Long보다 크니 BigInteger
    println(k)

    fun hanoi(depth: Int, start: Int, mid: Int, end: Int) { // 이동 경로를 구하는 문제
        if (depth == 1) {
            sb.append("$start $end\n")
            return
        }

        // hanoi(몇 개를, 출발지에서, 보조 기둥을 거쳐서, 도착지로)

        // 1. 위쪽의 N-1개 원판을 전부 '2번 기둥(보조 기둥)'으로 치워둔다.
        hanoi(depth - 1, start, end, mid)
        // 2. 제일 큰 N번 원판을 '3번 기둥(목표 기둥)'으로 옮긴다. (출력: 1 3)
        sb.append("$start $end\n")
        // 3. 아까 2번에 치워뒀던 N-1개 원판을 다시 '3번 기둥'으로 얹는다.
        hanoi(depth - 1, mid, start, end)
    }

    if (n <= 20)
        hanoi(n, 1, 2, 3) // 문제에서 기둥이 1,2,3 이라고 했었음
    println(sb)
}