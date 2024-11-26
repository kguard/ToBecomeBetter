package com.kguard.tobecomebetter.baekjoon

import kotlin.math.sqrt

// 골드 3 Fly me to the Alpha Centauri
// 수학
// 맨 처음과 마지막은 1개만 움직일 수 있음
// 규칙을 찾아서 문제를 해결하는 방식

//Count 값에 따라 이동할 수 있는 최대 거리를 나열해보니 규칙이 세 가지 보인다.
//1. max 가 1 씩 증가하면서 2 번씩 반복된다.
//2. Distance(거리) 는 이전 거리와 최댓값과의 차이가 max 가 증가하는 규칙과 동일하다.
//3. max 가 변하는 지점의 Distance 는 max 의 제곱 값이다.

// 규칙 1 : max 의 값은 distance 의 루트 값에서 소수점을 버린 정수값
// 규칙 2 : max 가 변하는 지점과 다음 지점 사이에는 항상 count 가 두 번씩 변함
// 규칙 3 : max 가 변하는 지점 다음 지점은 count가 변함
// 규칙 4 : max값이 변하는 지점은 Count = ( 2 × max - 1 ) 의 공식을 적용
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        val distance = y-x // 두 점 사이의 거리
        val max = sqrt(distance.toDouble()).toInt() // 두 점 사이의 거리를 이동할 때 제일 멀리 이동하는 거리 -> 거리의 루트의 정수 부분이 max값임
        if (max.toDouble() == sqrt(distance.toDouble())) // max 값이 변하는 지점
            println(2 * max - 1)
        else if (distance <= max * max + max) // 두 max 값 사이에서 규칙 3 다음에 두번째 count가 변하는 지점을 기준으로 앞 부분은 2*max
            println(2 * max)
        else // 나머지 두 max 값 사이에서 규칙 3 다음에 두번째 count가 변하는 지점을 기준으로 뒷 부분은 2*max+1
            println(2 * max + 1)
    }
}