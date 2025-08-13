package com.kguard.tobecomebetter.baekjoon

// 골드 3 줄 세우기
// 그래프 이론, 위상 정렬, 방향 비순환 그래프
// 순서가 정해져 있는 일련의 작업을 차례대로 수행해야 할 때 사용할 수 있는 알고리즘
// 사이클이 없는 방향 그래프의 모든 노드를 '방향성에 거스르지 않도록 순서대로 나열하는 것
// 사이클이 없는 방향 그래프에서 순서가 있을 때 사용하는 알고리즘이다.
// 진입차수 (Indegree) : 특정한 노드로 들어오는 간선의 개수
// 진출차수 (Outdegree) : 특정한 노드에서 나가는 간선의 개수
//1) 시작하기 전에 진입 차수가 0인 노드를 큐에 삽입한다.
//2) 큐에서 하나씩 꺼내면서 방문한다. 이 때, 방문 결과를 저장하는 변수(result)에 현재 노드를 저장한다.
//3) 현재 방문하고 있는 노드와 연결된 노드들의 진입 차수를 1씩 줄여준다.
//4) 진입 차수가 0인 노드를 큐에 삽입한다.
fun main(){
    val (n,m) = readln().split(" ").map { it.toInt() } // n은 사람 수, m은 먼저 서야하는 조건의 수
    val graph = MutableList(n+1){ mutableListOf<Int>() } // 그래프를 그리기 위한 리스트
    val inDegree = MutableList(n+1){0} // 진입차수(인덱스로 들어오는 간선의 갯수)
    repeat(m){
        val (a,b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b) // 그래프에 추가
        inDegree[b] += 1 // b에 대한 진입차수를 하나 증가 시킴
    }
    val queue = mutableListOf<Int>() // 위상정렬을 하기 위한 큐
    val result = mutableListOf<Int>() // 결과를 저장하기 위한 리스트
    for(i in 1 .. n)
        if(inDegree[i] == 0) // 진입차수가 0인 노드들 큐에 추가
            queue.add(i)
    while (queue.isNotEmpty()){ // 큐가 비어있지 않을떄 까지
        val poll = queue.removeAt(0) // 큐에서 poll
        result.add(poll) // result에 poll 저장
        for(i in graph[poll]){ // poll에서 연결되어 있는 노드에서
            inDegree[i] -= 1 // poll을 result에 저장했으니 진입차수 -1
            if(inDegree[i] == 0) // 진입차수가 0이 되면
                queue.add(i)// queue에 노드 추가
        }
    }
    for(i in result) print("$i ")
}