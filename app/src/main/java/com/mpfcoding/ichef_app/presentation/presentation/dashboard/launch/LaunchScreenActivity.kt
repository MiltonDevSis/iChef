package com.mpfcoding.ichef_app.presentation.presentation.dashboard.launch

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.core.domain.Launch
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_COLOR
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_CONTENT_COLOR
import com.mpfcoding.ichef_app.core.utils.fromHex
import com.mpfcoding.ichef_app.framework.cache.SharedPrefs
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.DashboardActivity
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class LaunchScreenActivity : ComponentActivity() {

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    private val viewModel: LaunchScreenViewModel by viewModels()

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {

        val productId: Int = intent.extras?.getInt("popularLaunchId") ?: 123
        val productName: String = intent.extras?.getString("popularLaunchName") ?: "nameError"
        val productPrice: String = intent.extras?.getString("popularLaunchPrice") ?: "priceError"

        super.onCreate(savedInstanceState)
        setContent {
            IChef_appTheme {

                var totalOrder by remember { mutableStateOf(0) }

                TopAppBar(
                    title = { Text(text = "ESCOLHA SEU LANCHE") },
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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 80.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    Text(
                        text = productName,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Text(
                        text = "R$ $productPrice",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 6.dp),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Green
                        )
                    )
                    Spacer(modifier = Modifier.size(25.dp))
                    Image(
                        painter = painterResource(id = R.drawable.xis_coracao),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(42.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = {
                            totalOrder += 1
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = null,
                                modifier = Modifier
                                    .width(26.dp)
                                    .height(26.dp)
                                    .background(Color.Green)
                            )
                        }
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(
                            text = "$totalOrder",
                            style = TextStyle(
                                fontSize = 26.sp
                            )
                        )
                        Spacer(modifier = Modifier.size(12.dp))
                        IconButton(onClick = {
                            if (totalOrder > 0) {
                                totalOrder -= 1
                            }
                        }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_remove),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(26.dp)
                                    .height(26.dp)
                                    .background(Color.Green)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "Coração de Frango, Maiones, Queijo, Pão, Milho, Ervilha, Tomate, Alface, Ovo e Maionese do Chef",
                        style = TextStyle(
                            fontSize = 18.sp
                        )
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Button(
                            onClick = {
                                if (totalOrder > 0) {

                                    lifecycleScope.launch {
                                        viewModel.insertLaunch(
                                            Launch(
                                                productId = productId,
                                                productName = productName,
                                                productPrice = productPrice,
                                                productQuantity = totalOrder
                                            )
                                        )
                                    }

                                    startActivity(
                                        Intent(
                                            this@LaunchScreenActivity,
                                            DashboardActivity::class.java
                                        )
                                    )
                                    finish()
                                } else {
                                    Toasty.warning(
                                        this@LaunchScreenActivity,
                                        "Adicione ao menos um lanche",
                                        Toasty.LENGTH_LONG
                                    ).show()
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(horizontal = 50.dp)
                                .padding(top = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Green,
                                contentColor = Color.White
                            ),
                            content = {
                                Text(
                                    text = "Adicionar no carrinho",
                                    style = TextStyle(
                                        fontSize = 18.sp
                                    )
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}
