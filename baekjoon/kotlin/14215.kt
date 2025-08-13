package com.kguard.tobecomebetter.baekjoon

// sort를 사용하면 더 좋음
fun main() {
    val line = readln().split(" ").map { it.toInt() }.toMutableList()
//    val max = line.max()
//    line.remove(line.max())
//    if (max >= line.sum()) {
//        line.add(line.sum() - 1)
//        print(line.sum())
//    } else {
//        line.add(max)
//        print(line.sum())
//    }
    line.sortDescending()
    if (line[0] >= line[1] + line[2]) {
        line.remove(line[0])
        line.add(line.sum() - 1)
    }
    print(line.sum())
}