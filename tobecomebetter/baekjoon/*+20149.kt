package com.kguard.tobecomebetter.baekjoon

// 플래티넘 4 선분 교차 3
// 기하학, 많은 조건 분기, 선분 교차 판정
// 17387번의 연장선, CCW로 문제 해결 및 일직선 존재 확인
// 두 선분이 교차하는 지점까지 구해야 하는 문제 -> 4개의 점이 주어졌을때, 교차하는 지점의 좌표를 구하는 공식 존재

// Pair을 비교하기 위해서 첫번째 값을 비교 후, 같다면 두번째 값 비교해서 return
private fun compare(a: Pair<Long, Long>, b: Pair<Long, Long>): Pair<Long, Long> {
    return if (a.first > b.first) a
    else if (a.first < b.first) b
    else {
        if (a.second > b.second) a
        else if (a.second < b.second) b
        else a
    }
}
// ccw를 구하는 함수
private fun ccw(a: Pair<Long, Long>, b: Pair<Long, Long>, c: Pair<Long, Long>): Int {
    val v =
        (b.first - a.first) * (c.second - b.second) - (c.first - b.first) * (b.second - a.second)
    return when {
        v > 0 -> 1
        v < 0 -> -1
        else -> 0
    }
}
// 교차하는지 확인하는 함수
private fun checkCross(a: Pair<Long, Long>, b: Pair<Long, Long>, c: Pair<Long, Long>, d: Pair<Long, Long>) {
    var aa = a
    var bb = b
    var cc = c
    var dd = d
    val c1 = ccw(aa, bb, cc) * ccw(aa, bb, dd)
    val c2 = ccw(cc, dd, aa) * ccw(cc, dd, bb)
    if (c1 == 0 && c2 == 0) { // 만나는 한 점이 있거나, 평행하거나 같은 직선에 존재 할 경우
        // 두 선분이 모두 일직선에 존재 할 때, 첫번째 선분에서 작은 값이 두번째 선분에서 큰 값 보다 작아야하고, 두번째 선분에서 작은 값이 첫번째 선분에서 큰 값 보다 작아야 함
        // 일직선에는 존재하지만, 길이 차이로 만나지 않은 경우의 수가 존재
        // aa > bb 일떄, 자리 바꾸기 // 정렬
        if (compare(aa, bb) == aa) aa = bb.also { bb = aa }
        // cc > dd 일때, 자리 바꾸기 // 정렬
        if (compare(cc, dd) == cc) cc = dd.also { dd = cc }
        if (compare(aa, dd) == dd && compare(bb, cc) == bb) {
            println(1)
            findXY(aa, bb, cc, dd)
        } else println(0)
    } else if (c1 <= 0 && c2 <= 0) {
        println(1)
        findXY(aa, bb, cc, dd)
    } else println(0)
}
// 교차하는 지점 구하는 함수
private fun findXY(a: Pair<Long, Long>, b: Pair<Long, Long>, c: Pair<Long, Long>, d: Pair<Long, Long>) {
    val mother: Double =
        (a.first.toDouble() - b.first) * (c.second.toDouble() - d.second) - (a.second.toDouble()  - b.second) * (c.first.toDouble() - d.first)
    val xChild: Double =
        (a.first.toDouble() * b.second - a.second * b.first) * (c.first.toDouble() - d.first) - (a.first.toDouble() - b.first) * (c.first.toDouble() * d.second - c.second * d.first)
    val yChild: Double =
        (a.first.toDouble() * b.second - a.second * b.first) * (c.second.toDouble() - d.second) - (a.second.toDouble() - b.second) * (c.first.toDouble() * d.second - c.second * d.first)
    if(mother == 0.0){ // 일자로 평행 할 때 -> 기울기가 같을 때
        // a, b는 정렬됨, c, d도 정렬됨
        if(b==c && compare(a,c) == c) println("${b.first} ${b.second}") // ab cd 순으로
        else if(a==d && compare(c,a) ==a) println("${a.first} ${a.second}") // cd ab 순으로
    }else{ // 한 점에서 시작할 때 -> 한 점만 교차 및 기울기 다름
        println("${xChild/mother} ${yChild/mother}")
    }
}

fun main() {
    val l1 = readln().split(" ").map { it.toLong() }
    val p1 = Pair(l1[0], l1[1])
    val p2 = Pair(l1[2], l1[3])
    val l2 = readln().split(" ").map { it.toLong() }
    val p3 = Pair(l2[0], l2[1])
    val p4 = Pair(l2[2], l2[3])
    // ccw 끼리 곱했을때 스택오버플로우 발생하기 때문에 return 값을 이렇게 설정
    checkCross(p1,p2,p3,p4)
}