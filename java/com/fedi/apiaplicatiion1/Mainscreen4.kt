package com.fedi.apiaplicatiion1

/*import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Mainscreen4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen4)
    }
}*/

/*import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.net.URL

class Mainscreen4 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var myMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen4)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        myMap = googleMap

        val startPoint = LatLng(36.8065, 10.1815)
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPoint, 18f))

        fetchLocationsFromBackend()
    }

    private fun fetchLocationsFromBackend() {
        GlobalScope.launch(Dispatchers.IO) {
            val url = URL("http://192.168.1.19:5000/users/listerdestination")
            val connection = url.openConnection()
            val inputStream = connection.getInputStream()
            val response = inputStream.bufferedReader().readText()

            val locations = parseLocations(response)
            runOnUiThread {
                displayLocationsOnMap(locations)
            }
        }
    }

    private fun parseLocations(jsonString: String): List<Location> {
        val locations = mutableListOf<Location>()

        try {
            val jsonObject = JSONObject(jsonString)
            val locationsArray = jsonObject.getJSONArray("contactdetination")

            for (i in 0 until locationsArray.length()) {
                val locationObject = locationsArray.getJSONObject(i)
                val title = locationObject.getString("title")
                val description = locationObject.getString("description")
                val latitude = locationObject.getDouble("latitude")
                val longitude = locationObject.getDouble("longitude")
                locations.add(Location(title, description, LatLng(latitude, longitude)))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return locations
    }

    private fun displayLocationsOnMap(locations: List<Location>) {
        for (location in locations) {
            myMap.addMarker(
                MarkerOptions()
                    .position(location.latLng)
                    .title(location.title)
                    .snippet(location.description)
            )
        }
    }

    data class Location(val title: String, val description: String, val latLng: LatLng)
}
*/
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.net.URL

class Mainscreen4 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var myMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen4)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val zoomInButton: Button = findViewById(R.id.zoom_in_button)
        val zoomOutButton: Button = findViewById(R.id.zoom_out_button)

        zoomInButton.setOnClickListener {
            myMap.animateCamera(CameraUpdateFactory.zoomIn())
        }

        zoomOutButton.setOnClickListener {
            myMap.animateCamera(CameraUpdateFactory.zoomOut())
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        myMap = googleMap

        val startPoint = LatLng(36.8065, 10.1815)
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPoint, 18f))

        fetchLocationsFromBackend()
    }

    private fun fetchLocationsFromBackend() {
        GlobalScope.launch(Dispatchers.IO) {
            val url = URL("http://192.168.1.19:5000/users/listerdestination")
            val connection = url.openConnection()
            val inputStream = connection.getInputStream()
            val response = inputStream.bufferedReader().readText()

            val locations = parseLocations(response)
            runOnUiThread {
                displayLocationsOnMap(locations)
            }
        }
    }

    private fun parseLocations(jsonString: String): List<Location> {
        val locations = mutableListOf<Location>()

        try {
            val jsonObject = JSONObject(jsonString)
            val locationsArray = jsonObject.getJSONArray("contactdetination")

            for (i in 0 until locationsArray.length()) {
                val locationObject = locationsArray.getJSONObject(i)
                val title = locationObject.getString("title")
                val description = locationObject.getString("description")
                val latitude = locationObject.getDouble("latitude")
                val longitude = locationObject.getDouble("longitude")
                locations.add(Location(title, description, LatLng(latitude, longitude)))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return locations
    }

    private fun displayLocationsOnMap(locations: List<Location>) {
        for (location in locations) {
            myMap.addMarker(
                MarkerOptions()
                    .position(location.latLng)
                    .title(location.title)
                    .snippet(location.description)
            )
        }
    }

    data class Location(val title: String, val description: String, val latLng: LatLng)
}
