package com.example.kotlinpractice

/**
 * Please explain the class!!
 *
 * @fileName      : by_lazy
 * @author        : kma04
 * @since         : 2023-08-10
 */
class by_lazy {
    /**
     * by lazy
     *  초기화 이후에 읽기 전용 값으로 사용할 때
     *  (값이 변하지 않는다.)
     *  값 변경이 불가능해서, val 사용
     */
}

fun main() {
    lateinit var text: String
    val textLength: Int by lazy {
        text.length
    }

    text = "H43RO_Velog"
    println(textLength)

    text = "happy"
    println(textLength) //값이 변하지않고 11로 불변
}