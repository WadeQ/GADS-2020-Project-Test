package com.wadektech.aadpracticeproject2020.ui.views

import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.wadektech.aadpracticeproject2020.R
import com.wadektech.aadpracticeproject2020.data.domainModels.Response
import com.wadektech.aadpracticeproject2020.data.remote.PostToGoogleFormsApiServiceImpl
import kotlinx.android.synthetic.main.activity_submit.*
import retrofit2.Call
import retrofit2.Callback
import timber.log.Timber


class SubmitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        val firstName = et_first_name.text.toString().trim()
        val lastName = et_last_name.text.toString().trim()
        val email = et_email.text.toString().trim()
        val link = et_project_link.text.toString().trim()

        btn_submit_project.setOnClickListener {
            when {
                TextUtils.isEmpty(firstName) -> {
                    et_first_name.error = "Field cannot be blank!"
                }
                TextUtils.isEmpty(lastName) -> {
                    et_last_name.error = "Field cannot be blank!"
                }
                TextUtils.isEmpty(email) -> {
                    et_email.error = "Field cannot be blank!"
                }
                TextUtils.isEmpty(link) -> {
                    et_project_link.error = "Field cannot be blank!"
                }
                else -> {
                    submitProject(firstName,lastName,email,link)
                }
            }
        }
    }

    private fun submitProject(fName: String, lName:String,email:String,link:String){

        val postContents = PostToGoogleFormsApiServiceImpl.apiService.postProjectToGoogleForm(fName,lName,email,link)
        postContents.enqueue(object : Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.isSuccessful){}
            Timber.d("Status response for post request call is :{$response.code()}" )
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

}

