package com.example.comik.ui.main

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.comik.R
import com.example.comik.utils.NetworkUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isConnection = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkTheme)
        } else {
            setTheme(R.style.Theme_Comik)
        }
        isConnection = NetworkUtil.isConnection(this)
        if (!isConnection) {
            showDialogCheckInternet().show()
            return
        }
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentNavHost) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }

    private fun showDialogCheckInternet(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.title_internet))
            .setMessage(getString(R.string.msg_check_internet))
            .setPositiveButton(getString(R.string.action_ok)) { _, _ ->
                startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
                finish()
            }
            .setNegativeButton(getString(R.string.action_cancel)) { _, _ ->
                finish()
            }
        return builder.create()
    }
}
