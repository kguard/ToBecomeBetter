package com.kguard.tobecomebetter.baekjoon

// 골드 4 타임머신
// 그래프 이론, 최단 경로, 벨만–포드
// 벨만포드 알고리즘으로 해결 -> 다익스트라 알고리즘은 가중치에 음수가 존재하면 해결 불가능
// 벨만포드 알고리즘은 출발치부터 정점-1번 반복 하며 모든 간선을 확인하는 식으로 진행

//다음의 과정을 (n(=정점) - 1)번 반복한다.
//1. 모든 간선 m개를 하나씩 확인한다.
//2. 각 간선을 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
//만약 음수 간선 순환이 발생하는지 체크하고 싶다면 위에 과정을 한 번 더 수행한다.
//--> 이때 최단 거리 테이블이 갱신된다면 음수 간선 순환이 존재하는 것이다.
fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }
//    val graph = MutableList(n+1){ mutableListOf<Pair<Int,Int>>() }
    val graph = mutableListOf<Triple<Int,Int,Int>>()
    repeat(m){
        val (a,b,c) = readln().split(" ").map { it.toInt() }
//        graph[a].add(Pair(b,c))
        graph.add(Triple(a,b,c))
    }
    val visited = MutableList(n+1){Int.MAX_VALUE.toLong()} // 최단거리이기 때문에 음수로 나올수 있는데 여기서 범위가 30억이 넘어가서 Long으로 변환
    fun bellman_ford() : Boolean{ // n-1번 까지 반복하여 최소거리를 구하는 알고리즘 -> 거리에서 음수가 존재해도 가능
        visited[1] = 0 // 1번에만 해당되는 최소거리
        repeat(n){
            for(i in graph){ // 모든 간선을 확인
                // 현재 노드가 무한값이 아니고, 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if(visited[i.first] != Int.MAX_VALUE.toLong() && visited[i.second] > visited[i.first] + i.third) {
                    visited[i.second] = visited[i.first] + i.third
                    if(it == n-1) // n-1번째에서도 값이 변경될 경우 음수 순환이 발생 -> n-1번까지 돌았을때 무조건 최소거리 확정
                        return true
                }
            }
        }
        return false
    }
    if(bellman_ford())
        println(-1)
    else
        for (i in 2..n) {
            if (visited[i] == Int.MAX_VALUE.toLong())
                println(-1)
            else
                println(visited[i])
        }
}