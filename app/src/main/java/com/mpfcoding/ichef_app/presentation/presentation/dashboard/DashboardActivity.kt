package com.mpfcoding.ichef_app.presentation.presentation.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpfcoding.ichef_app.core.utils.IchefConstants
import com.mpfcoding.ichef_app.framework.cache.SharedPrefs
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.PromoDayComponent
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menuapp.AppBar
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menuapp.MyBottomAppBarComponent
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import javax.inject.Inject

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {

    //private val viewModel: DashboardViewModel by viewModels()

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    private lateinit var nameUserLogged: String

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nameUserLogged = if (sharedPrefs.contains(key = IchefConstants.UserLogged.USER_LOGGED)) {
            sharedPrefs.getString(key = IchefConstants.UserLogged.USER_LOGGED)
        } else {
            "Sem Login"
        }

        setContent {
            IChef_appTheme {
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar()
                    },
                    bottomBar = {
                        MyBottomAppBarComponent(
                            onOrder = {
                                Toasty.success(this, "Home", Toasty.LENGTH_LONG).show()
                            },
                            onLocation = {
                                Toasty.success(this, "Back", Toasty.LENGTH_LONG).show()
                            },
                            onConfigs = {
                                // Sair
//                                sharedPrefs.clearSharedPreferences()
//
//                                val intent = Intent(
//                                    this@DashboardActivity,
//                                    IntroActivity::class.java
//                                )
//                                intent.flags =
//                                    Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//                                this@DashboardActivity.startActivity(intent)
//                                this@DashboardActivity.finish()
                            },
                            onProfile = {

                            }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {},
                            backgroundColor = Color(0xffFFA000)
                        ) {
                            Icon(
                                Icons.Filled.ShoppingCart, tint = Color.White,
                                contentDescription = null
                            )
                        }
                    },
                    isFloatingActionButtonDocked = true,
                    floatingActionButtonPosition = FabPosition.Center,

                    ) {

                    Column {
                        PromoDayComponent (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(170.dp)
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        )

                        Text(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            text = "Categorias",
                            modifier = Modifier.padding(start = 12.dp, top = 6.dp)
                        )
                    }
                }
            }
        }
    }
}
