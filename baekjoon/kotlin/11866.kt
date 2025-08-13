package com.kguard.tobecomebetter.baekjoon

import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().split(" ").map { it.toInt() }
    val queue: Queue<Int> = LinkedList(List(n[0]) { it + 1 })
    var count = 0
    print("<")
    while (queue.size != 0) {
        if (count == n[1] - 1) {
            count = 0
            print("${queue.poll()}")
            if (queue.size != 0)
                print(", ")
        } else {
            count++
            queue.offer(queue.poll())
        }
    }
    print(">")
}