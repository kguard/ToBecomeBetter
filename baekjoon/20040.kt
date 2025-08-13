package com.kguard.tobecomebetter.baekjoon

// 골드 4 사이클 게임
// 자료 구조, 분리 집합
// 입력된 두 점의 루트 노드를 찾았을때 같으면, 연결되었을 때 사이클이 생긴다는 의미 이니 find 값이 같으면 순서 출력한 후 return
fun main(){
    val (n,m) = readln().split(" ").map { it.toInt() }
    val graph = MutableList(n+1){it}
    fun find(x: Int): Int { // 루트 노드 찾기
        return if (graph[x] == x) x
        else {
            graph[x] = find(graph[x])
            graph[x]
        }
    }
    fun union(x: Int, y: Int) { // 합치기 -> 루트 노드가 같아짐
        val nx = find(x)
        val ny = find(y)
        if (nx != ny) graph[nx] = ny
    }
    repeat(m){
        val (a,b) = readln().split(" ").map { it.toInt() }
        if(find(a) == find(b)){ // 루트 노드가 같으면, 연결되었을때 사이클이 형성됨
            println(it+1) // 순서출력
            return // 끝
        }
        union(a,b)
    }
    println(0) // 순서가 출력이 안되었으면 0 출력
}