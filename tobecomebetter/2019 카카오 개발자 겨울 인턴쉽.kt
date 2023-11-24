package com.kguard.tobecomebetter

fun main() {
//    println(
//        crane(
//            arrayOf(
//                intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 1, 0, 3), intArrayOf(0, 2, 5, 0, 1),
//                intArrayOf(4, 2, 4, 4, 2), intArrayOf(3, 5, 1, 3, 1)
//            ), intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
//        )
//    )
//    tuple("{{4,2,3},{3},{2,3,4,1},{2,3}}")
//    print(crossBridge(intArrayOf(7, 2, 8, 7, 2, 5, 9), 3))
//    errorUser(
//        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
//        arrayOf("fr*d*", "*rodo", "******", "******")
//    )

    println(errorUser(
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
        arrayOf("*r*d*", "*rodo", "******")
    ))
}

fun crane(board: Array<IntArray>, moves: IntArray): Int {
    val mBoard = mutableListOf<MutableList<Int>>()
    val sol = mutableListOf<Int>()
    var count = 0
    for (i in board.indices) {
        val ml = mutableListOf<Int>()
        for (j in board[i].indices.reversed()) {
            ml.add(board[j][i])
        }
        mBoard.add(ml)
    }
    for (i in mBoard)
        i.removeAll(listOf(0))
    for (i in moves) {
        if (mBoard[i - 1].isEmpty())
            continue
        val n = mBoard[i - 1].last()
        mBoard[i - 1].removeLast()
        if (sol.isNotEmpty() && sol.last() == n) {
            sol.removeLast()
            count += 2
        } else
            sol.add(n)
    }
    return count
}

fun tuple(s: String): IntArray {
    val ms = mutableListOf<Int>()
    val split = s.split("},{").map { it.replace("{", "").replace("}", "") }.sortedBy { it.length }
        .toMutableList()
    for (i in split) {
        if (i.length == 1) {
            ms.add(i.toInt())
            continue
        } else {
            val u = i.split(",").toMutableList()
            for (t in ms) {
                u.remove(t.toString())
            }
            ms.add(u.last().toInt())
        }
    }
    return ms.toIntArray()

}

fun crossBridge(stones: IntArray, k: Int): Int {
    // 이분 탐색으로 찾는 방법
    var min: Int = stones.minOrNull()!!
    var max = stones.maxOrNull()!!
    while (min <= max) // 최소 값과 최대 값이 같아질때 까지 반복
    {
        val mid = (max + min) / 2  // 가장 큰값과 작은 값을 더해서 나눠 중간 값을 구함
        println("min:$min, max:$max, mid:$mid")
        val check = crossBridgeCheck(stones, mid, k) // 중간 값에 대한 다리를 건넜는지 못 건넜는지 확인
        if (check) // 다리를 건넜으면
            min = mid + 1 // 중간 값 이후에 다리를 건넌것 -> 최소값을 중간값+1 로 지정
        else // 다리를 못 건넜으면
            max = mid - 1 //중간 값 이전에 다리를 못 건넌것 -> 최대 값을 중간값-1 로 지정
    }
    return min
}

private fun crossBridgeCheck(stones: IntArray, mid: Int, k: Int): Boolean {
    var cnt = 0
    for (i in stones.indices) {
        if (stones[i] - mid <= 0) // 중간 값이 비교 값 보다 클때 -> 돌을 못 건넜다
            cnt++ // 못 건넜으니 카운트 증가
        else // 중간 값이 비교 값보다 작다 -> 돌을 건넜다
            cnt = 0 // 돌을 건넜으니 카운트 복귀
        if (cnt == k) // 돌을 k개 한번에 못 건너니 다리를 못 건넌것
            return false // 실패
    }
    return true //다리를 건넜다
}
fun errorUser(userIdList: Array<String>, bannedIdList: Array<String>): Int {
    val result = mutableSetOf<Set<String>>() // 총 결과를 넣기 위한 set
    val banned = mutableListOf<Regex>() // 정규 표현식을 위한 리스트
    for (i in bannedIdList)
        banned.add(i.replace("*", ".").toRegex()) // 정규표현식으로 바꾸기
    fun isMatch(userId: String, bannedId: Regex): Boolean {
        return bannedId.matches(userId) // userId와 정규 표현식 비교
    }
    println(userIdList.toMutableList())
    fun dfs(index: Int, selected: MutableSet<String>) {
        println("DFS Call: index=$index, selected=$selected")

        if (index == banned.size) {
            println("Add to Result: $selected")
            result.add(selected.toSet()) // 결과에 셀렉트 넣기
            return // 함수 끝내기
        }

        for (userId in userIdList) {
            println("Matching: userId=$userId, bannedId=${banned[index]}")
            if (userId !in selected && isMatch(userId, banned[index])) { // set안에 userId가 존재하는지 확인 and 정규표현식에 맞는지 확인
                println("Matched: userId=$userId, bannedId=${banned[index]}")
                selected.add(userId) // 위 두 조건에 만족하면 set에 userId 추가
                dfs(index + 1, selected) // 재귀 함수 호출로 다음 정규표현식을 비교
                selected.remove(userId) // set에서 마지막 것 삭제
                println("Backtrack: $selected") // 백트래킹 실행
            }
        }
    }

    dfs(0, mutableSetOf())
    return result.size
}
/*
[frodo, fradi, crodo, abc123, frodoc] -> 실행 시작
DFS Call: index=0, selected=[]  -> dfs(0) 시작
Matching: userId=frodo, bannedId=.r.d. -> dfs(0) 첫번쨰 userId 첫번쨰 정규표현식과 비교
Matched: userId=frodo, bannedId=.r.d. -> dfs(0) 첫번쨰 userId 가 set에 존재하지 않고, 첫번째 정규표현식에 match 됨
DFS Call: index=1, selected=[frodo] -> dfs(1) 시작
Matching: userId=frodo, bannedId=.rodo -> dfs(1) 첫번쨰 userId와 두번째 정규표현식과 비교 -> 첫번째 userId set에 존재 -> 실패
Matching: userId=fradi, bannedId=.rodo -> dfs(1) 두번째 userId와 두번쨰 정규표현식과 비교 -> 정규표현식 안맞음 -> 실패
Matching: userId=crodo, bannedId=.rodo -> dfs(1) 세번째 userId와 두번쨰 정규표현식과 비교
Matched: userId=crodo, bannedId=.rodo -> dfs(1) 세번째 userId 가 set에 존재하지 않고, 두번째 정규표현식에 match 됨
DFS Call: index=2, selected=[frodo, crodo] -> dfs(2) 시작
Matching: userId=frodo, bannedId=...... -> dfs(2) 첫번쨰 userId와 세번째 정규표현식과 비교 -> 첫번째 userId set에 존재 -> 실패
Matching: userId=fradi, bannedId=...... -> dfs(2) 두번째 userId와 세번쨰 정규표현식과 비교 -> 정규표현식 안맞음 -> 실패
Matching: userId=crodo, bannedId=...... -> dfs(2) 세번째 userId와 세번쨰 정규표현식과 비교 -> 세번째 userId set에 존재 -> 실패
Matching: userId=abc123, bannedId=......-> dfs(2) 네번째 userId와 세번쨰 정규표현식과 비교
Matched: userId=abc123, bannedId=...... -> dfs(2) 네번째 userId가 set에 존재하지 않고, 세번째 정규표현식에 match 됨
DFS Call: index=3, selected=[frodo, crodo, abc123] -> dfs(3) 시작
//todo Add to Result: [frodo, crodo, abc123] -> dfs(3) index == banned.size 이기 때문에 result에 추가하고 dfs(3) 함수 종료 1
Backtrack: [frodo, crodo] -> dfs(2)의 remove 실행
Matching: userId=frodoc, bannedId=...... -> dfs(2) 다섯번째 userId와 세번째 정규표현식 비교
Matched: userId=frodoc, bannedId=...... -> dfs(2) 다섯번째 userId가 set에 존재하지 않고, 세번째 정규표현식에 match 됨
DFS Call: index=3, selected=[frodo, crodo, frodoc] -> dfs(3) 시작
//todo Add to Result: [frodo, crodo, frodoc] -> dfs(3) index == banned.size 이기 때문에 result에 추가하고 dfs(3) 함수 종료 2
Backtrack: [frodo, crodo] -> dfs(2)의 remove 실행, 다섯번째까지 다 돌았으므로 dfs(2) 종료
Backtrack: [frodo] -> dfs(1)의 remove 실행
Matching: userId=abc123, bannedId=.rodo -> dfs(1) 네번쨰 userId와 두번째 정규표현식 비교 -> 정규표현식 안맞음 -> 실패
Matching: userId=frodoc, bannedId=.rodo -> dfs(1) 다섯번쨰 userId와 두번째 정규표현식 비교 -> 정규표현식 안맞음 -> 실패
Backtrack: [] -> 다섯번째까지 다 돌았으므로 dfs(1) 종료, dfs(0)의 remove 실행
Matching: userId=fradi, bannedId=.r.d. -> dfs(0) 두번째 userId와 첫번쨰 정규표현식 비교
Matched: userId=fradi, bannedId=.r.d. -> dfs(0) 두번째 userId가 set에 존재하지 않고, 첫번쨰 정규표현식에 match 됨
DFS Call: index=1, selected=[fradi] -> dfs(1) 시작
Matching: userId=frodo, bannedId=.rodo -> dfs(1) 첫번쨰 userId와 두번째 정규표현식과 비교
Matched: userId=frodo, bannedId=.rodo  -> dfs(1) 첫번쨰 userId 가 set에 존재하지 않고, 두번재 정규표현식에 match 됨
DFS Call: index=2, selected=[fradi, frodo] -> dfs(2) 시작
Matching: userId=frodo, bannedId=...... -> dfs(2) 첫번쨰 userId와 세번째 정규표현식과 비교 -> 첫번째 userId set에 존재 -> 실패
Matching: userId=fradi, bannedId=...... -> dfs(2) 두번째 userId와 세번쨰 정규표현식과 비교 -> 두번째 userId set에 존재 -> 실패
Matching: userId=crodo, bannedId=...... -> dfs(2) 세번째 userId와 세번쨰 정규표현식과 비교 -> 정규표현식 안맞음 -> 실패
Matching: userId=abc123, bannedId=...... -> dfs(2) 네번째 userId와 세번쨰 정규표현식과 비교
Matched: userId=abc123, bannedId=...... -> dfs(2) 네번째 userId가 set에 존재하지 않고, 세번째 정규표현식에 match 됨
DFS Call: index=3, selected=[fradi, frodo, abc123] -> dfs(3) 시작
//todo Add to Result: [fradi, frodo, abc123] -> dfs(3) index == banned.size 이기 때문에 result에 추가하고 dfs(3) 함수 종료 3
Backtrack: [fradi, frodo] -> dfs(2)의 remove 실행
Matching: userId=frodoc, bannedId=...... -> dfs(2) 다섯번째 userId와 세번째 정규표현식 비교
Matched: userId=frodoc, bannedId=...... -> dfs(2) 다섯번째 userId가 set에 존재하지 않고, 세번째 정규표현식에 match 됨
DFS Call: index=3, selected=[fradi, frodo, frodoc] -> dfs(3) 시작
//todo Add to Result: [fradi, frodo, frodoc] -> dfs(3) index == banned.size 이기 때문에 result에 추가하고 dfs(3) 함수 종료 4
Backtrack: [fradi, frodo] -> dfs(2)의 remove 실행, 다섯번째까지 다 돌았으므로 dfs(2) 종료
Backtrack: [fradi] -> dfs(1)의 remove 실행
Matching: userId=fradi, bannedId=.rodo -> dfs(1) 두번째 userId와 두번째 정규표현식 비교 -> 두번째 userId set에 존재 -> 실패
Matching: userId=crodo, bannedId=.rodo -> dfs(1) 세번째 userId와 두번째 정규표현식 비교
Matched: userId=crodo, bannedId=.rodo -> dfs(1) 세번째 userId가 set에 없고, 두번째 정규표현식에 match됨
DFS Call: index=2, selected=[fradi, crodo] -> dfs(2)시작
Matching: userId=frodo, bannedId=...... -> dfs(2) 첫번쨰 userId와 세번째 정규표현식과 비교 -> 정규표현식과 안맞음 -> 실패
Matching: userId=fradi, bannedId=...... -> dfs(2) 두번째 userId와 세번쨰 정규표현식과 비교 -> 두번째 userId set에 존재 -> 실패
Matching: userId=crodo, bannedId=...... -> dfs(2) 세번째 userId와 세번쨰 정규표현식과 비교 -> 세번째 userId set에 존재 -> 실패
Matching: userId=abc123, bannedId=...... -> dfs(2) 네번째 userId와 세번쨰 정규표현식과 비교
Matched: userId=abc123, bannedId=...... -> dfs(2) 네번째 userId가 set에 존재하지 않고, 세번째 정규표현식에 match 됨
DFS Call: index=3, selected=[fradi, crodo, abc123] -> dfs(3) 시작
//todo Add to Result: [fradi, crodo, abc123] -> dfs(3) index == banned.size 이기 때문에 result에 추가하고 dfs(3) 함수 종료 5
Backtrack: [fradi, crodo] -> dfs(2)의 remove 실행
Matching: userId=frodoc, bannedId=...... -> dfs(2) 다섯번째 userId와 세번째 정규표현식 비교
Matched: userId=frodoc, bannedId=...... -> dfs(2) 다섯번째 userId가 set에 존재하지 않고, 세번째 정규표현식에 match 됨
DFS Call: index=3, selected=[fradi, crodo, frodoc] -> dfs(3) 시작
//todo Add to Result: [fradi, crodo, frodoc] -> dfs(3) index == banned.size 이기 때문에 result에 추가하고 dfs(3) 함수 종료 6
Backtrack: [fradi, crodo] -> dfs(2)의 remove 실행, 다섯번째까지 다 돌았으므로 dfs(2) 종료
Backtrack: [fradi] -> dfs(1)의 remove 실행
Matching: userId=abc123, bannedId=.rodo -> dfs(1) 네번째 userId와 두번째 정규표현식 비교 -> 정규표현식과 안맞음 -> 실패
Matching: userId=frodoc, bannedId=.rodo -> dfs(1) 다섯번째 userId와 두번째 정규표현식 비교 -> 정규표현식과 안맞음 -> 실패
Backtrack: [] -> 다섯번째까지 다 돌았으므로 dfs(1) 종료, dfs(0)의 remove 실행
Matching: userId=crodo, bannedId=.r.d. -> dfs(0) 세번째 userId와 첫번째 정규표현식 비교
Matched: userId=crodo, bannedId=.r.d. -> dfs(0) 세번째 userId이 set에 존재하지 않고, 첫번째 정규표현식에 match 됨
DFS Call: index=1, selected=[crodo] -> dfs(1) 시작
Matching: userId=frodo, bannedId=.rodo -> dfs(1) 첫번째 userId와 두번째 정규표현식 비교
Matched: userId=frodo, bannedId=.rodo -> dfs(1) 첫번째 userId이 set에 존재하지 않고, 두번째 정규표현식에 match 됨
DFS Call: index=2, selected=[crodo, frodo] -> dfs(2) 시작
Matching: userId=frodo, bannedId=...... -> dfs(2) 첫번쨰 userId와 세번째 정규표현식과 비교 -> 첫번째 userId set에 존재 -> 실패
Matching: userId=fradi, bannedId=...... -> dfs(2) 두번째 userId와 세번쨰 정규표현식과 비교 -> 정규표현식과 안맞음-> 실패
Matching: userId=crodo, bannedId=...... -> dfs(2) 첫번쨰 userId와 세번째 정규표현식과 비교 -> 세번째 userId set에 존재 -> 실패
Matching: userId=abc123, bannedId=...... -> dfs(2) 네번째 userId와 세번쨰 정규표현식과 비교
Matched: userId=abc123, bannedId=...... -> dfs(2) 네번째 userId가 set에 존재하지 않고, 세번째 정규표현식에 match 됨
DFS Call: index=3, selected=[crodo, frodo, abc123] -> dfs(3) 시작
//todo Add to Result: [crodo, frodo, abc123] -> dfs(3) index == banned.size 이기 때문에 result에 추가하고 dfs(3) 함수 종료 7
Backtrack: [crodo, frodo] -> dfs(2)의 remove 실행
Matching: userId=frodoc, bannedId=...... -> dfs(2) 다섯번째 userId와 세번째 정규표현식 비교
Matched: userId=frodoc, bannedId=...... -> dfs(2) 다섯번째 userId가 set에 존재하지 않고, 세번째 정규표현식에 match 됨
DFS Call: index=3, selected=[crodo, frodo, frodoc] -> dfs(3) 시작
//todo Add to Result: [crodo, frodo, frodoc] -> dfs(3) index == banned.size 이기 때문에 result에 추가하고 dfs(3) 함수 종료 8
Backtrack: [crodo, frodo] -> dfs(2)의 remove 실행, 다섯번째까지 다 돌았으므로 dfs(2) 종료
Backtrack: [crodo] -> dfs(1)의 remove 실행
Matching: userId=fradi, bannedId=.rodo -> dfs(1) 두번째 userId와 두번째 정규표현식과 비교 -> 정규표현식 안맞음 -> 실패
Matching: userId=crodo, bannedId=.rodo -> dfs(1) 세번째 userId와 두번째 정규표현식과 비교 -> 세번째 userId set에 존재 -> 실패
Matching: userId=abc123, bannedId=.rodo -> dfs(1) 네번째 userId와 두번째 정규표현식과 비교 -> 정규표현식 안맞음 -> 실패
Matching: userId=frodoc, bannedId=.rodo -> dfs(1) 다섯번째 userId와 두번째 정규표현식과 비교 -> 정규표현식 안맞음 -> 실패
Backtrack: [] -> -> 다섯번째까지 다 돌았으므로 dfs(1) 종료, dfs(0)의 remove 실행
Matching: userId=abc123, bannedId=.r.d. -> dfs(0) 네번째 userId와 첫번째 정규표현식과 비교 -> 정규표현식 안맞음 -> 실패
Matching: userId=frodoc, bannedId=.r.d. -> dfs(0) 다섯번째 userId와 첫번째 정규표현식과 비교 -> 정규표현식 안맞음 -> 실패
//todo 1-7, 2-8 순서가 존재하지 않기 때문에 중복,  3,4,5,6까지 총 6개 존재
6

 */