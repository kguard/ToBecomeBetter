package com.kguard.tobecomebetter.baekjoon

// 골드 5 트리
// 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색(dfs)
// 리프 노드가 항상 0이 아님
fun main(){
    val n = readln().toInt()
    val parent = readln().split(" ").map { it.toInt() }.toMutableList()
    val del = readln().toInt()
    fun dfs(d : Int){ // 내가 직접 작성한 코드
        parent[d] = -2
        for(i in 0 until n)
            if(parent[i] == d)
                dfs(i)
    }
    dfs(del)
    var count = 0
    for(i in parent.indices) // 해당 인덱스가 트리에 없으면 리프 노드 임
        if(parent[i] != -2 && i !in parent)
            count++
    println(count)
//    println(parent)
}