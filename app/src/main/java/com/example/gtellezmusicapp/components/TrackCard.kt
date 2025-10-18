package com.example.gtellezmusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.gtellezmusicapp.models.Album
import com.example.gtellezmusicapp.ui.theme.Main

@Composable
fun TrackCard(album: Album, num: Int) {
    Box(
        modifier = Modifier
            .padding(top = 15.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(Main.copy(alpha = 0.40f))
        ) {
            Box(
                modifier = Modifier
                    .padding(2.dp) // más padding = más difuminado visual
                    .shadow(5.dp, RoundedCornerShape(12.dp))
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Black)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.size(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = album.image,
                            contentDescription = album.title,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(14.dp)
                    ) {
                        Text(
                            text = "${album.title} - Track ${num}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            maxLines = 1, // 🔹 solo una línea
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                        Text(
                            text = album.artist,
                            color = Color.Gray,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                    Box(
                        modifier = Modifier,
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Opciones",
                            tint = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier
                                .size(35.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TrackCardPreview(){
    TrackCard (
        album =
            Album(
                title = "The wonder of you",
                artist = "Elvis",
                description = "La mejor cancion de Elvis",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRiNTwYwJf1FdI_0lizxyrsC0JGgQ72Dce4xw&s",
                id = "1"
            ),
        num = 1
    )
}