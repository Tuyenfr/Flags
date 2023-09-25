package com.example.flags.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.flags.ui.theme.FlagsTheme


@Composable
fun CountryItem(
    countryName: String,
    countryCode: String,
    countryDescription : String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
) {
    var shouldExpand by rememberSaveable { mutableStateOf(true) }

    Surface(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {

        Column {
            Row {
                Image(
                    painter = painterResource(
                        id = LocalContext.current.resources.getIdentifier(
                            countryCode,
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
                        text = countryName,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                    Text(text = countryCode.uppercase())
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
                    Text(
                        style = TextStyle(textAlign = TextAlign.Justify),
                        text = countryDescription
                    )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CountryItemPreview() {
    CountryItem("France", "fra")
}