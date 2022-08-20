package com.example.hemnetapp.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hemnetapp.models.PropertyType

fun Modifier.handlePropertyBorder(type: String): Modifier {
    if (type == PropertyType.Highlighted.type) {
        return this.border(
            width = 2.dp,
            color = BorderColor,
            shape = RoundedCornerShape(5.dp)
        )
    }
    return this
}
