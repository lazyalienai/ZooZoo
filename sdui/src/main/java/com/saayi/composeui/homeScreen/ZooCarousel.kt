package com.saayi.composeui.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saayi.composeui.R
import com.saayi.composeui.common.image.ZooImage

@Composable
fun ZooCarousel(
    imageUrls: List<Any>,
    modifier: Modifier = Modifier,
    onClick: (position: Int) -> Unit
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { imageUrls.size })

    HorizontalPager(
        state = pagerState,
        pageSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(520.dp)
    ) { index ->
        ZooImage(
            model = imageUrls[index],
            contentDescription = "Carousel Image + $index",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick(index) }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ZooCarouselPreview() {
    ZooCarousel(
        imageUrls = listOf(
            R.drawable.ic_test_image,
            R.drawable.ic_test_image,
            R.drawable.ic_test_image,
        ),
        modifier = Modifier
    ) { }
}