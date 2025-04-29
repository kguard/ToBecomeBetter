package com.kguard.tobecomebetter.baekjoon

// 실버 5 수들의 합
// 수학, 그리디 알고리즘
// 서로 다른 N개의 자연수의 합에서 n의 최대값을 구해야하니 1부터 하나씩 더하는 경우의 수를 구하면 됨
// 1부터 하나씩 더하다가 k를 더했을때 s보다 크면 k-1가 최대 값이 됨
fun main(){
    val s = readln().toLong()
    var sum = 0L
    var n = 0L
    while (true){
        sum += n
        if(sum > s) break
        n++
    }
    println(n-1)
}