package com.kguard.tobecomebetter.baekjoon

//골드 4 공유기 설치
// 이분탐색, 매개변수 탐색
/*
fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Long>()
    repeat(n) {
        list.add(readln().toLong())
    }
    list.sort()
    println(parametricSearch(list, c))
}
// 거리를 이용한 이분 탐색을 진행
// 최소 거리는 1 최대 거리는 리스트의 처음과 마지막 차 + 1 로 계산하여
// 거리마다 설치할 수 있는 공유기의 갯수를 검색하여 구하기
private fun parametricSearch(list: List<Long>, search: Int): Long {
    var left = 1L // 두 집 사이의 최소 거리
    var right = list.last() - list.first() + 1// 두 집 사이의 최대 거리
    var mid: Long
    while (left < right) {
        mid = (left + right) / 2
        var prev = list[0] // 공유기가 설치된 이전 집 -> 맨 처음 위치에 공유기 설치
        var count = 1 // 공유기 갯수
        for (i in 1 until list.size) {
            if (list[i] - prev >= mid) {  // 두개의 집 사이의 거리가 설정했던 거리보다 클 경우 -> 공유기 설치 가능
                count++ // 공유기 설치
                prev = list[i] // 공유기가 설치된 이전 집 변경
            }
        }
        if (count >= search) { // 주어진 공유기 개수보다 같거나 더 많이 사용한 경우 -> 설정한 거리가 맞거나 짧은 상황
            left = mid + 1 // 거리를 늘리기 위하여 왼쪽 값을 중간 값 다음으로 이동
        } else { // 주어진 공유기 갯수보다 더 적게 공유기를 사용한 경우 -> 설정한 거리가 너무 긴 경우
            right = mid // 거릴르 줄이기 위하여 오른쪽 값을 중간 값으로 이동
        }
    }
    return right - 1
}
*/
fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Long>()
    repeat(n) {
        list.add(readln().toLong())
    }
    list.sort()
    println(search2(list,c))
}

private fun search(list: List<Long>, search: Int): Long {
    var left = 1L // (A) 가능한 '최소 거리' (정답이 될 수 있는 최소값)
    var right = list.last() - list.first()// (B) 가능한 '최대 거리' (정답이 될 수 있는 최대값)

    while (left < right) {
        val mid = (left + right) / 2 // (C) 현재 확인하려는 '최소 거리' 후보
        var prev = list[0]
        var count = 1

        for (i in 1 until list.size) { // (D) 'mid' 거리를 기준으로 공유기 설치 시뮬레이션
            // (E) 직전 설치 위치(prev)와 현재 집(list[i])의 거리가 mid보다 같거나 크면
            if (list[i] - prev >= mid) {
                count++ // 공유기 설치
                prev = list[i]
            }
        }

        // (F) 'mid' 거리로 C개 이상의 공유기를 설치할 수 있었는가? (즉, mid가 가능한 거리인가?)
        if (count >= search) {
            // [성공] 'mid'는 가능한 거리이다.
            // 하지만 우리는 '최대' 거리를 찾아야 하므로, 더 큰 거리도 가능한지 확인한다.
            // 탐색 범위를 (mid + 1) ~ right 로 좁힌다.
            left = mid + 1
        }
        else {
            // [실패] 'mid' 거리는 너무 커서 불가능한 거리이다.
            // 'mid'는 정답이 될 수 없으므로, 더 작은 거리에서 가능한 값을 찾아야 한다.
            // 탐색 범위를 left ~ (mid) 로 좁힌다. (right = mid)
            right = mid
        }
    }

    // 이 로직(Lower Bound)의 결과로 left(혹은 right)는
    // "설치가 불가능한 최초의 거리"를 가리키게 된다.
    // 따라서 "설치가 가능한 마지막(최대) 거리"는 (left - 1) 또는 (right - 1) 이다.
    return right // (그래서 이 부분은 right - 1 이 되어야 합니다)
}
private fun search2(list: List<Long>, search: Int): Long {

    // --- 1. 탐색 범위 설정 ---

    // [left]: 정답이 될 수 있는 최소 거리
    // 두 집 사이의 거리는 최소 1일 수 있습니다.
    var left = 1L

    // [right]: 정답이 될 수 있는 최대 거리
    // 첫 번째 집과 마지막 집에만 설치하는 경우가 최대 거리입니다.
    var right = list.last() - list.first()

    // [answer]: "설치 가능한" 거리를 찾을 때마다 저장할 변수
    // (조건을 만족하는 mid 중 가장 큰 값을 저장하게 됩니다)
    var answer = 0L

    // --- 2. 이분 탐색 시작 ---

    // left와 right가 교차하기 전까지 (즉, left <= right) 탐색합니다.
    // 'mid' 자체를 정답 후보로 포함하여 확인하기 위해 '='가 포함됩니다.
    while (left <= right) {

        // [mid]: 현재 확인하려는 "최소 거리" 후보
        val mid = (left + right) / 2

        // --- 3. 'mid' 거리로 설치 시뮬레이션 ---

        // 항상 첫 번째 집(list[0])에는 공유기를 설치한다고 가정합니다.
        var prev = list[0] // 직전에 공유기를 설치한 집의 위치
        var count = 1      // 설치한 공유기 개수

        // 두 번째 집부터 순회
        for (i in 1 until list.size) {
            // 현재 집(list[i])과 직전 설치 집(prev)의 거리가
            // 우리가 정한 'mid' 거리보다 같거나 크다면
            if (list[i] - prev >= mid) {
                // 이 집(list[i])에 공유기를 설치할 수 있습니다.
                count++
                prev = list[i] // '직전 설치 위치'를 갱신합니다.
            }
        }

        // --- 4. 시뮬레이션 결과 판별 ---

        // 'mid' 거리로 설치했더니, 목표 개수(search) 이상 설치할 수 있었나요?
        if (count >= search) {
            // [성공] 'mid'는 "설치 가능한 거리"입니다.

            // 1. 이 'mid' 값을 정답 후보로 저장합니다.
            //    (이후 더 큰 mid가 성공하면 이 값은 덮어쓰입니다)
            answer = mid

            // 2. 하지만 우리는 '최대' 거리를 찾아야 합니다.
            //    더 큰 거리(mid + 1 부터)도 가능한지 탐색해봅니다.
            left = mid + 1

        } else {
            // [실패] 'mid' 거리는 너무 깁니다. (목표 개수를 채우지 못했습니다)

            // 1. 'mid'는 정답이 될 수 없습니다.
            // 2. 더 작은 거리(right - 1 까지)에서 가능한 값이 있는지 탐색해봅니다.
            right = mid - 1
        }
    }

    // while 루프가 끝나면(left > right),
    // answer 변수에는 조건을 만족했던(count >= search) 수많은 'mid' 값 중
    // 가장 '마지막'에 저장된 값, 즉 '가장 큰 값'이 남게 됩니다.
    return answer
}