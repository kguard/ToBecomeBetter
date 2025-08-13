package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*
// 골드 3 우주신과의 교감
// 그래프 이론, 최소 스패닝 트리
// 4386번과 같은 원리로 문제 해결 -> 크루스칼 알고리즘을 사용
// 다른 점은 두 점을 입력받은 다음 먼저 union을 해서 하나의 트리로 만들어서 다시 연결할 수 없도록 함
// 그 다음 두 점사이의 거리를 기준으로 정렬해서 union 진행
fun main(){
    val (n,m) = readln().split(" ").map { it.toInt() }
    val stars = mutableListOf<Triple<Int, Long, Long>>() // index, x좌표, y좌표
    val graph = mutableListOf<Triple<Int,Int,Double>>() // 시작 점, 끝난 점, 두 점사이의 거리
    val visited = MutableList(n+1){it}
    repeat(n){
        val (x,y) = readln().split(" ").map { num -> num.toLong() }
        stars.add(Triple(it+1, x, y))
    }
    for(i in stars){
        for(j in stars){
            if(i == j) continue
            graph.add(Triple(i.first,j.first, distance(i,j)))
        }
    }
    fun find(x: Int): Int {
        return if (visited[x] == x) x // 찾는 값에 대한 부모가 같음 -> 자기 자신
        else {
            visited[x] = find(visited[x]) // 찾는 값이 부모와 다를때 -> 내 위에 거를 계속해서 찾으면서 값을 넣음 -> 재귀 사용
            visited[x]  // 부모값 리턴
        }
    }
    fun union(x: Int, y: Int) {
        val nx = find(x)
        val ny = find(y)
        if (nx != ny) visited[ny] = nx
    }
    var answer = 0.0
    // 입력 받은 두점을 먼저 연결해주는 과정
    repeat(m){
        val (s,e) = readln().split(" ").map { it.toInt() }
        union(s,e) // 두 점 연결하기
    }
    graph.sortBy { it.third }
    for(i in graph)
        if(find(i.first) != find(i.second)) { // 같은 트리가 아니면
            union(i.first, i.second) // 같은 집합으로 만들면서
            answer+=i.third // 두 점사이의 거리 길이 추가
        }
//    println(round(answer*100) / 100)
   println( String.format("%.2f", answer))
}


fun distance(first: Triple<Int, Long, Long>, second: Triple<Int, Long, Long>): Double {
    return hypot((first.second - second.second).toDouble(), (first.third - second.third).toDouble())
}

