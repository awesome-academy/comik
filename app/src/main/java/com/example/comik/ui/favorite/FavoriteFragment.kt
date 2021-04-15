package com.example.comik.ui.favorite

import androidx.navigation.fragment.findNavController
import com.example.comik.R
import com.example.comik.base.BaseFragment
import com.example.comik.data.model.Comic
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.comik.databinding.FragmentFavoriteBinding
import com.example.comik.ui.adapter.FavoriteAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override val layoutResources get() = R.layout.fragment_favorite
    override val viewModel by viewModel<FavoriteViewModel>()

    private val favoriteAdapter = FavoriteAdapter(::clickItemFavoriteComic)

    override fun setupViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            favoriteVM = viewModel
        }
        recyclerFavorite.adapter = favoriteAdapter
    }

    override fun initActions() {
    }

    private fun clickItemFavoriteComic(comic: Comic) {
        val action = FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment(comic.id)
        findNavController().navigate(action)
    }
}
