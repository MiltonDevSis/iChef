package com.mpfcoding.ichef_app.presentation.presentation.dashboard

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.mpfcoding.ichef_app.core.utils.IchefConstants
import com.mpfcoding.ichef_app.framework.cache.SharedPrefs
import com.mpfcoding.ichef_app.framework.navigation.DashboardNavigation
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.CategoriesListComponent
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.MyFloatingActionButton
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.PopularOrdersComponent
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.PromoDayComponent
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menuapp.AppBar
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menuapp.MyBottomAppBarComponent
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.settings.SettingsActivity
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {

    //private val viewModel: DashboardViewModel by viewModels()

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    private lateinit var nameUserLogged: String

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
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            nameUserLogged = nameUserLogged
                        )
                    },
                    bottomBar = {
                        MyBottomAppBarComponent(
                            onHome = { type ->
                                when (type) {
                                    DashboardNavigation.HOME -> {

                                    }
                                    DashboardNavigation.PROFILE -> {

                                    }
                                    DashboardNavigation.SUPPORT -> {

                                    }
                                    else -> {
                                        startActivity(Intent(this@DashboardActivity, SettingsActivity::class.java))
                                    }
                                }
                            }
                        )
                    },
                    floatingActionButton = {
                        MyFloatingActionButton()
                    },
                    isFloatingActionButtonDocked = true,
                    floatingActionButtonPosition = FabPosition.Center,
                    content = {

                        LazyColumn {
                            items(1) {
                                PromoDayComponent(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(160.dp)
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                )

                                Text(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    text = "Categorias",
                                    modifier = Modifier.padding(start = 12.dp, top = 6.dp)
                                )

                                CategoriesListComponent(
                                    onItemClick = {
                                        when (it.title) {
                                            LaunchCategoriesEnum.PIZZA -> {}
                                            LaunchCategoriesEnum.XIS -> {}
                                            LaunchCategoriesEnum.BEBIDA -> {}
                                            LaunchCategoriesEnum.TABUA -> {}
                                            LaunchCategoriesEnum.PORCAO -> {}
                                            else -> { // pratos
                                            }
                                        }
                                    }
                                )

                                Text(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    text = "Populares",
                                    modifier = Modifier.padding(start = 12.dp, top = 6.dp)
                                )

                                PopularOrdersComponent(onItemClick = {})

                                Text(
                                    //Todo(Esse Text é necessário pois senão a bottomBar corta o último component)
                                    text = "",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp)
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}