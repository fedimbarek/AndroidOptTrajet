/*package com.fedi.apiaplicatiion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class PermisionActivity : AppCompatActivity() {
    private lateinit var retrofit: Retrofit
    private lateinit var retrofitInterface: RetrofitInterface
    private val BASE_URL = "http://192.168.1.19:5000"

    private lateinit var DateDebut: EditText
    private lateinit var DateFin: EditText
    private lateinit var DateDemande: EditText
    private lateinit var HeureDebut: EditText
    private lateinit var HeureFin: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permision)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitInterface = retrofit.create(RetrofitInterface::class.java)

        /*val builder = AlertDialog.Builder(this)

        builder.show()*/

        val button: Button = findViewById(R.id.button)
        val Nom: EditText = findViewById(R.id.nom)
        DateDebut = findViewById(R.id.DateDebut)
        DateFin = findViewById(R.id.DateFin)
        DateDemande = findViewById(R.id.DateDemmande)
        HeureDebut = findViewById(R.id.HeureDebut)
        HeureFin = findViewById(R.id.HeureFin)
        val Raison: EditText = findViewById(R.id.Raison)

        button.setOnClickListener {
            val map = HashMap<String, String>()

            map["Nom"] = Nom.text.toString()
            map["DateDebut"] = DateDebut.text.toString()
            map["DateFin"] = DateFin.text.toString()
            map["DateDemande"] = DateDemande.text.toString()
            map["HeureDebut"] = HeureDebut.text.toString()
            map["HeureFin"] = HeureFin.text.toString()
            map["Raison"] = Raison.text.toString()

            val call: Call<Void> = retrofitInterface.executePermission(map)

            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.code() == 200) {
                        Toast.makeText(
                            this@PermisionActivity,
                            "Permission up successfully",
                            Toast.LENGTH_LONG
                        ).show()
                    } else if (response.code() == 400) {
                        Toast.makeText(
                            this@PermisionActivity,
                            "Already Permission",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(
                        this@PermisionActivity,
                        t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        }

        val dateOnClickListener = View.OnClickListener {
            openDialogDate(it)
        }

        DateDebut.setOnClickListener(dateOnClickListener)
        DateFin.setOnClickListener(dateOnClickListener)
        DateDemande.setOnClickListener(dateOnClickListener)

        val dateOnClick = View.OnClickListener {
            openDialogHeure(it)
        }

        HeureDebut.setOnClickListener(dateOnClick)
        HeureFin.setOnClickListener(dateOnClick)
    }

    private fun openDialogDate(v: View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(this, { datePicker, y, m, d ->
            when (v) {
                DateDebut -> DateDebut.setText("$y/${m + 1}/$d")
                DateFin -> DateFin.setText("$y/${m + 1}/$d")
                DateDemande -> DateDemande.setText("$y/${m + 1}/$d")
            }
        }, year, month, day)

        dialog.show()
    }

    private fun openDialogHeure(v: View) {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        val dialog = TimePickerDialog(this, { timePicker, h, m ->
            when (v) {
                HeureDebut -> HeureDebut.setText("$h:$m")
                HeureFin -> HeureFin.setText("$h:$m")
            }
        }, hour, minute, true)

        dialog.show()
    }

}*/

package com.fedi.apiaplicatiion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.text.SimpleDateFormat
import java.text.ParseException
class PermisionActivity : AppCompatActivity() {
    private lateinit var retrofit: Retrofit
    private lateinit var retrofitInterface: RetrofitInterface
    private val BASE_URL = "http://192.168.1.19:5000"

    private lateinit var DateDebut: EditText
    private lateinit var DateFin: EditText
    private lateinit var DateDemande: EditText
    private lateinit var HeureDebut: EditText
    private lateinit var HeureFin: EditText
    private lateinit var Nom: EditText
    private lateinit var Raison: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permision)

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitInterface = retrofit.create(RetrofitInterface::class.java)

        val button: Button = findViewById(R.id.button)
        Nom = findViewById(R.id.nom)
        DateDebut = findViewById(R.id.DateDebut)
        DateFin = findViewById(R.id.DateFin)
        DateDemande = findViewById(R.id.DateDemmande)
        HeureDebut = findViewById(R.id.HeureDebut)
        HeureFin = findViewById(R.id.HeureFin)
        Raison = findViewById(R.id.Raison)

        button.setOnClickListener {
            if (isValidInput()) {
                val map = HashMap<String, String>()

                map["Nom"] = Nom.text.toString()
                map["DateDebut"] = DateDebut.text.toString()
                map["DateFin"] = DateFin.text.toString()
                map["DateDemande"] = DateDemande.text.toString()
                map["HeureDebut"] = HeureDebut.text.toString()
                map["HeureFin"] = HeureFin.text.toString()
                map["Raison"] = Raison.text.toString()

                val call: Call<Void> = retrofitInterface.executePermission(map)

                call.enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.code() == 200) {
                            Toast.makeText(
                                this@PermisionActivity,
                                "Permission up successfully",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (response.code() == 400) {
                            Toast.makeText(
                                this@PermisionActivity,
                                "Already Permission",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(
                            this@PermisionActivity,
                            t.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
            }
        }

        val dateOnClickListener = View.OnClickListener {
            openDialogDate(it)
        }

        DateDebut.setOnClickListener(dateOnClickListener)
        DateFin.setOnClickListener(dateOnClickListener)
        DateDemande.setOnClickListener(dateOnClickListener)

        val dateOnClick = View.OnClickListener {
            openDialogHeure(it)
        }

        HeureDebut.setOnClickListener(dateOnClick)
        HeureFin.setOnClickListener(dateOnClick)
    }

    private fun openDialogDate(v: View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(this, { datePicker, y, m, d ->
            when (v) {
                DateDebut -> DateDebut.setText("$y/${m + 1}/$d")
                DateFin -> DateFin.setText("$y/${m + 1}/$d")
                DateDemande -> DateDemande.setText("$y/${m + 1}/$d")
            }
        }, year, month, day)

        dialog.show()
    }

    private fun openDialogHeure(v: View) {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        val dialog = TimePickerDialog(this, { timePicker, h, m ->
            when (v) {
                HeureDebut -> HeureDebut.setText("$h:$m")
                HeureFin -> HeureFin.setText("$h:$m")
            }
        }, hour, minute, true)

        dialog.show()
    }

    private fun isValidInput(): Boolean {
        if (Nom.text.toString().isEmpty()) {
            Toast.makeText(this, "Nom cannot be empty", Toast.LENGTH_SHORT).show()
            return false
        }

        // Add additional validation as needed for other fields
        // Date validation can be more complex, but for simplicity, let's check if they are not empty

        if (DateDebut.text.toString().isEmpty()) {
            Toast.makeText(this, "DateDebut cannot be empty", Toast.LENGTH_SHORT).show()
            return false
        }

        if (DateFin.text.toString().isEmpty()) {
            Toast.makeText(this, "DateFin cannot be empty", Toast.LENGTH_SHORT).show()
            return false
        }
        val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
        try {
            val dateDebut = dateFormat.parse(DateDebut.text.toString())
            val dateFin = dateFormat.parse(DateFin.text.toString())

            if (dateDebut != null && dateFin != null) {
                if (dateDebut.after(dateFin)) {
                    Toast.makeText(this, "DateDebut must be before DateFin", Toast.LENGTH_SHORT).show()
                    return false
                }
            }
        } catch (e: ParseException) {
            Toast.makeText(this, "Invalid date format", Toast.LENGTH_SHORT).show()
            return false
        }
        if (DateDemande.text.toString().isEmpty()) {
            Toast.makeText(this, "DateDemande cannot be empty", Toast.LENGTH_SHORT).show()
            return false
        }

        if (HeureDebut.text.toString().isEmpty()) {
            Toast.makeText(this, "HeureDebut cannot be empty", Toast.LENGTH_SHORT).show()
            return false
        }

        if (HeureFin.text.toString().isEmpty()) {
            Toast.makeText(this, "HeureFin cannot be empty", Toast.LENGTH_SHORT).show()
            return false
        }

        if (Raison.text.toString().isEmpty()) {
            Toast.makeText(this, "Raison cannot be empty", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

}

