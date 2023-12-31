package com.example.actividadesmars.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.actividadesmars.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    private lateinit var marsViewModel:MarsViewModel
    private lateinit var recycler: RecyclerView
    private lateinit var itemAdapter: AdapterMars

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)



        recycler = mBinding.RecyclerView1
        itemAdapter= AdapterMars(emptyList())
        recycler.adapter=itemAdapter
        recycler.layoutManager=GridLayoutManager(this,2)


        marsViewModel=ViewModelProvider(this).get(MarsViewModel::class.java)
        marsViewModel.marsLiveData.observe(this, Observer { marsLiveData->

            itemAdapter.datos=marsLiveData
            itemAdapter.notifyDataSetChanged()

        })
        marsViewModel.getMars()

    }
}