package ro.pub.cs.systems.eim.practicaltest01var04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private lateinit var nameText: EditText
private lateinit var groupText: EditText
private lateinit var OK: Button
private lateinit var CANCEL:Button
class PracticalTest01Var04SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var04_secondary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        OK = findViewById(R.id.ok_button)
        CANCEL = findViewById(R.id.cancel_button)

        OK.setOnClickListener(ButtonListener())
        CANCEL.setOnClickListener(ButtonListener())

        val text1 = intent.getStringExtra("nameText")
        val text2 = intent.getStringExtra("groupText")
        findViewById<EditText>(R.id.nameText).setText(text1.toString())
        findViewById<EditText>(R.id.groupText).setText(text2.toString())

    }


    inner class ButtonListener: View.OnClickListener{
        override fun onClick(v: View?) {
            if (v?.id == R.id.ok_button) {
                val returnIntent = Intent()
                returnIntent.putExtra("result", "OK")
                setResult(RESULT_OK, returnIntent)
                finish()
            }
            if (v?.id == R.id.cancel_button) {
                val returnIntent = Intent()
                returnIntent.putExtra("result", "CANCEL")
                setResult(RESULT_CANCELED, returnIntent)
                finish()
            }
        }

    }
}