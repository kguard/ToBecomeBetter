package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.TreeSet

// 골드 2 공항
// 중요한 푸는 방법은 i가 들어오면 i 부터 채워 넣는것 i가 채워져있으면 i-1를 채워넣는 방법으로
// 1. 그리디 : TreeSet에 게이트를 저장해 놓고 floor를 이용해서 작거나 같은 게이트부터 삭제하며 count++
// 2. union-find : 각 인덱스에 대한 가능한 게이트를 저장해 놓움. 하나씩 작은 게이트를 저장해서 가능한 해당 게이트를 사용한것으로 취급. find를 이용해서 가능한 게이트를 찾기
fun main(){
    val g = readln().toInt()
    val p = readln().toInt()
    var count = 0
    val insert = mutableListOf<Int>()
    repeat(p){
        insert.add(readln().toInt())
    }

    // union-find로 푸는 방법
    // gemini : union 함수는 굳이 필요 없다 -> 어쩌피 바로 아래거를 부모로 만들것이기 때문에
/*
    val parent = MutableList(g+1){it}
    fun find(a : Int) : Int = if(a==parent[a]) a else find(parent[a]).also { parent[a] = it }

    fun union(a:Int, b: Int){
        val na = find(a)
        val nb = find(b)
        if(na != nb)
            parent[nb] = na
    }

    for(i in insert){
        val j = find(i)
        if(j == 0){
            break
        }else{
            count++
            // union(j-1,j)
            parent[j] = j-1
        }
    }
*/


    // TreeSet을 이용해서 푼 풀이
    val index = TreeSet<Int>()
    repeat(g){
        index.add(it+1)
    }

    for(i in insert){
        val j = index.floor(i)
        if(j == null)
            break
        else{
            index.remove(j)
            count++
        }
    }
    println(count)
}