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

package com.example.mealplanning.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mealplanning.model.Affirmation
import com.example.mealplanning.R
import java.time.LocalDate

/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadAffirmations( affList: List<Affirmation>): List<Affirmation> {
        var unordered = mutableListOf<Affirmation>()
        for (item in affList) {
            unordered.add(item)
        }
        return unordered.sortedWith(compareBy { it.dateResourceId })
    }
}