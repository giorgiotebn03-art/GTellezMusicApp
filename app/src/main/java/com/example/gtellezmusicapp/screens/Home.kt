package com.example.gtellezmusicapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gtellezmusicapp.components.AlbumCard
import com.example.gtellezmusicapp.components.MusicCard
import com.example.gtellezmusicapp.components.PlayCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(15.dp)
            .padding(top = 20.dp)
    ){
        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ){
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(22.dp))
                    .background(Color.Cyan)
                    .padding(20.dp)
                    .padding(bottom = 10.dp)
            ){
                Row (){
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ){
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Menu",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }

                }
                Text(text = "Good Morning!",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(top = 25.dp, bottom = 5.dp))
                Text(text = "Giorgio Tellez",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    modifier = Modifier
                        .padding( bottom = 5.dp))
            }

            Column (
                modifier = Modifier
                    .padding(top = 30.dp)
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = "Albums",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Text(text = "See more",
                        color = Color.Cyan,
                        fontSize = 20.sp,
                        modifier = Modifier
                    )
                }

                Row (
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                ){
                    AlbumCard()
                    AlbumCard()
                    AlbumCard()
                    AlbumCard()
                }
            }
            Column(
            ) {
                Row {
                    Text(text = "Recently Played",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Text(text = "See more",
                        color = Color.Cyan,
                        fontSize = 20.sp,
                        modifier = Modifier
                    )
                }
                MusicCard()
                MusicCard()
                MusicCard()
                MusicCard()
                MusicCard()
            }
        }
        Box(
            modifier = Modifier.align(Alignment.BottomCenter)
        ){
            PlayCard()
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}