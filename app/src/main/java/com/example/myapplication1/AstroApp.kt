package com.example.myapplication1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication1.ui.theme.AstroViewModel

enum class AstroScreen() {
    Start,
    Result,
    Horoscope,
    Match,
    Sun,
    Rising,
    Traits
}

@Composable
fun AstroAppLook(content: @Composable () -> Unit) {
    val logoImage: Painter = painterResource(id = R.drawable.pngtree_astrology)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.hsl(210f, 0.6f, 0.9f),
                        Color.hsl(280f, 0.4f, 0.8f),
                        Color.hsl(170f, 0.5f, 0.8f)
                    )
                ),
                shape = MaterialTheme.shapes.medium
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Astro-Facts",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 5.dp),
            )
        }
        Image(
            painter = logoImage,
            contentDescription = "logoicon",
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-100).dp)
                .graphicsLayer(alpha = 0.5f)
        )
        content()
    }
}

@Composable
fun AstroApp(
    navController: NavHostController = rememberNavController(),
    astroViewModel: AstroViewModel = viewModel(),
    modifier: Modifier = Modifier,
) {
    val astroUiState by astroViewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = AstroScreen.Start.name,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = AstroScreen.Start.name) {
            AstroAppStarter(
                currFirstName = astroUiState.currentName,
                currLastName = astroUiState.currentSurname,
                currRisingSign = astroUiState.currentRisingSign,
                currSunSign = astroUiState.currentSunSign,
                onFirstNameChange = { astroViewModel.updateName(it) },
                onLastNameChange = { astroViewModel.updateSurname(it) },
                onSunSignChange = { astroViewModel.updateSunSign(it) },
                onRisingSignChange = { astroViewModel.updateRisingSign(it) },
                onNextButtonClicked = { sun, rising ->
                    astroViewModel.determineTraits(sun, rising)
                    navController.navigate(AstroScreen.Result.name)
                },
                onClick = {
                    navController.navigate(AstroScreen.Traits.name)
                }
            )
        }
        composable(route = AstroScreen.Result.name) {
            AstroResultsScreen(
                sunSign = astroUiState.currentSunSign,
                risingSign = astroUiState.currentRisingSign,
                description = astroUiState.currentDescription,
                onHoroscopeButtonClicked = { sun ->
                    astroViewModel.determineHoroscope(sun)
                    navController.navigate(AstroScreen.Horoscope.name)
                },
                onMatchesButtonClicked = { rising ->
                    astroViewModel.determineBestMatchDescription(rising)
                    navController.navigate(AstroScreen.Match.name)
                },
                onSunSignButtonClicked = {
                    navController.navigate(AstroScreen.Sun.name)
                },
                onRisingSignButtonClicked = {
                    navController.navigate(AstroScreen.Rising.name)
                },
                navController = navController
            )
        }
        composable(route = AstroScreen.Horoscope.name) {
            AstroAppReusableScreen(
                title = "Your yearly horoscope of 2024",
                description = astroUiState.currentHoroscope,
                imageLocation = R.drawable.pngtree_astrology,
                navController = navController
            )
        }
        composable(route = AstroScreen.Match.name) {
            AstroAppReusableScreen(
                title = "Traits of a sign that would be a good match for you",
                description = astroUiState.currentBestMatch,
                imageLocation = R.drawable.purple_heart_svgrepo_com,
                navController = navController
            )
        }
        composable(route = AstroScreen.Sun.name) {
            AstroAppReusableScreen(
                title = "What does the Sun sign represent in Astrology",
                description = ElementsDescription.SUN_SIGN_MEANING,
                imageLocation = R.drawable.sun_icon,
                navController = navController
            )
        }
        composable(route = AstroScreen.Rising.name) {
            AstroAppReusableScreen(
                title = "What does the Rising sign represent in Astrology",
                description = ElementsDescription.RISING_SIGN_MEANING,
                imageLocation = R.drawable.rising,
                navController = navController
            )
        }
        composable(route = AstroScreen.Traits.name) {
            AstroAppAllSignTraitsScreen(
                navController = navController
            )
        }
    }
}