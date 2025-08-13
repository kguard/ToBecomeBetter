package com.kguard.tobecomebetter.baekjoon

// 골드 3 선분 교차 1
// 기하학, 선분 교차 판정
// CCW를 이용하여 한 선분의 양 끝점과 나머지 선분의 각각의 점을 CCW를 하여 두 CCW 결과를 곱한 것이 0 보다 작거나 같아야 한다.
// 또한 반대로 선분의 양 끝점과 처음 천분의 각각의 점을 CCW 하여 두 CCW 결과를 곱한 것이 0 보다 작거나 같아야 한다.
// CCW(p1, p2, p3) * CCW(p1, p2, p4) <= 0 && CCW(p3, p4, p1) * CCW(p3, p4, p2) <= 0
// 반례로 두 선분이 같은 일직선에 있을 수 있기 때문에 교차 하려면 포개져 있는 경우여야 함
fun main() {
    val l1 = readln().split(" ").map { it.toLong() }
    val p1 = Pair(l1[0], l1[1])
    val p2 = Pair(l1[2], l1[3])
    val l2 = readln().split(" ").map { it.toLong() }
    val p3 = Pair(l2[0], l2[1])
    val p4 = Pair(l2[2], l2[3])
    // ccw 끼리 곱했을때 스택오버플로우 발생하기 때문에 return 값을 이렇게 설정
    fun ccw(a: Pair<Long, Long>, b: Pair<Long, Long>, c: Pair<Long, Long>): Int {
        val v = (b.first - a.first) * (c.second - b.second) - (c.first - b.first) * (b.second - a.second)
        return when {
            v > 0 -> 1
            v < 0 -> -1
            else -> 0
        }
    }
    val c1 = ccw(p1, p2, p3) * ccw(p1, p2, p4)
    val c2 = ccw(p3, p4, p1) * ccw(p3, p4, p2)
    if (c1 < 0 && c2 < 0) print(1) else print(0)
}