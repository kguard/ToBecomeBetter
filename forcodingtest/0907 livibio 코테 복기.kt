package com.kguard.tobecomebetter.forcodingtest

import kotlin.math.max
import kotlin.math.min

fun solution1(nums: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 0..nums.size - 3) {
        val a = nums[i]
        val b = nums[i + 1]
        val c = nums[i + 2]

        val isAscending = a < b && b < c
        val isDescending = a > b && b > c

        if (isAscending || isDescending) {
            result.add(1)
        } else {
            result.add(0)
        }
    }
    return result
}

fun solution2(numsInput: MutableList<Int>): MutableList<Int> {
    val result = mutableListOf<Int>()
    while (numsInput.isNotEmpty()) {
        var min = Int.MAX_VALUE
        if (numsInput.size == 1) {
            result.add(numsInput.removeAt(0))
            continue
        }
        if (numsInput[0] > numsInput[1])
            min = min(min, numsInput[0])
        if (numsInput[numsInput.lastIndex] > numsInput[numsInput.lastIndex - 1])
            min = min(min, numsInput[numsInput.lastIndex])
        for (i in 1..numsInput.lastIndex - 1)
            if (numsInput[i - 1] < numsInput[i] && numsInput[i] > numsInput[i + 1])
                min = min(min, numsInput[i])
        numsInput.remove(min)
        result.add(min)
    }
    return result
}

fun solution3(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val result = MutableList(matrix.size) { MutableList(matrix.size) { 0 } }
    for (i in 0 until matrix.size) {
        for (j in 0 until matrix.size) {
            val mRow = matrix[i].mapIndexedNotNull { index, t -> if (index == j) null else t }.distinct()
            val mCol = matrix.mapIndexedNotNull { index, t -> if (index == i) null else t[j] }.distinct()
            if (mRow.size == 1 && mRow == mCol)
                result[i][j] = 1
            else
                result[i][j] = 0
        }
    }
    return result
}

fun solution4(price: MutableList<Int>, algo: MutableList<Int>, k: Int): Int {
    println(algo)
    val t = algo.toMutableList()
    var sum = 0;
    for (i in 0 until price.size) {
        if (algo[i] == 1)
            sum += price[i]
        else
            sum -= price[i]
    }
    println("sum $sum")
    var now = sum
    for (i in 0 until k) {
        if (t[i] == 0)
            t[i] = 1
        if (algo[i] == 0)
            now += (price[i] * 2)
    }
    println(now)
    println(t)
    sum = max(sum, now)
    for (i in 0 until price.size - k) {
        if (algo[i] == 0) {
            now -= (price[i] * 2)
            t[i] = 0
        }
        if (algo[i + k] == 0) {
            now += (price[i + k] * 2)
            t[i + k] = 1
        }
        println(now)
        println(t)
        sum = max(sum, now)
    }

    return sum
}

fun main() {
    val price = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
    val algo = mutableListOf<Int>(0, 1, 0, 0, 1, 0)
    val k = 3
    print(solution4(price, algo, k))
}