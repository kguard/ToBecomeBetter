package com.kguard.tobecomebetter.baekjoon

//// 1. 이분탐색으로 검색해야한다
//fun binarySearch(arr: List<Int>, search: Int): Int {
//    var low = 0
//    var high = arr.size - 1
//    var mid: Int
//    while (low <= high) {
//        mid = (low + high) / 2
//        if (search == arr[mid])
//            return 1  // 리스트 안에 숫자가 있으면 1
//        else if (search < arr[mid])
//            high = mid - 1
//        else
//            low = mid + 1
//    }
//    return 0 // 없으면 0
//}
//
//fun main() {
//    readln()
//    val numCard = readln().split(" ").map { it.toInt() }.sorted()
//    readln()
//    val numCheck = readln().split(" ").map { it.toInt() }
//    for (i in numCheck) {
//        print("${binarySearch(numCard, i)} ")
//    }
//}
// 2. 집합으로 만든다
fun main(){
    readln()
    val numCard = readln().split(" ").map { it.toInt() }.toMutableSet()
    readln()
    val numCheck = readln().split(" ").map { it.toInt() }.toMutableSet()
    for(i in numCheck)
    {
        if(i in numCard)
            print("1 ")
        else
            print("0 ")
    }
}