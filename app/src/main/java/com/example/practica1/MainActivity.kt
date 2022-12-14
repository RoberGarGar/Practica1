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

        val messageEditText: EditText = findViewById(R.id.messageEditText)
        val sendMessageButton: Button = findViewById(R.id.sendMessageButton)
        val changeBackgroundButton: Button = findViewById(R.id.changeBackgroundButton)
        val goUrlButton: Button = findViewById(R.id.goUrlButton)

        sendMessageButton.setOnClickListener{

            val editTextInfo: String = messageEditText.getText().toString()
            val intent = Intent(this, Practica1ActivityB::class.java)
            intent.putExtra("textinfo",editTextInfo)
            startActivity(intent)
        }

        changeBackgroundButton.setOnClickListener{

           startActivityForResult(Intent(this, Practica1ActivityB::class.java),myRequestCode)

        }

        goUrlButton.setOnClickListener{
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



