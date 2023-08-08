package com.example.kotlinpractice

/**
 * Please explain the class!!
 *
 * @fileName      : Data
 * @author        : kma04
 * @since         : 2023-08-08
 */
class Data {
}

data class Ticket(val companyName:String,val name: String, var date:String,val seatNumber:Int)
//toString(), hashCode(), equals() ,copy()

class TicketNormal(val companyName:String,val name: String, var date:String,val seatNumber:Int)

fun main(){
    val TicketA = Ticket("koreanAir","Baekkuenwoo","2020-02-15",14)
    val TicketB = TicketNormal("koreanAir","Baekkuenwoo","2020-02-15",14)

    println(TicketA)
    println(TicketB)
}