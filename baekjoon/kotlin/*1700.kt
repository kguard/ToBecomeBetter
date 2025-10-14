package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 1 멀티탭 스케줄링

// 전체 빈도를 계산한 처음 풀이 (오답)
/*
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ")
    val map = HashMap<String,Int>()
    list.forEach { map[it] = map.getOrDefault(it,0)+1}
    val set = HashSet<String>()
    var index = 0
    while (set.size < n){
        if(list[index] !in set) {
            set.add(list[index])
            index++
        }
    }
    var count = 0
    for(i in index until m){
        if(list[i] !in set){
            val remove = set.minBy {map.getValue(it)}
            set.remove(remove)
            set.add(list[i])
            count++
        }
    }
    println(count)
}*/


// 미래를 보고 가장 늦게 사용될 플러그를 뽑는 것이 최소한의 플러그를 뽑을 수 있는 수가 됨
// Set을 이용해서 콘센트 취급
// 최적 페이지 교체 알고리즘
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ")
    val set = HashSet<String>()

    var count = 0

    list.forEachIndexed { index, string ->

        // 이미 set(플러그에 꽂혀있으면)안에 있으면 넘어감
        if(string in set)
            return@forEachIndexed // continue 역할

        // set(플러그가 다 안꽂혀있으면) 의 사이즈가 다 채워지지 않았으면 넣어줌
        if(set.size < n) {
            set.add(string)
            return@forEachIndexed
        }

        // 제일 나중에 쓰일 플러그를 찾음 -> 인덱스가 제일 큰 값
        // 찾아서 그 플러그를 뽑아줌
        val remove = set.maxBy {
            val min = list.subList(index+1,m).indexOf(it)
            if(min == -1) Int.MAX_VALUE else min
        }
        set.remove(remove) //
        count++
        set.add(string)
    }

    println(count)
}
