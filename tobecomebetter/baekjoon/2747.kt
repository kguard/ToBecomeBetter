package com.kguard.tobecomebetter.baekjoon

// 브론즈 2 피보나치 수
// 수학, 구현, 다이나믹 프로그래밍
fun main(){
    val n = readln().toInt()
    val f = MutableList(n+1){0}
    f[1]=1
    for(i in 2..n){
        f[i] = f[i-1] + f[i-2]
    }
    println(f[n])
}