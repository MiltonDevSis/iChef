package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.core.domain.LaunchCategories
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.LaunchCategoriesEnum

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoriesListComponent(
    onItemClick: (LaunchCategories) -> Unit
) {

    val launchCategories = listOf(
        LaunchCategories(
            Image = painterResource(id = R.drawable.ic_pizza),
            title = LaunchCategoriesEnum.PIZZA
        ),
        LaunchCategories(
            Image = painterResource(id = R.drawable.ic_hamburguer),
            title = LaunchCategoriesEnum.XIS
        ),
        LaunchCategories(
            Image = painterResource(id = R.drawable.ic_bebida),
            title = LaunchCategoriesEnum.BEBIDA
        ),
        LaunchCategories(
            Image = painterResource(id = R.drawable.ic_tabua),
            title = LaunchCategoriesEnum.TABUA
        ),
        LaunchCategories(
            Image = painterResource(id = R.drawable.ic_porcao),
            title = LaunchCategoriesEnum.PORCAO
        ),
        LaunchCategories(
            Image = painterResource(id = R.drawable.ic_prato_feito),
            title = LaunchCategoriesEnum.PRATO
        )
    )

    LazyRow(
        modifier = Modifier.padding(start = 12.dp, top = 6.dp)
    ) {
        items(launchCategories) { item ->
            Card(
                modifier = Modifier
                    .padding(6.dp)
                    .width(70.dp)
                    .height(100.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(12.dp),
                onClick = { onItemClick(item) }
            ) {
                Column {
                    Image(
                        painter = item.Image,
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(4.dp)
                            .height(50.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = item.title.name,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(1.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}
