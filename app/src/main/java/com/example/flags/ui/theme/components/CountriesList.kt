package com.example.flags.ui.theme.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.flags.models.Country

@Composable
fun CountriesList(
    navHostController: NavHostController
) {

    LazyColumn {
        item { CountryItem(country = Country(countryName = "Austria", countryCode= "aut"), navHostController = navHostController) }
        item { CountryItem(country = Country(countryName = "Belgium", countryCode = "bel"), navHostController = navHostController) }
        item { CountryItem(country = Country(countryName = "France", countryCode = "fra"), navHostController = navHostController) }
        item { CountryItem(country = Country(countryName = "Germany", countryCode = "deu"), navHostController = navHostController)}
        item { CountryItem(country = Country(countryName = "Greece", countryCode = "grc"), navHostController = navHostController) }
        item { CountryItem(country = Country(countryName = "Italy", countryCode = "ita"), navHostController = navHostController) }
        item { CountryItem(country = Country(countryName = "Norway", countryCode = "nor"), navHostController = navHostController) }
        item { CountryItem(country = Country(countryName = "Portugal", countryCode = "prt"), navHostController = navHostController) }
        item { CountryItem(country = Country(countryName = "Spain", countryCode = "esp"), navHostController = navHostController) }
        item { CountryItem(country = Country(countryName = "Sweden", countryCode = "swe"), navHostController = navHostController) }
    }
}
    @Preview(showBackground = true)
    @Composable
    fun CountriesListPreview() {
        CountriesList(navHostController = NavHostController(context = LocalContext.current))
    }