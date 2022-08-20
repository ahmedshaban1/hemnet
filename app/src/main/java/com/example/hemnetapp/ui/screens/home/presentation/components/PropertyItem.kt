package com.example.hemnetapp.ui.screens.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.hemnetapp.R
import com.example.hemnetapp.models.PropertyModel
import com.example.hemnetapp.models.PropertyType
import com.example.hemnetapp.ui.theme.HemnetAppTheme
import com.example.hemnetapp.ui.theme.handlePropertyBorder

@Composable
fun PropertyItem(item: PropertyModel) {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (imageCover, title, address, infoRow, days) = createRefs()

        Image(
            rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.image)
                    .size(Size.ORIGINAL)
                    .build()
            ), contentDescription = "Image cover",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .handlePropertyBorder(item.type)
                .clip(RoundedCornerShape(5.dp))
                .constrainAs(imageCover) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                },
            contentScale = ContentScale.Crop
        )

        if (item.type != PropertyType.Area.type) {
            Text(text = item.municipality, modifier = Modifier.constrainAs(title) {
                top.linkTo(imageCover.bottom,2.dp)
                start.linkTo(imageCover.start)
            })

            Text(text = "${item.streetAddress}, ${item.area}", modifier = Modifier.constrainAs(address) {
                top.linkTo(title.bottom, 5.dp)
                start.linkTo(title.start)
            })
            Row(modifier = Modifier.constrainAs(infoRow) {
                top.linkTo(address.bottom, 5.dp)
                start.linkTo(address.start)
            }) {
                Text(text = item.askingPrice)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = stringResource(id = R.string.mSquare, item.livingArea))

                Spacer(modifier = Modifier.width(10.dp))
                Text(text = item.numberOfRooms.toString())
            }

            Text(text = item.daysOnHemnet.toString(), modifier = Modifier.constrainAs(days) {
                top.linkTo(infoRow.top)
                bottom.linkTo(infoRow.bottom)
                end.linkTo(imageCover.end)
            })
        }

    }
}


@Preview
@Composable
fun PropertyItemPreview() {
    HemnetAppTheme {
        PropertyItem(
            item = PropertyModel(
                area = "Area",
                id = "id",
                askingPrice = "100",
                livingArea = 10,
                streetAddress = "Address",
                daysOnHemnet = 10,
                numberOfRooms = 3,
                image = "image",
                monthlyFee = "1000",
                municipality = "sss",
                type = "ss"

            )
        )
    }
}