package ro.pub.cs.systems.eim.practicaltest01var04

import android.content.Intent
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
private lateinit var navigateSecond : Button
private lateinit var nameCheck : CheckBox
private lateinit var groupCheck : CheckBox
private lateinit var concatInfo : TextView

object Constants {
    const val LEFT_COUNT = "firstText"
    const val RIGHT_COUNT = "secondText"
}
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
        navigateSecond = findViewById(R.id.navigateSecond)

        displayButton.setOnClickListener(ButtonListener())
        navigateSecond.setOnClickListener(ButtonListener())

                if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.LEFT_COUNT)) {
                nameText.setText(savedInstanceState.getString(Constants.LEFT_COUNT))
            } else {
                nameText.setText(" ")
            }

            if (savedInstanceState.containsKey(Constants.RIGHT_COUNT)) {
                groupText.setText(savedInstanceState.getString(Constants.RIGHT_COUNT))
            } else {
                groupText.setText(" ")
            }
        } else {
            nameText.setText(" ")
            groupText.setText(" ")
        }
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
            if (v?.id == R.id.navigateSecond) {
                val text1 = nameText.text.toString()
                val text2 = groupText.text.toString()

                val intent = Intent(
                    this@PracticalTest01Var04MainActivity,
                    PracticalTest01Var04SecondaryActivity::class.java
                )

                intent.putExtra("nameText", text1)
                intent.putExtra("groupText", text2)
                startActivityForResult(intent, 1)
            }
        }

    }

        override fun onSaveInstanceState (outState : Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(Constants.LEFT_COUNT, nameText.text.toString())
        outState.putString(Constants.RIGHT_COUNT, groupText.text.toString())
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey(Constants.LEFT_COUNT)) {
            nameText.setText(savedInstanceState.getString(Constants.LEFT_COUNT))
        } else {
            nameText.setText(" ")
        }

        if (savedInstanceState.containsKey(Constants.RIGHT_COUNT)) {
            groupText.setText(savedInstanceState.getString(Constants.RIGHT_COUNT))
        } else {
            groupText.setText(" ")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            when (resultCode) {
                RESULT_OK -> {
                    Toast.makeText(this, "Utilizatorul a apăsat OK", Toast.LENGTH_SHORT).show()
                }
                RESULT_CANCELED -> {
                    Toast.makeText(this, "Utilizatorul a apăsat CANCEL", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}