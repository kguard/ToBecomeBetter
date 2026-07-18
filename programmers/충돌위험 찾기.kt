package com.kguard.tobecomebetter.programmers

import kotlin.math.abs

class Solution_충돌위험_찾기 {
    fun solution(points: Array<IntArray>, routes: Array<IntArray>): Int {
        var answer: Int = 0
        val r = mutableListOf<List<Triple<Int, Int, Int>>>()

        for (i in routes) {
            val whole = i.map { points[it - 1] }
            r.add(move(whole))
        }

        val rr = r.flatten()
        val count = rr.groupingBy { it }.eachCount()
        answer = count.count { it.value >= 2 }
        return answer
    }

    fun move(routes: List<IntArray>): List<Triple<Int, Int, Int>> {
        val route = mutableListOf<Triple<Int, Int, Int>>()
        var t = 0
        route.add(Triple(t, routes[0][0], routes[0][1]))
        t++
        for (i in 0 until routes.size - 1) {
            val start = routes[i]
            val end = routes[i + 1]
            val time = abs(start[0] - end[0]) + abs(start[1] - end[1])
            for (j in 1..time) {
                var nowY = route.last().second
                var nowX = route.last().third
                if (nowY != end[0]) {
                    if (start[0] > end[0]) {
                        nowY--
                    } else
                        nowY++
                } else {
                    if (start[1] > end[1]) {
                        nowX--
                    } else
                        nowX++
                }
                route.add(Triple(t, nowY, nowX))
                t++
            }
        }
        return route
    }
}