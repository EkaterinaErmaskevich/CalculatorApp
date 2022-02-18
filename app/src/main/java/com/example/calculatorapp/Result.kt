package com.example.calculatorapp

open class Result(val numberOne: Int, val numberTwo: Int) {


    fun resultPlus(): Int {

        return numberOne + numberTwo
    }

    fun resultMinus(): Int {
        return numberOne - numberTwo
    }

    fun resultMultiplication(): Int {
        return  numberOne * numberTwo
    }

    fun resultExept(): Int {
        return numberOne / numberTwo
    }

}