package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.Stack

// 골드 5 탑
// 스택을 이용해서 해결 하는 문제
fun main() {
    val n = readln().toInt()
    val building = readln().split(" ").map { it.toInt() }
    val stack = Stack<Int>()
    for (i in building.indices) {
        while (stack.isNotEmpty() && building[stack.peek()] < building[i]) // 현재 값이 스택의 제일 위의 값 보다 작거나 같을 때 까지 pop -> 닿을 때 까지 빼주기
            stack.pop()

        print("${if (stack.isNotEmpty()) stack.peek() + 1 else 0} ") // 제일 위의 인덱스에 닿은 깃

        stack.push(i) // 현재 번 보다 다음게 더 작을 수 있으니 일단 push
    }
}