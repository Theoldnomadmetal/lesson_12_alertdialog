package com.example.lesson_12_alertdialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button

class CustomDialog(context: Context): Dialog(context) {
    private var btnOk:Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)
        window?.setBackgroundDrawableResource(R.drawable.dialog_back)
        setCancelable(false)
        btnOk = findViewById(R.id.btnOk)
        btnOk?.setOnClickListener {
            dismiss()
        }
    }


}