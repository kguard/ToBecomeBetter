package com.kguard.tobecomebetter.baekjoon

import kotlin.math.pow

// 골드 2 피보나치 수 3
// 수학, 분할 정복을 이용한 거듭제곱
// 피사노 주기 : 피보나치 수를 일정한 수 k로 나누면 반복되어 나온다는 것이다. 주기의 길이를 P라고 하면 N번째 피보나치 수를 M으로 나눈 나머지는 N%P번째 피보나치 수를 M으로 나눈 나머지와 같다.
// 주기는 m = 10^k (k>2) 일때 항상 15*10^(k-1)이게 됨
// n은 10^18 까지고, m은 10^5 까지임
// 재귀를 사용하면 쓸모 없는 연산이 계속되기 때문에 메모리제이션으로 계산
fun main(){
    val n = readln().toBigInteger()
    val m = 10.0.pow(6).toInt()
    val p = (15 * 10.0.pow(5).toInt()).toBigInteger()
    val fibonacci = mutableListOf<Int>()
    fibonacci.add(0)
    fibonacci.add(1)
    for(i in 2..(n%p).toInt()+1)
        fibonacci.add((fibonacci[i-1] + fibonacci[i-2]) % m)
    println(fibonacci[(n%p).toInt()])
}
