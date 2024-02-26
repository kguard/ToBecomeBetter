package com.kguard.tobecomebetter.baekjoon

//실버 2
private val paper = mutableListOf<List<Int>>()
private val result = MutableList(2) { 0 }
fun main() {
    val n = readln().toInt()

    repeat(n)
    {
        paper.add(readln().split(" ").map { it.toInt() })
    }
    checkColor(n, 0, 0)
    for (i in result)
        println(i)
}

fun checkColor(size: Int, startX: Int, startY: Int) {
    val color = paper[startX][startY]

    if (size == 1) {
        result[color]++
        return
    }

    for (i in startY until startY + size) {
        for (j in startX until startX + size) {
            if (paper[j][i] != color) {
                checkColor(size / 2, startX, startY)
                checkColor(size / 2, startX + size / 2, startY)
                checkColor(size / 2, startX, startY + size / 2)
                checkColor(size / 2, startX + size / 2, startY + size / 2)
                return
            }
        }
    }
    result[color]++
//    var zero = true
//    var one = true
//    for(i in startY until startY+size){
//        for(j in startX until startX+size){
//            if(paper[i][j]==0) one=false
//            else zero =false
//        }
//    }
//    if(zero){
//        result[0]++
//        return
//    }
//    if(one){
//        result[1]++
//        return
//    }
//    checkColor(size / 2, startX, startY)
//    checkColor(size / 2, startX + size / 2, startY)
//    checkColor(size / 2, startX, startY + size / 2)
//    checkColor(size / 2, startX + size / 2, startY + size / 2)
}