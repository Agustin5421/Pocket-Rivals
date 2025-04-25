package com.mobile.pocketrivals.mocks

import com.google.gson.annotations.SerializedName

data class Hero(
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

data class Transformation(
  @SerializedName("id") val id: String,
  @SerializedName("name") val name: String,
  @SerializedName("icon") val icon: String,
  @SerializedName("health") val health: String?,
  @SerializedName("movement_speed") val movementSpeed: String?
)

data class Costume(
  @SerializedName("id") val id: String,
  @SerializedName("name") val name: String,
  @SerializedName("icon") val icon: String,
  @SerializedName("quality") val quality: String,
  @SerializedName("description") val description: String,
  @SerializedName("appearance") val appearance: String
)

data class Ability(
  @SerializedName("id") val id: Int,
  @SerializedName("icon") val icon: String,
  @SerializedName("name") val name: String?,
  @SerializedName("type") val type: String,
  @SerializedName("isCollab") val isCollab: Boolean,
  @SerializedName("description") val description: String?,
  @SerializedName("additional_fields") val additionalFields: AdditionalFields?,
  @SerializedName("transformation_id") val transformationId: String
)

data class AdditionalFields(
  @SerializedName("Key") val key: String?,
  @SerializedName("Casting") val casting: String?,
  @SerializedName("Energy Cost") val energyCost: String?,
  @SerializedName("Special Effect") val specialEffect: String?
)
