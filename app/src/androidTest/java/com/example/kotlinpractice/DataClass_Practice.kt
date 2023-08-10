package com.example.kotlinpractice


/**
 * Please explain the class!!
 *
 * @fileName      : DataClass_Practice
 * @author        : kma04
 * @since         : 2023-08-10
 */
class DataClass_Practice {
    /**
     *
     */
}

data class People(
    val name: String,
    val age: Int
)

fun main(){
    val peopleA = People("백근우",30)
    val peopleB = People("성민",28)
    println("peopleA : $peopleA")
    println("peopleB : $peopleB")


    val newPeopleA  = peopleA.copy(age=20)
    println("newPeopleA : $newPeopleA")


    println(peopleA.hashCode())
    println(peopleB.hashCode())




}