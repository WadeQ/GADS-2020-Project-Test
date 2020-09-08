package com.wadektech.aadpracticeproject2020.ui.views

import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.wadektech.aadpracticeproject2020.R
import com.wadektech.aadpracticeproject2020.data.domainModels.Submit
import kotlinx.android.synthetic.main.activity_submit.*


class SubmitActivity : AppCompatActivity() {
    lateinit var firstName : EditText
    lateinit var lastName : EditText
    lateinit var email : EditText
    lateinit var link : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        val firstName = et_first_name.text.trim()
        val lastName = et_last_name.text.trim()
        val email = et_email.text.trim()
        val link = et_project_link.text.trim()

        if (TextUtils.isEmpty(firstName)){
            
        }

    }

    fun submitProject(submit: Submit){
        val dialog = ProgressDialog(this@SubmitActivity, R.style.DialogStyle)
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        dialog.setTitle("Awaiting server response...")
        dialog.setMessage("Please be patient as we process your request")
        dialog.show()

        val submit = Submit(sub)
    }

}