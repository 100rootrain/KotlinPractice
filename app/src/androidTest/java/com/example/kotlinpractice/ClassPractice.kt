package com.example.kotlinpractice

/**
 * Please explain the class!!
 *
 * @fileName      : ClassPractice
 * @author        : kma04
 * @since         : 2023-08-08
 */
class ClassPractice {

}

open class Human{
    val name =  "joyce"

    fun eatingCake(){
        println("This is so YUMMYYY~~~~")
    }

    open fun singASong(){
        println("lalala")
    }
}

open class Human1 (val name : String ="Annonymous"){//주생성자
    /**
     * java 에서 생성자
     *
     * class Person{
     *  public Person(Stirng name){ 이름넣을수있는 생성자
     * }
     *
     * public Person(Stirng name, int age){ 이름,나이 넣을수있는 생성자
     *  this(name);
     * }
     *
     */

    //Kotlin에서 생성자
    constructor(name:String, age:Int): this(name) { //부생성자 : 항상 부생성자는 주생성자의 위임을 받아야된다.
        println("my name is ${name}, ${age}years old")
    }


    init{//처음 Human1의 인스턴스를 생성할때 어떤동작을 하고싶은지..
        println("New human1 has been born!!")
    }

    open fun singASong1(){
        println("hahaha")
    }


}

//상속 java의 extends와 같음

class Korean : Human(){
    /** Human()에 왜 빨간줄이 떴을까?
     *  Kotlin의 클래스는 기본적으로 final 클래스이기 때문에 아무리 같은 파일에 있더라도 접근을 못해요
     *  그래서 open을 해야됨.
     */
    override fun singASong(){
        super.singASong()
        println("라라랄")
        println("my name is :${name}")
    }

}

class Japan : Human1(){ //상속은 하나밖에못함.
    override fun singASong1(){
        println("my name is :${name}")

    }

}



fun main(){
    val human = Human() //java에서 객체를 만들땐 new Human()이지만, Kotlin은 필요없다.
    human.eatingCake()
    println("This human's name is ${human.name}")

    val human1 = Human1("minsu")
    val human2 = Human1()
    println("This human1's name is ${human1.name}")
    println("This human1's name is ${human2.name}")

    val stranger = Human1()

    val mom = Human1("Kuri",55)
    println("this human's name is ${stranger.name}")

    val korean = Korean()
    korean.singASong()
    val japan = Japan()
    japan.singASong1()



}