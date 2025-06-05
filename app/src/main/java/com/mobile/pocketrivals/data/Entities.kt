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

// Entities for Player
data class PlayerProfile(
  @SerializedName("uid") val uid: Long,
  @SerializedName("name") val name: String,
  @SerializedName("player") val player: Player,
  @SerializedName("isPrivate") val isPrivate: Boolean,
  @SerializedName("match_history") val matchHistory: List<MatchHistory> = emptyList(),
  @SerializedName("rank_history") val rankHistory: List<RankHistory> = emptyList(),
  @SerializedName("hero_matchups") val heroMatchups: List<HeroMatchup> = emptyList()
)


data class Player(
  @SerializedName("uid") val uid: Long,
  @SerializedName("level") val level: String,
  @SerializedName("name") val name: String,
  @SerializedName("icon") val icon: PlayerIcon,
  @SerializedName("rank") val rank: PlayerRank,
  @SerializedName("team") val team: PlayerTeam,
  @SerializedName("info") val info: PlayerInfo
)


data class MatchHistory(
  @SerializedName("match_id") val matchId: String,
  @SerializedName("date") val date: String,
  @SerializedName("result") val result: String,
  @SerializedName("kills") val kills: Int,
  @SerializedName("deaths") val deaths: Int,
  @SerializedName("assists") val assists: Int
)

data class RankHistory(
  @SerializedName("season") val season: Int,
  @SerializedName("rank") val rank: String,
  @SerializedName("points") val points: Int
)

data class HeroMatchup(
  @SerializedName("hero_id") val heroId: Int,
  @SerializedName("win_rate") val winRate: Float,
  val heroName: String = "",
  val heroImageUrl: String = ""
)

data class PlayerIcon(
  @SerializedName("player_icon_id") val playerIconId: String,
  @SerializedName("player_icon") val playerIcon: String
)

data class PlayerRank(
  @SerializedName("rank") val rank: String,
  @SerializedName("image") val image: String?,
  @SerializedName("color") val color: String?
)

data class PlayerTeam(
  @SerializedName("club_team_id") val clubTeamId: String,
  @SerializedName("club_team_mini_name") val clubTeamMiniName: String,
  @SerializedName("club_team_type") val clubTeamType: String
)

data class PlayerInfo(
  @SerializedName("completed_achievements") val completedAchievements: String,
  @SerializedName("login_os") val loginOs: String,
  @SerializedName("rank_game_season") val rankGameSeason: Map<String, RankGameSeason>
)

data class RankGameSeason(
  @SerializedName("rank_game_id") val rankGameId: Int,
  @SerializedName("level") val level: Int,
  @SerializedName("rank_score") val rankScore: Double,
  @SerializedName("max_level") val maxLevel: Int,
  @SerializedName("max_rank_score") val maxRankScore: Double,
  @SerializedName("update_time") val updateTime: Long,
  @SerializedName("win_count") val winCount: Int,
  @SerializedName("protect_score") val protectScore: Int,
  @SerializedName("diff_score") val diffScore: Double
)

