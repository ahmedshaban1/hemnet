package com.example.hemnetapp.ui.screens.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hemnetapp.R
import com.example.hemnetapp.ui.screens.home.presentation.components.PropertyItem
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val viewState by viewModel.viewState.collectAsState()
    val scope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = { PropertyDetailsBottomSheet(viewState.selectedProperty) },
        sheetShape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)

    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { CreateTopBar() }
        ) {
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                contentPadding = PaddingValues(10.dp)
            ) {
                if (viewState.homeList.isNotEmpty()) {
                    items(viewState.homeList) { item ->
                        PropertyItem(item = item) {
                            viewModel.updateSelectedItem(item)
                            scope.launch {
                                modalBottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                            }
                        }
                    }
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
