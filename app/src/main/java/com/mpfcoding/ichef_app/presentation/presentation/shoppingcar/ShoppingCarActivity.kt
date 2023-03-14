package com.mpfcoding.ichef_app.presentation.presentation.shoppingcar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import com.mpfcoding.ichef_app.core.domain.Launch
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_COLOR
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_CONTENT_COLOR
import com.mpfcoding.ichef_app.core.utils.fromHex
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ShoppingCarActivity : ComponentActivity() {

    private val viewModel: ShoppingCarViewModel by viewModels()

    private var listOrders: List<Launch> = emptyList()

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IChef_appTheme {

                var isLoading by remember { mutableStateOf(true) }

                Column {
                    TopAppBar(
                        title = { Text(text = "MEU CARRINHO") },
                        backgroundColor = Color.fromHex(TOOLBAR_COLOR),
                        contentColor = Color.fromHex(TOOLBAR_CONTENT_COLOR),
                        navigationIcon = {
                            IconButton(onClick = {
                                finish()
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = null
                                )
                            }
                        }
                    )

                    lifecycleScope.launch {
                        viewModel.loadAllOrders()
                    }

                    viewModel.orders.observe(this@ShoppingCarActivity) { listLunchs ->
                        listOrders = listLunchs
                        isLoading = false
                    }

                   if (!isLoading) {
                       OrderComponent(
                           orders = listOrders,
                           viewModel = viewModel
                       )
                   }
                    Text(text = "Total dos pedidos: ")
                }
            }
        }
    }
}