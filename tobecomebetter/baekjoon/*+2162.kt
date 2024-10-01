package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 플래티넘 5 선분 그룹
// 자료 구조, 기하학, 분리 집합, 선분 교차 판정
// 기존의 17387, 20149의 선분 교차 판정 + Union_find를 합쳐서 문제 해결하기
// 이중 for문을 사용해서 교차하는지 구하기
private fun ccw(a: Pair<Int,Int>, b: Pair<Int,Int>, c: Pair<Int,Int>): Int {
    val v = (b.first - a.first) * (c.second - b.second) - (c.first - b.first) * (b.second - a.second)
    return when {
        v > 0 -> 1
        v < 0 -> -1
        else -> 0
    }
}
private fun compare(a: Pair<Int,Int>, b: Pair<Int,Int>): Pair<Int, Int> {
    return if (a.first > b.first) a
    else if (a.first < b.first) b
    else {
        if (a.second > b.second) a
        else if (a.second < b.second) b
        else a
    }
}
private fun checkCross(a: Pair<Int,Int>, b: Pair<Int,Int>, c: Pair<Int,Int>, d: Pair<Int, Int>) : Int {
    var aa = a
    var bb = b
    var cc = c
    var dd = d
    val c1 = ccw(aa, bb, cc) * ccw(aa, bb, dd)
    val c2 = ccw(cc, dd, aa) * ccw(cc, dd, bb)
    return if (c1 == 0 && c2 == 0) { // 만나는 한 점이 있거나, 평행하거나 같은 직선에 존재 할 경우
        // 두 선분이 모두 일직선에 존재 할 때, 첫번째 선분에서 작은 값이 두번째 선분에서 큰 값 보다 작아야하고, 두번째 선분에서 작은 값이 첫번째 선분에서 큰 값 보다 작아야 함
        // 일직선에는 존재하지만, 길이 차이로 만나지 않은 경우의 수가 존재
        // aa > bb 일떄, 자리 바꾸기 // 정렬
        if (compare(aa, bb) == aa) aa = bb.also { bb = aa }
        // cc > dd 일때, 자리 바꾸기 // 정렬
        if (compare(cc, dd) == cc) cc = dd.also { dd = cc }
        if (compare(aa, dd) == dd && compare(bb, cc) == bb) {
            1
        } else 0
    } else if (c1 <= 0 && c2 <= 0) { // 두 선분이 일직선에 존재 하거나, 같은 점에서 시작하지 않음
        1
    } else 0
}

fun main(){
    val n = readln().toInt()
    val list = mutableListOf<Pair<Pair<Int,Int>,Pair<Int,Int>>>()
    val group =  MutableList(n){it}
    fun find(x: Int): Int {
        return if (group[x] == x) x // 찾는 값에 대한 부모가 같음 -> 자기 자신
        else {
            group[x] = find(group[x]) // 찾는 값이 부모와 다를때 -> 내 위에 거를 계속해서 찾으면서 값을 넣음 -> 재귀 사용
            group[x]  // 부모값 리턴
        }
    }
    fun union(x: Int, y: Int) {
        val nx = find(x)
        val ny = find(y)
        if (nx != ny) group[ny] = nx
    }
    repeat(n){
        list.add( readln().split(" ").map { it.toInt() }.let { Pair(Pair(it[0],it[1]),Pair(it[2],it[3]))  })
    }
    for(i in 0 until n-1){
        for(j in i+1 until n) {
            if (checkCross(list[i].first, list[i].second, list[j].first, list[j].second) == 1) {
                union(i,j)
            }
        }
    }
    // 마지막에 union을 해도 부모가 통일이 안되기 때문에 마지막에 모든 인덱스 find() 실행
    for(i in 0 until n)
        find(i)

//    println(group)
    println(group.toMutableSet().size)
    println(group.groupingBy { it }.eachCount().maxOf { it.value })
}