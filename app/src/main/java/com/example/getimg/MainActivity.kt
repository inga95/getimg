package com.example.getimg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import org.json.JSONArray




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidNetworking.initialize(applicationContext)

        val getOutPut: TextView = findViewById(R.id.getOutPut)

        AndroidNetworking.get("http://api-edu.gtl.ai/api/v1/imagesearch/bing")
            .addQueryParameter("url", "https://toppng.com/uploads/preview/cat-11521380838sq5q7tscgh.png")
            .setTag("test")
            .setPriority(Priority.LOW)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                    getOutPut.text = "GET response: " + response.toString()
                }

                override fun onError(error: ANError?) {

                }
            })
    }
}