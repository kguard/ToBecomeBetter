package com.kguard.tobecomebetter.baekjoon

//실버 2
// 재귀, 분할 정복
// 시작 점의 위치의 색 을 알아 낸 다음, 사이즈가 1 이면 색을 추가
// 사직점 부터 크위를 더한 부분까지 색상들이 일치하지 않으면 색종이를 나누기

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
                checkColor(size / 2, startX, startY) // 왼쪽 위
                checkColor(size / 2, startX + size / 2, startY) // 오른쪽 위
                checkColor(size / 2, startX, startY + size / 2) // 왼쪽 아래
                checkColor(size / 2, startX + size / 2, startY + size / 2) // 오른쩍 이레
                return
            }
        }
    }
    result[color]++ // 색이 같은 사이즈가 1이 아닌 정사각형 색종이 하나 추가
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