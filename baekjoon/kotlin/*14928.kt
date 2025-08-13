package com.kguard.tobecomebetter.baekjoon

// 브론즈 5 큰 수 (BIG)
// 수학, 사칙연산, 임의 정밀도 / 큰 수 연산
// BigInteger는 사용 불가 -> 시간 초과
// 우리가 평소에 하던 나눗셈 방식으로 문제 해결
// 예를 들어) 4321를 20 으로 나눈다고 할떄
// 1. 4는 20으로 나누면 나머지가 4 이니까 뒤에 3이랑 붙여서 이전해서 43 나누기 20
// 2. 43 나누기 20의 나머지는 3이니까 뒤에 2와 붙여서 32 나누기 20
// 3. 32 나누기 20의 나머지는 12이니까 뒤에 1과 붙여서 121 나누기 20
// 4. 121 나누기 20의 결과는 1
// 5. 따라서 4321 % 20 = 1
fun main() {
    val n = readln()
    var remain = 0
    for(i in n)
        remain = (remain * 10 + i.toString().toInt()) % 20000303
    println(remain)
//    println(readln().toBigInteger() % 20000303.toBigInteger())
}