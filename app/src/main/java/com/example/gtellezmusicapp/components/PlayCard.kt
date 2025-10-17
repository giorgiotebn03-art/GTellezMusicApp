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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlayCard(){
    Row (
        modifier = Modifier
            .padding(5.dp)
            .shadow(elevation = 10.dp)
            .clip(RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .background(Color.Cyan)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box (
            modifier = Modifier
                .size(60.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "Opciones",
                tint = Color.Black,
                modifier = Modifier
                    .size(35.dp)
            )
        }
        Column (
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
        ){
            Text(text = "Titulo del album",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(5.dp))
            Text(text = "Autor",
                color = Color.Gray,
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
                contentDescription = "Opciones",
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