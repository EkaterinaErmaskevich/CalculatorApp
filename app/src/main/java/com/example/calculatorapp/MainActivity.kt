package com.example.calculatorapp


import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var bindingClass: ActivityMainBinding
    private var action: String = ""
    private var numberOne: String = ""
    private var numberTwo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        bindingClass.buttonEight.setOnClickListener {
            bindingClass.inputTextFirstNumber.setText(R.string.number_eight)
        }

        bindingClass.buttonFive.setOnClickListener {
            if (numberOne.isNullOrEmpty()) {
                numberOne = "5"
                bindingClass.inputTextFirstNumber.text = numberOne
            } else {
                if (action.isNullOrEmpty()) {
                    numberOne += "5"
                    bindingClass.inputTextFirstNumber.text = numberOne
                } else {
                    numberTwo += "5"
                    bindingClass.inputTextSecondNumber.text = numberTwo
                }
            }

        }

        bindingClass.buttonMultiplication.setOnClickListener {
            configAction("*")
        }

        bindingClass.buttonPlus.setOnClickListener {
            configAction("+")

        }
        bindingClass.buttonMinus.setOnClickListener {
            configAction("-")
        }
        bindingClass.buttonExept.setOnClickListener {
            configAction("/")
        }

        bindingClass.buttonAC.setOnClickListener {
            bindingClass.inputTextSecondNumber.text = ""
            bindingClass.inputTextAction.text = ""
            bindingClass.inputTextFirstNumber.text = ""
        }
        bindingClass.buttonResult.setOnClickListener {
            val text = "Нельзя делить на 0"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.CENTER, 0, 0)
            var result: Int

            if (action.isNullOrEmpty()) {
                Log.d("TestCalculator", "all empty")
            } else {
                if (numberTwo.isNullOrEmpty()) {
                    numberTwo = numberOne
                    configResult(numberOne, numberTwo)
                } else {
                    if (numberTwo == "0") {
                        if (action == "/") toast.show()
                    } else {
                        configResult(numberOne, numberTwo)
                    }
                }
            }
        }

        bindingClass.buttonFour.setOnClickListener {
            configNumber("4")
        }

        bindingClass.buttonNine.setOnClickListener {
            configNumber("9")
        }

        bindingClass.buttonOne.setOnClickListener {
            configNumber("1")
        }
        bindingClass.buttonSixth.setOnClickListener {
            configNumber("6")
        }

        bindingClass.buttonSeven.setOnClickListener {
            configNumber("7")
        }
        bindingClass.buttonThree.setOnClickListener {
            configNumber("3")
        }

        bindingClass.buttonTwo.setOnClickListener {
            configNumber("2")

        }

        bindingClass.buttonEight.setOnClickListener {
            configNumber("8")
        }

        bindingClass.buttonZero.setOnClickListener {
            if (numberOne.isNullOrEmpty()) {
                numberOne += "0"
                bindingClass.inputTextFirstNumber.text = numberOne
            } else {
                if (action.isEmpty()) {
                    if (numberOne == "0") {
                    } else {
                        numberOne += "0"
                        bindingClass.inputTextFirstNumber.text = numberOne
                    }
                } else {
                    if (numberTwo == "0") {
                    } else {
                        numberTwo += "0"
                        bindingClass.inputTextSecondNumber.text = numberTwo
                    }
                }
            }
        }
    }

    private fun configNumber(number: String) {
        if (numberOne.isNullOrEmpty()) {
            numberOne += number
            bindingClass.inputTextFirstNumber.text = numberOne
        } else {
            if (action.isNullOrEmpty()) {
                numberOne += number
                bindingClass.inputTextFirstNumber.text = numberOne
            } else {
                numberTwo += number
                bindingClass.inputTextSecondNumber.text = numberTwo
            }
        }
    }

    private fun configAction(inputAction: String) {
        if (numberOne.isNotEmpty()) {
            action = inputAction
            bindingClass.inputTextAction.text = action
        }
    }

    private fun configResult(inputNumberOne: String, inputNumberTwo: String) {
        numberOne = inputNumberOne
        numberTwo = inputNumberTwo


        if (action == "/") {
            bindingClass.inputTextFirstNumber.text =
                Result(numberOne.toInt(), numberTwo.toInt()).resultExept().toString()
        }
        if (action == "-") {
            bindingClass.inputTextFirstNumber.text =
                Result(numberOne.toInt(), numberTwo.toInt()).resultMinus().toString()
        }
        if (action == "+") {
            bindingClass.inputTextFirstNumber.text =
                Result(numberOne.toInt(), numberTwo.toInt()).resultPlus().toString()
        }
    }
}




