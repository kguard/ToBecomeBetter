package com.kguard.tobecomebetter.baekjoon

// 실버4 보물
// 수학, 그리디 알고리즘, 정렬
// A, B 리스트에서
// S = A[0] × B[0] + ... + A[N-1] × B[N-1] 이 최소 값이 되려면
// A는 오름차순으로 정렬해야하고, B는 내림차순으로 정렬하면 됨
fun main(){
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toMutableList()
    val b = readln().split(" ").map { it.toInt() }
    val a1 = a.sorted()
    val b1 = b.sortedDescending()
    var sum = 0
    for(i in 0 until n){
        sum+= a1[i] * b1[i]
    }
    println(sum)
}