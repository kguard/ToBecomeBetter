package com.kguard.tobecomebetter.baekjoon

// 골드 4 별 찍기 - 11
// 재귀
// n이 3*2^k 이기 때문에 계속해서 2로 나눠줌
// y는 계속해서 내려가고 x는 양옆으로 퍼져야 됨
fun main() {
    val n = readln().toInt()
    val graph = MutableList(n) { MutableList(n * 2) { " " } }
    fun stars(y: Int, x: Int, nn: Int) {
        if (nn == 3) {
            graph[y][x] = "*"
            graph[y + 1][x - 1] = "*"
            graph[y + 1][x + 1] = "*"
            graph[y + 2][x - 2] = "*"
            graph[y + 2][x - 1] = "*"
            graph[y + 2][x] = "*"
            graph[y + 2][x + 1] = "*"
            graph[y + 2][x + 2] = "*"
        } else {
            stars(y, x, nn / 2)
            stars(y + nn / 2, x + nn / 2, nn / 2)
            stars(y + nn / 2, x - nn / 2, nn / 2)
        }
    }
    stars(0,n-1,n)
    for(i in graph)
        println(i.joinToString(""))
}