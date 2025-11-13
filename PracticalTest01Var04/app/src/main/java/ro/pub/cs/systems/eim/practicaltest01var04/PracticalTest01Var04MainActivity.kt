package ro.pub.cs.systems.eim.practicaltest01var04

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private lateinit var nameText : EditText
private lateinit var groupText : EditText
private lateinit var displayButton : Button
private lateinit var nameCheck : CheckBox
private lateinit var groupCheck : CheckBox
private lateinit var concatInfo : TextView
class PracticalTest01Var04MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var04_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameText = findViewById(R.id.nameText)
        groupText = findViewById(R.id.groupText)
        displayButton = findViewById(R.id.informationButton)
        nameCheck = findViewById(R.id.nameCheck)
        groupCheck = findViewById(R.id.groupCheck)
        concatInfo = findViewById(R.id.concatInfo)

        displayButton.setOnClickListener(ButtonListener())
    }

    inner class ButtonListener : View.OnClickListener {
        override fun onClick(v: View?) {
            if (v?.id == R.id.informationButton) {
                if (nameCheck.isChecked && groupCheck.isChecked) {
                    var finalText = nameText.text.toString() + groupText.text.toString()
                    concatInfo.setText(finalText)
                }else if (nameCheck.isChecked) {
                    concatInfo.setText(nameText.text.toString())
                }else if (groupCheck.isChecked) {
                    concatInfo.setText(groupText.text.toString())
                }else {
                    concatInfo.setText(" ")
                }

            }
        }

    }
}