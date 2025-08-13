package com.kguard.tobecomebetter.baekjoon

// 골드 4 최소 스패닝 트리
// 그래프 이론, 최소 스패닝 트리
// 가중치가 작은 순으로 정렬한 다음, 사이클이 생기지 않는 선에서 더하기
// 사이클이 생기는 부분에서는 union-find를 사용 -> 크루스칼 알고리즘
fun main(){
    val (v,e) = readln().split(" ").map { it.toInt() }
    val graph = mutableListOf<Triple<Int,Int,Int>>()
    repeat(e){
        val (a,b,c) = readln().split(" ").map { it.toInt() }
        graph.add(Triple(a,b,c))
    }
    graph.sortBy { it.third }
    val visited = MutableList(v + 1) { it } // 각 인덱스에 해당하는 값은 부모의 값을 뜻함
    // 원소의 부모를 찾는 과정
    // x와 x의 부모가 다름 -> x의 부모를 매개변수로 재귀적으로 수행
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
        if (nx < ny) visited[ny] = nx
        else visited[nx] = ny
    }
    var answer = 0
    for(i in graph)
        if(find(i.first) != find(i.second)) { // 같은 트리가 아니면
            union(i.first, i.second) // 같은 집합으로 만들기
            answer+=i.third // 간선 길이 추가
        }
    println(answer)
}