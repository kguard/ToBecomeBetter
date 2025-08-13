package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 일곱 난쟁이
// 브루트포스 알고리즘, 정렬
fun main() {
    val height = mutableListOf<Int>()
    repeat(9) { height.add(readln().toInt()) }
    height.sort()
    val s = height.sum() - 100
    l1@ for (i in 0 until 9)
        for (j in i until 9) {
            val a = height[i]
            val b = height[j]
            if (a + b == s) {
                height.remove(a)
                height.remove(b)
                break@l1
            }
        }
    height.forEach { println(it) }
}