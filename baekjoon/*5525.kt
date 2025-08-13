package com.kguard.tobecomebetter.baekjoon

// 실버 1 IOIOI
// 문자열

// 단순하게 움직이며 비교하면 50점 받음
//fun main() {
//    val n = readln().toInt()
//    val s = readln().toInt()
//    val string = readln()
//    var p = "I"
//    repeat(n) { p += "OI" }
//    var count = 0
//    for (i in 0 .. s - (2 * n + 1))
//        if (string.slice(i until i + 2 * n + 1) == p)
//            count++
//    print(count)
//}

// OI가 반복되는 것을 찾기
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val s = readln()
    var cursor = 0 // 위치를 표시 하기 위한 변수
    var count = 0 // OI가 반복되는 횟수를 저장하기 위한 변수
    var result = 0 // 정답
    while (cursor <= m - 3) { // 3개를 계속 비교할것이니 m-3까지 할 수 있도록 함
        if (s.slice(cursor until cursor + 3) == "IOI") { // IOI가 맞으면
            cursor += 2 // OI가 있는 것을 확인 했기 때문에 커서 위치를 2개 옮겨줌
            count++ // OI갯수 하나 증가
            if (count == n) { // OI갯수가 n개와 같으면 결과 출력 + 1
                count-- // 맨 앞부분을 없애서 중간 부터 시작하는 것을 확인하기 위해서 OI갯수 하나 삭제
                result++
            }
        } else { // IOI가 아니면
            cursor += 1 // 커서를 하나 증가해서 바로 다음 인덱스를 확인
            count = 0 // 처음부터 시작이니 count = 0
        }
    }
    print(result)
}