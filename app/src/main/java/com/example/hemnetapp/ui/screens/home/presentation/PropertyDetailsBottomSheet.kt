@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.hemnetapp.ui.screens.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hemnetapp.R
import com.example.hemnetapp.models.PropertyModel
import com.example.hemnetapp.ui.screens.home.presentation.components.PropertyItem

@Composable
fun PropertyDetailsBottomSheet(propertyModel: PropertyModel) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Spacer(
                modifier = Modifier
                    .width(50.dp)
                    .height(5.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color.Gray)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        PropertyItem(item = propertyModel)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = stringResource(id = R.string.monthly_fess, propertyModel.monthlyFee))
        Spacer(modifier = Modifier.height(150.dp))

    }
}