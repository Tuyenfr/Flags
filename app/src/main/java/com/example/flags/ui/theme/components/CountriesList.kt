package com.example.flags.ui.theme.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CountriesList() {
    LazyColumn {
        item { CountryItem(countryName = "Austria", countryCode = "aut") }
        item { CountryItem(countryName = "Belgium", countryCode = "bel") }
        item { CountryItem(countryName = "France", countryCode = "fra") }
        item { CountryItem(countryName = "Germany", countryCode = "deu") }
        item { CountryItem(countryName = "Greece", countryCode = "grc") }
        item { CountryItem(countryName = "Italy", countryCode = "ita") }
        item { CountryItem(countryName = "Norway", countryCode = "nor") }
        item { CountryItem(countryName = "Portugal", countryCode = "prt") }
        item { CountryItem(countryName = "Spain", countryCode = "esp") }
        item { CountryItem(countryName = "Sweden", countryCode = "swe") }
    }
}
    @Preview(showBackground = true)
    @Composable
    fun CountriesListPreview() {
        CountriesList()
    }