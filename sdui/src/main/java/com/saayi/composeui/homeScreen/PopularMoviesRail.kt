package com.saayi.composeui.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saayi.composeui.common.image.ZooImage

@Composable
fun PopularMoviesRail(
    imageUrls: List<Any>,
    onClick: (position: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = 32.dp)
    ) {
        Text(
            text = "Popular Movies",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        LazyRow {
            items(imageUrls.size) { index ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onClick(index) }
                ) {
                    ZooImage(
                        model = imageUrls[index],
                        contentDescription = "Carousel Image + $index",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(180.dp)
                            .width(130.dp)
                    )
                }
            }
        }
    }
}