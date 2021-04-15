package com.example.comik.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.comik.R
import com.example.comik.utils.loadLocalImageCircle
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_setting, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageLogo.loadLocalImageCircle(R.drawable.splash)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            switchTheme.isChecked = true
        }
        changeMode()
        viewInfo.setOnClickListener {
            showDialogInfo()
        }
    }

    private fun changeMode() {
        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun showDialogInfo() {
        context?.let {
            AlertDialog.Builder(it)
                .setTitle(resources.getString(R.string.text_about_app))
                .setMessage(resources.getString(R.string.text_message_info))
                .setNegativeButton(resources.getString(R.string.action_ok)) { dialog, _ ->
                    dialog.cancel()
                }
                .create()
                .show()
        }
    }
}
