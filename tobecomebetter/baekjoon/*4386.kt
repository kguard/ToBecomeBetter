package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue
import kotlin.math.*


// 골드 3 별자리 만들기
// 그래프 이론, 최소 스패닝 트리
// 1197과 동일한 방식으로 해결 (크루스칼 알고리즘) -> 가중치가 적은 순으로 정렬 후, union-find로 사이클이 생기지 않도록 해결
//fun main(){
//    val n = readln().toInt()
//    val stars = mutableListOf<Triple<Int,Double,Double>>() // index, x좌표, y좌표
//    val graph = mutableListOf<Triple<Int,Int,Double>>() // 시작 점, 끝난 점, 두 점사이의 거리
//    val visited = MutableList(n){it}
//    repeat(n){
//        val (a,b) = readln().split(" ").map { num -> num.toDouble() }
//        stars.add(Triple(it,a,b))
//    }
//    // 두 점 사이의 거리를 구해서 점1, 점2, 두 점사이의 거리 이렇게 저장
//    for(i in stars){
//        for(j in stars){
//            if(i == j) continue
//            graph.add(Triple(i.first,j.first, distance(i,j)))
//        }
//    }
//    graph.sortBy { it.third } // 거리순으로 정렬
//    fun find(x: Int): Int {
//        return if (visited[x] == x) x // 찾는 값에 대한 부모가 같음 -> 자기 자신
//        else {
//            visited[x] = find(visited[x]) // 찾는 값이 부모와 다를때 -> 내 위에 거를 계속해서 찾으면서 값을 넣음 -> 재귀 사용
//            visited[x]  // 부모값 리턴
//        }
//    }
//    fun union(x: Int, y: Int) {
//        val nx = find(x)
//        val ny = find(y)
//        if (nx != ny) visited[ny] = nx
//    }
//    var answer = 0.0
//    for(i in graph)
//        if(find(i.first) != find(i.second)) { // 같은 트리가 아니면
//            union(i.first, i.second) // 같은 집합으로 만들면서
//            answer+=i.third // 두 점사이의 거리 길이 추가
//        }
//    println(answer)
//
//}

// 프림 방법으로 풀기 -> 느낌이 bfs같음
fun main() {
    val n = readln().toInt()
    val stars = mutableListOf<Triple<Int, Double, Double>>() // index, x좌표, y좌표
    val graph = MutableList(n) { mutableListOf<Pair<Int, Double>>() }// 시작점, ( 끝 점, 두 점사이의 거리)
    val visited = MutableList(n) { false }
    repeat(n) {
        val (a, b) = readln().split(" ").map { num -> num.toDouble() }
        stars.add(Triple(it, a, b))
    }
    for (i in stars) {
        for (j in stars) {
            if (i == j) continue
            graph[i.first].add(Pair(j.first, distance(i, j)))
        }
    }
    var sum = 0.0
    val queue = PriorityQueue<Pair<Int, Double>> { a, b -> (a.second - b.second).toInt() } // () 안에 아무것도 없으면 오름차순 -> 두 점사이의 거리를 기준으로 순서가 바뀌는 큐
    queue.add(Pair(0,0.0)) // 시작점인 0을 넣는게 중요
    while (queue.isNotEmpty()) {
        val poll = queue.poll()  // 맨 앞의 값을 가져와서
        if(visited[poll.first]) continue // 방문한 점이면 넘어가고
        visited[poll.first] = true // 방문하지 않았으니, 방문한 걸로 바꿔줨
        sum += poll.second // 맨 앞의 점에 대한 거리 추가
        for (i in graph[poll.first]) { // 맨 앞에서 갈 수 있는 모든 점에서
            if (!visited[i.first]) {  // 방문 하지 않았으면
                queue.add(i) // 큐에 추가
            }
        }
    }
    println(sum)

}

fun distance(first: Triple<Int, Double, Double>, second: Triple<Int, Double, Double>): Double {
    return hypot(first.second - second.second, first.third - second.third)
}

