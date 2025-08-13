package com.kguard.tobecomebetter.baekjoon

// 골드 2
// 수학, 분할 정복을 이용한 거듭 제곱
// 숫자가 너무 높기 때문에 기존의 피보나치 식으로는 구할 수 없음
// 1. 도가뉴의 항등식을 이용해서 문제 해결
// 짝수 번쨰 일때는 n(2(n-1) + n)
// 홀수 번째 일때는 (n의 제곱) + (n+1)의 제곱
// 2. 행렬을 이용해서 문제 해결
// 모듈러 연산을 이용  (a+b)mod n = (a mod n + b mod n) mod n

private const val p: Long = 1000000007
private val dFibMap = HashMap<Long, Long>().apply {
    put(0, 0L)
    put(1, 1L)
}
private val fib = mutableListOf(mutableListOf(1L, 1L), mutableListOf(1L, 0L))
fun main() {
    val n = readln().toLong()
//    println(dFibonacci(n))

    println(mul(fib, n - 1)[0][0])
}

// 1. 도가뉴의 항등식을 이용해서 문제 해결
// 짝수 번쨰 일때는 n(2(n-1) + n)
// 홀수 번째 일때는 (n의 제곱) + (n+1)의 제곱
private fun dFibonacci(n: Long): Long {
    if (dFibMap[n] == null) {
        if (n % 2 == 0L) dFibMap[n] =
            (dFibonacci(n / 2) * (2 * dFibonacci(n / 2 - 1) + dFibonacci(n / 2))) % p
        else dFibMap[n] =
            (dFibonacci(n / 2) * dFibonacci(n / 2) + (dFibonacci(n / 2 + 1) * dFibonacci(n / 2 + 1))) % p
    }
    return dFibMap[n] ?: 0L
}

// 2. 행렬을 이용해서 문제 해결
// 행렬로 정리 하게 되면 [[f(n+1), f(n)],[f(n),f(n-1)]]으로 나오게 되어서  초기 값인[[1,1],[1,0]]을 n-1 만큼 제곱하게 되면 [0][0]번쨰에 n번째의 피보나치 수열이 들어오게됨
private fun ms(
    a: MutableList<MutableList<Long>>,
    b: MutableList<MutableList<Long>>
): MutableList<MutableList<Long>> {
    val c = MutableList(2) { MutableList(2) { 0L } }
//    for (i in 0 until n) {
//        for (j in 0 until n) {
//            for (k in 0 until n) {
//                c[i][j] += a[i][k] * b[k][j] % p // 모듈러 연산을 위해 여기서도 1000 나머지를 구함
//            }
//        }
//    }
    c[0][0] = ((a[0][0] * b[0][0]) + (a[0][1] * b[1][0])) % p
    c[0][1] = ((a[0][0] * b[0][1]) + (a[0][1] * b[1][1])) % p
    c[1][0] = ((a[1][0] * b[0][0]) + (a[1][1] * b[1][0])) % p
    c[1][1] = ((a[1][0] * b[0][1]) + (a[1][1] * b[1][1])) % p
    return c
}

private fun mul(a: MutableList<MutableList<Long>>, b: Long): MutableList<MutableList<Long>> {
    if (b <= 1L) return a // 지수가 1일 때는 단순히 나머지 연산
    var k = mul(a, b / 2) // 지수를 2로 나누어서 두개로 계산
    k = ms(k, k)
    if (b % 2 == 1L) k = ms(k, fib)
    return k
}


