package com.kguard.tobecomebetter.baekjoon

// 실버 5 팩토리얼 0의 개수
// 수학
// 팩토리얼을 다 구할 수는 없음
// 뒤에 0이 나오려면 5의 갯수 만큼 나오면 됨 5, 10, 15, 20 ...
// 근데 25, 125 는 5의 거듭 제곱이기 때문에 5가 더 많이 나옴
// 따라서 n/5의 개수 + n/25의 개수 + n/125의 개수 하면 됨 (500까지이니 5의 4제곱은 필요 없음)
fun main() {
    val n = readln().toInt()
    var sum = 0
    sum += n/5
    sum += n/25
    sum += n/125
    println(sum)
}
