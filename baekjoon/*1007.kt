package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 골드 2 벡터 매칭
// 수학, 브루트포스 알고리즘(그냥 단순 무식하게 푸는 문제)
// 점들의 집합에서 조합을 이용해서 절반에 해당 되는 부분만 빼주면 됨 -> 벡터의 합을 이용한 방식

// 점 4개중에서
// v1 = (x1-x2, y1-y2)
// v2 = (x3-x4, y3-y4) 라고 할 때
// v1 + v2 = ( (x1-x2) + (x3-x4) , (y1-y2) + (y3-y4) ) 을
// ( (x1+x3) - (x2+x4) , (y1+y3) - (y2+y4) )으로 볼 수 있다.
// 더하는 집단은 (모든 더한 집합) - (빼는 집단) 으로 표현 가능
// 따라서 임의로 ((전체 x합) - (임의로 정한 절반의 x합)){더하는 집단} - (임의로 정한 절반의 x합){빼는 집단} 으로 구하면 된

private fun combination( // 갯수에 맞는 모든 조합을 찾는 함수
    result: MutableList<List<Pair<Int, Int>>>, // 결과를 저장할 집합
    origin: MutableList<Pair<Int, Int>>, // 조합을 구할 원래 잡헙
    check: MutableList<Boolean>, // 중복을 방지하기 위한 Boolean 집합
    start: Int, // 조합을 구할 시작점
    target: Int // 조합의 갯수
) {
    if (target == 0) // 타겟 갯수가 0 이면, 그 동안 true로 바꿔놓은 위치들 추가
        result.addAll(mutableListOf(origin.filterIndexed { index, pair -> check[index] }))
    else
        for (i in start until origin.size) {
            check[i] = true // result로 들어갈 숫자 고르기
            combination(result, origin, check, i + 1, target - 1)
            check[i] = false
        }
}
fun main(){
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val p = mutableListOf<Pair<Int, Int>>() // 좌표들의 집합
        val combine = mutableListOf<List<Pair<Int, Int>>>() // 좌표들의 집합에서 절반의 갯수로 구하는 조합들의 집합 (이중 리스트)
        var min = 1000000.0 // 벡터의 최소값이 들어갈 부분
        var xTotal = 0 // x를 다 더한 값
        var yTotal = 0 // y를 다 더한 값
        repeat(n) {
            val (x, y) = readln().split(" ").map { it.toInt() }
            xTotal += x
            yTotal += y
            p.add(Pair(x, y))
        }
        combination(combine, p, MutableList(n) { false }, 0, n / 2) // 원래 집합에서 절반의 조합을 구하는 함수의 집합 -> 모든 조합이 구해짐
        for (i in combine) {
            var xSum = 0 // 뺴는 부분의 x값을 다 더한 값
            var ySum = 0 // 빼는 부분의 y값을 다 더한 값
            for (j in i) {
                xSum += j.first
                ySum += j.second
            }
            xSum -= xTotal - xSum // 더하는 집단은 (모든 더한 집합) - (빼는 집단) 으로 표현 가능 우리가 구해야 할건 (더하는 집단) - (빼는 집단) 이기 떄문에 이렇게 표현
//            xSum = xTotal - xSum - xSum
            ySum -= yTotal - ySum // 더하는 집단은 (모든 더한 집합) - (빼는 집단) 으로 표현 가능 우리가 구해야 할건 (더하는 집단) - (빼는 집단) 이기 떄문에 이렇게 표현
//            ySum = yTotal- ySum - ySum
            min = min(min, hypot(xSum.toDouble(), ySum.toDouble())) // 최소값 구하기
        }
        println(min)
    }
}