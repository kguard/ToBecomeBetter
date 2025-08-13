package com.kguard.tobecomebetter.baekjoon

fun main() {
    val list = sieveOfEratosthenes(1000001)
    repeat(readln().toInt())
    {
        val n = readln().toInt()
        var count = 0
        for(i in 2..n/2)
            if(list[i] && list[n-i])
                count++
        println(count)
    }
}

////소수를 판별할 숫자의 제곱근 까지 나누어서 나누어 떨어지지 않으면 해당 숫자는 소수임으로 none 으로 확인 후 결과 리턴
private fun isPrime(n: Int): Boolean {
    var i = 2
    while (i * i <= n) {
        if (n % i++ == 0) return false
    }
    return true
}
//에라토스테네스의 체
private fun sieveOfEratosthenes(end: Int): List<Boolean> {
    val list = BooleanArray(end + 1) { true }
    list[0] = false
    list[1] = false
    var i = 2
    while (i * i <= end) {
        if (list[i]) {
            for (j in i * i..end step i) {
                list[j] = false
            }
        }
        i++
    }
    return list.toMutableList()
}
