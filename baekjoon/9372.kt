package com.kguard.tobecomebetter.baekjoon

// 실버 4 상근이의 여행
// 그래프 이론, 트리
// 가장 적은 비행기의 갯수를 구하는 문제
// dfs로 문제 해결
// 사실 더 쉽게 푸는 방식 존재 -> 최소 신장 트리의 성질 (밑으로)
//fun main(){
//    val t = readln().toInt()
//    repeat(t){
//        val (n,m) = readln().split(" ").map { it.toInt() }
//        val graph = MutableList(n+1){ mutableListOf<Int>() }
//        repeat(m){
//            val (a,b) = readln().split(" ").map { it.toInt() }
//            graph[a].add(b)
//            graph[b].add(a)
//        }
//        val visited = MutableList(n+1){false}
//        var count = 0
//        fun dfs(s: Int){
//            visited[s] = true
//            count+=1
//            for(i in graph[s]){
//                if(!visited[i])
//                    dfs(i)
//            }
//        }
//        dfs(1)
//        println(count-1)
//    }
//}

// 사실 정답은 무조건 n-1이 됨 -> 최소 신장 트리로 모든 정점이 연결되어 있기 때문에 간선 = 정점 - 1
// 모든 국가는 연결 되어 있기 때문에 비행기의 최소 종류는 국가 - 1 이된다
fun main(){
    val t = readln().toInt()
    repeat(t){
        val (n,m) = readln().split(" ").map { it.toInt() }
        repeat(m){
            val (a,b) = readln().split(" ").map { it.toInt() }
        }
      println(n-1)
    }
}