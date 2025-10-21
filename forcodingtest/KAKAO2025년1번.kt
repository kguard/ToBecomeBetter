package com.kguard.tobecomebetter.forcodingtest

class Solution {
    fun solution(message: String, spoiler_ranges: Array<IntArray>): Int {
        // 1. 스포일러 맵 생성
        val spoilerMap = BooleanArray(message.length)
        for (range in spoiler_ranges) {
            val start = range[0]
            val end = range[1]
            for (i in start..end) {
                // end가 message 길이를 넘지 않도록 안전장치를 추가합니다.
                if (i < message.length) {
                    spoilerMap[i] = true
                }
            }
        }

        // 2. 단어 토큰화 및 스포 일러/비-스포일러 단어 분류
        val spoilerWords = mutableListOf<String>()
        val nonSpoilerWords = mutableSetOf<String>()

        var currentWordStart = -1
        for (i in message.indices) {
            // isWhitespace() 대신 직접 공백 문자와 비교합니다.
            if (message[i] != ' ' && currentWordStart == -1) {
                currentWordStart = i
            }

            // isWhitespace() 대신 직접 공백 문자와 비교합니다.
            if (currentWordStart != -1 && (message[i] == ' ' || i == message.length - 1)) {
                val endIdx = if (message[i] == ' ') i - 1 else i

                // StringBuilder 대신 slice 함수를 사용하여 단어를 추출합니다.
                val word = message.slice(currentWordStart..endIdx)

                var isSpoilerWord = false
                for (j in currentWordStart..endIdx) {
                    if (spoilerMap[j]) {
                        isSpoilerWord = true
                        break
                    }
                }

                if (isSpoilerWord) {
                    spoilerWords.add(word)
                } else {
                    nonSpoilerWords.add(word)
                }

                currentWordStart = -1
            }
        }

        // 3. 최종 조건 확인을 통해 중요한 단어 개수 세기
        val importantWordsFound = mutableSetOf<String>()
        var importantWordCount = 0

        for (word in spoilerWords) {
            if (word in nonSpoilerWords) {
                continue
            }
            if (word in importantWordsFound) {
                continue
            }
            importantWordCount++
            importantWordsFound.add(word)
        }

        return importantWordCount
    }
}

