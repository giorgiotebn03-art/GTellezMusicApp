package com.example.gtellezmusicapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gtellezmusicapp.Services.AlbumService
import com.example.gtellezmusicapp.components.AlbumCard
import com.example.gtellezmusicapp.components.MusicCard
import com.example.gtellezmusicapp.components.PlayCard
import com.example.gtellezmusicapp.models.Album
import com.example.gtellezmusicapp.ui.theme.DetailRoute
import com.example.gtellezmusicapp.ui.theme.Main
import com.example.gtellezmusicapp.ui.theme.MainLight
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun HomeScreen(
    navController: NavController
){
    var albums by remember {
        mutableStateOf(listOf<Album>())
    }

    var loading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(true) {
        try {
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://music.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            val result = async(Dispatchers.IO){
                service.getAllAlbums()
            }
            Log.i("HomeScreen", "${result.await()}")
            albums = result.await()
            loading = false
        }
        catch (e: Exception){
            loading = false
            Log.e("HomeScreen", e.toString())
        }
    }

    if(loading){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }
    else {
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
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(22.dp))
                        .background(Main)
                        .padding(20.dp)
                        .padding(bottom = 10.dp)
                ) {
                    Row() {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Menu",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }

                    }
                    Text(
                        text = "Good Morning!",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(top = 25.dp, bottom = 5.dp)
                    )
                    Text(
                        text = "Giorgio Tellez",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 35.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(top = 30.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Albums",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Text(
                            text = "See more",
                            color = MainLight,
                            fontSize = 20.sp,
                            modifier = Modifier
                        )
                    }
                    LazyRow(
                    ) {
                        items(albums) { album ->
                            AlbumCard(
                                album = album,
                                onClick = {
                                    navController.navigate(DetailRoute(album.id))
                                })
                        }
                    }
                    Column(
                        modifier = Modifier.padding(bottom = 25.dp)
                    ) {
                        Row {
                            Text(
                                text = "Recently Played",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                modifier = Modifier
                                    .weight(1f)
                            )
                            Text(
                                text = "See more",
                                color = MainLight,
                                fontSize = 20.sp,
                                modifier = Modifier
                            )
                        }
                        LazyColumn(
                            modifier = Modifier
                                .height(400.dp)
                                .fillMaxWidth()
                        ) {
                            items(albums) { album ->
                                MusicCard(
                                    album = album,
                                    onClick = {
                                        navController.navigate(DetailRoute(album.id))

                                    }
                                )
                            }
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {

                PlayCard()
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}