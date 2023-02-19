package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.core.utils.DRAWER_HEADER_COLOR
import com.mpfcoding.ichef_app.core.utils.fromHex
import com.mpfcoding.ichef_app.framework.cache.SharedPrefs
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.DashboardActivity
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menudrawer.AppBar
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menudrawer.DrawerBody
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menudrawer.DrawerHeader
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menudrawer.ItemMenuDrawerId
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menudrawer.MenuItem
import com.mpfcoding.ichef_app.presentation.presentation.intro.IntroActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashboardComponent(
    nameUserLogged: String = "Tester",
    activity: DashboardActivity,
    sharedPrefs: SharedPrefs
) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader(
                nameUserLogged = nameUserLogged,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.5F)
                    .background(Color.fromHex(DRAWER_HEADER_COLOR))
            )
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = ItemMenuDrawerId.PEDIDO,
                        title = "Meus Pedidos",
                        contentDescription = "Meus Pedidos",
                        icon = painterResource(id = R.drawable.ic_pedidos)
                    ),
                    MenuItem(
                        id = ItemMenuDrawerId.CUPON,
                        title = "Meus Cupons",
                        contentDescription = "Meus Cupons",
                        icon = painterResource(id = R.drawable.ic_meus_cupons)
                    ),
                    MenuItem(
                        id = ItemMenuDrawerId.ENDERECO,
                        title = "Meus Endereços",
                        contentDescription = "Meus Endereços",
                        icon = painterResource(id = R.drawable.ic_meus_enderecos)
                    ),
                    MenuItem(
                        id = ItemMenuDrawerId.CONFIGS,
                        title = "Configurções",
                        contentDescription = "Configurções",
                        icon = painterResource(id = R.drawable.ic_configs)
                    ),
                    MenuItem(
                        id = ItemMenuDrawerId.SAIR,
                        title = "Sair",
                        contentDescription = "Sair",
                        icon = painterResource(id = R.drawable.ic_sair)
                    ),
                ),
                onItemClick = {
                    when(it.id){
                        ItemMenuDrawerId.PEDIDO -> {

                        }
                        ItemMenuDrawerId.CUPON -> {

                        }
                        ItemMenuDrawerId.ENDERECO -> {

                        }
                        ItemMenuDrawerId.CONFIGS -> {

                        }
                        else -> {
                            // Sair
                            sharedPrefs.clearSharedPreferences()

                            val intent = Intent(activity, IntroActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            activity.startActivity(intent)
                            activity.finish()
                        }
                    }
                },
                modifier = Modifier
                    .background(Color.Gray)
                    .weight(8.5F)
            )
        }
    ) {

    }
}
