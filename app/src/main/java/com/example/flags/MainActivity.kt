package com.example.flags

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.flags.ui.theme.FlagsTheme
import com.example.flags.ui.theme.components.CountriesList
import com.example.flags.ui.theme.components.CountryDetails
import com.example.flags.ui.theme.components.DrawerMenu
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val coroutineScope = rememberCoroutineScope()
            val navHostController = rememberNavController()
            FlagsTheme {
                Scaffold(
                     topBar = {
                        TopAppBar(
                            title = { Text(text = "Countries") },
                            navigationIcon = {
                                IconButton(
                                    onClick = {
                                        coroutineScope.launch {
                                            drawerState.open()
                                        }
                                    },
                                ) {
                                    Icon(
                                        Icons.Rounded.Menu,
                                        contentDescription = ""
                                    )
                                }
                            })
                    },
                    content = {
                        PaddingValues(20.dp)
                    }
                )

                    NavHost(
                        navController = navHostController,
                        startDestination = "countriesList"
                    ) {
                        composable("countriesList") { CountriesList(navHostController = navHostController) }
                        composable(
                            "countryDetails/{encodedCountry}",
                            arguments = listOf(navArgument("encodedCountry") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            CountryDetails(
                                encodedCountry = backStackEntry.arguments?.getString(
                                    "encodedCountry"
                                )!!
                            )
                        }
                    }
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        FlagsTheme {
            CountriesList(navHostController = NavHostController(context = LocalContext.current))
        }

    }
