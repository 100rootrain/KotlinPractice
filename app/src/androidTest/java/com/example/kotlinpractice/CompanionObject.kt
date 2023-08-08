package com.example.kotlinpractice

/**
 * Please explain the class!!
 *
 * @fileName      : Practice3
 * @author        : kma04
 * @since         : 2023-08-08
 */
class Practice3 {
}

class Book private constructor(val id : Int, val name : String){
    companion object BookFactory:idProvider{ //companion object Java의 Static과 같은역할

        override fun getId(): Int{
            return 444
        }

        val myBook = "new book"
        //fun create() :Book = Book(0,"animal farm")
        fun create() :Book = Book(0,myBook)
    }

}

interface idProvider{
    fun getId() : Int
}

fun main(){
    val book = Book.BookFactory.create()
    println("${book.id} ${book.name}")

    val bookId = Book.getId()
    println(bookId)
}