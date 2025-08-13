package com.kguard.tobecomebetter.baekjoon

import java.util.Stack

fun main() {
    while (true) {
        val stack: Stack<Char> = Stack()
        val vps = readln()
        if (vps == ".") break
        for (i in vps) {
            when (i) {
                '(' -> stack.push(i)
                '[' -> stack.push(i)
                ')' -> if (stack.isNotEmpty()) {
                    if (stack.peek() == '(') stack.pop() else break
                } else {
                    stack.push('-')
                    break
                }
                ']' -> if (stack.isNotEmpty()) {
                    if (stack.peek() == '[') stack.pop() else break
                } else {
                    stack.push('-')
                    break
                }
            }
        }
        if (stack.isEmpty()) println("yes") else println("no")
    }
}