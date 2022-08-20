package com.example.hemnetapp.ui.screens.home.presentation

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hemnetapp.R

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val viewState by viewModel.viewState.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CreateTopBar() }
    ) {

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {


            if (viewState.homeList.isNotEmpty()) {
                items(viewState.homeList) { item ->
                    Text(text = item.area)
                }
            }
        }
    }

}

@Composable
fun CreateTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) }
    )
}