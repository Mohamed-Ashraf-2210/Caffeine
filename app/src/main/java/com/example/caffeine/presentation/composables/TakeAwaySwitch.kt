package com.example.caffeine.presentation.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Black
import com.example.caffeine.ui.theme.ButtonColor
import com.example.caffeine.ui.theme.ButtonColor2
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.White

@Composable
fun TakeAwaySwitch(
    isTakeAway: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val takeAwayColor by animateColorAsState(
        targetValue = if (isTakeAway) ButtonColor else ButtonColor2
    )

    var target =  if (isTakeAway) {
        Alignment.CenterStart
    } else{
        Alignment.CenterEnd
    } as BiasAlignment
    val alignment by animateFloatAsState(
        targetValue = target.horizontalBias,
    )
    val alignmentIconSwitch by remember {
        derivedStateOf {
            BiasAlignment(
                horizontalBias = alignment,
                verticalBias = 0f
            )
        }
    }
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(takeAwayColor)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp).align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Text(
                text = "OFF",
                color = Black.copy(0.6f),
                fontFamily = UrbanistFamily,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.25.sp,
                fontSize = 10.sp
            )
            Text(
                text = "ON",
                color = White.copy(0.6f),
                fontFamily = UrbanistFamily,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.25.sp,
                fontSize = 10.sp
            )
        }
        Image(
            painter = painterResource(R.drawable.take_away),
            contentDescription = null,
            modifier = Modifier
                .padding(1.dp)
                .size(40.dp)
                .clip(CircleShape)
                .clickable { onClick() }
                .align(alignmentIconSwitch),
            contentScale = ContentScale.Fit
            )
    }
}