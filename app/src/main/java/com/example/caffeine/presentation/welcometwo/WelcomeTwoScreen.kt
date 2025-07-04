package com.example.caffeine.presentation.welcometwo

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.composables.AppBar
import com.example.caffeine.presentation.composables.ContinueButton
import com.example.caffeine.ui.theme.MineShaft
import com.example.caffeine.ui.theme.Nobel
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.textColor

@Composable
fun WelcomeTwoScreen(navController: NavController) {
    var typeOfCup by remember { mutableStateOf("Black") }
    var pagerState = rememberPagerState { 4 }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
            .verticalScroll(state = rememberScrollState()),
    ) {
        AppBar(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        WelcomeTwoText()

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(top = 56.dp)
                .height(298.dp),
            contentPadding = PaddingValues(horizontal = 80.dp),
            reverseLayout = true
        ) { pageIndex ->
            when (pageIndex) {
                0 -> CupItem(
                    image = painterResource(id = R.drawable.takea_black),
                    type = "Black",
                    isSelected = pagerState.currentPage == 0
                )

                1 -> CupItem(
                    image = painterResource(id = R.drawable.takea_latte),
                    type = "Latte",
                    isSelected = pagerState.currentPage == pageIndex
                )

                2 -> CupItem(
                    image = painterResource(id = R.drawable.takea_macchiato),
                    type = "Macchiato",
                    isSelected = pagerState.currentPage == pageIndex
                )

                3 -> CupItem(
                    image = painterResource(id = R.drawable.takea_espresso),
                    type = "Espresso",
                    isSelected = pagerState.currentPage == pageIndex
                )
            }
        }
        Spacer(Modifier.weight(1f))
        ContinueButton(
            title = "Continue",
            icon = painterResource(id = R.drawable.arrow_right),
            Modifier
                .padding(bottom = 50.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            when(pagerState.currentPage){
                0 -> typeOfCup = "Black"
                1 -> typeOfCup = "Latte"
                2 -> typeOfCup = "Macchiato"
                3 -> typeOfCup = "Espresso"
            }
            navController.navigate(Screen.Home.route + "/$typeOfCup") {
                popUpTo(Screen.WelcomeTwo.route)
            }
        }
    }
}

@Composable
private fun WelcomeTwoText() {
    Text(
        text = "Good Morning",
        modifier = Modifier.padding(top = 16.dp, start = 16.dp),
        fontFamily = UrbanistFamily,
        fontSize = 36.sp,
        letterSpacing = 0.25.sp,
        fontWeight = FontWeight.Bold,
        color = Nobel,
        textAlign = TextAlign.Start
    )
    Text(
        text = "Hamsa ☀",
        modifier = Modifier.padding(start = 16.dp),
        fontFamily = UrbanistFamily,
        fontSize = 36.sp,
        letterSpacing = 0.25.sp,
        fontWeight = FontWeight.Bold,
        color = textColor,
        textAlign = TextAlign.Start
    )
    Text(
        text = "What would you like to drink today?",
        modifier = Modifier.padding(top = 4.dp, start = 16.dp),
        fontFamily = UrbanistFamily,
        fontSize = 16.sp,
        letterSpacing = 0.25.sp,
        fontWeight = FontWeight.Bold,
        color = MineShaft.copy(0.8f),
        textAlign = TextAlign.Start
    )
}

@Composable
private fun CupItem(
    image: Painter,
    type: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    Box(modifier = modifier.fillMaxSize()) {
        val sizeLogo by animateDpAsState(
            targetValue = if (isSelected) 66.dp else 40.dp,
            animationSpec = tween(durationMillis = 500)
        )
        val paddingTopLogo by animateDpAsState(
            targetValue = if (isSelected) 116.dp else 169.dp,
            animationSpec = tween(durationMillis = 500)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val paddingTopForCup by animateDpAsState(
                targetValue = if (isSelected) 0.dp else 94.dp,
                animationSpec = tween(durationMillis = 500)
            )
            val paddingHorizontalForCup by animateDpAsState(
                targetValue = if (isSelected) 0.dp else 40.dp,
                animationSpec = tween(durationMillis = 500)
            )
            Box(
                modifier = Modifier
                    .size(width = 199.dp, height = 244.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = paddingTopForCup)
                        .padding(horizontal = paddingHorizontalForCup),
                    contentScale = ContentScale.Fit
                )
            }

            Text(
                text = type,
                modifier = Modifier.padding(top = 16.dp),
                fontFamily = UrbanistFamily,
                fontSize = 32.sp,
                letterSpacing = 0.25.sp,
                fontWeight = FontWeight.Bold,
                color = MineShaft,
                textAlign = TextAlign.Center
            )
        }
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .padding(top = paddingTopLogo)
                .size(sizeLogo)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Fit
        )
    }
}