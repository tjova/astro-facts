package com.example.myapplication1

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//pomocna funkcija za validaciju - da li je input jedan od astroloskih znakova
fun isValidSunSign(input: String): Boolean {
    return AstrologicalSigns.values().any { it.name.equals(input, ignoreCase = true) }
}
@Composable
fun AstroAppStarter(
    currFirstName: String,
    currLastName: String,
    currRisingSign: String,
    currSunSign: String,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onSunSignChange: (String) -> Unit,
    onRisingSignChange: (String) -> Unit,
    onNextButtonClicked: (String, String) -> Unit,
    onClick: () -> Unit,
) {
    AstroAppLook {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .padding(24.dp)
                .padding(top = 100.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .verticalScroll(rememberScrollState())
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Please fill in your name information and then your Sun and Rising sign below",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = currFirstName,
                onValueChange = onFirstNameChange,
                label = { Text("First name") },
                placeholder = { Text("e.g., John") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = currLastName,
                onValueChange = onLastNameChange,
                label = { Text("Last name") },
                placeholder = { Text("e.g., Doe") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = currSunSign,
                onValueChange = onSunSignChange,
                label = { Text("Sun Sign") },
                placeholder = { Text("e.g., Aries") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = currRisingSign,
                onValueChange = onRisingSignChange,
                label = { Text("Rising Sign") },
                placeholder = { Text("e.g., Libra") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .clickable {
                        onClick()
                    }
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = MaterialTheme.shapes.medium
                    )
            ) {
                Text(
                    text = "Want to know about traits of all astrological signs? Click me!",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Blue
                )
            }
            Button(
                onClick = {
                    //validacija - da li su sva polja popunjena i ako jesu, da li su znak i podznak
                    //pravilno uneseni
                    if (currFirstName.isNotBlank() && currLastName.isNotBlank() && currSunSign.isNotBlank() && currRisingSign.isNotBlank()) {
                        if (isValidSunSign(currSunSign) && isValidSunSign(currRisingSign)) {
                            onNextButtonClicked(currSunSign, currRisingSign)
                        } else {
                            Toast.makeText(
                                context,
                                "Please enter a valid Astrological Element (First letter should be uppercase)",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(context, "Please fill in all fields.", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Submit", color = Color.White)
            }
        }
    }
}



