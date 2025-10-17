package com.example.gtellezmusicapp.screens

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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gtellezmusicapp.components.AlbumCard
import com.example.gtellezmusicapp.components.MusicCard
import com.example.gtellezmusicapp.components.PlayCard

@Composable
fun DetailScreen(){
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
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(22.dp))
                    .background(Color.Cyan)
                    .fillMaxWidth()
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "Opciones",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .size(200.dp)
                )

                Row (
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(start = 15.dp,end = 15.dp,top = 20.dp)
                ){
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ){
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White,
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }

                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "Regresar",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
                Column (
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(20.dp)
                ){
                    Text(text = "Titulo del album",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .padding(5.dp))
                    Text(text = "Autor / Pupular Song",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(5.dp))
                    Row (
                        modifier = Modifier
                            .padding(top = 10.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .clip(RoundedCornerShape(30.dp))
                                .background(Color.Black)
                                .size(50.dp),
                            contentAlignment = Alignment.Center
                        ){
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
                        ){
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
            Column(
                modifier = Modifier
                    .padding(top = 25.dp)
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
fun DetailScreenPreview(){
    DetailScreen()
}