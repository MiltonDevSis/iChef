package com.mpfcoding.ichef_app.presentation.presentation.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mpfcoding.ichef_app.core.utils.IchefConstants
import com.mpfcoding.ichef_app.framework.cache.SharedPrefs
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.DashboardComponent
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint
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
                DashboardComponent(
                    nameUserLogged = nameUserLogged,
                    this@DashboardActivity,
                    sharedPrefs
                )
            }
        }
    }
}
