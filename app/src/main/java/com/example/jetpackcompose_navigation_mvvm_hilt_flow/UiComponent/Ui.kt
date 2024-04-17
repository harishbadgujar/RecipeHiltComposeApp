package com.example.jetpackcompose_navigation_mvvm_hilt_flow.UiComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import coil.compose.rememberAsyncImagePainter

@Composable
fun TextViewComponent(text: String, fontWeight: FontWeight = FontWeight.Normal, fontSize: TextUnit,color: Color = Color.Black) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color
    )
}

@Composable
fun ImageComponent(recipeImage: String?, imageSizeInDp: Dp, imageRoundedCornerShapeInDp: Dp, crop: ContentScale) {
    Image(
        painter = rememberAsyncImagePainter(recipeImage),
        contentDescription = null,
        modifier = Modifier
            .size(imageSizeInDp)
            .clip(RoundedCornerShape(imageRoundedCornerShapeInDp)),
        contentScale = crop
    )
}

@Composable
fun ViewSpacer(space : Dp){
    Spacer(modifier = Modifier.height(space))
}