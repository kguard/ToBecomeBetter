package com.kguard.tobecomebetter.baekjoon

// 골드 1 제곱ㄴㄴ수
// 수학, 정수론, 소수 판정, 에라토스테네스의 체
// 단순하게 제곱수를 나눠 보는 과정을 진행하면 시간 초과 발생
// 에라토스테네스의 체를 변형해서 문제를 해결
// 1. 시작점을 2의 제곱으로 나눠서 나온 몫을 하나씩 증가시키면서 2의 제곱을 곱하여 나온 수들은 모두 제곱ㄴㄴ수로 판단
// 2. 이후 3, 4.... i의 제곱이 max 값보다 작을때 까지 반복
fun main() {
    val (min, max) = readln().split(" ").map { it.toLong() }
    println(sieveOfEratosthenes(min,max))
}


// 에라토스테네스의 체 변형
private fun sieveOfEratosthenes(start: Long, end: Long): Long {
    val list = BooleanArray((end - start + 1).toInt()) { false }
    var i = 2L // 2부터 시작
    while (i * i <= end) { // i의 제곱이 마지막 값보다 작은 경우 반복 !! 중요한 부분 -> 제곱수가 end보다 작은 배수만 삭제
        var num : Long = start / (i * i) // 처음으로 나오는 몫
        if(start % (i * i) != 0L ) num += 1 // 나누어 떨어지지 않으면 몫 +1 을 해서 범위 안에 들어가게 하기 -> 나머지가 있으면 (몫 * i의 제곱)은 start 보다 작은 값이기 때문
        while(num * (i * i) <= end ){ // 몫 * i 제곱이 max보다 작을때 까지 반복 -> 목 * i제곱은 무조건 나누어 떨어지는 것
            if(!list[((num*(i*i))- start).toInt()]) // 나누어 떨어지지 않는 수로 표시 되어 있으면 변경
                list[((num*(i*i))- start).toInt()] = true
            num++ // 몫 + 1
        }
        i++ // 제곱수 + 1
    }
    return list.count { !it }.toLong() // 나누어 떨어지지 않는 수만 출력
}


// 에라토스테네스의 체 -> 소수를 찾는 방법
// 1. 0 과 1은 소수이니 false로 시작
// 2. 2부터 시작해서 i의 제곱이 end값보다 작을 때 까지
// 3. i가 소수 이면 i의 배수들은 다 소수가 아님
// 4. i가 소수가 아니면 넘어감
// 5. 마지막에 i+1
//private fun sieveOfEratosthenes(end: Int): List<Boolean> {
//    val list = BooleanArray(end + 1) { true }
//    list[0] = false
//    list[1] = false
//    var i = 2 // 2부터 시작
//    while (i * i <= end) { // i의 제곱이 마지막 값보다 작은 경우 반복 !! 중요한 부분 -> 제곱수가 end보다 작은 배수만 삭제
//        if (list[i]) { // 소수로 표현되어 있을 경우
//            for (j in i * i..end step i) { // i제곱 부터 end 까지 i의 배수는 다 false
//                list[j] = false
//            }
//        }
//        i++
//    }
//    return list.toMutableList()
//}
//
