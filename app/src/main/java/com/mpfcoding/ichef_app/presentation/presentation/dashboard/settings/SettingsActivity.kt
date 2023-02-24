package com.mpfcoding.ichef_app.presentation.presentation.dashboard.settings

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_COLOR
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_CONTENT_COLOR
import com.mpfcoding.ichef_app.core.utils.fromHex
import com.mpfcoding.ichef_app.framework.cache.SharedPrefs
import com.mpfcoding.ichef_app.framework.util.AlertDialogComponent
import com.mpfcoding.ichef_app.presentation.presentation.intro.IntroActivity
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    //private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalCoroutinesApi::class)
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IChef_appTheme {

                var showDialog by remember { mutableStateOf(false) }

                Column {
                    TopAppBar(
                        title = { Text(text = "CONFIGURAÇÕES") },
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
                    SettingsItens(
                        image = painterResource(id = R.drawable.ic_info),
                        title = "Receber notificações",
                        onClick = {

                        }
                    )
                    SettingsItens(
                        image = painterResource(id = R.drawable.ic_settings),
                        title = "Sair",
                        onClick = {
                            showDialog = true
                        }
                    )
                    AlertDialogComponent(
                        showDialog,
                        clickYes = {
                            sharedPrefs.clearSharedPreferences()

                            val intent = Intent(
                                this@SettingsActivity, IntroActivity::class.java
                            )
                            intent.flags =
                                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                                        Intent.FLAG_ACTIVITY_CLEAR_TASK or
                                        Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()
                        },
                        clickNo = {
                            showDialog = !showDialog
                        }
                    )
                }
            }
        }
    }
}