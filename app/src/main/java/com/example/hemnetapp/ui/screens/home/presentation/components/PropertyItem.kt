package com.example.hemnetapp.ui.screens.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
import com.example.hemnetapp.ui.theme.Purple200
import com.example.hemnetapp.ui.theme.handlePropertyBorder

@Composable
fun PropertyItem(item: PropertyModel) {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (imageCover, title, mergeView) = createRefs()

        Image(
            rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.image)
                    .size(Size.ORIGINAL)
                    .build()
            ),
            contentDescription = "Image cover",
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

        Text(
            text = item.area,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(imageCover.bottom, 2.dp)
                start.linkTo(imageCover.start)
            },
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(mergeView) {
                    top.linkTo(title.bottom)
                    start.linkTo(title.start)
                }
        ) {
            if (item.type != PropertyType.Area.type)
                NoneAreaProperty(item)
            else if (item.type == PropertyType.Area.type)
                AreaProperty(item)
        }
    }
}

@Composable
fun NoneAreaProperty(item: PropertyModel) {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (address, icon, infoRow, days) = createRefs()
        Icon(
            painterResource(id = R.drawable.ic_baseline_home_work_24),
            contentDescription = "icon",
            tint = Purple200,
            modifier = Modifier.constrainAs(icon) {
                top.linkTo(parent.top, 5.dp)
                start.linkTo(parent.start)
            }
        )
        Text(
            text = "${item.streetAddress}, ${item.municipality}",
            modifier = Modifier.constrainAs(address) {
                top.linkTo(icon.top)
                bottom.linkTo(icon.bottom)
                start.linkTo(icon.end, 5.dp)
            }
        )

        Row(
            modifier = Modifier.constrainAs(infoRow) {
                top.linkTo(icon.bottom, 5.dp)
                start.linkTo(icon.start)
            }
        ) {
            Text(text = item.askingPrice)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = stringResource(id = R.string.mSquare, item.livingArea))

            Spacer(modifier = Modifier.width(10.dp))
            Text(text = item.numberOfRooms.toString())
        }

        Text(
            text = stringResource(
                id = R.string.days_on_Hemnet,
                item.daysOnHemnet
            ),
            modifier = Modifier.constrainAs(days) {
                top.linkTo(infoRow.top)
                bottom.linkTo(infoRow.bottom)
                end.linkTo(parent.end)
            }
        )
    }
}

@Composable
fun AreaProperty(item: PropertyModel) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(
                id = R.string.rating, item.rating
            )
        )
        Text(
            text = stringResource(
                id = R.string.average_price, item.averagePrice
            )
        )
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
                type = "Area",
                rating = "2/5",
                averagePrice = "1000"
            )
        )
    }
}
