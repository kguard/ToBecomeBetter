package com.kguard.tobecomebetter.baekjoon

// 브론즈 2 Hashing
// 구현, 문자열, 해싱
// 모듈러 연산이 중요한 문제
// 총 모듈러 연산을 3번 진행
// 1. 덧셈 모듈러 연산 ((코드 * 제곱수) 의 합) * mod m = (((코드 * 제곱수) mod m)의 합) mod m
// 2. 곱셈 모듈러 연산 (코드 * 제곱수) mod m = ((코드 mod m) * (제곱수 mod m)) mod m
// 3. 제곱 곱셈 모듈러 연산 (제곱수 mod m) = ((n-1제곱 mod m) * (1제곱 mod m)) mod m 의 반복으로 진행
// 2번 설명 : 숫자가 너무 크기 때문에 모듈러 연산으로 해야됨 (코드 * 제곱수) mod m = ((코드 mod m) * (제곱수 mod m)) mod m
// 3번 설명 : 여기 (제곱수 mod m)에서 제곱수도 너무 크기 때문에 제곱수도 모듈러 연산으로 나눠서 계산해야됨
// 예를 들어 (2**5 mod m) = ((2**4 mod m) * (2**1 mod m)) mod m 으로 진행 함 -> 이것도 지수가 작은 경우에만 가능, 더 커지면 크게 쪼개야됨
fun main() {
    val r = 31
    val m = 1234567891
    val l = readln().toInt()
    val list = readln().split("").toMutableList()
    list.removeAt(0)
    list.removeAt(list.lastIndex)
    val code = list.map { it[0].code - 96L } // Char to Int
    var sum = 0L
    for (i in 0 until l) { // 1번, (((코드 * 제곱수) mod m)의 합을 구하기 위한 반복문
        var p = 1L
        for(j in 0 until i) // 3번, 지수를 하나씩 증가하면서 계산하는 과정. 예를 들면, 5 = 4 + 1, 4 = 3 + 1 으로 진행하면 모듈러 연산
            p = (p * r) % m
        sum += code[i] * p % m // 2번들을 다 더해서 1번을 구함, 코드가 26까지 이기 떄문에 모듈러 연산을 해도 코드가 그대로 나옴
    }
    println(sum % m) // 1번, 더하는 부분도 모듈러 연산을 사용했기 때문에 마지막에 sum mod m 진행
}