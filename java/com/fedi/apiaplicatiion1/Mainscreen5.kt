package com.fedi.apiaplicatiion1

/*import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView

import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

data class Planning(
    @SerializedName("_id") val id: String,
    @SerializedName("nom_dagent") val agentName: String,
    val date: String,
    val title: String,
    val Tache: String
)


class Mainscreen5 : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen5)

        textView = findViewById(R.id.textView)

        // Instantiate Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.19:5000/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        // Create an instance of the Retrofit interface
        apiService = retrofit.create(ApiService::class.java)

        // Make API call to get planning data
        fetchPlanningData()
    }
    private fun fetchPlanningData() {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val planning = apiService.getPlanningById("your_planning_id")
                // Update UI with the retrieved planning data
                updateUI(planning)
            } catch (e: Exception) {
                // Handle errors
                e.printStackTrace()
                updateUIError()
            }
        }
    }

    private fun updateUI(planning: Planning) {
        runOnUiThread {
            textView.text = "Agent: ${planning.agentName}\n" +
                    "Date: ${planning.date}\n" +
                    "Title: ${planning.title}\n" +
                    "Task: ${planning.Tache}"
        }
    }

    private fun updateUIError() {
        runOnUiThread {
            textView.text = "Error fetching data"
        }
    }
}*/

/*import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL
*/
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.net.URL
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import android.os.AsyncTask
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection

class Mainscreen5 : AppCompatActivity() {

    /*private lateinit var viewModel: MainViewModel
    private lateinit var planningAdapter: PlanningAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen5)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val recyclerView: RecyclerView = findViewById(R.id.rvPosts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        planningAdapter = PlanningAdapter(emptyList()) // Initially, list is empty
        recyclerView.adapter = planningAdapter

        viewModel.planningList.observe(this, { planningList ->
            planningAdapter = PlanningAdapter(planningList)
            recyclerView.adapter = planningAdapter
        })

        viewModel.fetchPlanningData() // Fetch data from backend
    }*/

/*    private fun fetchDataFromBackend() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val url = URL("http://192.168.1.19:5000/user/afficherplannig")
                val connection = url.openConnection()
                val inputStream = connection.getInputStream()
                val response = inputStream.bufferedReader().use { it.readText() }

                val data = parseData(response)
                runOnUiThread {
                    displayData(data)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle error: Display an error message to the user
                runOnUiThread {
                    // Example of displaying error message in a TextView
                    textView.text = "Error fetching data: ${e.message}"
                }
            }
        }
    }

    private fun parseData(jsonString: String): List<String> {
        val dataList = mutableListOf<String>()

        try {
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val title = jsonObject.getString("title")
                val date = jsonObject.getString("date")
                dataList.add("Title: $title, Date: $date")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return dataList
    }

    private fun displayData(data: List<String>) {
        adapter.clear()
        adapter.addAll(data)
        adapter.notifyDataSetChanged()
    }
    data class Planning(
        val nom_dagent: String, // Assuming this is the user's name
        val date: String,
        val title: String, // Assuming this is the destination's title
        val Tache: String
    )*/
/*private lateinit var viewModel: MainViewModel
    private lateinit var planningAdapter: PlanningAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen5)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val recyclerView: RecyclerView = findViewById(R.id.rvPosts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the planning adapter with an empty list
        planningAdapter = PlanningAdapter(emptyList())
        recyclerView.adapter = planningAdapter

        // Observe the planning list from the view model
        viewModel.getAllPlanning().observe(this, Observer<List<Planning>> { planningList ->
            // Update the adapter when the planning list changes
            planningAdapter.setData(planningList)
        })
    }*/

/*    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen5)

        // Execute the AsyncTask to perform the GET request
        GetRequestTask().execute()
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@Mainscreen5, Mainscreen4::class.java)
            startActivity(intent)
        }
    }

    inner class GetRequestTask : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void?): String {
            val url =
                URL("http://10.0.2.2:5000/users/afficherplannig") // Use the correct IP address or hostname
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
                try {
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
                }
            }
        }
    }*/
private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen5)

        listView = findViewById(R.id.listview1)

        // Execute the AsyncTask to perform the GET request
        GetRequestTask().execute()

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@Mainscreen5, Mainscreen4::class.java)
            startActivity(intent)
        }
    }

    inner class GetRequestTask : AsyncTask<Void, Void, List<String>>() {

        override fun doInBackground(vararg params: Void?): List<String> {
            val url = URL("http://10.0.2.2:5000/users/afficherplannig")
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

            return parsePlanningData(response.toString())
        }

        override fun onPostExecute(result: List<String>?) {
            super.onPostExecute(result)
            result?.let {
                val adapter = ArrayAdapter(this@Mainscreen5, android.R.layout.simple_list_item_1, it)
                listView.adapter = adapter
            }
        }

        private fun parsePlanningData(jsonString: String): List<String> {
            val planningList = mutableListOf<String>()
            try {
                val jsonObject = JSONObject(jsonString)
                val planningArray = jsonObject.getJSONArray("planningList")

                for (i in 0 until planningArray.length()) {
                    val planning = planningArray.getJSONObject(i)
                    val date = planning.getString("date")
                    val nomDagent = planning.getJSONObject("nom_dagent").getString("nom")

                    // Check if "Tache" key exists
                    val tache = if (planning.has("Tache")) {
                        planning.getString("Tache")
                    } else {
                        "No Task Available" // Provide a default value if "Tache" key is missing
                    }

                    val displayString = "Date: $date\nTache: $tache\nAgent: $nomDagent"
                    planningList.add(displayString)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
                // Handle JSON parsing error
            }
            return planningList
        }
    }
}