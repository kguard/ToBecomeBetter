package com.kguard.tobecomebetter.programmers

import java.util.Stack

class Solution_택배_상자_꺼내기 {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer: Int = 1
        val stacks = MutableList<Stack<Int>>(w){Stack<Int>()}
        for(i in 0 until n){
            if ((i/w) % 2 == 0)
                stacks[i%w].push(i+1)
            else
                stacks[(w-1) - (i%w)].push(i+1)
        }
        val t =  if (((num-1)/w) % 2 == 0) (num-1)%w else (w-1) - ((num-1)%w)
        while(stacks[t].peek() != num) {
            stacks[t].pop()
            answer++
        }
        return answer
    }
}