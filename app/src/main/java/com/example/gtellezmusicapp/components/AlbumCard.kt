package com.example.gtellezmusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
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
import com.example.gtellezmusicapp.models.Album
import com.example.gtellezmusicapp.ui.theme.Main

@Composable
fun AlbumCard(album: Album, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 20.dp, bottom = 20.dp, end = 15.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(34.dp))
                .background(Main.copy(alpha = 0.40f)) // halo muy suave
        ) {
            Box(
                modifier = Modifier
                    .padding(2.dp) // más padding = más difuminado visual
                    .shadow(5.dp, RoundedCornerShape(12.dp))
                    .clip(RoundedCornerShape(34.dp))
                    .background(Color.Black)
            ) {
                Box(
                    modifier = Modifier
                        .shadow(elevation = 5.dp)
                        .clip(RoundedCornerShape(34.dp))
                        .background(Main)
                        .size(300.dp, 250.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = album.image,
                        contentDescription = album.title,
                        modifier = Modifier
                            .clip(RoundedCornerShape(34.dp))
                            .size(300.dp, 250.dp),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 15.dp)
                            .clip(RoundedCornerShape(22.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .background(Color.Black.copy(alpha = 0.6f))
                                .size(250.dp, 100.dp)
                                .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                Text(
                                    text = album.title,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(5.dp)
                                )
                                Text(
                                    text = album.artist,
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    modifier = Modifier
                                        .padding(5.dp)
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
                                    contentDescription = "Play",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(40.dp)

                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AlbumCardPreview(){
    AlbumCard(
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