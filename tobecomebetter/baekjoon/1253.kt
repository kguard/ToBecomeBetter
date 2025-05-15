package com.kguard.tobecomebetter.baekjoon

// 골드 4 좋다
// 정렬, 이분 탐색, 두 포인터 (투 포인터)
// 투 포인터 시작과 마지막을 인덱스로 0 과 list의 마지막으로 설정
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toLong() }.sorted() // 정렬
    var good = 0
    if (n != 1) {
        for (i in list.indices) {
            var start = 0 // 시작
            var end = list.lastIndex // 끝
            while (start < end) { // start 가 end보다 크거나 같으면 다 찾아본거
                if (start == i) { // 자기 자신은 쓰일 수 없으니 start일떄는 start++
                    start++
                    continue
                }
                if (end == i) { // 자기 자신은 쓰일 수 없으니 end일떄는 end--
                    end--
                    continue
                }
                if (list[start] + list[end] < list[i]) // start와 end의 수를 더한것이 원래 숫자보다 작으면 start를 올려서 더한 겂을 키워줌
                    start++
                else if (list[start] + list[end] == list[i]) { // start와 end의 수를 더한것이 원래 숫자와 같으면 good을 올리고 break
                    good++
                    break
                } else //  start와 end의 수를 더한것이 원래 숫자보다 크면 end를 내려서 더한 값을 줄여줌
                    end--
            }
        }
        print(good)
    }
}