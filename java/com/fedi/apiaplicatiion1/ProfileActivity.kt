package com.fedi.apiaplicatiion1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_profile.*
import androidx.databinding.DataBindingUtil
import com.fedi.apiaplicatiion1.databinding.ActivityProfileBinding
import com.google.gson.Gson

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent.hasExtra("resultJson")) {
            val resultJson = intent.getStringExtra("resultJson")
            Log.d("ProfileActivity", "Received ResultJson: $resultJson")  // Debug received JSON

            val result = Gson().fromJson(resultJson, LoginResult::class.java)
            Log.d("ProfileActivity", "Parsed Result: $result")  // Debug parsed result

            if (result != null) {
                val binding: ActivityProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
                binding.result = result
                Log.d("ProfileActivity", "Result: $result")

            /*    if (result.etat_active == "Inactive") {
                    Toast.makeText(this@ProfileActivity, "Your account is inactive", Toast.LENGTH_SHORT).show()
                    // Optionally, you can navigate back to MainActivity or perform other actions
                    finish()
                }*/

            } else {
                Toast.makeText(this@ProfileActivity, "No profile data available", Toast.LENGTH_SHORT).show()
                finish()
            }
        } else {
            Toast.makeText(this@ProfileActivity, "No intent extras available", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}