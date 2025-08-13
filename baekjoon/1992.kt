package com.kguard.tobecomebetter.baekjoon

// 실버 1
// 재귀, 분할 정복
// 시작 점의 숫자를 알아내서 숫자와 같으면 넘어가고 아니면 다시 쪼개서 문제 해결
// 쪼개 질때 괄호 추가
private val list = mutableListOf<List<Int>>()
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val t = readln().split("").toMutableList()
        t.removeFirst()
        t.removeLast()
        list.add(t.map { it.toInt() })
    }
    quadTree(n, 0, 0)
}

private fun quadTree(size: Int, startX: Int, startY: Int) {
    val start = list[startX][startY]
    if (size == 1) {
        print(start)
        return
    }
    for (i in startX until startX + size) {
        for (j in startY until startY + size) {
            if (list[i][j] != start) {
                print("(")
                quadTree(size / 2, startX, startY) // 왼쪽 위
                quadTree(size / 2, startX, startY + size / 2) // 오른족 위
                quadTree(size / 2, startX + size / 2, startY) // 왼쪽 아래
                quadTree(size / 2, startX + size / 2, startY + size / 2) // 오른쪽 아래
                print(")")
                return
            }
        }
    }
    print(start)
}