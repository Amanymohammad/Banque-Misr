package com.example.banque_misr

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IconItem(
    @DrawableRes IconRes:Int,
             text:List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(100.dp).clickable {}
    ) {
        Box(
            modifier = Modifier.size(75.dp).padding(8.dp), contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = IconRes),
                contentDescription = null,
               tint=Color.Unspecified
            )
        }
        Spacer (modifier = Modifier.height(8.dp))
        text.forEach { line ->
            Text(
                text = line, fontSize = 16.sp, color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }

}
