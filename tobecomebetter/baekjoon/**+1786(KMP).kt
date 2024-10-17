package com.kguard.tobecomebetter.baekjoon

// 플래티넘 5 찾기
// 문자열, KMP
// 문자열에서 특정 패턴을 찾는 문제
// T[i+j-1] != P[j] -> i는 시작점, j는 얼만큼 움직였는지
// 패턴에서 접두사와 접미사가 같은 부분을 리스트로 저장해서, 원래 문자열과 패턴을 비교중 틀렸을때, 패턴이 같은 부분 부터 탐색하도록 함
// 패턴과 문장의 불일치가 발생했을 때 중복연산을 최대한 피하면서 패턴을 우측으로 이동시킨다. 이를 위해서는 문장의 불일치 발생 시, 얼만큼 건너 뛴 후에 비교연산을 할 것인가를 판단하여야 한다.
// 1. 패턴에서 접두사와 접미사가 같은 부분의 길이를 저장하는 리스트 생성
// 2. 패턴과 문자열을 비교할 때, 접두사 접미사 리스트를 이용해서 그 부분 만큼 건너뛰기
fun main(){
    val t = readln()
    val p = readln()
    val pattern = MutableList(p.length){0} // 각 인덱스는 p를 인덱스에 맞춰 자른 길이 이며, 값은 접두사와 접미사의 패던이 같은 갯수
    val result = mutableListOf<Int>()
    fun table(){ // KMP 함수를 실행하기 전에, 패턴을 알기 위한 함수
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
    var count = 0
    fun KMP(){ // 접두사 접미사를 이용해서 패턴과 문장이 일치하는지 비교하는 함수
        var idx = 0 // p와 t의 패턴의 같은 갯수를 뜻함
        for(i in t.indices) {
            while (idx > 0 && t[i] != p[idx]) // idx는 p와 t의 패턴의 같은 갯수를 뜻하기 때문에, 패턴에서 같은 패턴이 있는 부분을 찾기
                idx = pattern[idx - 1] // 여태까지 같았으니 idx가 증가했고, 현재의 것과 비교 했을때 다르다면, 패턴을 확인해서 같았던 부분으로 이동
            if(t[i] == p[idx]){ // 같다면
                if(idx == p.length-1){ // 같은 갯수가 찾으려는 패턴의 길이와 같다면
                    count++ // 같은 갯수 추가
                    result.add(i-p.length+2) // 같은 부분의 첫 인덱스 출력
                    idx = pattern[idx] // 패턴이 같았던 부분으로 다시 이동
                }
                else
                    idx++ // 같은 갯수가 찾으려는 패턴의 길이 보다 작다면, 하나 증가
            }
        }
    }
    KMP()
    println(count)
    for (i in result)
        print("$i ")
}