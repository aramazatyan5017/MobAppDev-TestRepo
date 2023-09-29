package com.example.githubtestproject

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun main(args: Array<String>) {

    val exerciseMap = mapOf(
        "1" to ::exercise1,
        "2" to ::exercise2,
        "3" to ::exercise3,
        "4" to ::exercise4,
        "5" to ::exercise5,
        "6" to ::exercise6,
        "7" to ::exercise7,
        "8" to ::exercise8,
        "9" to ::exercise9,
        "10" to ::exercise10
    )

    for (i in 1..exerciseMap.size) {
        System.out.printf("Problem %d: %n%n", i)
        exerciseMap[i.toString()]?.invoke()
        println("-----------------------------------------------------")
    }

}

fun exercise1() {
    val numArray = arrayOf(5, 1, -7, 11, 0, -234)
    print("The values of the array are: ")
    numArray.forEach { number -> System.out.printf("%d ", number) }
    println()

    val stringList = listOf<String>("Mobile", "Application", "Development")
    print("The values of the list are: ")
    stringList.forEach { txt -> System.out.printf("%s ", txt) }
    println()
}

fun exercise2() {
    val txt1 = "Mobile    "
    val txt2 = "   ApPlICatIon  "
    val combined = txt1.trim() + " " + txt2.trim();
    println(combined)
    val words = combined.split(" ")
    var targetWord = words[1]
    println(targetWord)
    targetWord = targetWord.substring(0, 3)
    println(targetWord)
    targetWord = targetWord.lowercase()
    println(targetWord)
    targetWord = targetWord.replaceFirstChar { targetWord.get(0).uppercase() }
    println(targetWord)
}

fun exercise3() {
    val nameToAgeMap = mapOf<String, Int>(
        "Poghos" to 34,
        "Petros" to 23,
        "Martiros" to 57
    )
    nameToAgeMap.forEach { (name, age) -> System.out.printf("%s is %d years old!%n", name, age) }
}

fun exercise4() {
    System.out.printf("The number %d is %s.%n", 4, exercise4Util(4))
    System.out.printf("The number %d is %s.%n", -3, exercise4Util(-3))
    System.out.printf("The number %d is %s.%n", 0, exercise4Util(0))
}

fun exercise4Util(number: Int): String {
    if (number == 0) return "ZERO"
    else if (number < 0) return "NEGATIVE"
    return "POSITIVE"
}

fun exercise5() {
    print("Enter Your Name: ")
    var inputName = readlnOrNull()

    print("Enter Your Age: ")
    val inputAgeStr = readlnOrNull()

    if ((inputName == null) || inputName.trim().isEmpty()) {
        println("Sorry, cannot proceed, don't know your name(")
        return
    }

    inputName = inputName.trim()

    if (inputAgeStr == null) {
        println("Your age is missing!")
        return
    }

    var inputAge = 0

    try {
        inputAge = inputAgeStr.toInt()
    } catch (e: NumberFormatException) {
        println("Your age should be a number!")
        return
    }

    if (inputAge <= 0) {
        println("Are you sure about your age?!")
        return
    }

    if (inputAge <= 30) System.out.printf("Hello %s! It seems to me that you are rather young.%n", inputName)
    else if (inputAge <= 55) System.out.printf("Hello %s! I suppose you are a middle aged human.%n", inputName)
    else System.out.printf("Hello %s! Yep... you are pretty old.%n", inputName)
}

fun exercise6() {
    print("Enter the Nominator: ")
    val nominatorStr = readlnOrNull()

    print("Enter the Denominator: ")
    val denominatorStr = readlnOrNull()

    if (nominatorStr == null || denominatorStr == null) {
        println("Missing Argument(s)")
        return
    }

    var nominator = 0
    var denominator = 0

    try {
        nominator = nominatorStr.toInt()
        denominator = denominatorStr.toInt()
    } catch (e: NumberFormatException) {
        println("Invalid Argument(s)")
        return
    }

    if (denominator == 0) {
        println("Cannot divide by zero!")
        return
    }

    System.out.printf("$nominator divided by $denominator is %.3f%n", nominator.toDouble() / denominator)
}

@RequiresApi(Build.VERSION_CODES.O)
fun exercise7() {
    val dateTime = LocalDateTime.now()
    println(dateTime.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy / HH:mm:ss")))
}

fun exercise8() {
    println(Person("Aram", "Azatyan", 23))
}

fun exercise9() {
    println(Person("Aram", "Azatyan", 23).determineLifePeriod())
}

fun Person.determineLifePeriod(): String {
    val age = getAge()
    return if (age <= 12) "Child"
    else if (age <= 17) "Teen"
    else if (age <= 30) "Young Adult"
    else if (age <= 55) "Adult"
    else "Elderly"
}

fun exercise10() {
    val intList = listOf<Int>(1, 2, 3, 4, -5, -6, -7, 8, 9, 10, 12)
    print("The values of the list are: ")
    intList.forEach { n -> System.out.printf("%d ", n) }

    print("\nThe even numbers of the list are: ")
    intList.filter { n -> n % 2 == 0 }
        .forEach { n -> print("$n ") }
    println()
}