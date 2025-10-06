package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 3 벽 부수고 이동하기 2
// bfs 심화 -> 분기가 나눠지는 bfs
// 벽을 부수고 이동했을때, 벽을 안부수고 이동했을때를 나눠서 찾음
// 3차원 배열의 boolean 배열을 만듬
// 마지막 인덱스는 벽을 몇개 부섰는지를 설정하는 것
fun main(){

    val(n,m,k) = readln().split(" ").map { it.toInt() }
    val map = mutableListOf<List<Int>>()
    repeat(n){
       map.add(readln().map { it.toString().toInt() })
    }
    val visited = Array(n){ Array(m){ BooleanArray(k+1){false} } }

    val moveHeight = mutableListOf(-1,1,0,0)
    val moveWidth = mutableListOf(0,0,-1,1)
    val q = ArrayDeque<MutableList<Int>>()
    q.add(mutableListOf(0,0,0,1)) // y, x, 부순 벽의 개수, 최소거리 -> 시작 거리 포함
    visited[0][0][0] = true // 처음 시작 위치 true
    var result = -1
    while (q.isNotEmpty()){
        val poll = q.removeFirst()
        val y = poll[0]
        val x = poll[1]
        val w = poll[2]
        val count = poll[3]

        if(y == n-1 && x == m-1){
            result = count
            break
        }
        for(i in 0 until 4){
            val ny = y + moveHeight[i]
            val nx = x + moveWidth[i]
            if(ny !in 0 until n || nx !in 0 until m)
                continue

            if(map[ny][nx] == 1 && w < k && !visited[ny][nx][w+1]){
                visited[ny][nx][w+1] = true
                q.add(mutableListOf(ny,nx,w+1,count+1))
            }else if(map[ny][nx] == 0 && !visited[ny][nx][w]){
                visited[ny][nx][w] = true
                q.add(mutableListOf(ny,nx,w,count+1))
            }
        }
    }
    print(result)
}