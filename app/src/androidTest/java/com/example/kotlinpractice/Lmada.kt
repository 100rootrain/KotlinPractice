package com.example.kotlinpractice

/**
 * Please explain the class!!
 *
 * @fileName      : Lmada
 * @author        : kma04
 * @since         : 2023-08-08
 */
class Lmada {
}

/**1.Lamda
 * 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
 * 1) 메소드의 파라미터로 넘겨줄수가 있다. fun maxBy(a :Int)
 * 2) return 값으로 사용할 수가 있다.
 *
 * 람다의 기본정의
 * val lamdaName : Type = {argumentLst -> codeBody}
 */

val square: (Int) -> (Int) = { number -> number * number }
val nameAge = { name: String, age: Int ->
    //리턴값이 없으면 왼쪽에 java의 Void와 비슷한 Unit이 나오는것을 확인할수있다.
    //람다에서는 항상 마지막에 있는 값이 리턴값이다.
    "my name is ${name} I'm ${age}"
}

// 확장함수
val pizzaGreat: String.() -> String = {
    this + "Pizza is the best!"
}
//pizzaGreat는 익명함수. String하고 .() 파라미터는 없어요.
//this는 String Object 자체를 가리킵니다.

// 확장함수2
fun extendString(name: String, age: Int): String {
    val introduceMyself: String.(Int) -> String = {
        "I am ${this} and ${it} years old"
    }
    return name.introduceMyself(age)
}

//람다의리턴
val calculateGrade: (Int) -> String = {
    //input파라미터가 하나라서 it으로 지칭해도 된다고 알려주고있음.
    when (it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }

}
//input 파라미터는 여러개가 될수있어서 괄호를 꼭써줘야됨.
//리턴 파라미터는 하나라서 안써줘도됨.


//람다를 표현하는 여러가지 방법

fun invokeLamda(lamda:(Double) ->Boolean) : Boolean { //Double을 받고 Boolean을 리턴하는 람다식을 파라미터로 받고싶어 invokeLamda함수는 Boolean으로 리턴
    return lamda(5.2343)
}



//


fun main() {
    //람다
    println(square(12))
    println(nameAge("joice", 99))

    //확장함수
    val a = "joyce said"
    val b = "mac said"

    println(a.pizzaGreat())// a,b 둘다 String이니까 확장함수를 쓸수있다.
    println(b.pizzaGreat())

    //확장함수1
    println(extendString("ariana", 30))

    //람다의리턴
    println(calculateGrade(98))
    println(calculateGrade(101))

    //람다를 표현하는 여러가지 방법
    val lamda ={number:Double->
        number==4.3213
    }

    println(invokeLamda(lamda))
    println(invokeLamda ({true}))
    println(invokeLamda {it>3.2}) //넣는 파라미터가 1개일때 그것을 가르킴 it
    //마지막파라미터가 람다식일경우 ()생략할수있음


}