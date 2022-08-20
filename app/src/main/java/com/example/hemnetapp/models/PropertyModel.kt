package com.example.hemnetapp.models

data class PropertyModel(
    val area: String,
    val askingPrice: String,
    val daysOnHemnet: Int,
    val id: String,
    val image: String,
    val livingArea: Int,
    val monthlyFee: String,
    val municipality: String,
    val numberOfRooms: Int,
    val streetAddress: String,
    val type: String
)