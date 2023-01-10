package com.life.assignment.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.life.assignment.R
import com.life.assignment.adapters.AdaptersMonths
import com.life.assignment.adapters.AdaptersPhoto
import com.life.assignment.data.Photos
import dagger.hilt.android.AndroidEntryPoint
import org.joda.time.LocalDate



@AndroidEntryPoint
class MainActivityMonths : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var resultPhotos: List<Photos>
    private lateinit var localDateList: List<LocalDate>
    private lateinit var adaptersMonths: AdaptersMonths
    private lateinit var adaptersPhoto: AdaptersPhoto
    private var mothsList = HashSet<String>()
    private lateinit var rvMonth: RecyclerView
    lateinit var photos : List<Photos>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMonth = findViewById<RecyclerView>(R.id.rv_list_month)
        setupRecyclerViewMonth()
        mainViewModel.getSelectMovie()
        mainViewModel.resultMutableLiveData.observe(this, Observer {
            resultPhotos = it.data()!!
            for (i in resultPhotos) {
                localDateList = listOf(i.takenDate)
                convertLocalDate(localDateList)
            }

            adaptersMonths.differ.submitList(mothsList.toList())
        })

        adaptersMonths.setOnItemClickListener {
            startActivity(Intent(this@MainActivityMonths, ActivityPhotos::class.java))

        }
    }

    private fun convertLocalDate(list: List<LocalDate>) {
        for (i in list) {
            val localDate = LocalDate.parse(i.toString())
            var dateAsString: String = localDate.monthOfYear.toString()
            when (dateAsString) {
                "1" -> mothsList.add("January")
                "2" -> mothsList.add("February")
                "3" -> mothsList.add("March")
                "4" -> mothsList.add("April")
                "5" -> mothsList.add("May\t")
                "6" -> mothsList.add("June\t")
                "7" -> mothsList.add("July\t")
                "8" -> mothsList.add("August")
                "9" -> mothsList.add("September\t")
                "10" -> mothsList.add("October")
                "11" -> mothsList.add("November")
                "12" -> mothsList.add("December\t")
            }
        }
    }

    private fun getPhotos(){
        mainViewModel.getSelectMovie()
        mainViewModel.resultMutableLiveData.observe(this, Observer {
            photos = it.data()!!
            for (i in photos) {

            }
            adaptersMonths.differ.submitList(mothsList.toList())
        })
    }

    private fun setupRecyclerViewMonth() {
        adaptersMonths = AdaptersMonths()
        rvMonth.apply {
            adapter = adaptersMonths
            layoutManager = LinearLayoutManager(this@MainActivityMonths)
        }
    }

}