package com.kguard.tobecomebetter.baekjoon

//실버 3

var count = 0
var c: Int = 0
var result = -1
lateinit var tmp: MutableList<Int>
fun main() {
    val n = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }.toMutableList()
    tmp = MutableList(size = a.size) { 0 }
    c = n[1]
    merge_sort(a, 0, a.size - 1)
    println(result)
}

fun merge_sort(a: MutableList<Int>, p: Int, r: Int) {
    if (p < r) {
        val q = (p + r) / 2 // q는 p,r의 중간 지점
        merge_sort(a, p, q) // 전반부 정렬
        merge_sort(a, q + 1, r) // 후반부 정렬
        merge(a, p, q, r) // 병합
    }
}

fun merge(a: MutableList<Int>, p: Int, q: Int, r: Int) {
    var i = p
    var j = q + 1
    var t = 0  //배열은 0부터 시작하기에 0으로 초기화
    while (i <= q && j <= r) { // i(초가값)이 q(중간값) 보다 작고, j(중간값+1)이 r(마지막 값) 보다 작을 때 반복
        if (a[i] <= a[j]) // a[i] 값과 a[j]값을 비교하여 더 작은 값을 tmp에 저장하고, 인덱스 증가
            tmp[t++] = a[i++]
        else
            tmp[t++] = a[j++]
    }
    while (i <= q) // 왼쪽 배열이 남는 경우, 나머지 채워 넣기
        tmp[t++] = a[i++]
    while (j <= r) // 오른쪽 배열이 남는 경우, 나머지 채워 넣기
        tmp[t++] = a[j++]
    i = p // 결과를 저장하기 위해서 인덱스 초기화
    t = 0 // 결과를 저장하기 위해서 인덱스 초기화
    while (i <= r) {
        count++
        if (count == c) {
            result = tmp[t]
            break
        }
        a[i++] = tmp[t++]  //결과 저장
    }
}

//var count = 0
//var c: Int = 0
//var result = -1
//fun main() {
//    val n = readln().split(" ").map { it.toInt() }
//    val a = readln().split(" ").map { it.toInt() }.toMutableList()
//    c = n[1]
//    merge_sort(a, 0, a.size - 1)
//    println(result)
//}
//
//fun merge_sort(a: MutableList<Int>, p: Int, r: Int) {
//    if (p < r) {
//        val q = (p + r) / 2 // q는 p,r의 중간 지점
//        merge_sort(a, p, q) // 전반부 정렬
//        merge_sort(a, q + 1, r) // 후반부 정렬
//        merge(a, p, q, r) // 병합
//    }
//}
//
//fun merge(a: MutableList<Int>, p: Int, q: Int, r: Int) {
//    var i = p
//    var j = q + 1
//    val tmp = mutableListOf<Int>()
//    while (i <= q && j <= r) { // i(초가값)이 q(중간값) 보다 작고, j(중간값+1)이 r(마지막 값) 보다 작을 때 반복
//        if (a[i] <= a[j]) // a[i] 값과 a[j]값을 비교하여 더 작은 값을 tmp에 저장하고, 인덱스 증가
//            tmp.add(a[i++])
//        else
//            tmp.add(a[j++])
//    }
//    while (i <= q) // 왼쪽 배열이 남는 경우
//        tmp.add(a[i++])
//    while (j <= r) // 오른쪽 배열이 남는 경우
//        tmp.add(a[j++])
//    i = p
//    var t = 0
//    while (i <= r) {
//        count++
//        if (count == c) {
//            result = tmp[t]
//            break
//        }
//        a[i++] = tmp[t++]  //결과 저장
//    }
//}
