package com.example.myapplication1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun AstroAppAllSignTraitsScreen(
    navController: NavHostController,
) {
    var showDialog by remember { mutableStateOf(false) }
    var dialogTitle by remember { mutableStateOf("") }
    var dialogText by remember { mutableStateOf("") }

    fun displayDialog(title: String, text: String) {
        dialogTitle = title
        dialogText = text
        showDialog = true
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) { Text(text = dialogTitle, textAlign = TextAlign.Center) }
            },
            text = {
                Text(text = dialogText, textAlign = TextAlign.Center)
            },
            confirmButton = {
                Button(
                    onClick = { showDialog = false }
                ) {
                    Text("Close")
                }
            }
        )
    }

    AstroAppLook {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Astrological traits for all signs",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 50.dp),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .padding(top = 100.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReusableBoxComponent(
                    title = "Aries",
                    imageRes = R.drawable.ariessign,
                    onClick = { displayDialog("Aries", ElementsDescription.ARIES_TRAITS) }
                )
                ReusableBoxComponent(
                    title = "Taurus",
                    imageRes = R.drawable.taurussign,
                    onClick = { displayDialog("Taurus", ElementsDescription.TAURUS_TRAITS) }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReusableBoxComponent(
                    title = "Gemini",
                    imageRes = R.drawable.geminisign,
                    onClick = { displayDialog("Gemini", ElementsDescription.GEMINI_TRAITS) }
                )
                ReusableBoxComponent(
                    title = "Cancer",
                    imageRes = R.drawable.cancersign,
                    onClick = { displayDialog("Cancer", ElementsDescription.CANCER_TRAITS) }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReusableBoxComponent(
                    title = "Leo",
                    imageRes = R.drawable.leosign,
                    onClick = { displayDialog("Leo", ElementsDescription.LEO_TRAITS) }
                )
                ReusableBoxComponent(
                    title = "Virgo",
                    imageRes = R.drawable.virgosign,
                    onClick = { displayDialog("Virgo", ElementsDescription.VIRGO_TRAITS) }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReusableBoxComponent(
                    title = "Libra",
                    imageRes = R.drawable.librasign,
                    onClick = { displayDialog("Libra", ElementsDescription.LIBRA_TRAITS) }
                )
                ReusableBoxComponent(
                    title = "Scorpio",
                    imageRes = R.drawable.scorpiosign,
                    onClick = { displayDialog("Scorpio", ElementsDescription.SCORPIO_TRAITS) }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReusableBoxComponent(
                    title = "Sagittarius",
                    imageRes = R.drawable.sagittatariussign,
                    onClick = {
                        displayDialog(
                            "Sagittarius",
                            ElementsDescription.SAGITTARIUS_TRAITS
                        )
                    }
                )
                ReusableBoxComponent(
                    title = "Capricorn",
                    imageRes = R.drawable.capricornsign,
                    onClick = { displayDialog("Capricorn", ElementsDescription.CAPRICORN_TRAITS) }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReusableBoxComponent(
                    title = "Aquarius",
                    imageRes = R.drawable.aquariussign,
                    onClick = { displayDialog("Aquarius", ElementsDescription.AQUARIUS_TRAITS) }
                )
                ReusableBoxComponent(
                    title = "Pisces",
                    imageRes = R.drawable.piscessign,
                    onClick = { displayDialog("Pisces", ElementsDescription.PISCES_TRAITS) }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                ) {
                    Text("Back")
                }
            }

        }
    }
}
