package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 골드 5 제곱수 찾기
// 브루트포스 알고리즘
// sqrt(n) % 1 == 0.0 이면 n은 제곱수
// 4중 for문을 돌려서 문제를 해결해야 됨
// 선택한 행과 열이 등차수열을 이뤄야 함
// 4중 for문을 생각 하지 못함....(아쉽)
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<List<Int>>()
    repeat(n) {
        val a = readln().split("").toMutableList()
        a.removeAt(0)
        a.removeAt(a.lastIndex)
        list.add(a.map { it.toInt() })
    }
    var answer = -1
    for (i in 0 until n) // 시작 행 위치
        for (j in 0 until m) // 시작 열 위치
            for (x in -n until n) // 행 방향 등차는 -n 부터 n-1 까지만 있을 수 있음
                for (y in -m until m) {  // 열 방향 등차 -m 부터 m-1 까지만 있을 수 있음
                    if (x == 0 && y == 0) continue // 행과 열의 등차가 0이면 움직이질 않음
                    var a = i // 처음 시작 값
                    var b = j // 처음 시작 값
                    var now = 0
                    while (a in 0 until n && b in 0 until m) { // a와 b가 인덱스 안에 있어야 함
                        now *= 10 // 숫자를 하나씩 추가 하기 위해서 10 곱함
                        now += list[a][b] // 숫자 추가
                        if (sqrt(now.toDouble()) % 1 == 0.0) answer = max(now, answer) // 제곱수 확인
                        a += x // 등차만큼 인덱스 이동
                        b += y // 등차만큼 인덱스 이동
                    }
                }
    println(answer)
}