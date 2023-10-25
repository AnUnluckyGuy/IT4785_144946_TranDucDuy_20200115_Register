package com.example.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import java.time.Month
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private var clickTime = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val regBtn: Button = findViewById(R.id.register_button);
        setDatePickerBtn();
        regBtn.setOnClickListener {
            val fnViewText: EditText = findViewById(R.id.fn_text);
            val lnViewText: EditText = findViewById(R.id.ln_text);
            val genderRadioGroup: RadioGroup = findViewById(R.id.radiogroup);
            val dobViewText: EditText = findViewById(R.id.dob_text);
            val addressViewText: EditText = findViewById(R.id.address_text);
            val emailViewText: EditText = findViewById(R.id.email_text);
            val checkbox: CheckBox = findViewById(R.id.checkbox);
            ++clickTime;
            val check = (fnViewText.text.isNotEmpty() && lnViewText.text.isNotEmpty() && dobViewText.text.isNotEmpty()
                    && addressViewText.text.isNotEmpty() && emailViewText.text.isNotEmpty()
                    && checkbox.isChecked && (genderRadioGroup.checkedRadioButtonId != -1));
            fnViewText.clearFocus();
            lnViewText.clearFocus();
            dobViewText.clearFocus();
            addressViewText.clearFocus();
            emailViewText.clearFocus();
            if (!check)Toast.makeText(applicationContext, "Something invalid", Toast.LENGTH_LONG).show();
            else Toast.makeText(applicationContext, "Everything good", Toast.LENGTH_LONG).show();
        }
    }

    private fun setDatePickerBtn() {
        val datePickerBtn: Button = findViewById(R.id.date_picker_btn);
        datePickerBtn.setOnClickListener {
            val dobViewText: EditText = findViewById(R.id.dob_text);
            val calendar = Calendar.getInstance();
            val year = calendar.get(Calendar.YEAR);
            val month = calendar.get(Calendar.MONTH);
            val day = calendar.get(Calendar.DAY_OF_MONTH);

            val datePickerDialog: DatePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    dobViewText.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                },
                year,
                month,
                day
            )
            datePickerDialog.show();
        }
    }
}