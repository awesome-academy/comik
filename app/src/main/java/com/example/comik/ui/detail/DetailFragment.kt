package com.example.comik.ui.detail

import android.graphics.text.LineBreaker
import android.os.Build
import com.example.comik.R
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.comik.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.comik.databinding.FragmentDetailBinding
import com.example.comik.ui.adapter.PosterAdapter
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.scrollingBanner
import kotlinx.android.synthetic.main.fragment_seemore.imageButtonBack

class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    override val layoutResources get() = R.layout.fragment_detail
    override val viewModel by viewModel<DetailViewModel>()

    private val args: DetailFragmentArgs by navArgs()
    private val posterAdapter = PosterAdapter()

    override fun setupViews() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            textDescription.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        }
    }

    override fun initData() {
        recyclerPoster.adapter = posterAdapter
        PagerSnapHelper().attachToRecyclerView(recyclerPoster)
        scrollingBanner.attachToRecyclerView(recyclerPoster)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            detailVM = viewModel
        }
        viewModel.initDataDetail(args.idComic)
    }

    override fun initActions() {
        imageButtonBack.setOnClickListener {
            findNavController().popBackStack()
        }
        imageButtonFavorite.setOnClickListener {
            viewModel.updateFavorite()
        }
    }
}
