package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 실버 1
private var n = 0
private var nums = mutableListOf<Int>()
private var sign = mutableListOf<Int>()
private var max = Integer.MIN_VALUE
private var min = Integer.MAX_VALUE
fun main() {
    n = readln().toInt()
    nums = readln().split(" ").map { it.toInt() }.toMutableList()
    sign = readln().split(" ").map { it.toInt() }.toMutableList()
    dfs(1, nums[0])
    println(max)
    println(min)
}

private fun dfs(nCount: Int, sum: Int) {
    if (nCount == n) { // 모든 숫자를 다 사용 하였을시에는
        max = max(max, sum)
        min = min(min, sum)
        return
    }
    for (i in sign.indices) // 부호 인덱스 안에서
    {
        if (sign[i] > 0) // 부호가 존재 한다면
        {
            sign[i]-- // 부호 하나 사용
            when (i) { // 다음 으로 이동
                0 -> dfs(nCount + 1, sum + nums[nCount])
                1 -> dfs(nCount + 1, sum - nums[nCount])
                2 -> dfs(nCount + 1, sum * nums[nCount])
                3 -> dfs(nCount + 1, sum / nums[nCount])
            }
            sign[i]++ // 부호 원래 대로 돌려 놓기
        }
    }
}