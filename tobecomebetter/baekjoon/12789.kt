package com.kguard.tobecomebetter.baekjoon

import java.util.Stack

fun main(){
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val stack:Stack<Int> = Stack()
    var seq = 1
    list.forEach {
        if(it == seq) seq++
        else {
            while(stack.isNotEmpty())
            {
                if(stack.peek() == seq) {
                    stack.pop()
                    seq++
                }
                else break
            }
            stack.push(it)
        }
    }
    while(stack.isNotEmpty())
    {
        if(stack.pop() == seq) {
            seq++
        }
        else break
    }
    if(stack.isEmpty())
        println("Nice")
    else
        println("Sad")
}