package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

// 골드 1 외판원 순회
// 다이나믹 프로그래밍, 비트마스킹, 비트필드를 이용한 다이나믹 프로그래밍, 외판원 순회 문제
// Traveling Salesman problem (TSP) 로 중요한 문제중 하나
// 여러 도시들이 있고 한 도시에서 다른 도시로 이동하는 비용이 모두 주어졌을 때, 모든 도시들을 단 한 번만 방문하고 원래 시작점으로 돌아오는 최소 비용의 이동 순서를 구하는 것.
// 모든 지점을 방문하는 브루트 포스도 있지만, 비효율적으로 동적 계획법 (DP) 를 사용해서 문제 해결
// 핵심 : dp[현재 방문도시][방문한 도시 (비트마스크)]에 경로값을 저장한다.
// 비트마스킹 -> 이진수로 나타내기 예시) 5개중 1,3,4를 방문 했다면 11010(2) 으로 표시 가능 -> 각 자릿수가 해당하는 인덱스를 뜻함 -> 3번째 인덱스 1000
// 방문 여부 확인 : visited & (1 << next)
// 방문할 도시 추가 : visited | (1 << next)
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val list = mutableListOf<IntArray>()
    val dp = Array(n) { Array(1 shl n) { -1 } }
    val max = 987654321
    repeat(n) {
        list.add(br.readLine().split(" ").map { it.toInt() }.toIntArray())
    }

    fun dfs(now: Int, visited: Int): Int{
        if (visited == ((1 shl n)-1)){ // 모든 도시 탐색 완료
            return if(list[now][0] == 0) // 다시 도시로 갈수 없는 경우
                max // 무한대 반환
            else
                list[now][0] // 갈 수 있으면 출발도시까지 거리 반환
        }
        if (dp[now][visited] != -1) return dp[now][visited] // 이미 탐색한 위치 이면 위치 값 반환
        dp[now][visited] = max
        for(i in 0 until n){
            if(list[now][i] == 0 || (visited and (1 shl i)) == 1 shl i) // 갈 수 없는 길 이거나, 이미 방문한 도시이면 넘어감
                continue
            dp[now][visited] = min(dp[now][visited], list[now][i] + dfs(i, visited or (1 shl i))) // 다음 도시로 이동할 때, 방문한 도시 추가 + 비용 추가
        }
        return dp[now][visited]
    }
    bw.write("${dfs(0,1)}") // now: 0번째 도시부터 방문, visited: 0번째 도시 방문 처리-> 1부터 시작
    bw.flush()
    bw.close()
}