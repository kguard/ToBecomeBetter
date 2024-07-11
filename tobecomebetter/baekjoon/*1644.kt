package com.kguard.tobecomebetter.baekjoon

// 골드 3 소수의 연속합
// 수학, 정수론, 투 포인터, 소수 판정, 에라토스테네스의 체
// 1806번을 참고하여 문제 해결
// 주어진 값보다 작으면 end를 늘려가며 더하고, 주어진 값과 같은지 확인후 count++, start를 왼쪽으로 옮김
fun main(){
    val n = readln().toInt()
    val a = sieveOfEratosthenes(n+1) // 소수 인것들만 true인 리스트
    var end = 0
    var sum = 0
    var count = 0
    for(i in 2 .. n){ // 마지막 값이 소수 일 수 있음
        if(!a[i]) continue // 소수가 아니면 넘어감
        while(sum < n && end <= n){ // 합이 주어진 수 보다 작고, end가 끝을 넘지 않을때 까지 반복
            if(a[end]) sum += end  // end가 소수 이면 sum에 end를 더함
            end++ // end 이동
        }
        if(sum == n) count ++ // 합이 주어진 수와 같으면, 경우의 수 추가
        sum -= i // start를 옮기기 위하여 부분 합에서 처음 값을 제거하여 start 움직임
    }
    println(count)
}
// 에라토스테네스의 체를 이용하여 소수 구하기
// 주어진 값 만큼의 리스트를 만들어
private fun sieveOfEratosthenes(end: Int): List<Boolean> {
    val list = BooleanArray(end + 1) { true }
    list[0] = false
    list[1] = false
    var i = 2
    while (i * i <= end) { // i의 제곱이 마지막 값보다 작은 경우 반복 !! 중요한 부분 -> 제곱수가 end보다 작은 배수만 삭제
        if (list[i]) { // 소수로 표현되어 있을 경우
            for (j in i * i..end step i) { // i제곱 부터 end 까지 i의 배수는 다 false
                list[j] = false
            }
        }
        i++
    }
    return list.toMutableList()
}

