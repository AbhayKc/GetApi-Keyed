package com.example.retroadapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("NotifyDataSetChanged")
class MainActivity : AppCompatActivity() {
    private lateinit var adapterRV: Adapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)

        setAdapter()
        val apiGenerator = ApiGenerator.buildServices(Interface::class.java)
        val call = apiGenerator.getData()

        call.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        adapterRV.setArraylist(data.data)
                    }
                }
            }
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("Failed", t.message.toString())
            }
        })
    }

    private fun setAdapter() {
        adapterRV = Adapter()
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapterRV
        }
    }