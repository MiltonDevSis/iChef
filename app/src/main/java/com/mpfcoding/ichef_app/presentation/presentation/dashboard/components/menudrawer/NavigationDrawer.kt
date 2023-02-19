package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menudrawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menudrawer.MenuItem

@Composable
fun DrawerHeader(
    nameUserLogged: String = "Tester",
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
            Row {
                Spacer(modifier = Modifier.size(15.dp))
                Icon(
                    modifier = Modifier
                        .size(45.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_edit_24),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(15.dp))
                Column{
                    Text(text = nameUserLogged, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Editar informações do perfil")
                }
            }
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit,
    modifier: Modifier
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            ) {
                Icon(
                    painter = item.icon,
                    contentDescription = item.contentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}