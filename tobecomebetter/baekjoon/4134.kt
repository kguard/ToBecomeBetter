package com.kguard.tobecomebetter.baekjoon
//BigInteger은 문자열 형태로 이루어져 있어 숫자의 범위가 무한하기에 어떠한 숫자이든지 담을 수 있기 때문에
// 무한의 정수가 들어갈 수 있는 가능성이 있다면 BigInteger이라는 클래스를 활용하는 것이 좋다.

//BigInteger 제공 메소드
//isProbablePrime(10) : 현재 값이 소수인지 아닌지 판단하는 메소드
//isProbablePrime()메소드에 인자로는 certainty에 대한 값을 넘겨야 하는데 대략 10의 값을 넘기면 해당 값이 소수인지에 대한 판별률이 99.9%에 가까워지기 때문에 10을 매개변수로 넘긴다.
//nextProbablePrime() : 다음 소수 값을 반환해주는 메소드
//BigInteger보다 큰 첫 번째 정수를 보유하는 Biginteger를 반환

fun main(){
    repeat(readln().toInt())
    {
        val a = readln().toBigInteger()
        if(a.isProbablePrime(10))
            println(a)
        else
           println(a.nextProbablePrime())
    }
}

////소수를 판별할 숫자의 제곱근 까지 나누어서 나누어 떨어지지 않으면 해당 숫자는 소수임으로 none 으로 확인 후 결과 리턴
//private fun isPrime(n: BigInteger): Boolean {
//    var i = 2
//    while (i * i <= n) {
//        if (n % i++ == 0) return false
//    }
//    return true
//}