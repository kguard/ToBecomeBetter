package com.kguard.tobecomebetter.baekjoon

import java.lang.StringBuilder
// 어쩌피 스택인 부분은 들어간 수가 바로 빠져 나오기 때문에 무시를 하면됨
// 따라서 하나의 큐라고 생각하면 되서 들어간 수만큼 거꾸로 수가 출력되면 됨
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    br.readLine()
    val first = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").filterIndexed { index, _ -> first[index] == 0 }.reversed().toMutableList()
    val addNumSize = br.readLine().toInt()
    val t = br.readLine().split(" ")
    a += t
    for(i in 0 until addNumSize)
        bw.write("${a[i]} ")
    bw.flush()
    bw.close()
    br.close()
}

//fun main() {
//    val br = System.`in`.bufferedReader()
//    val bw = System.out.bufferedWriter()
//    val sb = StringBuilder()
//    val size1 = br.readLine().toInt()
//    val first = br.readLine().split(" ").map { it.toInt() }
//    val second = br.readLine().split(" ").map { it.toInt() }
//    var size = br.readLine().toInt()
//    val new = br.readLine().split(" ").map {it.toInt()}
//    for(i in size1-1 downTo 0)
//    {
//        if(size == 0 ) break
//        if(first[i] == 0) {
//            sb.append("${second[i]} ")
//            size --
//        }
//    }
//    for(i in 0 until size)
//        sb.append("${new[i]} ")
//    bw.write(sb.toString())
//    bw.flush()
//    bw.close()
//    br.close()
//}