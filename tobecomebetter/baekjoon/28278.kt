package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// print()와 readln()는 시간 초과가 나와버림
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stack = mutableListOf<String>()
    repeat(readln().toInt())
    {
        val n = br.readLine().split(" ")
        when (n[0]) {
            "1" -> stack.add(n[1])
            "2" -> {
                if (stack.size > 0) {
                    bw.write(stack.last() + "\n")
                    stack.removeLast()
                } else
                    bw.write("-1\n")
            }

            "3" -> bw.write("${stack.size}\n")
            "4" -> {
                if (stack.isEmpty()) bw.write("1\n") else bw.write("0\n")
            }

            "5" -> {
                if (stack.size > 0) {
                    bw.write(stack.last() + "\n")
                } else
                    bw.write("-1\n")
            }
        }
    }
    bw.flush()
    bw.close()
}
