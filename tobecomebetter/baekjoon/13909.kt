package com.kguard.tobecomebetter.baekjoon
// 약수의 갯수가 홀수인 숫자들을 기점으로 열린 창문의 갯수가 증가 -> 약수의 갯수가 홀수개 이려면 제곱수 여야한다.
// 제곱수만 카운트 해준다
fun main(){
   val n = readln().toInt()
   var i = 1
   var count = 0
   while(i*i <= n)
   {
      count++
      i++
   }
   println(count)
}