/*package com.fedi.apiaplicatiion1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {

  /*  private lateinit var retrofit: Retrofit
    private lateinit var retrofitInterface: RetrofitInterface
    private val BASE_URL = "http://192.168.1.19:5000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitInterface = retrofit.create(RetrofitInterface::class.java)

        findViewById<Button>(R.id.login).setOnClickListener {
            handleLoginDialog()
        }

        findViewById<Button>(R.id.signup).setOnClickListener {
            handleSignupDialog()
        }
    }

    private fun handleLoginDialog() {
        val view = layoutInflater.inflate(R.layout.login_dialog, null)

        val builder = AlertDialog.Builder(this)
        builder.setView(view).show()

        val loginBtn = view.findViewById<Button>(R.id.login)
        val email = view.findViewById<EditText>(R.id.emailEdit)
        val password = view.findViewById<EditText>(R.id.passwordEdit)

        loginBtn.setOnClickListener {
            val map = hashMapOf(
                "email" to email.text.toString(),
                "password" to password.text.toString()
            )

            val call = retrofitInterface.executeLogin(map)

            call.enqueue(object : Callback<LoginResult> {
                override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                    if (response.code() == 200) {
                        val result = response.body()

                        val builder1 = AlertDialog.Builder(this@MainActivity)
                        builder1.setTitle(result?.nom)
                        builder1.setMessage(result?.email)

                        builder1.show()
                        Toast.makeText(this@MainActivity, "Login connected", Toast.LENGTH_SHORT).show()
                    } else if (response.code() == 404) {
                        Toast.makeText(this@MainActivity, "Wrong Credentials", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun handleSignupDialog() {
        val view = layoutInflater.inflate(R.layout.signup_dialog, null)

        val builder = AlertDialog.Builder(this)
        builder.setView(view).show()

        val signupBtn = view.findViewById<Button>(R.id.signup)
        val nom = view.findViewById<EditText>(R.id.nameEdit)
        val email = view.findViewById<EditText>(R.id.emailEdit)
        val password = view.findViewById<EditText>(R.id.passwordEdit)

        signupBtn.setOnClickListener {
            val map = hashMapOf(
                "nom" to nom.text.toString(),
                "email" to email.text.toString(),
                "password" to password.text.toString()
            )

            val call = retrofitInterface.executeSignup(map)

            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.code() == 200) {
                        Toast.makeText(this@MainActivity, "Signed up successfully", Toast.LENGTH_LONG).show()
                    } else if (response.code() == 400) {
                        Toast.makeText(this@MainActivity, "Already registered", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}
*/
 /*
 */
  private lateinit var retrofit: Retrofit
    private lateinit var retrofitInterface: RetrofitInterface
    private val BASE_URL = "http://192.168.1.19:5000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitInterface = retrofit.create(RetrofitInterface::class.java)

        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val email = findViewById<EditText>(R.id.emailEdit).text.toString()
            val password = findViewById<EditText>(R.id.passwordEdit).text.toString()
            val rememberMe = findViewById<CheckBox>(R.id.rememberMe).isChecked

            val map = HashMap<String, String>()
            map["email"] = email
            map["password"] = password

            val call = retrofitInterface.executeLogin(map)

            call.enqueue(object : Callback<LoginResult> {
                override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                    if (response.code() == 200) {
                        val result = response.body()
                        Toast.makeText(this@MainActivity, "Login connected", Toast.LENGTH_SHORT).show()
                        val i = Intent(this@MainActivity, Mainscreen::class.java)
                        startActivity(i)
                        finish()
                    } else if (response.code() == 404) {
                        Toast.makeText(this@MainActivity, "Wrong Credentials", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}*/
package com.fedi.apiaplicatiion1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.regex.Pattern
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit
    private lateinit var retrofitInterface: RetrofitInterface
      private val BASE_URL = "http://192.168.1.19:5000"
    // private val BASE_URL = "http://172.16.113.13:5000"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitInterface = retrofit.create(RetrofitInterface::class.java)

        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val email = findViewById<EditText>(R.id.emailEdit).text.toString()
            val password = findViewById<EditText>(R.id.passwordEdit).text.toString()

            if (validateEmail(email) && validatePassword(password)) {
                val map = HashMap<String, String>()
                map["email"] = email
                map["password"] = password




                val call = retrofitInterface.executeLogin(map)

                call.enqueue(object : Callback<LoginResult> {
                   /* override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                        if (response.code() == 200) {
                            val result = response.body()
                            Log.d("MainActivity", "Server Response: $result")
                            Toast.makeText(this@MainActivity, "Login connected", Toast.LENGTH_SHORT).show()
                            val i = Intent(this@MainActivity, Mainscreen::class.java)
                            startActivity(i)
                            finish()
                           /* val i = Intent(this@MainActivity, PermisionActivity::class.java)
                            startActivity(i)
                            finish()*/
                            /*if (result != null) {
                                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                                intent.putExtra("resultJson", Gson().toJson(result))
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this@MainActivity, "Data is null", Toast.LENGTH_SHORT).show()
                            }*/
                        } else if (response.code() == 404) {
                            Toast.makeText(this@MainActivity, "Wrong Credentials", Toast.LENGTH_LONG).show()
                        }*/
                   override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                       if (response.code() == 200) {
                           val result = response.body()
                           if (result != null) {
                               val userName = result.nom // Getting the user's name from LoginResult
                               Log.d("MainActivity", "Server Response: $userName")
                               Toast.makeText(this@MainActivity, "Login connected", Toast.LENGTH_SHORT).show()
                               // Now you can use the userName variable to display the name
                               // For example, if you have a TextView with id userNameText
                               // you can set the text like this:
                               // val userNameTextView = findViewById<TextView>(R.id.userNameText)
                               // userNameTextView.text = userName

                               val i = Intent(this@MainActivity, Mainscreen::class.java)
                               startActivity(i)
                               finish()
                           } else {
                               Toast.makeText(this@MainActivity, "Data is null", Toast.LENGTH_SHORT).show()
                           }
                       } else if (response.code() == 404) {
                           Toast.makeText(this@MainActivity, "Wrong Credentials", Toast.LENGTH_LONG).show()
                       }
                    }

                    override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                    }
                })
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        val emailPattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        val matcher = emailPattern.matcher(email)
        return if (matcher.matches()) {
            true
        } else {
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun validatePassword(password: String): Boolean {
        return if (password.length >= 6) {
            true
        } else {
            Toast.makeText(this, "Password should be at least 6 characters long", Toast.LENGTH_SHORT).show()
            false
        }
    }
}
