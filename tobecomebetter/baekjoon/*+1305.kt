package com.kguard.tobecomebetter.baekjoon

// 플래티넘 4 광고
// 문자열, KMP
// KMP 에서 접두사와 접미사의 패턴을 찾는 방식을 응용하여 푸는 문제
// 전체 길이에서 중복되는 접미사만 제거하면 최소길이를 구할 수 있음
// 문자열의 마지막이 접두사와 중복된 채로 끝난다면 해당 중복 문자열의 길이만큼 광고 문자열을 감소시킬 수 있다.
// -> 접두사와 접미사의 중복을 찾는 리스트에서 마지막 길이 해당 되는 인덱스에서 중복되는 부분을 제거하면 됨
fun main(){
    val l = readln().toInt()
    val p = readln()
    val pattern = MutableList(p.length){0} // 각 인덱스는 p를 인덱스에 맞춰 자른 길이 이며, 값은 접두사와 접미사의 패던이 같은 갯수
    fun table(){ // KMP 함수를 실행하기 전에, 패턴을 알기 위한 함수 -> 접두사와 접미사가 겹치는 부분을 찾기 위한 함수
        var idx = 0 // 접두사(문장의 앞 부분)
        for(i in 1 until pattern.size) { // 접미사(문장의 뒷 부분)
            while (idx > 0 && p[idx] != p[i]) // 접두사를 앞쪽(0쪽)으로 보내면서 같은지 비교하는 부분 -> idx가 맨 앞으로 가거나, 중간에 같은 부분이 있으면 break
                idx = pattern[idx - 1]
            if (p[i] == p[idx]) { // 앞 부분과 뒷 부분이 같으면
                idx += 1 // 접두사를 하나 뒷쪽으로 이동
                pattern[i] = idx // 같은 갯수 저장
            }
        }
    }
    table()
    println(l-pattern.last()) // 전체 길이중 중복되는 접미사만 제거하면 최소길이가 됨
}