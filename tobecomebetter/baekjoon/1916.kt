package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue

// 골드 5 최소비용 구하기
// 그래프 이론, 최단 경로, 데이크스트라(다익크스트라)
// 다익크스트라 알고리즘의 기본문제
// 우선순위큐를 사용하는게 시간단축됨(원래도 정석)
// https://velog.io/@717lumos/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BCDijkstra-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
fun main(){
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = MutableList(n+1){mutableListOf<Pair<Int,Int>>()}
    repeat(m) {
        val (a,b,c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(b,c))
    }
    val (start,end) = readln().split(" ").map { it.toInt() }
    fun dijkstra(start : Int, end: Int){
        val distanceFromStart = MutableList(n+1){100000001} // start를 기준으로 한 거리를 저장하는 리스트
        val queue = PriorityQueue<Pair<Int,Int>> {a,b -> a.second - b.second}// pair의 두번째 값 -> 가중치로 우선 순위 정하는 큐, 그 이유는 작은 값을 기준으로 계산하기 위해서
        distanceFromStart[start] = 0 // 자기자신은 0
        queue.add(Pair(start,0))
        while (queue.isNotEmpty()){
            val poll = queue.poll()
            if(poll.second > distanceFromStart[poll.first]) continue // 기존 거리가 새로운 들어온 거리보다 작으면 넘어감
            for(i in graph[poll.first]){ // poll하고 연결된 모든 노드를 탐색
                if(distanceFromStart[i.first] > distanceFromStart[poll.first] + i.second) { // 노드 i가 start와의 원래 거리와 노드 poll을 거처서 가는 경우를 비교
                    distanceFromStart[i.first] = distanceFromStart[poll.first] + i.second // 만약 거처가는 것이 더 작다면 갱신
                    queue.add(Pair(i.first,distanceFromStart[i.first])) // 큐에 노드 i 와 start에서 노드 i 까지의 거리 추가
                }
            }
        }
        println(distanceFromStart[end])
    }
    dijkstra(start,end)
}