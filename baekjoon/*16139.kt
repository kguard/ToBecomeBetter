package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 실버1
/*
fun main(){
    val n = readln().split("").toMutableList()
    n.removeFirst()
    n.removeLast()
    repeat(readln().toInt()){
        val t = readln().split(" ")
        println(n.slice(t[1].toInt()..t[2].toInt()).count { it == t[0] })
    }
}
*/

// 알파벳에 대한 모든 누적 합을 구한 다음 인덱스에서 빼서 계산
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toCharArray()
    val sum = Array(n.size + 1) { Array(26) { 0 } }
    for (i in 1 .. n.size) {
        for (j in 0 until 26) {
            if(n[i- 1].code == j + 97)
                sum[i][j] = sum[i-1][j]+1
            else
                sum[i][j] = sum[i-1][j]
        }
    }
    repeat(br.readLine().toInt()) {
        val t = br.readLine().split(" ")
        val find = t[0].toCharArray()[0].code - 97
        val start = t[1].toInt() +1
        val end = t[2].toInt() +1
        bw.write("${sum[end][find]-sum[start-1][find]}\n")
    }
    bw.flush()
    bw.close()
}