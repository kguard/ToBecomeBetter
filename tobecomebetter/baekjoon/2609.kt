package com.kguard.tobecomebetter.baekjoon

//브론즈 1
// 유클리드 호제법 : a, b (a>b)에서 나머지가 0일 될때까지 b, a%b를 해서 a%b==0 일때 나온 b 가 최대공약수
// a, b (a>b)에서 a*b == (a,b의 최소공배수) * (a,b의 최대공약수)
fun main() {
    val n = readln().split(" ").map { it.toInt() }.sorted()
    println(gcm(n[0], n[1]))
    println(lcm(n[0], n[1]))
}

private fun gcm(a: Int, b: Int): Int = if (b == 0) a else gcm(b, a % b)
private fun lcm(a: Int, b: Int): Int = (a * b) / gcm(a, b)
