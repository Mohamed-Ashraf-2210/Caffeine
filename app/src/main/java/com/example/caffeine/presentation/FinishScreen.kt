package com.example.caffeine.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.composables.ContinueButton
import com.example.caffeine.ui.theme.ButtonColor
import com.example.caffeine.ui.theme.MineShaft
import com.example.caffeine.ui.theme.SingletonFamily
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.WildSand

@Composable
fun FinishScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
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
                .align(Alignment.Start)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 24.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.coffee_beans),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = ButtonColor
            )

            Text(
                text = "More Espresso, Less Depresso",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = ButtonColor,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 6.dp),
                fontFamily = SingletonFamily,
            )
            Icon(
                painter = painterResource(R.drawable.coffee_beans),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = ButtonColor
            )
        }

        Image(
            modifier = Modifier.size(300.dp),
            painter = painterResource(R.drawable.cupcake),
            contentDescription = null,
        )
        Row(
            modifier = Modifier.padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Bon appétit",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = UrbanistFamily,
                color = MineShaft.copy(.8f)
            )
            Icon(
                painter = painterResource(R.drawable.magic_wand),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint =  MineShaft.copy(.8f)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        ContinueButton(
            title = "Thank youuu",
            icon = painterResource(id = R.drawable.arrow_right),
            Modifier
                .padding(bottom = 50.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            navController.popBackStack(
                route = Screen.WelcomeOne.route,
                inclusive = false
            )
        }
    }
}