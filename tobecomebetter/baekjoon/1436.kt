package com.kguard.tobecomebetter.baekjoon

/*
    문제를 거꾸로 푸는 생각을 하여라!!
    그냥 666 부터 하나씩 증가하면서 "666"이 있는지 확인 후, 있으면 count++ 하고, 없으면 넘어감
    count가 입력값과 같으면 break
    ** 브루트 포스이기 때문에 그냥 계속되는 수에서 666를 찾는 편이 낫다 -> 너무 어렵게 생각한거 같음...
 */
fun main() {
    val n = readln().toInt()
    var result = 666
    var count = 0
    while (true) {
        if ("666" in result.toString())
            count++
        if (count == n)
            break
        result++
    }
    println(result)
}