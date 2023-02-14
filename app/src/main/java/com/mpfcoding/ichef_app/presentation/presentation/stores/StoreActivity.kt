package com.mpfcoding.ichef_app.presentation.presentation.stores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mpfcoding.ichef_app.core.domain.Store
import com.mpfcoding.ichef_app.core.domain.stores
import com.mpfcoding.ichef_app.presentation.presentation.stores.components.StoreCard
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoreActivity : ComponentActivity() {

    //private val viewModel: StoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IChef_appTheme {
                Column {
                    TopAppBar(
                        title = { Text(text = "ESTABELECIMENTOS") },
                        backgroundColor = Color.Green,
                    )
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        content = {
                            items(stores) { item: Store ->
                                StoreCard(store = item)
                            }
                        }
                    )
                }
            }
        }
    }
}