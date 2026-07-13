package com.kguard.tobecomebetter.programmers

import kotlin.collections.forEach

class Solution_추억_점수 {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val score = HashMap<String, Int>()
        var answer: IntArray = intArrayOf()

        name.forEachIndexed { index, string ->
            score[string] = yearning[index]
        }

        photo.forEach{ array ->
            var sum = 0
            for(i in array){
                if(score[i] != null)
                    score[i]?.let { sum += it }
            }
            answer += sum
        }


        return answer
    }
}