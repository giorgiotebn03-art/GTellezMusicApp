package com.example.gtellezmusicapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.gtellezmusicapp.Services.AlbumService
import com.example.gtellezmusicapp.components.AlbumCard
import com.example.gtellezmusicapp.components.MusicCard
import com.example.gtellezmusicapp.components.PlayCard
import com.example.gtellezmusicapp.components.TrackCard
import com.example.gtellezmusicapp.models.Album
import com.example.gtellezmusicapp.ui.theme.HomeRoute
import com.example.gtellezmusicapp.ui.theme.Main
import com.example.gtellezmusicapp.ui.theme.MainLight
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun DetailScreen(
    id : String,
    navController: NavController
) {

    var albums by remember {
        mutableStateOf(listOf<Album?>())
    }

    LaunchedEffect(true) {
        try {
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://music.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            val result = async(Dispatchers.IO) {
                service.getAllAlbums()
            }
            albums = result.await()
            Log.i("HomeScreen", "${result.await()}")
        } catch (e: Exception) {
            Log.e("HomeScreen", e.toString())
        }
    }


    if (albums == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black,
                            Color.Black,
                            Color.Black,
                            Main
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
                .padding(15.dp)
                .padding(top = 20.dp)
        ) {
            val album = albums.find { it?.id == id }
            album?.let {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(22.dp))
                        .background(Main)
                        .fillMaxWidth()
                        .height(300.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = it.image,
                        contentDescription = it.title,
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    Row(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                        ){
                            Button(
                                onClick = {
                                    navController.navigate(HomeRoute)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Regresar",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(40.dp)
                                )
                            }
                        }
                        
                        Button(
                            onClick = {
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                        ) {
                            Icon(
                                imageVector = Icons.Filled.FavoriteBorder,
                                contentDescription = "Regresar",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }

                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(20.dp)
                    ) {
                        Text(
                            text = it.title,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                        Text(
                            text = it.artist,
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                        Row(
                            modifier = Modifier
                                .padding(top = 10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(end = 10.dp)
                                    .clip(RoundedCornerShape(30.dp))
                                    .background(Color.Black)
                                    .size(50.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.PlayArrow,
                                    contentDescription = "Opciones",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(40.dp)

                                )
                            }
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(30.dp))
                                    .background(Color.White)
                                    .size(50.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.PlayArrow,
                                    contentDescription = "Opciones",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(40.dp)

                                )
                            }
                        }
                    }
                }
                Column {
                    Box(
                        modifier = Modifier
                            .padding(top = 25.dp)
                    ) {
                        Column {
                            Column(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .shadow(elevation = 10.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .fillMaxWidth()
                                    .background(Color.White)
                                    .padding(15.dp)
                            ) {
                                Text(
                                    text = "About this album",
                                    color = Main,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(5.dp)
                                )
                                Text(
                                    text = it.description,
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(5.dp)
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .shadow(elevation = 10.dp)
                                    .clip(RoundedCornerShape(18.dp))
                                    .background(Color.White)
                                    .padding(10.dp)
                            ) {
                                Row {
                                    Text(
                                        text = "Artist: ",
                                        color = Main,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,
                                        modifier = Modifier
                                            .padding(5.dp)
                                    )
                                    Text(
                                        text = it.artist,
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        modifier = Modifier
                                            .padding(vertical = 5.dp)
                                            .padding(end = 5.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .height(400.dp)
                        .fillMaxWidth()
                ) {
                    items(10) { index ->
                        TrackCard(
                            album = it,
                            num = index + 1
                        )
                    }
                }
}

            }
            Box(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                PlayCard()
            }
        }
    }
}
@Preview
@Composable
fun DetailScreenPreview(){
    DetailScreen(
        "1",
        rememberNavController()
    )
}