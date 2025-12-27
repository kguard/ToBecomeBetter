package com.kguard.tobecomebetter.baekjoon.kotlin

import kotlin.math.max
import kotlin.math.min

// 골드 4 테트로미노
// bfs로 문제 해결 (개같네)
// 모든 bfs를 돌아도 모든 경우의 블럭이 나올 수 있음
// dfs가 맞는 문제 인거 같음
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = mutableListOf<List<Int>>()
    repeat(n) {
        map.add(readln().split(" ").map { t -> t.toInt() })
    }
    var sum: Int = 0
    val moveHeight = mutableListOf(0, 0, 1, -1)
    val moveWidth = mutableListOf(-1, 1, 0, 0)

    fun bfs(p: Pair<Int, Int>) {
        val queue = ArrayDeque<MutableList<Int>>()
        queue.add(
            mutableListOf(
                p.first,
                p.second,
                1,
                map[p.first][p.second],
                p.first * m + p.second,
                -1,
                -1
            )
        )
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            if (poll[2] == 4) {
                sum = max(sum, poll[3])
            }
            for (i in 0 until 4) {
                val ny = poll[0] + moveHeight[i]
                val nx = poll[1] + moveWidth[i]
                if (ny in 0 until n && nx in 0 until m && poll[2] < 4) {
                    val nid = ny * m + nx
                    if (nid != poll[4] && nid != poll[5] && nid != poll[6]) {
                        queue.add(
                            mutableListOf(
                                ny,
                                nx,
                                poll[2] + 1,
                                poll[3] + map[ny][nx],
                                nid,
                                poll[4],
                                poll[5]
                            )
                        )
                    }
                }
            }
        }
    }

    fun bfs2(p: Pair<Int, Int>) {
        var s = map[p.first][p.second]
        var count = 1
        var minVal = 1001
        for (i in 0 until 4) {
            val ny = p.first + moveHeight[i]
            val nx = p.second + moveWidth[i]
            if (ny in 0 until n && nx in 0 until m) {
                s += map[ny][nx]
                count++
                minVal = min(minVal, map[ny][nx])
            }
        }
        if (count == 5) {
            sum = max(sum, s - minVal)
        } else if (count == 4) {
            sum = max(sum, s)
        }
    }
    for (i in 0 until n)
        for (j in 0 until m) {
            bfs(i to j)
            bfs2(i to j)
        }
    println(sum)

}

// dfs로 푸는 방법
/*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

// DFS + 백트래킹 방식
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    // 배열 접근이 리스트보다 빠르므로 IntArray 사용 권장
    val map = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) } // 방문 체크용 배열

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until m) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    var maxVal = 0
    val dy = intArrayOf(-1, 1, 0, 0)
    val dx = intArrayOf(0, 0, -1, 1)

    // 1. DFS 함수 (길쭉이, 네모, ㄴ, ㄹ 모양 담당)
    fun dfs(y: Int, x: Int, depth: Int, sum: Int) {
        // 깊이가 4가 되면 (블록 4개 선택) 종료
        if (depth == 4) {
            maxVal = max(maxVal, sum)
            return
        }

        for (i in 0 until 4) {
            val ny = y + dy[i]
            val nx = x + dx[i]

            // 범위 안이고, 아직 방문하지 않았다면
            if (ny in 0 until n && nx in 0 until m && !visited[ny][nx]) {

                // [백트래킹 핵심]
                visited[ny][nx] = true      // 1. 들어갈 때 체크
                dfs(ny, nx, depth + 1, sum + map[ny][nx])
                visited[ny][nx] = false     // 2. 나올 때 체크 해제 (다른 경로에서 쓸 수 있게)
            }
        }
    }

    // 2. ㅗ 모양 처리 함수 (기존 bfs2 로직 개선)
    // DFS는 한붓그리기라 중간에서 튀어나온 ㅗ 모양을 못 만듦 -> 따로 계산
    fun checkTShape(y: Int, x: Int) {
        var sum = map[y][x]
        var count = 0
        var minVal = 1001 // 최소값을 찾아서 빼기 위함

        // 4방향을 다 살핀다
        for (i in 0 until 4) {
            val ny = y + dy[i]
            val nx = x + dx[i]

            if (ny in 0 until n && nx in 0 until m) {
                count++
                sum += map[ny][nx]
                minVal = min(minVal, map[ny][nx])
            }
        }

        // + 모양(5칸)이면 그중 제일 작은거 하나를 뺌 -> ㅗ,ㅏ,ㅜ,ㅓ 중 최대값
        if (count == 4) {
            maxVal = max(maxVal, sum - minVal)
        }
        // 딱 3방향만 유효하면 그 자체가 ㅗ,ㅏ,ㅜ,ㅓ 모양
        else if (count == 3) {
            maxVal = max(maxVal, sum)
        }
    }

    // 전체 좌표 순회
    for (i in 0 until n) {
        for (j in 0 until m) {
            // DFS 시작 전 시작점 방문 처리
            visited[i][j] = true
            dfs(i, j, 1, map[i][j])
            visited[i][j] = false // 다음 턴을 위해 해제

            // ㅗ 모양 확인
            checkTShape(i, j)
        }
    }

    println(maxVal)
}*/
