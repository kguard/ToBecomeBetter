package com.kguard.tobecomebetter.baekjoon
//gcd 최대공약수를 구하는 함수를 재귀함수로 작성함
// List.reduce를 사용해서 재귀함수를 사용하는 방식으로 풀음
// acc는 이전 결과들, i는 이번 차례 변수 acc+i 는 acc+= i 를 뜻함
// https://kotlinworld.com/32
fun main() {
    val a = readln().toInt()
    val n = MutableList(a) { readln().toInt() }
    val between = MutableList(a - 1) { n[it + 1] - n[it] }
    val min  = between.reduce{acc, i -> gcd(acc,i)}
    var count = 0
    for(i in between){
        count += i/min-1
    }
    println(count)
}

private fun gcd(a: Int, b: Int): Int =
    if (b == 0)
        a
    else
        gcd(b, a % b)
