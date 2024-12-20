package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 명령 프롬프트
// 구현, 문자열
// 첫번째 문자열을 저장 한 다음, 이후 모든 문자열과 하나씩 비교하며 같지 않으면 ? 로 표시
// 2중 for문 사용
fun main(){
    val n = readln().toInt()
    val list = mutableListOf<String>()
    repeat(n){
        list.add(readln())
    }
    val answer = list[0].toMutableList()
    for(i in answer.indices){ // 문자열의 문자를 하나씩 비교
        for(j in 1 until n){ // list의 각 문자열을 찾기
           if(answer[i] != list[j][i]) // 하나라도 같지 않으면 ?
               answer[i] = '?'
        }
    }
    println(answer.joinToString(""))
}