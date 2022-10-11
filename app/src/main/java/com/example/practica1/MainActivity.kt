package com.example.practica1


import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private val myRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica1_activity)

        val editText1: EditText = findViewById(R.id.EDT_text)
        val button1: Button = findViewById(R.id.BT_1)
        val button2: Button = findViewById(R.id.BT_2)
        val button3: Button = findViewById(R.id.BT_3)

        button1.setOnClickListener{

            val editTextInfo: String = editText1.getText().toString()
            val intent = Intent(this, Practica1ActivityB::class.java)
            intent.putExtra("textinfo",editTextInfo)
            startActivity(intent)
        }

       button2.setOnClickListener{

           startActivityForResult(Intent(this, Practica1ActivityB::class.java),myRequestCode)

        }

        button3.setOnClickListener{
            val intentWeb = Intent()
            intentWeb.action = Intent.ACTION_VIEW
            intentWeb.data = Uri.parse("https://codelabs.developers.google.com/android-training/")
            startActivity(intentWeb)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val constraintLayout: ConstraintLayout = findViewById(R.id.Constraint)
        val dato = data?.getStringExtra("colorbutton").toString()

        if(myRequestCode==requestCode){
            if (dato != null) {
                constraintLayout.setBackgroundColor(Color.parseColor(dato))
            }
        }
    }
}



