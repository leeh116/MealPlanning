/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mealplanning

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplanning.adapter.ItemAdapter
import com.example.mealplanning.data.Datasource
import com.example.mealplanning.databinding.ActivityMainBinding
import com.example.mealplanning.model.Affirmation
import java.text.DateFormatSymbols
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val affList = mutableListOf<Affirmation>()

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize data.
//        var myDataset = Datasource().loadAffirmations(affList)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        var myAdapter = ItemAdapter(this, affList)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

        binding.submitName.setOnClickListener {
            if (binding.mealInput.text.isNotEmpty()) {
                println("here")
                println(binding.dateInput.month)
                val theDate = LocalDate.of(binding.dateInput.year, Month.of(binding.dateInput.month+1), binding.dateInput.dayOfMonth)
                println(theDate)
                affList.add(Affirmation(binding.mealInput.text.toString(), theDate))
                myAdapter.notifyDataSetChanged()
            }

        }

        recyclerView.adapter = myAdapter
    }
}