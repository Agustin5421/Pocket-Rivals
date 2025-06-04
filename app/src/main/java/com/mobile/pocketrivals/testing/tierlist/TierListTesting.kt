package com.mobile.pocketrivals.testing.tierlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharacterListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CharacterListScreen()
                }
            }
        }
    }
}

// Data model for Character
data class Character(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val roleImageUrl: String,
    val winRate: Float,
    val pickRate: Float,
    val banRate: Float
)

// ViewModel to handle data loading and state
class CharacterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<CharacterListUiState>(CharacterListUiState.Loading)
    val uiState: StateFlow<CharacterListUiState> = _uiState.asStateFlow()

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            // Simulate network delay
            delay(1500)

            // Sample data
            val characters = listOf(
                Character(
                    id = 1,
                    name = "Ahri",
                    imageUrl = "https://dummyimage.com/200x200/000/fff&text=Ahri",
                    roleImageUrl = "https://dummyimage.com/50x50/00f/fff&text=M",
                    winRate = 51.2f,
                    pickRate = 12.5f,
                    banRate = 8.7f
                ),
                Character(
                    id = 2,
                    name = "Darius",
                    imageUrl = "https://dummyimage.com/200x200/000/fff&text=Darius",
                    roleImageUrl = "https://dummyimage.com/50x50/f00/fff&text=T",
                    winRate = 49.8f,
                    pickRate = 9.3f,
                    banRate = 15.2f
                ),
                Character(
                    id = 3,
                    name = "Lux",
                    imageUrl = "https://dummyimage.com/200x200/000/fff&text=Lux",
                    roleImageUrl = "https://dummyimage.com/50x50/0f0/fff&text=S",
                    winRate = 52.4f,
                    pickRate = 14.7f,
                    banRate = 5.3f
                ),
                Character(
                    id = 4,
                    name = "Yasuo",
                    imageUrl = "https://dummyimage.com/200x200/000/fff&text=Yasuo",
                    roleImageUrl = "https://dummyimage.com/50x50/f00/fff&text=T",
                    winRate = 48.6f,
                    pickRate = 18.9f,
                    banRate = 22.1f
                ),
                Character(
                    id = 5,
                    name = "Jinx",
                    imageUrl = "https://dummyimage.com/200x200/000/fff&text=Jinx",
                    roleImageUrl = "https://dummyimage.com/50x50/ff0/fff&text=A",
                    winRate = 50.9f,
                    pickRate = 15.2f,
                    banRate = 7.8f
                ),
                Character(
                    id = 6,
                    name = "Thresh",
                    imageUrl = "https://dummyimage.com/200x200/000/fff&text=Thresh",
                    roleImageUrl = "https://dummyimage.com/50x50/0ff/fff&text=S",
                    winRate = 51.7f,
                    pickRate = 13.4f,
                    banRate = 6.2f
                ),
                Character(
                    id = 7,
                    name = "Lee Sin",
                    imageUrl = "https://dummyimage.com/200x200/000/fff&text=Lee+Sin",
                    roleImageUrl = "https://dummyimage.com/50x50/00f/fff&text=J",
                    winRate = 47.9f,
                    pickRate = 16.8f,
                    banRate = 9.5f
                ),
                Character(
                    id = 8,
                    name = "Garen",
                    imageUrl = "https://dummyimage.com/200x200/000/fff&text=Garen",
                    roleImageUrl = "https://dummyimage.com/50x50/f00/fff&text=T",
                    winRate = 53.1f,
                    pickRate = 8.2f,
                    banRate = 3.4f
                ),
                Character(
                    id = 9,
                    name = "Zed",
                    imageUrl = "https://dummyimage.com/200x200/000/fff&text=Zed",
                    roleImageUrl = "https://dummyimage.com/50x50/00f/fff&text=M",
                    winRate = 49.2f,
                    pickRate = 17.3f,
                    banRate = 19.8f
                ),
                Character(
                    id = 10,
                    name = "Morgana",
                    imageUrl = "https://dummyimage.com/200x200/000/fff&text=Morgana",
                    roleImageUrl = "https://dummyimage.com/50x50/0ff/fff&text=S",
                    winRate = 52.8f,
                    pickRate = 11.6f,
                    banRate = 12.3f
                )
            )

            _uiState.value = CharacterListUiState.Success(characters)
        }
    }
}

// UI state for the character list
sealed class CharacterListUiState {
    object Loading : CharacterListUiState()
    data class Success(val characters: List<Character>) : CharacterListUiState()
    data class Error(val message: String) : CharacterListUiState()
}

@Composable
fun CharacterListScreen(viewModel: CharacterViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Character Stats",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        when (val state = uiState) {
            is CharacterListUiState.Loading -> {
                LoadingState()
            }
            is CharacterListUiState.Success -> {
                CharacterList(characters = state.characters)
            }
            is CharacterListUiState.Error -> {
                ErrorState(message = state.message)
            }
        }
    }
}

@Composable
fun LoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(48.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Loading characters...",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun ErrorState(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Error: $message",
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CharacterList(characters: List<Character>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = characters,
            key = { it.id }
        ) { character ->
            CharacterCard(character = character)
        }
    }
}

@Composable
fun CharacterCard(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            ) {
                // Character image with lazy loading
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(character.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = character.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val state = painter.state
                    if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.surfaceVariant),
                            contentAlignment = Alignment.Center
                        ) {
                            if (state is AsyncImagePainter.State.Loading) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(24.dp),
                                    strokeWidth = 2.dp
                                )
                            } else {
                                Text(
                                    text = character.name.first().toString(),
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }
                        }
                    } else {
                        SubcomposeAsyncImageContent()
                    }
                }

                // Role indicator
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.BottomEnd)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(2.dp)
                ) {
                    SubcomposeAsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(character.roleImageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Role",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                    ) {
                        val state = painter.state
                        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colorScheme.surfaceVariant)
                            )
                        } else {
                            SubcomposeAsyncImageContent()
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    StatItem(
                        label = "Win Rate",
                        value = "${character.winRate}%",
                        color = if (character.winRate > 50) Color(0xFF4CAF50) else Color(0xFFF44336)
                    )
                    StatItem(
                        label = "Pick Rate",
                        value = "${character.pickRate}%",
                        color = Color(0xFF2196F3)
                    )
                    StatItem(
                        label = "Ban Rate",
                        value = "${character.banRate}%",
                        color = Color(0xFF9C27B0)
                    )
                }
            }
        }
    }
}

@Composable
fun StatItem(label: String, value: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 12.sp
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = color,
            fontSize = 14.sp
        )
    }
}

@Composable
fun CharacterListTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = darkColorScheme(),
        typography = Typography(),
        content = content
    )
}

@Preview
@Composable
fun CharacterListPreview() {
    CharacterListTheme {
        CharacterListScreen(viewModel = CharacterViewModel())
    }
}