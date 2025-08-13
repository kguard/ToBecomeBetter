package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max
import kotlin.math.min

// 플래티넘 4 도로 네트워크
// 자료 구조, 트리, 최소 공통 조상, 희소 배열
// 모든 도시가 트리 형태로 존재 하기 떄문에 최소 공통 부모를 찾아서 부모까지의 거리의 최소 최대값을 각각 찾으면 되는 문제
// 11438번과 유사하게 문제 풀이(거의 똑같음) 최대 길이, 최소 길이 구하는 부분만 다름
fun main() {
    val n = readln().toInt()
    val m = 17 // n의 최대값이 100000인데 2진수로 표현시 17자리까지 자리가 나옴
    val depth = MutableList(n + 1) { 0 }
    val graph = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val parent = MutableList(m + 1) { MutableList(n + 1) { 0 } } // 부모를 저장할 리스트
    val minDist = MutableList(m + 1) { MutableList(n + 1) { 0 } } // 거리중 작은 거리만 저장하는 리스트
    val maxDist = MutableList(m + 1) { MutableList(n + 1) { 0 } } // 거리중 큰 거리만 저장하는 리스트
    repeat(n - 1) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }

    fun findParent(now: Int, deep: Int) { // 연결되어 있는 부모와 길이들 저장하는 함수
        depth[now] = deep // 깊이 저장
        for (next in graph[now]) {
            if (depth[next.first] == 0) {
                findParent(next.first, deep + 1)
                parent[0][next.first] = now
                minDist[0][next.first] = next.second // 연결된 거리 저장
                maxDist[0][next.first] = next.second // 연결된 거리 저장
            }
        }
    }
    findParent(1, 1)
//    fun findParent(now: Int, prev: Int, deep: Int, prevDist: Int) {
//        depth[now] = deep
//        parent[0][now] = prev
//        maxDist[0][now] = prevDist
//        minDist[0][now] = prevDist
//        for (next in graph[now]) {
//            if (depth[next.first] == 0) {
//                findParent(next.first, now, deep + 1, next.second)
//            }
//        }
//    }
//    findParent(1,0,1,0)

    for(i in 1..m) // 2진수에 맞춰서 부모와 최소 길이와 최대 길이를 저장하기 위한 반복문
        for(j in 1..n){
            parent[i][j] = parent[i-1][parent[i-1][j]]
            minDist[i][j] = min(minDist[i-1][parent[i-1][j]], minDist[i-1][j]) // 이전 거와 비교해서 더 작은 값만 저장
            maxDist[i][j] = max(maxDist[i-1][parent[i-1][j]], maxDist[i-1][j]) // 이전 거와 비교해서 더 큰 값만 저장
        }

    fun lca(a1: Int, b1: Int) : Pair<Int,Int>{ // 최소 공통 부모를 찾아서 거기 까지의 최소 길이 최대 길이 구하기
        var a = a1
        var b = b1
        var minResult = 1000000
        var maxResult = 0
        if(depth[a] < depth[b]) // a의 깊이가 더 크도록
            a = b.also { b = a }

        for(i in m downTo 0) // 1. a와 b의 높이가 같도록 a를 끌어 올리기
            if(depth[a]-depth[b] and (1 shl i) > 0) {
                minResult = min(minResult, minDist[i][a])
                maxResult = max(maxResult, maxDist[i][a])
                a = parent[i][a]
            }
        if(a!=b){ // 2. 두개가 다르면
            for(i in m downTo 0){ // 2-1. a와 b가 같아지도록 끌어 올리면서 최대 길이, 최소 길이 찾기
                if(parent[i][a] != parent[i][b]){
                    minResult = min(minResult, min(minDist[i][a],minDist[i][b]))
                    maxResult = max(maxResult, max(maxDist[i][a],maxDist[i][b]))
                    a = parent[i][a]
                    b = parent[i][b]
                }
            }
            minResult = min(minResult, min(minDist[0][a],minDist[0][b]))
            maxResult = max(maxResult, max(maxDist[0][a],maxDist[0][b]))
        }
        return Pair(minResult,maxResult)
    }
    val k = readln().toInt()
    repeat(k){
        val (a,b) = readln().split(" ").map { it.toInt() }
        val result = lca(a,b)
        println("${result.first} ${result.second}")
    }
}