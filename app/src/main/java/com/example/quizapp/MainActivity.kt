package com.example.quizapp

import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        var dateFormatter = DateTimeFormatter.ofPattern("yyyy MM dd hh:mm:ss")
//        var currentDateValue = currentDate.format(dateFormatter)


        submit.setOnClickListener{
            println("inside submit")
            var result: Double = 0.0;
            if(q_1_d.isChecked){
                result +=50
            }
            if(q_2_b.isChecked){
                result += 50
            }
            val currentDate = LocalDate.now()
                .toString()
            val msg = "You've submitted on ${currentDate}, Your score is ${result}."

            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage(msg)
                .setCancelable(false)
                .setNegativeButton("OK", DialogInterface.OnClickListener{
                    dialog,id -> dialog.cancel()
                })
            val alert = dialogBuilder.create()
            alert.setTitle("Result")
            alert.show()

        }
        resetBtn.setOnClickListener{
            radioGroup.clearCheck()
            radioGroup2.clearCheck()
        }

    }



}