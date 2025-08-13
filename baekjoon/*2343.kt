package com.kguard.tobecomebetter.baekjoon

// 실버 1 기타 레슨
// 이분 탐색, 매개 변수 탐색
// 블루레이의 길이를 기준으로 삼기 (중요)
fun main(){
    val (n,m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    println(parametricSearch(list,m))
}
private fun parametricSearch(list: List<Int>, search: Int): Int {
    var left = list.max() // 하나의 블루레이의 하나의 강의가 들어있는 경우의 수 -> 블루레이의 크기는 list의 max 값이어야 함
    var right = list.sum() // 하나의 블루레이의 모든 강의가 들어있는 경우의 수 -> 블루레이의 크기는 다 더한것 이어야 함
    var mid: Int
    while (left <= right) {
        var sum = 0
        var cnt = 0
        mid = (left + right) / 2 // 가운데 값
        for(i in list){
            if(sum + i > mid){ // 다음 번을 더했을 때, mid 보다 숫자가 크면 초기화 및 갯수 증가
                sum = 0
                cnt++
            }
            sum += i // 차례로 더해주기
        }
        if (sum != 0) cnt++ // 마지막 sum이 0이 아닌 이상 블루레이 갯수 하나 증가
        if (cnt > search) // 갯수가 m개 보다 많을 때 블루레이당 강의 사이즈를 키워야 하기 때문에 왼쪽으로 가운데로 옮김
            left = mid + 1
        else // 갯수가 m개 보다 적거나 같으면  블루레이당 강의 사이즈를 줄여아 하기 때문에 오른쪽을 가운데로 옮김
            right = mid - 1
    }
    return left
}