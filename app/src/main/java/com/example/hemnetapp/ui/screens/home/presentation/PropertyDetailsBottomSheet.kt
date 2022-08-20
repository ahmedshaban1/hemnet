@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.hemnetapp.ui.screens.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hemnetapp.models.PropertyModel
import com.example.hemnetapp.ui.screens.home.presentation.components.PropertyItem

@Composable
fun PropertyDetailsBottomSheet(propertyModel: PropertyModel) {
    Column(Modifier.fillMaxWidth()) {
        PropertyItem(item = propertyModel)
        Spacer(modifier = Modifier.height(150.dp))
    }
}