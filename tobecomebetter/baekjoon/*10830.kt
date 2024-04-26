package com.kguard.tobecomebetter.baekjoon

// 골드 4
// 수학, 분할 정복
// 분할 정복을 이용한 거듭 제곱
// 행렬 곱셈과, 거듭제곱 분할 정복을 이용
// 그전에 배웠었던 행렬의 곱셈과, 거듭 제곱을 분할해서 푸는 방식을 동시에 적용해서 문제 해결
fun main() {
    val t = readln().split(" ")
    val a = mutableListOf<MutableList<Long>>()
    repeat(t[0].toInt()) {
        a.add(readln().split(" ").map { it.toLong() }.toMutableList())
    }
    for (i in mul(a, t[1].toLong())) {
        for (j in i)
            print("${j % 1000} ")
        println()
    }

    /*val c = MutableList(n) { MutableList(n) { 0 } }
    for(i in 0 until n)
        for(j in 0 until n)
            c[i][j] = a[i][j]

    repeat(b) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    c[i][j] += c[i][k] * a[k][j]
                }
                c[i][j] %= 1000
            }
        }
    }
    for (i in c) {
        for (j in i)
            print("${j%1000} ")
        println()
    }*/
}

// 행렬 제곱을 구하는 함수 -> 행렬 곱셈을 이용해서 함수 작성
private fun ms(
    a: MutableList<MutableList<Long>>,
    b: MutableList<MutableList<Long>>
): MutableList<MutableList<Long>> {
    val n = a.size // a 와 b는 모두 정사각형 모양의 행렬
    val c = MutableList(n) { MutableList(n) { 0L } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                c[i][j] += a[i][k] * b[k][j] % 1000 // 모듈러 연산을 위해 여기서도 1000 나머지를 구함
            }
        }
    }
    return c
}

// 분할을 사용한 거듭 제곱
private fun mul(a: MutableList<MutableList<Long>>, b: Long): MutableList<MutableList<Long>> {
    if (b == 1L) return a // 지수가 1일 때는 단순히 나머지 연산
    val k = mul(a, b / 2) // 지수를 2로 나누어서 두개로 계산
    return if (b % 2 == 0L) ms(k, k)
    else ms(ms(k, k), a)
}
