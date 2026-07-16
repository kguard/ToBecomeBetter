package com.kguard.tobecomebetter.programmers

// 이분 탐색
// 최소 값을 찾기 위한 문제
class Solution_퍼즐_기임_챌린지 {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var answer: Int = 0
        var left = 1
        var right = 100000
        while(left <= right){
            val mid = (left + right) / 2
            if(check(mid, diffs, times) <= limit) // -> 숙련도가 높으면 시간이 더 작아지고, 숙련도가 낮으면 시간이 더 커짐
                // limit 보다 작거나 같다 -> 조건을 만족하면 숙련도를 더 낮춰서 시간 찾기
                right = mid - 1
            else
                // limit 보다 크다 -> 조건을 만족하지 못하기 때문에 숙련도를 더 높여셔 시간 찾기
                left = mid + 1
        }
        answer = left // 제일 왼쪽이 제일 최소 값
        return answer
    }

    fun check(level : Int, diffs: IntArray, times: IntArray) : Long {
        var totalTime = 0L
        totalTime += times[0]
        for(i in 1 until diffs.size){
            if(level >= diffs[i])
                totalTime += times[i]
            else
                totalTime += (times[i] + times[i-1]).toLong() * (diffs[i] - level).toLong() + times[i]
        }
        return totalTime
    }
}