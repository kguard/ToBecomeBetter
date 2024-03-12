package com.kguard.tobecomebetter.baekjoon

// 브론즈 1
private val f = MutableList(41) { 0 }
private var countRecursion = 0
private var countDynamic = 0
fun main() {
    val n = readln().toInt()
    fibRecursion(n)
    fibDynamic(n)
    println("$countRecursion $countDynamic")
}

private fun fibRecursion(n: Int): Int {
    return if (n == 1 || n == 2) {
        countRecursion++
        1
    } else
        fibRecursion(n - 1) + fibRecursion(n - 2)
}

private fun fibDynamic(n: Int): Int {
    f[1] = 1
    f[2] = 1
    for (i in 3..n) {
        countDynamic++
        f[i] = f[i - 1] + f[i - 2]
    }
    return f[n]
}