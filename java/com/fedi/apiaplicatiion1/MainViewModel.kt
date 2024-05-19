package com.fedi.apiaplicatiion1

/*import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
*/
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class MainViewModel : ViewModel() {

  /*  private val _planningList = MutableLiveData<List<Planning>>()
    val planningList: LiveData<List<Planning>> = _planningList

    // Implement a method to fetch data from your backend and update _planningList
    fun fetchPlanningData() {
        // Implement your logic to fetch data from the backend and update _planningList
    }*/
  private val BASE_URL = "http://192.168.1.19:5000/users/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = retrofit.create(ApiService::class.java)

    // Method to add planning
   /* fun addPlanning(planning: Planning) {
        val call = service.addPlanning(planning)
        call.enqueue(object : Callback<Planning> {
            override fun onResponse(call: Call<Planning>, response: Response<Planning>) {
                // Handle successful response
                if (response.isSuccessful) {
                    // Planning added successfully
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<Planning>, t: Throwable) {
                // Handle failure
            }
        })
    }*/

    // Method to fetch all planning
    fun getAllPlanning(): LiveData<List<Planning>> {
        val planningList = MutableLiveData<List<Planning>>()
        val call = service.getAllPlanning()
        call.enqueue(object : Callback<List<Planning>> {
            override fun onResponse(call: Call<List<Planning>>, response: Response<List<Planning>>) {
                // Handle successful response
                if (response.isSuccessful) {
                    planningList.value = response.body()
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<List<Planning>>, t: Throwable) {
                // Handle failure
            }
        })
        return planningList
    }

    // Method to get planning by ID
  /*  fun getPlanningById(id: String): LiveData<Planning> {
        val planning = MutableLiveData<Planning>()
        val call = service.getPlanningById(id)
        call.enqueue(object : Callback<Planning> {
            override fun onResponse(call: Call<Planning>, response: Response<Planning>) {
                // Handle successful response
                if (response.isSuccessful) {
                    planning.value = response.body()
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<Planning>, t: Throwable) {
                // Handle failure
            }
        })
        return planning
    }*/

    // Method to update planning
   /* fun updatePlanning(id: String, planning: Planning) {
        val call = service.updatePlanning(id, planning)
        call.enqueue(object : Callback<Planning> {
            override fun onResponse(call: Call<Planning>, response: Response<Planning>) {
                // Handle successful response
                if (response.isSuccessful) {
                    // Planning updated successfully
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<Planning>, t: Throwable) {
                // Handle failure
            }
        })
    }*/
}