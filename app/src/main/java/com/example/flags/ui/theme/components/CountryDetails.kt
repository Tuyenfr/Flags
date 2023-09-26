package com.example.flags.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.flags.models.Country
import com.google.gson.Gson

@Composable
fun CountryDetails(
    encodedCountry: String
) {
    val country = decodedCountry(encodedCountry)
    Column {
        Image(painter = painterResource(
            id = LocalContext.current.resources.getIdentifier(
                country.countryCode,
                "drawable",
                LocalContext.current.packageName
                )
            ),
            contentDescription = null)
        Text(text = country.countryName, style = TextStyle(fontSize = 48.sp))
        Text(text = country.countryDescription)
                
    }
}

private fun decodedCountry(encodedCountry: String): Country {
    return Gson().fromJson(encodedCountry, Country::class.java)
}

@Preview(showBackground = true)
@Composable
fun CountryDetailsPreview() {
    CountryDetails(encodedCountry = "")
}