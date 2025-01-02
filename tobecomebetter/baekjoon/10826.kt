package com.kguard.tobecomebetter.baekjoon

// 실버 4 스택
// 구현, 자료 구조, 스택
fun main() {
    val stack = mutableListOf<Int>()
    val n = readln().toInt()
    repeat(n) {
        val a = readln().split(" ")
        when (a[0]) {
            "push" -> {
                stack.add(a[1].toInt())
            }

            "pop" -> {
                if (stack.isEmpty()) println(-1)
                else println(stack.removeAt(stack.lastIndex))
            }

            "size" -> {
                println(stack.size)
            }

            "empty" -> {
                if (stack.isEmpty()) println(1)
                else println(0)
            }

            "top" -> {
                if (stack.isEmpty()) println(-1)
                else println(stack[stack.lastIndex])
            }

        }
    }
}