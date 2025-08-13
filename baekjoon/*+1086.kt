package com.kguard.tobecomebetter.baekjoon

// 플래티넘 5 박성원
// 다이나믹 프로그래밍, 비트마스킹, 비트필드를 이용한 다이나믹 프로그래밍
// "현재 방문지점(bitmask)에서 나머지가 x라면 아직 방문하지 않은 지역을 방문했을 때, k로 완성된 숫자를 나누면 0인 개수"
// 2098번을 참고해서 문제를 해결해야 됨
// 너무 어려워서 설명하기가 어려움... 추후 리뷰 필요
fun main(){
    val n = readln().toInt()
    val list = mutableListOf<String>()
    repeat(n){
        list.add(readln())
    }
    val k = readln().toInt()
    val dp =  MutableList(1 shl n) { MutableList(k) { -1L } } //[방문지점][나머지] 기록을 위한 dp
    val mods = MutableList(n) {MutableList(k) {-1} } //[배열 순서][나머지]에 따른 나머지 값 계산 배열
    fun getMod(idx: Int, mod: Int): Int{ // 나머지를 구하는 함수
        if(mods[idx][mod]!= -1) return mods[idx][mod]
        var curr = mod
        for(i in 0 until list[idx].length){
            curr *= 10 // 10의 자리로 증가
            curr+=(list[idx][i] -'0'); //1의 자리 더하기
            curr %= k // k로 나눈 나머지
        }
        mods[idx][mod] = curr
        return mods[idx][mod]
    }
    fun getDP(bitMask : Int, mod: Int) : Long{ 	//dp를 이용하여 이미 계산한 값을 사용함
        if(dp[bitMask][mod] != -1L) return dp[bitMask][mod]
        if (bitMask == ((1 shl n)-1)) return if(mod == 0) 1 else 0
        var count = 0L
        for(i in 0 until n){
            if ((bitMask and (1 shl i)) == 0){ //아직 방문하지 않았다면
                count += getDP(bitMask or (1 shl i), getMod(i, mod) ) //방문여부 표시, mod 업데이트 하여 재귀한 값을 추가
            }
        }
        dp[bitMask][mod] = count
        return dp[bitMask][mod]
    }
    fun getGcd(a: Long, b: Long) : Long{ // 최대 공약수 구하는 함수
        if(b == 0L) return a
        return getGcd(b, a%b)
    }
    val result = getDP(0,0) //k로 나눈 나머지가 0인 수 계산 (모든 점 미방문, 나머지 0)
    if(result == 0L) println("0/1")
    else{ 	//0이 아니면 최대공약수를 이용하여 기약분수형태로 출력
        var fac = 1L
        for(i in 2 .. n){
            fac *= i
        }
        val gcd = getGcd(fac, result)
        println("${result/gcd}/${fac/gcd}")
    }
}