package com.kguard.tobecomebetter.baekjoon.kotlin

// 실버 1 2026년이 기대되는 이유
// 소수(에라토스테네스의 체)를 이용해서 문제를 해결
private val primeNumbers = sieveOfEratosthenes(100001)
fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()
    val specialNumber = List<Boolean>(100001) { check(it) }
    val specialCount = IntArray(100001)
    for (i in 1..100000) {
        specialCount[i] = specialCount[i - 1] + if (specialNumber[i]) 1 else 0
    }
    repeat(t) {
        val n = readln().toInt()
        sb.append(specialCount[n]).append("\n")
    }
    println(sb)
}

private fun check(num: Int): Boolean {
    if (!primeNumbers[num + 1])
        return false
    var ten = 10
    while (ten <= num) {
        val up = num / ten
        val down = num % ten
        if (!primeNumbers[((up * down) + 1)])
            return false;
        ten *= 10
    }
    return true
}

// 에라토스테네스의 체 -> 소수를 찾는 방법
// 1. 0 과 1은 소수이니 false로 시작
// 2. 2부터 시작해서 i의 제곱이 end값보다 작을 때 까지
// 3. i가 소수 이면 i의 배수들은 다 소수가 아님
// 4. i가 소수가 아니면 넘어감
// 5. 마지막에 i+1
private fun sieveOfEratosthenes(end: Int): List<Boolean> {
    val list = BooleanArray(end + 1) { true }
    list[0] = false
    list[1] = false
    var i = 2 // 2부터 시작
    while (i * i <= end) { // i의 제곱이 마지막 값보다 작은 경우 반복 !! 중요한 부분 -> 제곱수가 end보다 작은 배수만 삭제
        // i * i가 end보다 커지면, 안쪽 for문은 단 한 번도 실행되지 않습니다. 그러니 바깥쪽 while문도 굳이 더 돌 필요 없이 거기서 멈추는 게 효율적입니다.
        if (list[i]) { // 소수로 표현되어 있을 경우
            for (j in i * i..end step i) { // i제곱 부터 end 까지 i의 배수는 다 false
                //여기서 j는 i * i (i의 제곱) 부터 시작합니다. 왜 그럴까요? i보다 작은 수와의 곱셈은 이미 이전 단계의 소수들이 다 처리했기 때문입니다.
                list[j] = false
            }
        }
        i++
    }
    return list.toMutableList()
}

