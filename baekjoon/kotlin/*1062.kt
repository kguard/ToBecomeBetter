package com.kguard.tobecomebetter.baekjoon.kotlin

import kotlin.math.max

// 골드 4 가르침
// 그리디 알고리즘 인줄 알았지만, 결국 브루트 포스로 다 도는 것이었음
// 처음에 그냥 제일 자주 나오는 문자가 답인줄(그리디 알고리즘) 알았는데 아니었음
// 기본 5글자를 제외한 모든 조합을 구해서 문자 체크
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    if (k < 5)
        println(0)
    else if (k == 26) {
        println(n)
    } else {
        var result = 0
        val learned = BooleanArray(26)
        learned['a'-'a'] = true
        learned['n'-'a'] = true
        learned['t'-'a'] = true
        learned['c'-'a'] = true
        learned['i'-'a'] = true
        val word = HashSet<String>()

        repeat(n){
            word.add(readln())
        }
        fun comb(depth : Int, index: Int){ // 조합을 구하는 함수

            if (depth == k){ // 개수를 다 채우면
                var count = 0
                for(i in word){
                    if(i.all { learned[it-'a'] }) // 문자가 만들어지는지 확인
                        count++
                }
                result = max(count,result)
                return
            }

            for(i in index until 26){
                if(!learned[i]){
                    learned[i] = true
                    comb(depth+1, i)
                    learned[i] = false
                }
            }

        }
        comb(5,0)
        println(result)

    }

}

// 자주 나오는것을 무조건 배우는게 좋은게 아님
/*
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val map = HashMap<Char, Int>()
    val word = HashSet<String>()
    val set = HashSet<Char>()
    set.add('a')
    set.add('c')
    set.add('n')
    set.add('t')
    set.add('i')
    var result = 0
    repeat(n) {
        val now = readln()
        word.add(now)
        val t = now.removePrefix("anta").removeSuffix("tica")
        for (i in t) {
            if (i !in set)
                map[i] = (map[i] ?: 0) + 1
        }
    }
    val s = map.toList().sortedByDescending { it.second }.take(k-5).toSet()
    for (i in s)
        set.add(i.first)
    for (i in word) {
        if (i.all { it in set })
            result++
    }
    println(result)

}*/
