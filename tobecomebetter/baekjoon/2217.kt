package com.kguard.tobecomebetter.baekjoon

// 실버 4 로프
// 수학, 그리디 알고리즘, 정렬
// 내림차순으로 정렬하면 index+1 은 자기길이 이상의 줄의 갯수를 뜻함
// (줄의 길이)*(줄의 갯수)의 최대 값이 됨
fun main(){
    val n = readln().toInt()
    val rope = mutableListOf<Int>()
    repeat(n){ rope.add(readln().toInt()) }
    println(rope.sortedDescending().mapIndexed { index, i -> i * (index+1) }.max())
}