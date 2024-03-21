package com.kguard.tobecomebetter.programmers

class Solution {
    fun solution(numLog: IntArray) : String {
        var string = ""
        for(i in 1 until numLog.size){
            when(numLog[i]-numLog[i-1])
            {
                10 -> string += "d"
                1 -> string += "w"
                -10 -> string += "a"
                -1 -> string += "s"
            }
        }
        return string
    }
}