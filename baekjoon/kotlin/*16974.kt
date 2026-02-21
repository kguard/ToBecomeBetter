package com.kguard.tobecomebetter.baekjoon.kotlin
/*
 골드 5 레벨 햄버거
 분할정복(재귀)로 문제를 해결하는 방법
 경우의 수를 나눠서 푸는 거 였음. 재귀라는 방법은 생각만 했는데 코드를 못 건들겠더라..
 X의 위치를 기준으로 경우의 수를 나눠서 구해주면 됨
 전체 길이와 P의 개수만을 구하는 함수를 이용히여서 X의 현재 위치에 따라서 더해주는 방식으로 구할 수 있음
 현재에서 더할 숫자를 계속해서 이용한다고 생각 하면 됨
 */
fun main() {
    val (n, x) = readln().split(" ").map { it.toLong() }
    val length = LongArray(51) { (1L shl (it + 2)) - 3 }
    fun countP(n: Int) = (1L shl (n + 1)) - 1 // n번쨰 버거 일떄 P의 개수를 세는 알고리즘

    fun count(n: Int, x: Long): Long {
        if (n == 0) { // 0번쨰 일때는 패티가 무조건 1개
            return 1L
        }

        val L = length[n - 1] // n-1번째의 버거의 전체 길이

        // 지금 부분에서 더할 숫자를 의미 한다고 생각하면 됨 -> 위로 올라오면서 숫자를 계속해서 더하게 됨
        return when (x) {
            0L -> 0L // 시작점 일때는 그냥 개수가 없음 0개
            in 1L..L -> count(n - 1, x - 1) // 왼쪽 n-1번쨰 버거에 해당되면 n-1개일때의 x-1번쨰를 보면됨 (맨처음에 B가 있기 때문에)
            L + 1L -> countP(n - 1) + 1 // 가운데 있으면 왼쪽 (n-1)번쨰 버거의 P의 개수 + 1(현재 번쨰거가 P) 이기 때문에
            in L + 2L..(2 * L) + 1L -> countP(n - 1) + 1 + count(n - 1, x - L - 2) // 오른쪽 n-1번째 버거에 존재하면 왼쪽
            else -> countP(n) // 마지막 번쨰 일떄는 그냥 해당 길이를 다 더해주면 됨
        }

    }

    println(count(n.toInt(), x - 1)) // 지금 숫자는 인덱스를 기준으로 했기 때문에 x-1을 넣어줌
}
