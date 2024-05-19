package com.fedi.apiaplicatiion1

/*import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONException
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class Mainscreen6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen6)

        GetRequestTask().execute()
    }
    inner class GetRequestTask : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void?): String {
            val url =
                URL("http://10.0.2.2:5000/users/listepermission") // Use the correct IP address or hostname
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            val response = StringBuilder()

            if (responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                var inputLine: String?

                while (reader.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }

                reader.close()
            } else {
                response.append("GET request failed with response code: $responseCode")
            }

            connection.disconnect()

            return response.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            // Handle the response here
            result?.let {
                Log.d("GET Request Response", it)
                /* val dataTextView = findViewById<TextView>(R.id.dateTextView)
                dataTextView.text = it*/
                // You can parse the response and update UI accordingly
                /*   val jsonObject = JSONObject(it)
                      val planningList = jsonObject.getJSONArray("planningList")

                      // Iterate over the planningList array
                      for (i in 0 until planningList.length()) {
                          val planning = planningList.getJSONObject(i)

                          // Extract the data you want to display
                          val date = planning.getString("date")
                          val tache = planning.getString("Tache")
                          val nom_dagent = planning.getJSONObject("nom_dagent").getString("nom")

                          // Update the UI elements
                          val dateTextView = findViewById<TextView>(R.id.dateTextView)
                          dateTextView.text = date

                          val tacheTextView = findViewById<TextView>(R.id.tacheTextView)
                          tacheTextView.text = tache

                          val agentTextView = findViewById<TextView>(R.id.agentTextView)
                          agentTextView.text = nom_dagent
                      }*/
              /*  try {
                    val jsonObject = JSONObject(it)
                    val planningList = jsonObject.getJSONArray("planningList")

                    // Iterate over the planningList array
                    for (i in 0 until planningList.length()) {
                        val planning = planningList.getJSONObject(i)

                        // Extract the data you want to display
                        val date = planning.getString("date")
                        val nom_dagent = planning.getJSONObject("nom_dagent").getString("nom")

                        // Check if "Tache" key exists
                        val tache = if (planning.has("Tache")) {
                            planning.getString("Tache")
                        } else {
                            "No Task Available" // Provide a default value if "Tache" key is missing
                        }

                        // Update the UI elements
                        val dateTextView = findViewById<TextView>(R.id.dateTextView)
                        dateTextView.text = date

                        val tacheTextView = findViewById<TextView>(R.id.tacheTextView)
                        tacheTextView.text = tache

                        val agentTextView = findViewById<TextView>(R.id.agentTextView)
                        agentTextView.text = nom_dagent
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    // Handle JSON parsing error
                }*/
            }
        }
    }
}*/

// code fou9any w loutany zada zouz s7a7 loutany asa7 minb foug
/*
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class Mainscreen6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen6)

        GetRequestTask().execute()
    }

    inner class GetRequestTask : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void?): String {
            val url = URL("http://10.0.2.2:5000/users/listepermission")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            val response = StringBuilder()

            if (responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                var inputLine: String?

                while (reader.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }

                reader.close()
            } else {
                response.append("GET request failed with response code: $responseCode")
            }

            connection.disconnect()

            return response.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            result?.let {
                try {
                    val jsonObject = JSONObject(it)
                    val permissionArray = jsonObject.getJSONArray("contactpermission")

                    val permissionsList = mutableListOf<String>()
                    for (i in 0 until permissionArray.length()) {
                        val permissionObj = permissionArray.getJSONObject(i)
                        val nom = permissionObj.getString("Nom")
                        val dateDebut = permissionObj.getString("DateDebut")
                        val dateFin = permissionObj.getString("DateFin")
                        val permissionString = "Nom: $nom\nDate de début: $dateDebut\nDate de fin: $dateFin"
                        permissionsList.add(permissionString)
                    }

                    val permissionsListView = findViewById<ListView>(R.id.permissionsListView)
                    val adapter = ArrayAdapter(this@Mainscreen6, android.R.layout.simple_list_item_1, permissionsList)
                    permissionsListView.adapter = adapter

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
        }
    }
}*/

/*import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class Mainscreen6 : AppCompatActivity() {

    private lateinit var permissionsListView: ListView
    private lateinit var permissionsList: List<Permission> // Define permissionsList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen6)

        permissionsListView = findViewById(R.id.permissionsListView)

        // Load permissions initially
        GetRequestTask().execute()

        // Setup the update button
        val updateButton: Button = findViewById(R.id.updateButton)
        updateButton.setOnClickListener {
            // Here you can open a dialog or activity to get the updated permission data
            // For simplicity, I'll just update the first permission in the list with dummy data
            val firstPermission = permissionsList.firstOrNull() ?: return@setOnClickListener
            val updatedData = mapOf(
                "Nom" to "Updated Name",
                "DateDebut" to "2024/05/20", // Example updated date
                "DateFin" to "2024/05/25"    // Example updated date
                // Add other fields to update as needed
            )
            UpdateRequestTask().execute(Pair(firstPermission.id, updatedData)) // Pass Pair object
        }
    }

    inner class GetRequestTask : AsyncTask<Void, Void, List<Permission>>() {

        override fun doInBackground(vararg params: Void?): List<Permission> {
            val url = URL("http://10.0.2.2:5000/users/listepermission")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            val response = StringBuilder()

            if (responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                var inputLine: String?

                while (reader.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }

                reader.close()
            } else {
                response.append("GET request failed with response code: $responseCode")
            }

            connection.disconnect()

            return parsePermissions(response.toString())
        }

        override fun onPostExecute(result: List<Permission>?) {
            super.onPostExecute(result)
            result?.let {
                permissionsList = it // Assign the result to permissionsList
                val adapter = ArrayAdapter(this@Mainscreen6, android.R.layout.simple_list_item_1, it)
                permissionsListView.adapter = adapter
            }
        }
    }

    inner class UpdateRequestTask : AsyncTask<Pair<String, Map<String, String>>, Void, Boolean>() {

        override fun doInBackground(vararg params: Pair<String, Map<String, String>>): Boolean {
            val (permissionId, updatedData) = params[0]
            val url = URL("http://10.0.2.2:5000/users/modifierPermission/{id}")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "PUT"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true

            val outputStreamWriter = OutputStreamWriter(connection.outputStream)
            outputStreamWriter.write(JSONObject(updatedData).toString())
            outputStreamWriter.flush()

            val responseCode = connection.responseCode

            return responseCode == HttpURLConnection.HTTP_OK
        }

        override fun onPostExecute(result: Boolean) {
            super.onPostExecute(result)
            if (result) {
                // Permission updated successfully, you can refresh the permissions list here
                GetRequestTask().execute()
            } else {
                // Handle update failure
                Log.e("UpdateRequestTask", "Failed to update permission")
            }
        }
    }

    private fun parsePermissions(jsonString: String): List<Permission> {
        val permissionsList = mutableListOf<Permission>()
        try {
            val jsonObject = JSONObject(jsonString)
            val permissionArray = jsonObject.getJSONArray("contactpermission")

            for (i in 0 until permissionArray.length()) {
                val permissionObj = permissionArray.getJSONObject(i)
                val permission = Permission(
                    permissionObj.getString("_id"),
                    permissionObj.getString("Nom"),
                    permissionObj.getString("DateDebut"),
                    permissionObj.getString("DateFin"),
                    permissionObj.getString("DateDemande"),
                    permissionObj.getString("HeureDebut"),
                    permissionObj.getString("HeureFin"),
                    permissionObj.getString("Raison"),
                    permissionObj.getString("__v").toInt()
                )
                permissionsList.add(permission)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return permissionsList
    }
}

data class Permission(
    val id: String,
    val nom: String,
    val dateDebut: String,
    val dateFin: String,
    val dateDemande: String,
    val heureDebut: String,
    val heureFin: String,
    val raison: String,
    val v: Int
) {
    override fun toString(): String {
        return "Nom: $nom\nDate de début: $dateDebut\nDate de fin: $dateFin"
    }
}*/
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class Mainscreen6 : AppCompatActivity() {

    private lateinit var permissionsListView: ListView
    private lateinit var permissionsList: List<Permission> // Define permissionsList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen6)

        permissionsListView = findViewById(R.id.permissionsListView)

        // Load permissions initially
        GetRequestTask().execute()

        // Set click listener on list items
        permissionsListView.setOnItemClickListener { parent, view, position, id ->
            val selectedPermission = permissionsList[position]
            // Here you can handle the update logic for the selected permission
            // For simplicity, I'll just show a log message
            Log.d("ListItemClicked", "Permission clicked: $selectedPermission")
            // You can also open an activity or dialog to edit the permission data
            // Pass the selected permission to the activity/dialog if needed
        }
    }

    inner class GetRequestTask : AsyncTask<Void, Void, List<Permission>>() {

        override fun doInBackground(vararg params: Void?): List<Permission> {
            val url = URL("http://10.0.2.2:5000/users/listepermission")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            val response = StringBuilder()

            if (responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                var inputLine: String?

                while (reader.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }

                reader.close()
            } else {
                response.append("GET request failed with response code: $responseCode")
            }

            connection.disconnect()

            return parsePermissions(response.toString())
        }

        override fun onPostExecute(result: List<Permission>?) {
            super.onPostExecute(result)
            result?.let {
                permissionsList = it // Assign the result to permissionsList
                val adapter = ArrayAdapter(this@Mainscreen6, android.R.layout.simple_list_item_1, it)
                permissionsListView.adapter = adapter
            }
        }
    }

    private fun parsePermissions(jsonString: String): List<Permission> {
        val permissionsList = mutableListOf<Permission>()
        try {
            val jsonObject = JSONObject(jsonString)
            val permissionArray = jsonObject.getJSONArray("contactpermission")

            for (i in 0 until permissionArray.length()) {
                val permissionObj = permissionArray.getJSONObject(i)
                val permission = Permission(
                    permissionObj.getString("_id"),
                    permissionObj.getString("Nom"),
                    permissionObj.getString("DateDebut"),
                    permissionObj.getString("DateFin"),
                    permissionObj.getString("DateDemande"),
                    permissionObj.getString("HeureDebut"),
                    permissionObj.getString("HeureFin"),
                    permissionObj.getString("Raison"),
                    permissionObj.getString("__v").toInt()
                )
                permissionsList.add(permission)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return permissionsList
    }
}

data class Permission(
    val id: String,
    val nom: String,
    val dateDebut: String,
    val dateFin: String,
    val dateDemande: String,
    val heureDebut: String,
    val heureFin: String,
    val raison: String,
    val v: Int
) {
    override fun toString(): String {
        return "Nom: $nom\nDate de début: $dateDebut\nDate de fin: $dateFin"
    }
}

