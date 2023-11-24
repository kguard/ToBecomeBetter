package com.kguard.tobecomebetter

fun main() {

    println(solution1(
        today =  "2020.05.15",
        terms = arrayOf("A 1"),
        privacies = arrayOf("2001.01.10 A", "2001.01.10 A")
    ).contentToString())
}

fun solution1(today: String, terms: Array<String>, privacies: Array<String>):IntArray {
    val todays = today.replace(".", "").toInt()
    val termsT = mutableMapOf<String, String>()
    val privaciesT = mutableListOf<Pair<String, String>>()
    val privaciesDays = mutableListOf<String>()
    val solution = mutableListOf<Int>()
    for (i in terms) {
        termsT[i.split(" ")[0]] = i.split(" ")[1]
    }
    for (i in privacies) {
        privaciesT.add(Pair(i.split(" ")[0], i.split(" ")[1]))
    }
    for (i in privaciesT) {
        var year = i.first.split(".")[0]
        var month = i.first.split(".")[1]
        var day = i.first.split(".")[2]
        month = (month.toInt() + termsT[i.second]!!.toInt()).toString()
        if (month.toInt() > 12) {
            var am : Int
            var ay : Int
            if(month.toInt()%12 == 0)
            {am = 12
            ay = (month.toInt()/12)-1}
            else{
                am =month.toInt()%12
                ay = month.toInt()/12
            }
            year = (i.first.split(".")[0].toInt() + ay).toString()
            month = am.toString()
        }
        if(month.toInt()<10)
            month = "0$month"
        privaciesDays.add(year + month + day)
    }
    for(i in privaciesDays){
       if(todays >= i.toInt())
           solution.add(privaciesDays.indexOf(i)+1)
        privaciesDays[privaciesDays.indexOf(i)] = ""
    }
    return solution.toIntArray()
}