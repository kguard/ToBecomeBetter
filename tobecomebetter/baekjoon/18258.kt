package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val queue: Queue<Int> = LinkedList()
    repeat(br.readLine().toInt())
    {
        val r = br.readLine().split(" ")
        when (r[0]) {
            "push" -> {
                queue.add(r[1].toInt())
            }

            "pop" -> {
                if (queue.isEmpty()) bw.write("-1\n") else bw.write("${queue.poll()!!}\n")
            }

            "size" -> {
                bw.write("${queue.size}\n")
            }

            "empty" -> {
                if (queue.isEmpty()) bw.write("1\n") else bw.write("0\n")
            }

            "front" -> {
                if (queue.isEmpty()) bw.write("-1\n") else bw.write("${queue.first()}\n")
            }

            "back" -> {
                if (queue.isEmpty()) bw.write("-1\n") else bw.write("${queue.last()}\n")
            }
        }
    }
    bw.flush()
    bw.close()
}