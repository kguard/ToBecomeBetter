package com.kguard.tobecomebetter.baekjoon

// 실버 3 패션왕 신해빈
// 수학, 자료 구조, 조합론, 해시를 사용한 집합과 맵, 집합과 맵
// 맵을 사용해서 key가 있으면 +1 해주고 없으면 0+1 로 넣어줌
// 맵의 getOrDefault를 사용해서 문제 해결
fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val cloths = HashMap<String, Int>()
        repeat(n) {
            val (v, key) = readln().split(" ")
            cloths.put(key, cloths.getOrDefault(key, 0) + 1)
        }
        cloths.forEach { cloths.put(it.key, it.value + 1) } // 옷을 안입는 경우도 있기 때문에 안입는 경우 +1 을 해줌
        var ans = 1
        cloths.values.forEach { ans *= it }  // 모든 옷 갯수를 곱함 (안 입는 경우 포함)
        ans -= 1 // 옷을 다 안 입는 경우는 빼야 하기 때문에 -1
        println(ans)
    }
}