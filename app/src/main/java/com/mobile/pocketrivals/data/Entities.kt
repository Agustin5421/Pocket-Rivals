package com.mobile.pocketrivals.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "heroes")
data class Hero(
  @PrimaryKey
  @SerializedName("id") val id: String,
  @SerializedName("name") val name: String,
  @SerializedName("real_name") val realName: String,
  @SerializedName("role") val role: String,
  @SerializedName("imageUrl") val imageUrl: String,
  @SerializedName("attack_type") val attackType: String,
  @SerializedName("team") val team: List<String>,
  @SerializedName("difficulty") val difficulty: String,
  @SerializedName("bio") val bio: String,
  @SerializedName("lore") val lore: String,
  @SerializedName("transformations") val transformations: List<Transformation>,
  @SerializedName("costumes") val costumes: List<Costume>,
  @SerializedName("abilities") val abilities: List<Ability>
)

@Entity(tableName = "transformations")
data class Transformation(
  @PrimaryKey
  @SerializedName("id") val id: String,
  @SerializedName("name") val name: String,
  @SerializedName("icon") val icon: String,
  @SerializedName("health") val health: String?,
  @SerializedName("movement_speed") val movementSpeed: String?
)

@Entity(tableName = "costumes")
data class Costume(
  @PrimaryKey
  @SerializedName("id") val id: String,
  @SerializedName("name") val name: String,
  @SerializedName("icon") val icon: String,
  @SerializedName("quality") val quality: String,
  @SerializedName("description") val description: String,
  @SerializedName("appearance") val appearance: String
)

@Entity(tableName = "abilities")
data class Ability(
  @PrimaryKey
  @SerializedName("id") val id: Int,
  @SerializedName("icon") val icon: String,
  @SerializedName("name") val name: String?,
  @SerializedName("type") val type: String,
  @SerializedName("isCollab") val isCollab: Boolean,
  @SerializedName("description") val description: String?,
  @SerializedName("additional_fields") val additionalFields: AdditionalFields?,
  @SerializedName("transformation_id") val transformationId: String
)

@Entity(tableName = "additional_fields")
data class AdditionalFields(
  @PrimaryKey(autoGenerate = true) val id: Int = 0,
  @SerializedName("Key") val key: String?,
  @SerializedName("Casting") val casting: String?,
  @SerializedName("Energy Cost") val energyCost: String?,
  @SerializedName("Special Effect") val specialEffect: String?
)