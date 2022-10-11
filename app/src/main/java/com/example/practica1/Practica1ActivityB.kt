package com.example.practica1


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Practica1ActivityB : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica1_b)

        val button4: Button = findViewById(R.id.BT_4)
        val button5: Button = findViewById(R.id.BT_5)
        val button6: Button = findViewById(R.id.BT_6)
        val bundle=intent.extras
        val dato = bundle?.getString("textinfo")

        if (dato==null || dato==""){
            Toast.makeText(this,"No hay mensaje",Toast.LENGTH_LONG)
        }else{
            Toast.makeText(this,dato,Toast.LENGTH_SHORT).show()
        }

        button4.setOnClickListener{

            val stringColor = getResources().getString(R.color.white_red)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("colorbutton",stringColor)
            setResult(RESULT_OK,intent)
            finish()
        }

        button5.setOnClickListener{

            val stringColor = getResources().getString(R.color.white_orange)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("colorbutton",stringColor)
            setResult(RESULT_OK,intent)
            finish()
        }

        button6.setOnClickListener{

            val stringColor = getResources().getString(R.color.white_blue)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("colorbutton",stringColor)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}