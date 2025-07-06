package com.example.caffeine.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.composables.ContinueButton
import com.example.caffeine.presentation.composables.CupSection
import com.example.caffeine.ui.theme.ButtonColor
import com.example.caffeine.ui.theme.MineShaft
import com.example.caffeine.ui.theme.MineShaft60
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.White87
import com.example.caffeine.ui.theme.WildSand

@Composable
fun HomeScreen(navController: NavController, typeOfCoffee: String?) {
    var barVisibility by remember { mutableStateOf(true) }
    var size by remember { mutableStateOf("M") }
    var coffeePercentage by remember { mutableStateOf("Low") }
    var putSmallCoffee by remember { mutableStateOf(false) }
    var putMediumCoffee by remember { mutableStateOf(false) }
    var putLargeCoffee by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val sizeOfCoffeeSmall = animateDpAsState(
            targetValue = if (putSmallCoffee) 100.dp else 200.dp,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
        val offsetCoffeeSmall = animateDpAsState(
            targetValue = if (putSmallCoffee) 20.dp else -(320).dp,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
        val alphaCoffeeSmall = animateFloatAsState(
            targetValue = if (putSmallCoffee) 0f else 1f,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
        val sizeOfCoffeeMedium = animateDpAsState(
            targetValue = if (putMediumCoffee) 100.dp else 200.dp,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
        val offsetCoffeeMedium = animateDpAsState(
            targetValue = if (putMediumCoffee) 20.dp else -(320).dp,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
        val alphaCoffeeMedium = animateFloatAsState(
            targetValue = if (putMediumCoffee) 0f else 1f,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
        val sizeOfCoffeeLarge = animateDpAsState(
            targetValue = if (putLargeCoffee) 100.dp else 200.dp,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
        val offsetCoffeeLarge = animateDpAsState(
            targetValue = if (putLargeCoffee) 20.dp else -(320).dp,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
        val alphaCoffeeLarge = animateFloatAsState(
            targetValue = if (putLargeCoffee) 0f else 1f,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )

        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.some_coffee),
                contentDescription = null,
                modifier = Modifier
                    .size(sizeOfCoffeeSmall.value)
                    .offset(y = offsetCoffeeSmall.value)
                    .alpha(alphaCoffeeSmall.value),
            )
            Image(
                painter = painterResource(id = R.drawable.some_coffee),
                contentDescription = null,
                modifier = Modifier
                    .size(sizeOfCoffeeMedium.value)
                    .offset(y = offsetCoffeeMedium.value)
                    .alpha(alphaCoffeeMedium.value),
            )
            Image(
                painter = painterResource(id = R.drawable.some_coffee),
                contentDescription = null,
                modifier = Modifier
                    .size(sizeOfCoffeeLarge.value)
                    .offset(y = offsetCoffeeLarge.value)
                    .alpha(alphaCoffeeLarge.value),
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AnimatedVisibility(visible = barVisibility) {
                    AppBar(
                        title = typeOfCoffee ?: "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    )
                }
                CupSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(341.dp),
                    size = size
                )
            }
        }

        Row(
            Modifier
                .clip(CircleShape)
                .background(WildSand)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            SelectedButton(
                modifier = Modifier.size(40.dp),
                title = "S",
                isSelected = size == "S",
            ) {
                size = "S"
            }
            SelectedButton(
                modifier = Modifier.size(40.dp),
                title = "M",
                isSelected = size == "M",
            ) {
                size = "M"
            }
            SelectedButton(
                modifier = Modifier.size(40.dp),
                title = "L",
                isSelected = size == "L",
            ) {
                size = "L"
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(
                Modifier
                    .padding(top = 16.dp)
                    .clip(CircleShape)
                    .background(WildSand)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                SelectedButton(
                    modifier = Modifier.size(40.dp),
                    icon = painterResource(R.drawable.coffee_beans),
                    isSelected = coffeePercentage == "Low",
                ) {
                    coffeePercentage = "Low"
                    putSmallCoffee = !putSmallCoffee
                }
                SelectedButton(
                    modifier = Modifier.size(40.dp),
                    icon = painterResource(R.drawable.coffee_beans),
                    isSelected = coffeePercentage == "Medium",
                ) {
                    coffeePercentage = "Medium"
                    putMediumCoffee = !putMediumCoffee
                }
                SelectedButton(
                    modifier = Modifier.size(40.dp),
                    icon = painterResource(R.drawable.coffee_beans),
                    isSelected = coffeePercentage == "High",
                ) {
                    coffeePercentage = "High"
                    putLargeCoffee = !putLargeCoffee
                }
            }
            TextRow()
        }
        Spacer(Modifier.weight(1f))
        AnimatedVisibility(visible = barVisibility) {
            ContinueButton(
                title = "Continue",
                icon = painterResource(id = R.drawable.arrow_right),
                Modifier
                    .padding(bottom = 50.dp, top = 111.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                navController.navigate(Screen.Waiting.route + "/$size") {
                    popUpTo(Screen.Home.route)
                }
            }
        }
    }
}

@Composable
private fun AppBar(title: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.arrow_left),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(WildSand)
                .padding(12.dp)
        )
        Text(
            text = title,
            fontFamily = UrbanistFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = MineShaft.copy(0.87f),
            letterSpacing = 0.25.sp
        )
    }
}


@Composable
private fun SelectedButton(
    modifier: Modifier = Modifier,
    title: String? = null,
    icon: Painter? = null,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) ButtonColor else Color.Transparent,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
    )
    val textColor by animateColorAsState(
        targetValue = if (isSelected) White87 else MineShaft60,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
    )
    val iconColor by animateColorAsState(
        targetValue = if (isSelected) White87 else Color.Transparent,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
    )
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(title != null && icon == null) {
            Text(
                text = title.toString(),
                fontFamily = UrbanistFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }
        AnimatedVisibility(icon != null) {
            Icon(
                painter = icon!!,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = iconColor
            )
        }
    }
}

@Composable
private fun TextRow() {
    Row(
        modifier = Modifier.width(152.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Low",
            fontFamily = UrbanistFamily,
            fontSize = 10.sp,
            letterSpacing = 0.25.sp,
            fontWeight = FontWeight.Medium,
            color = MineShaft60,
        )
        Text(
            text = "Medium",
            fontFamily = UrbanistFamily,
            fontSize = 10.sp,
            letterSpacing = 0.25.sp,
            fontWeight = FontWeight.Medium,
            color = MineShaft60,
        )
        Text(
            text = "High",
            fontFamily = UrbanistFamily,
            fontSize = 10.sp,
            letterSpacing = 0.25.sp,
            fontWeight = FontWeight.Medium,
            color = MineShaft60,
        )
    }
}