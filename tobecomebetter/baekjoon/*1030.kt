package com.kguard.tobecomebetter.baekjoon

import kotlin.math.pow

// 골드 3 프렉탈 평면
// 구현, 분할 정복, 재귀
// 큰 사각형에서 시작해서 재귀를 통해 작은 사각형으로 진행하며 문제를 해결
// (평면의 길이) * (평면의 등비 - 가운데 평면의 길이) / 2 와 (평면의 길이) * (평면의 등비 + 가운데 평면의 길이) / 2  가 중요
// 평면의 길이가 길어질 수록 가운데가 칠해져야 하는 밤위도 달라지니 범위를 구해서 문제를 해결해야됨
// 평면의 길이에 맞에 검은색으로 칠해지려면 (평면의 길이) * (평면의 등비 - 가운데 평면의 길이) / 2 와 (평면의 길이) * (평면의 등비 + 가운데 평면의 길이) / 2 사이에 있어야함
// /2를 한 이유는 3등분을 해서 가운데를 골라내기 위해서 함
fun main() {
    val a = readln().split(" ").map { it.toInt() }
    val s = a[0]
    val n = a[1]
    val k = a[2]
    val r1 = a[3]
    val r2 = a[4]
    val c1 = a[5]
    val c2 = a[6]
    val size = n.toDouble().pow(s).toInt()
    fun find(len: Int, y: Int, x: Int): Int { // len은 평면의 길이, 나머지는 좌표
        if (len == 1) return 0
        val border = len / n // border는 이전 단계의 평면의 길이
        if (y >= border * (n - k) / 2 && y < border * (n + k) / 2 && x >= border * (n - k) / 2 && x < border * (n + k) / 2) return 1 // 범위의 시작과 끝 사이에 있으면 색칠
        return find(border, y % border, x % border) // 재귀를 위해서 이전 단계의 평면의 길이, y좌표를 평면의 길이로 나눈 나머지, x좌표를 평면의 길이로 나눈 나머지 -> 크기가 작아지니, 크기에 맞는 좌표를 선택
    }
    for (i in r1 ..  r2) {
        for (j in  c1 ..  c2) {
            print(find(size, i, j))
        }
        println()
    }
}