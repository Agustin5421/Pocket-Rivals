package com.mobile.pocketrivals.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromCostumeList(costumes: List<Costume>?): String {
        return gson.toJson(costumes)
    }

    @TypeConverter
    fun toCostumeList(data: String): List<Costume> {
        val listType = object : TypeToken<List<Costume>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromStringList(strings: List<String>?): String {
        return gson.toJson(strings)
    }

    @TypeConverter
    fun toStringList(data: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromTransformationList(transformations: List<Transformation>?): String {
        return gson.toJson(transformations)
    }

    @TypeConverter
    fun toTransformationList(data: String): List<Transformation> {
        val listType = object : TypeToken<List<Transformation>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromAbilityList(abilities: List<Ability>?): String {
        return gson.toJson(abilities)
    }

    @TypeConverter
    fun toAbilityList(data: String): List<Ability> {
        val listType = object : TypeToken<List<Ability>>() {}.type
        return gson.fromJson(data, listType)
    }
}