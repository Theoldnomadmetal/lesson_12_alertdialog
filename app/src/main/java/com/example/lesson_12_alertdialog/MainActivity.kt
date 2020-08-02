package com.example.lesson_12_alertdialog

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper

class MainActivity : AppCompatActivity() {
    private var etFirstname: EditText? = null
    private var etSecondname: EditText? = null
    private var etBirthdate: EditText? = null
    private var btnSave: Button? = null

    private val firstNameString= etFirstname?.text.toString()
    private val secondNameString= etSecondname?.text.toString()
    private val birthDateString= etBirthdate?.text.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupListeners()

    }

    private fun setupViews() {
        etFirstname = findViewById(R.id.etFirstname)
        etSecondname = findViewById(R.id.etSecondname)
        etBirthdate = findViewById(R.id.etBirthdate)
        btnSave = findViewById(R.id.btnSave)

    }

    private fun setupListeners() {
        btnSave?.setOnClickListener {
            alertDialog()
        }

        etBirthdate?.setOnClickListener {
            createDatePickerDialog()
        }
    }

    private fun createDatePickerDialog() {
        val dialog = DatePickerDialog(this)
        dialog.setOnDateSetListener { view, year, month, day ->
            etBirthdate?.setText("$day/$month/$year")
        }
        dialog.show()
    }
    private fun sharePreference(){
        val profilePreference = getSharedPreferences("Data", Context.MODE_PRIVATE)
        profilePreference.edit().putString("Data",firstNameString).apply()
        profilePreference.edit().putString("Data",secondNameString).apply()
        profilePreference.edit().putString("Data",birthDateString).apply()

        customDialog()
    }
    private fun alertDialog(){
        val dialog = AlertDialog.Builder(ContextThemeWrapper(this,R.style.myDialog))
        dialog.setTitle(getString(R.string.dialog_save))
        dialog.setPositiveButton("Да"
        ) { p0, p1 -> sharePreference() }
        dialog.setNegativeButton("Нет"
        ) { p0, p1 ->  }
        dialog.setCancelable(false)
        dialog.show()

    }
    private fun customDialog(){
        CustomDialog(this).show()
    }
}