package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.Stack

fun main() {
    val n = readln().toInt()
    var sum = 0L
    val stack = Stack<Int>()
    repeat(n) {
        // 내 기준으로 나를 볼 수 있는 건물들은 내버려두는 것
        val now = readln().toInt()

        // 나 보다 작거나 같은 애들은 나한테 가려서 없어짐 -> pop
        while (stack.isNotEmpty() && stack.peek() <= now) {
            stack.pop()
        }

        // stack 에 나온것은 나보다 "학실히 큰" 건물들 뿐 이기 때문에
        // 그 건물들은 나를 볼 수 있기 때문에 -> 스택의 사이즈 만큼 count 증가
        sum += stack.size
        stack.push(now)

    }
    println(sum)
}