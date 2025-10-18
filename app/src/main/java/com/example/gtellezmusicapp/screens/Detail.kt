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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.gtellezmusicapp.components.AlbumCard
import com.example.gtellezmusicapp.components.MusicCard
import com.example.gtellezmusicapp.components.PlayCard
import com.example.gtellezmusicapp.components.TrackCard
import com.example.gtellezmusicapp.models.Album
import com.example.gtellezmusicapp.ui.theme.Main
import com.example.gtellezmusicapp.ui.theme.MainLight

@Composable
fun DetailScreen(album: Album, onClick: () -> Unit){
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
                    .background(Main)
                    .fillMaxWidth()
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ){
                AsyncImage(
                    model = album.image,
                    contentDescription = album.title,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )

                Row (
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(start = 15.dp, end = 15.dp, top = 20.dp)
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
                    Text(text = album.title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .padding(5.dp))
                    Text(text = album.artist,
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
            Column {
                Box(modifier = Modifier
                    .padding(top = 25.dp)
                ){
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
                            Text(text = "About this album",
                                color = Main,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(5.dp))
                            Text(text = album.description,
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
                        ){
                            Row {
                                Text(text = "Artist: ",
                                    color = Main,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(5.dp))
                                Text(text = album.artist,
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
                        album = album,
                        num = index + 1
                    )
                }
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
    DetailScreen(
        album =
            Album(
                title = "The wonder of you",
                artist = "Elvis",
                description = "La mejor cancion de Elvis",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRiNTwYwJf1FdI_0lizxyrsC0JGgQ72Dce4xw&s",
                id = "1"
            ),
        onClick = {}
    )
}