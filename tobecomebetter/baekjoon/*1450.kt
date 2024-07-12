package com.kguard.tobecomebetter.baekjoon

// 골드 1 냅색문제
// 이분 탐색, 중간에서 만나기
// meet in middle의 문제로 리스트를 절반으로 나눠서 진행
// 각각의 부분합을 구한다음, 이분 탐색으로 경우의 수 구하기
fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    var count = 0
    // 물건을 넣고 안 넣고의 모든 경우의 수
    fun dfs(start: Int, end: Int, list1: MutableList<Int>, sum: Int) { // 모든 부분합을 구하는 함수 -> 부분 합의 경우의 수
        if(sum > c) return
        if (start > end) { // 시작 인덱스가 마지막 인덱스 보다 크면
            list1.add(sum) // 리스트에 부분 합을 추가
            return // 종료
        }
        dfs(start + 1, end, list1, sum) // list[start]의 값을 넣지 않았을 때 합
        dfs(start + 1, end, list1, sum + list[start]) // list[start] 값을 넣었을때 합
    }
    dfs(0, n / 2 - 1, left, 0)
    dfs(n / 2, n - 1, right, 0)
    left.sort()
    for(i in right){ // 오른쪽의 모든 값에 대해서
        var lefts = 0
        var rights = left.size // 중간 구하기
        var mids: Int
        while(lefts < rights){  // 더했을때 범위 구하기
            mids = (lefts + rights) / 2
            if(i + left[mids] > c) // 중간 값과 i를 더한 값이 c 보다 크면 -> 중간 값 이전으로 탐색 진행
                rights = mids // 오른쪽 값을 중간으로 이동
            else // 중간 값과 i를 더한 값이 c와 같거나 작으면 -> 중간 값 이후로 탐색 진행
                lefts = mids +1 // 왼쪽 값을 중간 +1로 이동
        }
        count += rights // 중간 값의 인덱스는 가방에 넣을 수 있는 경우의 수를 의미
    }
    println(count)
}