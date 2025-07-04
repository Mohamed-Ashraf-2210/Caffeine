package com.example.caffeine.presentation.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.CaffeineTheme
import com.example.caffeine.ui.theme.MineShaft
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.White87

@Composable
fun ContinueButton(
    title: String,
    icon: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MineShaft,
            contentColor = White87
        ),
        contentPadding = PaddingValues(vertical = 18.5.dp, horizontal = 32.dp),
        modifier = modifier
    ) {
        Text(
            text = title,
            fontFamily = UrbanistFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = White87,
            textAlign = TextAlign.Center,
        )
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 8.dp)
                .size(24.dp),
            tint = White87
        )
    }
}