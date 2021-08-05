package com.example.activitylifecycle.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.activitylifecycle.R
import com.example.activitylifecycle.models.QuestionModel

class SecondActivity : AppCompatActivity() {
    private lateinit var myModel: QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.i("Lifecycle","onCreate")

        val btn : Button = findViewById(R.id.btnAdd)
        val tvQuestion : TextView = findViewById(R.id.tvQuestion)
        val tvName : TextView = findViewById(R.id.tvName)

        //if(savedInstanceState != null)
        //    tvQuestion.text = savedInstanceState.getString("question")

        //myModel = QuestionModel()

        //myModel = ViewModelProvider(this).get(QuestionModel::class.java)
        myModel = QuestionModel.getInstance()

        tvQuestion.text = myModel.getQuestion()
        tvName.text = myModel.name
        btn.setOnClickListener(){
            tvQuestion.text = myModel.generateQuestion()
        }
    }

    override fun onStart(){
        super.onStart()

        Log.i("Lifecycle","onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("Lifecycle","onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("Lifecycle","onPause")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("Lifecycle","onRestart")
    }

    override fun onStop() {
        super.onStop()

        Log.i("Lifecycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("Lifecycle","onDestroy")
    }

   /* override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        var question = findViewById<TextView>(R.id.tvQuestion).text.toString()
        outState.putString("question",question)

    }*/


}