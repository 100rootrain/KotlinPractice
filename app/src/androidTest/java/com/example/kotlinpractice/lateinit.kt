package com.example.kotlinpractice

/**
 * Please explain the class!!
 *
 * @fileName      : lateinit
 * @author        : kma04
 * @since         : 2023-08-10
 */
class lateinit {
    /**
     *  초기화 이후에 계속하여 값이 바뀔 수 있을 때
     *  (값 변함)
     *  var 사용
     */
}

fun main(){
    lateinit var text: String

    val result1 = 30

    text = "result1 : $result1 "
    println(text)

    var result2 = 50

    text = "result2: ${result2}"
    println(text)

    text = "result1+result2: ${result1+result2}"
    println(text)
}

