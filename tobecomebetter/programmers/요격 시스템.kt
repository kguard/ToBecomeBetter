package com.kguard.tobecomebetter.programmers

// 1. 배열안에 값을 마지막 값을 기준으로 정렬
// 2. 현재 배열의 시작 값이 이전 배열의 마지막 값 보다 크면 겹치지 않는걸로 간주하고 값 추가
// 마지막값으로 정렬하는 이유는 마지막 값을 저장하기 때문에
private fun solution(targets: Array<IntArray>): Int {
    var answer = 0
    targets.sortBy { it.last() } // 마지막값을 기준으로 오름차순 정렬
    var end = 0
    for (target in targets) {
        if (target.first() >= end) {
            answer++
            end = target.last()
        }
    }
    return answer
}