package com.yapp.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson

class ListConverter {
    @TypeConverter
    fun toJson(list: List<String>) = Gson().toJson(list)

    @TypeConverter
    fun toList(json: String) = Gson().fromJson(json, Array<String>::class.java).toList()
}