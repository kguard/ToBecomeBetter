package com.kguard.tobecomebetter.baekjoon

// 골드 4 가장 가까운 공통 조상
// 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색, 최소 공통 조상(LCA)
// LCA 최소 공통 조상을 구하는 문제 의 기본적인 방식 익히기
// 간단한 LCA 알고리즘 : O(N)
// 1. 루트 노드를 기준으로 DFS를 통해 각 노드의 트리 높이와 부모 노드를 저장해준다.
// 2. 두 노드의 높이를 맞춰준다. -> 이 부분이 포인트
// 3. 부모노드가 일치할 때까지 각 노드의 부모노드로 이동시켜 준다.
// 밑에 문제는 다른 방식으로 해결
// 한쪽의 부모를 모두 찾고, 나머지 한쪽도 부모를 찾을 때 방문했으면 바로 return
fun main(){
    val t = readln().toInt()
    repeat(t){
        val n = readln().toInt()
        val parent = MutableList(n+1){0} // 부모가 들어갈 리스트
        val visited = MutableList(n+1){false} // 방문 유무
        repeat(n-1){
            val (a, b) = readln().split(" ").map { it.toInt() }
            parent[b] = a // 부모 설절
        }
        var (a,b) = readln().split(" ").map { it.toInt() }
        while(a != 0){ // a가 루트 노드까지 이동함
            visited[a] = true // 지나온 부모들 방문 표시
            a = parent[a] // 부모로 변환
        }
        while(b != 0){ // b도 루트 노드까지 이동하는 과정에서
            if(visited[b]) break // 이미 부모를 지나갔으면 break
            b = parent[b]// 부모로 변환
        }
        println(b) // 이미 지나온 최소의 공통 부모를 반환
    }
}