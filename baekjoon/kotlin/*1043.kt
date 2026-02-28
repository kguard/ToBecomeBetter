package com.kguard.tobecomebetter.baekjoon.kotlin

/*
    골드4 거짓말
    유니온-파인드를 이용해서 푸는 문제
    다른 문제에서도 그룹 끼리 묶고 전파가 필요한 문제들은 유니온 파인드 문제로 푸는 것을 생각해야 할듯
    유니온 파인드를 생각하지 못함 -> 전파 된다고 생각하면 유니온 파인드를 생각했어야 했음

    사실 M이 50까지여서 그냥 다 구해도 된다고 함.
    0을 정답을 아는 그룹으로 묶어서 계산

    순서
    1. 파티를 저장하고, 파티 내의 구성원들 끼지 하나의 구성체로 묶음
    2. 파티를 돌면서 find를 해서 제일 상단의 구성체를 찾아서 확인 (0이면 진실을 아는 그룹)
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { it }
    val parties = mutableListOf<List<Int>>()
    var count = m
    val (knowSize, knowTrue) = readln().split(" ").map { it.toInt() }
        .let { it.first() to it.drop(1) }
    knowTrue.forEach { parent[it] = 0 } // 0은 정답을 아는 그룹

    fun find(a: Int): Int {
        if (parent[a] == a)
            return a
        return find(parent[a]).also { parent[a] = it }
    }

    fun union(a: Int, b: Int) {
        val na = find(a)
        val nb = find(b)
        if (na != nb) {
            if (na < nb)
                parent[nb] = na
            else
                parent[na] = nb
        }
    }

    // 1. 유니온 하는 과정 -> 같은 파티에 참석한 사람들을 하나로 묶기
    repeat(m) {
        val (size, party) = readln().split(" ").map { it.toInt() }.let { it.first() to it.drop(1) }
        if (size > 1)
            for (i in 1 until size)
                union(party[0], party[i]) // 어쩌피 전이 되기 때문에 하나의 값을 고정 시켜 둠 -> 파티내에서 정답을 아는 사람를 늘리는 과정
        parties.add(party)
    }

    // 2. 과장할 파티 개수 세기
    parties.forEach { party ->
        if (parent[find(party[0])] == 0) // 각 파티에서 첫번째 사람이 정답을 알고 있으면 count -- -> 어쩌피 위에서 union을 통해서 정답을 다 공유 했었음
            count--
    }
    println(count)
}

/*
 단순 반복으로 푸는 문제 50번이기 때문에 50*50 번 임
 fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val truthInput = readln().split(" ").map { it.toInt() }

    // 1. 애초에 진실을 아는 사람이 0명이라면?
    // 볼 것도 없이 모든 파티(m개)에서 거짓말 가능! 바로 출력하고 끝냅니다.
    if (truthInput[0] == 0) {
        println(m)
        return
    }

    // 2. 진실을 아는 사람들을 Set(집합)에 모아둡니다.
    // Set을 쓰면 중복해서 들어가는 걸 막아주고, '이 사람이 여기 있나?' 찾는 속도가 엄청 빠릅니다.
    val truthSet = truthInput.drop(1).toMutableSet()

    // 3. 파티 참석자 명단도 리스트에 싹 다 저장해 둡니다. (맨 앞의 '사람 수'는 drop(1)으로 버림)
    val parties = mutableListOf<List<Int>>()
    repeat(m) {
        val party = readln().split(" ").map { it.toInt() }.drop(1)
        parties.add(party)
    }

    // [이 코드의 핵심] 4. 무식하게 파티 개수(M)만큼 전체 파티를 반복해서 훑습니다!
    // 도미노가 아무리 길게 꼬리를 물어도(1번 파티 -> 2번 파티 -> 3번 파티...),
    // 전체 파티가 M개이므로 M번만 돌면 무조건 처음부터 끝까지 소문 전파가 100% 완료됩니다.
    repeat(m) {
        for (party in parties) {
            // any: 파티원 중에 '단 한 명이라도' 진실 집합(truthSet)에 들어있다면?
            if (party.any { it in truthSet }) {
                // 운명 공동체 당첨! 파티원 전원을 진실 집합에 쑤셔 넣습니다.
                truthSet.addAll(party)
            }
        }
    }

    // 5. M번의 루프가 끝나고 소문 전파가 완벽히 끝난 상태.
    // 이제 각 파티를 보면서 '파티원 전원이 진실 집합에 없는(none)' 파티의 개수만 셉니다.
    val count = parties.count { party ->
        party.none { it in truthSet }
    }

    // 최종 결과 출력!
    println(count)
}
 */