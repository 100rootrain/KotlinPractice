package com.example.kotlinpractice

/**
 * Please explain the class!!
 *
 * @fileName      : sample
 * @author        : kma04
 * @since         : 2023-08-08
 */

fun main(){
helloWorld()
    println(add(4,5))

    //3.String Template
    val name = "joyce"
    val lastName = "Hong"
    println("my name is $name") //변수를 출력하고싶을때는 $
    println("my name is ${name}I'm 23") //띄어쓰기를 하고싶지않을때는 ${}
    println("my name is ${name+lastName} I'm 23")
    println("is this true? ${1==0}")
    println("this is 2\$a") //$를 쓰고피으면 \$

    println(checkNum(1))

    forAndWhile()
    nullcheck()


}


//1.함수
//자바같은경우에는 리턴안하는경우에는 void, 리턴할경우에는 int(리턴형태를 썼었다.)
//코틀린의 경우 뭘 리턴하든 관계없이 function의 줄인 fun

fun helloWorld() : Unit{ // 아무것도 리턴을 안할경우 void(Unit)
    //Redundant 으로 뜨는건 안써도되는데 너가썼어. Unit 생략해도 됨.
println("Hello World!")
}

fun add(a : Int, b : Int) : Int{
    //( 변수명 : 변수타입 ) 파라미터가 끝나고 : 리턴타입
    //아무것도 리턴을 안할경우에는 생략해도되지만, 무언가를 리턴할경우에는 생략할 수없다.
    return a+b
}

//2. val vs var
// val = value

fun hi(){
    val a: Int = 10 //변하지않는값(상수)    ::::: 발은 우리몸에서 뗄수가없음.
    var b : Int = 9 // 변할수있음          ::::: 바지는 갈아입을수있음
    //var e //(x)
    var e : String //(o)

}

//4. 조건식
fun maxBy(a:Int,b:Int) :Int{
    if(a>b){
        return a
    }else{
        return b
    }
}
//위의 조건식과 같은형식
fun maxBy2(a:Int,b:Int) = if(a>b) a else b //자동타입추론으로 리턴타입 : Int가 생략된것을 알수있다.

//return (a>b) ? a : b 자바처럼 삼항연산자가 없기때문에 위와 같이 표현

fun checkNum(score:Int):Unit{
    when(score){
        0->println("this is 0")
        1->println("this is 1")
        2,3->println("this is 2 or 3")
        else->println("I don't know") //이경우엔 else를 안써주셔도 상관없다.
    }

    var b : Int = when(score){ // when의 경우 이런식으로 리턴식으로도 쓸수있다. 하지만 else를 항상 써줘야된다.
        1->1
        2->2
        else ->3
    }
    println("b : ${b}")

    when(score){
        in 90..100 ->println("You are genius")
        in 10..80 ->println("not bad")
        else ->println("okay")
    }
}

//Expression vs Statement

//값을 만들면 Expression
//Kotlin의 모든 함수는 Expression Why? 아무리 Unit 이 없더라도(생략돼있음) return값을 반환함

//지시하는느낌.. statement

//5. Array and List

//Array : 메모리가 할당이돼서 나오기때문에 처음에 크기를 지정해줘야된다.

//List      1.(Immutable)List(수정불가능)      2.MutableList (수정가능)

fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)
    val array2 = arrayOf(1,"d",3.4f)
    val list2 = listOf(1,"d",11L)

    array[0]=3 // array는 기본적으로 Mutable이다. 사이즈를 변경X , 값을변경하는것 가능.
    //list[0]= 2 // 불가능, array와 다르게 인터페이스이기 때문에
    var result =list.get(0) // 가져와서 값을 넣을수는 있음. 직접적으로 들어가서 바꾸는것은 불가능하다.

    val arrayList = arrayListOf<Int>() //초기화
    //var는 val로 바꿀수있음.. why? arrayList의 참조값(주소값) 자체는 바뀌지않기 때문에
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 20

   // arrayList = arrayListOf() //참조값이 바뀌는경우는 오류가남/

}

//6. For / While

fun forAndWhile(){
    val students = arrayListOf("joyce","james","jenny","jennifer")

    for(name in students){
        println("${name}")
    }

    //index와 name을 같이쓰고싶을때
    for((index,name) in students.withIndex()){
        println("${index+1}번째 학생 : ${name}")
    }


    var sum : Int = 0
    for(i in 1..10){
        sum += i
    }

    var a : Int = 0
    for(i in 1..10 step 2){
        a += i
    }

    var b : Int = 0
    for(i in 10 downTo 1){
        b += i
    }

    var c : Int = 0
    for(i in 1 until 100){//1부터 99까지 99번 for문이 돌아감
        c += i
    }

    var d : Int = 0
    for(i in 1..100){ //1부터 100까지 100번 for문이 돌아감
        d += i
    }

    println(sum)
    println(a)
    println(b)
    println(c)
    println(d)


    var index = 0
    while(index<10){
        println("current index : ${index}")
        index++
    }
}

// 7. Nullable / NonNull

fun nullcheck(){
    //NPE : Null Pointer Exception

    var name = "joyce" //타입을 생략하게 되면 기본적으로 NonNull 타입
    var nullName : String? = null // type에 ? 넣으면 null 넣을수있음(Nullable타입) (null타입을 만들려면 타입을 생략하면 안됨)

    var nameInUpperCase = name.uppercase()
    var nullNameInUpperCase = nullName?.uppercase() //null이면 null반환, 아니면 실행

    // ?: ->엘비스 연산자

    val lastName : String? = null
    val fullName = name+" "+(lastName?: "NO lastName") //lastName이 있으면 lastName 출력, null이면 "NO lastName"출력
    println(fullName)
    //lastName에 null대신 "Hong" 입력하면 Hong출력된다.

}

// !! --> 이거 null아니야 보증해줄때 쓰는것

fun ignoreNulls(str : String){
    val mNotNull : String = str!! //null들어올일없으니까
    val upper = mNotNull.uppercase()

    val email : String? = "qor0923@naver.com"
    email?.let{
        println("my email is ${email}")
    } // email이 null이 아니면 {}를 해라
}