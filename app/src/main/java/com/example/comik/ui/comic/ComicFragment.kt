package com.example.comik.ui.comic

import android.app.Dialog
import androidx.navigation.fragment.findNavController
import com.example.comik.R
import com.example.comik.base.BaseFragment
import com.example.comik.data.model.Comic
import com.example.comik.databinding.FragmentComicBinding
import com.example.comik.ui.adapter.ComicAdapter
import com.example.comik.utils.APIConfig.FORMAT_COMIC
import kotlinx.android.synthetic.main.dialog_fitler_year.*
import kotlinx.android.synthetic.main.fragment_comic.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

const val MIN_YEAR = 1954

class ComicFragment : BaseFragment<FragmentComicBinding>() {
    override val layoutResources get() = R.layout.fragment_comic
    override val viewModel by viewModel<ComicViewModel>()

    private val comicAdapter = ComicAdapter(::clickItemComic)

    override fun setupViews() {
    }

    override fun initData() {
        recyclerComic.adapter = comicAdapter
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            comicVM = viewModel
        }
    }

    override fun initActions() {
        buttonSearch.setOnClickListener {
            createDialogWithoutDateField()
        }
    }

    private fun createDialogWithoutDateField() {
        val calendar = Calendar.getInstance()
        val dialog = Dialog(requireContext())
        dialog.apply {
            setContentView(R.layout.dialog_fitler_year)
            window?.setBackgroundDrawableResource(R.drawable.bg_white_radius_24)
            val year = calendar[Calendar.YEAR]
            numberPickerYear.minValue = MIN_YEAR
            numberPickerYear.maxValue = calendar.get(Calendar.YEAR)
            numberPickerYear.value = year
            buttonSet.setOnClickListener {
                if (editTextChooseYear.text.isEmpty()) {
                    updateComicByYear(numberPickerYear.value)
                } else {
                    updateComicByYear(editTextChooseYear.text.toString().toInt())
                }
                dismiss()
            }
            buttonCancel.setOnClickListener {
                dismiss()
            }
            show()
        }
    }

    private fun updateComicByYear(value: Int) {
        binding?.buttonSearch?.text = value.toString()
        viewModel.getComicByYear(FORMAT_COMIC, value)
    }

    private fun clickItemComic(comic: Comic) {
        val action = ComicFragmentDirections.actionComicFragmentToDetailFragment(comic.id)
        findNavController().navigate(action)
    }
}
