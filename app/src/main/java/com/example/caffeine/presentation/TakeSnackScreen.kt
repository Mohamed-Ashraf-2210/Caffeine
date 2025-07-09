package com.example.caffeine.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.Snack
import com.example.caffeine.navigation.Screen
import com.example.caffeine.ui.theme.MineShaft87
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.WildSand

@Composable
fun TakeSnackScreen(navController: NavController) {
    val items = listOf(
        Snack("1", "Croissant", R.drawable.croissant),
        Snack("2", "Chocolate", R.drawable.chocolate),
        Snack("3", "Cupcake", R.drawable.cupcake),
        Snack("4", "Cookies", R.drawable.cookies),
        Snack("5", "Cinnamon_roll", R.drawable.cinnamon_roll),
        Snack("6", "Oreo", R.drawable.oreo)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.cancel),
            contentDescription = "Cancel",
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(WildSand)
                .padding(12.dp)
        )

        Text(
            text = "Take your snack",
            fontFamily = UrbanistFamily,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.25.sp,
            color = MineShaft87,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp)
        )


        val lazyColumnState = rememberLazyListState()

        LazyColumn(
            state = lazyColumnState,
            modifier = Modifier.height(600.dp),
            contentPadding = PaddingValues(top = 30.dp, bottom = 30.dp),
        ) {
            items(items.size) {
                SnackCard(
                    snack = items[it],
                    onClick = {
                        navController.navigate(Screen.Finish.route + "/${items[it].name}")
                    }
                )
            }
        }
    }
}

@Composable
fun SnackCard(
    snack: Snack,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(id = snack.imageResId),
        contentDescription = snack.name,
        modifier = Modifier
            .size(260.dp,274.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(WildSand)
            .padding(vertical = 63.dp, horizontal = 58.dp)
            .clickable(onClick = onClick)
    )
}

