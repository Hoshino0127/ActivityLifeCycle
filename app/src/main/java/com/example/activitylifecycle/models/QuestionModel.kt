package com.example.activitylifecycle.models

import androidx.lifecycle.ViewModel

class QuestionModel : ViewModel() {
    var name : String = ""
    var no1 : Int = 0
    var no2 : Int = 0
    var ans : Int = 0

    init{
        generateQuestion()
    }

    fun setAnswer(){
        ans = no1 + no2
    }

    fun generateQuestion(): String{
        no1 = (Math.random()*100).toInt()
        no2 = (Math.random()*100).toInt()
        setAnswer()
        return "${no1} + ${no2} = ?"
    }

    fun getQuestion(): String{
        return "${no1} + ${no2} = ?"
    }

    fun checkAns(ansEntered: Int): Boolean{
        if (ans == ansEntered) {
            return true
        }
        return false
    }

    companion object{
        private var instance : QuestionModel? = null

        // synchronized will sync all instances
        fun getInstance() = instance?: synchronized(QuestionModel::class.java){
            instance ?: QuestionModel().also{ instance = it}
        }

    }
}