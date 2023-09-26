package com.example.flags.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flags.ui.theme.FlagsTheme

@Composable
fun DrawerMenu() {
    Column(
        modifier = Modifier.padding(24.dp),
    )
    {
        Text(text = "Country Flag", style = TextStyle(fontSize = 48.sp))
        Spacer(modifier = Modifier.height(20.dp))
        Divider()
        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Icon(Icons.Default.List, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "European Flags")
        }

        Row {
            Icon(Icons.Default.List, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "South American Flags")
        }

        Row {
            Icon(Icons.Default.Settings, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Settings")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DrawerMenuPreview() {
    FlagsTheme {
        DrawerMenu()
    }
}