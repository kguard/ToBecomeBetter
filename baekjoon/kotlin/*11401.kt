package com.kguard.tobecomebetter.baekjoon

// 골드 1 이항 계수3
// 페르마의 소정리, 모듈로 곱셉 역원, 분할 정복, 모듈러 산술
// 숫자가 4000000 까지 올수 있기 때문에 범위가 Long을 넘음
// a mod c = b mod c 이면 (a의 k승) mod c = (b의 k승) mod c 가 성립 한다 -> 모듈러 산술
// -> a mod p = (a의 p승) mod p 가 성립
// a/x 를 a * (x의 -1승) 으로 표현 가능 -> 역원
// a 가 p로 나누어 떨어지지 않을 떄 , (a의 p승) mod p = a mod p 에서 양변 a로 나누면 (a의 p-1승) mod p = 1 mod p 한번더 a로 나누면 (a의 p-2승) mod p = (a의 -1)승 mod p -> 페르마 소정리 사용
/*
fun main() {
    val (n, k) = readln().split(" ").map { it.toLong() }
    val p: Long = 1000000007
    val m = factorialP(k, p) * factorialP(n - k, p) % p  // 분모
    println((factorialP(n, p) * mul(m, p - 2, p)) % p) //
}

// 1629 번에서 가져온 곱셉 mod 함수 a: 몫, b : 지수, c : 모듈러 연산
private fun mul(a: Long, b: Long, c: Long): Long {
    if (b == 1L) return a % c // 지수가 1일 때는 단순히 나머지 연산
    val k = mul(a, b / 2, c) % c // 지수를 2로 나누어서 두개로 계산
    return if (b % 2 == 0L) k * k % c // 지수가 짝수일 경우에는 나눈 두 수를 곱한 다음 나머지 연산 -> 모듈러 연산
    else k * k % c * a % c // 지수가 홀수일 경우에는 나눈 두 수를 곱한 다음 나머지 연산하고, 하나 더 계산 -> 모듈러 연산
}

// 11050에서 가져온 팩토리얼 함수 -> 재귀 함수 // 전체 모듈화 계산
private fun factorialP(n: Long, mod: Long): Long {
    return if (n <= 1) 1L else n * factorialP(n - 1, mod) % mod
}
*/

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val p: Long = 1000000007
    val fact = MutableList(40000001) { 0L }
    fact[0] = 1
    for (i in 1..4000000)
        fact[i] = (fact[i - 1] * i) % p

    val up = fact[n]
    val down = (fact[k] * fact[n - k]) % p

    /* BigInteger로 푸는 방법
    val upBig = up.toBigInteger()
    val downBig = down.toBigInteger().modInverse(p.toBigInteger())
    val result = upBig.multiply(downBig).mod(p.toBigInteger())
    println(result)
    */
    fun pow(base: Long, exp: Long): Long {
        if (exp == 0L)
            return 1L
        else if (exp == 1L)
            return base % p

        val half = pow(base, exp / 2)
        return if (exp % 2 == 0L) {
            (half * half) % p
        } else
            (((half * half) % p) * base) % p

    }

    val inverseDown = pow(down, p-2)
    val result = (up * inverseDown) % p
    println(result)
}
