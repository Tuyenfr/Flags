package com.example.flags.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flags.models.Country
import com.example.flags.ui.theme.FlagsTheme
import com.google.gson.Gson


@Composable
fun CountryItem(
    country : Country,
    navHostController: NavHostController
) {
    var shouldExpand by rememberSaveable { mutableStateOf(true) }

    Surface(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {

        Column {
            Row {
                Image(
                    painter = painterResource(
                        id = LocalContext.current.resources.getIdentifier(
                            country.countryCode,
                            "drawable",
                            LocalContext.current.packageName
                        )
                    ),
                    contentDescription = null,
                    modifier = Modifier.width(60.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1.0f)
                ) {
                    Text(
                        text = country.countryName,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                    Text(text = country.countryCode.uppercase())
                }
                OutlinedButton(onClick = {
                    shouldExpand = !shouldExpand
                }) {
                    if(shouldExpand) {
                        Text(text = "Show less")
                    } else {
                        Text(text = "Show more")
                    }
                }
            }
                if(shouldExpand) {
                    Column {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            style = TextStyle(textAlign = TextAlign.Justify),
                            text = country.countryDescription
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                navHostController.navigate("countrydetails/${encodedCountry(country = country)}")
                            }) {
                            Text(text = "DETAILS")
                        }
                    }
                   
            }
        }
    }
}

private fun encodedCountry(country: Country): String {
    return Gson().toJson(country)
}
@Preview(showBackground = true)
@Composable
fun CountryItemPreview() {
    FlagsTheme {
        CountryItem(
            country = Country ("France", "fra"),
            navHostController = rememberNavController())

    }
}