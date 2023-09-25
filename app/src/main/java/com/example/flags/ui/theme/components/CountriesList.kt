package com.example.flags.ui.theme.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.flags.models.Country

@Composable
fun CountriesList() {
    LazyColumn {
        item { CountryItem(country = Country(countryName = "Austria", countryCode= "aut")) }
        item { CountryItem(country = Country(countryName = "Belgium", countryCode = "bel")) }
        item { CountryItem(country = Country(countryName = "France", countryCode = "fra")) }
        item { CountryItem(country = Country(countryName = "Germany", countryCode = "deu"))}
        item { CountryItem(country = Country(countryName = "Greece", countryCode = "grc")) }
        item { CountryItem(country = Country(countryName = "Italy", countryCode = "ita")) }
        item { CountryItem(country = Country(countryName = "Norway", countryCode = "nor")) }
        item { CountryItem(country = Country(countryName = "Portugal", countryCode = "prt")) }
        item { CountryItem(country = Country(countryName = "Spain", countryCode = "esp")) }
        item { CountryItem(country = Country(countryName = "Sweden", countryCode = "swe")) }
    }
}
    @Preview(showBackground = true)
    @Composable
    fun CountriesListPreview() {
        CountriesList()
    }