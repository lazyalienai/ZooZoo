package com.saayi.composeui.common.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.Companion.DefaultTransform
import coil.compose.AsyncImagePainter.State
import coil.compose.DefaultModelEqualityDelegate
import coil.compose.EqualityDelegate
import com.saayi.composeui.R

@Composable
fun ZooImage(
    model: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    transform: (State) -> State = DefaultTransform,
    onState: ((State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DefaultFilterQuality,
    clipToBounds: Boolean = true,
    modelEqualityDelegate: EqualityDelegate = DefaultModelEqualityDelegate,
) {
    if (model is Int) {
        Image(
            painter = painterResource(model),
            contentDescription = contentDescription,
            modifier = modifier,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
        )

    } else {
        AsyncImage(
            model = model,
            contentDescription = contentDescription,
            modifier = modifier,
            transform = transform,
            onState = onState,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
            filterQuality = filterQuality,
            clipToBounds = clipToBounds,
            modelEqualityDelegate = modelEqualityDelegate
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ZooImagePreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_test_image),
            contentDescription = "Test Image",
            modifier = Modifier,
        )
    }
}