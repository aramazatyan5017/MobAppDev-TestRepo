package com.example.githubtestproject

import java.lang.IllegalArgumentException

class Person(private var firstName: String, private var lastName: String, private var age: Int) {

    fun getFirstName(): String {
        return firstName
    }

    fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    fun getLastName(): String {
        return lastName
    }

    fun setLastName(lastName: String) {
        this.lastName = lastName
    }

    fun getAge(): Int {
        return age
    }

    fun setAge(age: Int) {
        if (age <= 0) {
            throw IllegalArgumentException("Age cannot be negative!")
        }
        this.age = age;
    }

    override fun toString(): String {
        return "$firstName $lastName is $age years old";
    }
}