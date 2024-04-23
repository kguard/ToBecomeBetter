package com.kguard.tobecomebetter.baekjoon

// 실버 2
// 재귀, 분할 정복
private val count = MutableList(3) { 0 }
private val list = mutableListOf<List<Int>>()
fun main() {
    val n = readln().toInt()
    repeat(n) {
        list.add(readln().split(" ").map { it.toInt() })
    }
    paper(n, 0, 0)
    for (i in count)
        println(i)
}

private fun paper(size: Int, startX: Int, startY: Int) {
    val start = list[startX][startY]
    if (size == 1) {
        count[start + 1]++
        return
    }
    for (i in startX until startX + size) {
        for (j in startY until startY + size) {
            if (list[i][j] != start) {
                paper(size / 3, startX, startY)
                paper(size / 3, startX, startY + size / 3)
                paper(size / 3, startX, startY + (2 * size / 3))
                paper(size / 3, startX + size / 3, startY)
                paper(size / 3, startX + size / 3, startY + size / 3)
                paper(size / 3, startX + size / 3, startY + (2 * size / 3))
                paper(size / 3, startX + (2 * size / 3), startY)
                paper(size / 3, startX + (2 * size / 3), startY + size / 3)
                paper(size / 3, startX + (2 * size / 3), startY + (2 * size / 3))
                return
            }
        }
    }
    count[start + 1]++
}