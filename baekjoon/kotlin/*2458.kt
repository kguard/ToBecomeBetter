package com.kguard.tobecomebetter.baekjoon

// 골드 4 키 순서
// 그래프 이론, 그래프 탐색, 깊이 우선 탐색, 최단 경로, 플로이드–워셜
// 모든 노드에서 본인으로 가는 최단 거리가 있거나, 본인에서 시작하여 갈 수 있는 최단 거리가 있으면 몇번째인지 계산기능
// 플로이드-워셜을 사용하여 최단거리를 계산
// 최단거리를 계산한 다음, 본인에서 시작하거나, 본인에서 끝나는 최단 거리가 존재하는지 확인하여 정확한 순서를 알 수있는지 확인
fun main(){
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = MutableList(n+1){MutableList(n+1){500} } // n의 최대가 500임
    repeat(m){
        val (a,b) = readln().split(" ").map { it.toInt() } // a < b 의 키
        graph[a][b] = 1 // 작은 키가 입력 받으면 거리는 무조건 1
    }
    var answer = 0 // 정확한 순서를 알 수 있는 노드의 수

    // 플로이드-워셜 알고리즘
    for (i in 1..n) // i 번째 노드를 거처서 가는 경우 -> 중간 노드
        for (a in 1..n) // a 번째 노드에서 시작하고 -> 시작 노드
            for (b in 1..n)// b 번째 노드에 도착하는 경우 -> 도착 노드
                if (graph[a][b] > graph[a][i] + graph[i][b]) // a에서 b로 가는 기존에 저장되어 있는 최소 거리가 i번째 노드를 거쳐서 가는 경우보다 큰 경우
                    graph[a][b] = graph[a][i] + graph[i][b]

    for(i in 1 .. n){ // 모든 노드를 확인
        var count = 0 // 각 노드의 카운트 생성
        for(j in 1 .. n){
            if(graph[i][j] != 500 || graph[j][i] != 500 ) // 본인 노드로가는 최단거리가 있거나, 본인이 출발해서 갈 수 있는 최단거리가 있으면 count++
                count++
        }
        if(count == n-1) answer++ // 본인 노드를 제외한 모든 노드에 관련있는 최단 거리가 존재하는 경우 (n-1개 일때) -> 정확한 순서를 알 수 있음
    }
    println(answer)
}