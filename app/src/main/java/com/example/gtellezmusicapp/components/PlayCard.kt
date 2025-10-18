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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.gtellezmusicapp.models.Album
import com.example.gtellezmusicapp.ui.theme.Main

@Composable
fun PlayCard(){
    Row (
        modifier = Modifier
            .padding(5.dp)
            .shadow(elevation = 10.dp)
            .clip(RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .background(Main)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box (
            modifier = Modifier
                .size(60.dp),
            contentAlignment = Alignment.Center
        ){
            AsyncImage(
                model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRiNTwYwJf1FdI_0lizxyrsC0JGgQ72Dce4xw&s",
                contentDescription = "La mejor cancion de Elvis",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Column (
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
        ){
            Text(text = "The wonder of you",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(5.dp))
            Text(text = "Elvis",
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(5.dp))
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(Color.Black)
                .size(50.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)

            )
        }

    }
}

@Preview
@Composable
fun PlayCardPreview(){
    PlayCard()
}