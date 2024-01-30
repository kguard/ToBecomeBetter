package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val deque = ArrayDeque<Int>()
    repeat(br.readLine().toInt())
    {
        val n = br.readLine().split(" ").map { it.toInt() }
        when (n[0]) {
            1 -> {
                deque.addFirst(n[1])
            }

            2 -> {
                deque.addLast(n[1])
            }

            3 -> {
                if (deque.isNotEmpty()) {
                    bw.write("${deque.removeFirst()}\n")
                } else
                    bw.write("-1\n")
            }

            4 -> {
                if (deque.isNotEmpty()) {
                    bw.write("${deque.removeLast()}\n")
                } else
                    bw.write("-1\n")
            }

            5 -> {
                bw.write("${deque.size}\n")
            }

            6 -> {
                if (deque.isEmpty()) bw.write("1\n") else bw.write("0\n")
            }

            7 -> {
                if (deque.isNotEmpty()) {
                    bw.write("${deque.first()}\n")
                } else
                    bw.write("-1\n")
            }

            8 -> {
                if (deque.isNotEmpty()) {
                    bw.write("${deque.last()}\n")
                } else
                    bw.write("-1\n")
            }
        }
    }
    bw.flush()
    bw.close()
}