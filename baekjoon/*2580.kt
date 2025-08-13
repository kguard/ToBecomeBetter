package com.kguard.tobecomebetter.baekjoon

import kotlin.system.exitProcess

private var sudoku = mutableListOf<MutableList<Int>>()
fun main() {
    repeat(9)
    { sudoku.add(readln().split(" ").map { it.toInt() }.toMutableList()) }
    dfs(0, 0)
}

private fun dfs(x: Int, y: Int) {
    if (y == 9) { // 한 행을 다 돌았으면 다음 행으로 이동
        dfs(x + 1, 0)
        return
    }
    if (x == 9) { // 모든 곳을 다 돌았을 때 종료
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                print("${sudoku[i][j]} ")
            }
            println()
        }
        exitProcess(0) // 출력시 종료
    }
    if (sudoku[x][y] == 0) {  // 0 이면 비교
        for (i in 1 until 10) {
            if (check(x, y, i)) { // 맞으면 넘어감
                sudoku[x][y] = i
                dfs(x, y + 1)
            }
        }
        sudoku[x][y] = 0 // 아니면 원상 복구
        return
    }
    dfs(x, y + 1) // 다음 으로 이동
}

private fun check(x: Int, y: Int, value: Int): Boolean { // 현재 x와 y축을 받고, 1~9까지 중의 값을 받는것
    for (i in 0 until 9) { // 같은 열에 값이 있는지 확인
        if (sudoku[x][i] == value)
            return false
    }
    for (i in 0 until 9) { // 같은 행에 값이 있는지 확인
        if (sudoku[i][y] == value)
            return false
    }

    val setX = (x / 3) * 3
    val setY = (y / 3) * 3

    for (i in setX until setX + 3) { // 3*3 위치에 값이 있는지 확인
        for (j in setY until setY + 3) {
            if (sudoku[i][j] == value)
                return false
        }
    }
    return true
}