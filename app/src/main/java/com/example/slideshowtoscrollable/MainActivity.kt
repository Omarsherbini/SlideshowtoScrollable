package com.example.slideshowtoscrollable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.annotation.DrawableRes

class SlideshowtoScrollable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                ScrollableImageList()
            }
        }
    }
}

data class ImageItem(
    @DrawableRes val imageRes: Int,
    val description: String
)

@Composable
fun ScrollableImageList() {
    val imageList = listOf(
        ImageItem(R.drawable.image1, "cristiano in all times 1"),
        ImageItem(R.drawable.image2, "Best in the world 2"),
        ImageItem(R.drawable.image3, "CR7 IN MANU 3"),
        ImageItem(R.drawable.image4, "CR7 IS THE GOAT 4"),
        ImageItem(R.drawable.image5, "RONALDO JR 5"),
        ImageItem(R.drawable.image1, "Another Cristiano 6"),
        ImageItem(R.drawable.image2, "Another Best 7"),
        ImageItem(R.drawable.image3, "Man U Days 8"),
        ImageItem(R.drawable.image4, "Legacy 9"),
        ImageItem(R.drawable.image5, "Next Gen 10")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        Text(
            text = "Ronaldo Gallery",
            color = Color.White,
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(imageList) { item ->
                ImageCard(item)
            }
        }
    }
}

@Composable
fun ImageCard(item: ImageItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .border(2.dp, Color.White)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = item.description,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.description,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
    }
}

