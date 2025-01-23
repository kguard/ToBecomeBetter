package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 아 맞다 마늘
// 구현, 자료 구조, 브루트포스 알고리즘, 해시를 사용한 집합과 맵
fun main() {
    val n = readln().toInt()
    val origin = readln().split(" ")
    val add = readln().split(" ")
    println((origin - add.toSet())[0])
}