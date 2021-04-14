package com.example.comik.ui.listcomic

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.comik.R
import com.example.comik.base.BaseFragment
import com.example.comik.data.model.Comic
import com.example.comik.databinding.FragmentListcomicBinding
import com.example.comik.ui.adapter.ComicAdapter
import kotlinx.android.synthetic.main.fragment_comic.recyclerComic
import kotlinx.android.synthetic.main.fragment_listcomic.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListComicFragment : BaseFragment<FragmentListcomicBinding>() {
    override val layoutResources get() = R.layout.fragment_listcomic
    override val viewModel by viewModel<ListComicViewModel>()

    private val args: ListComicFragmentArgs by navArgs()
    private val comicAdapter = ComicAdapter(::clickItemComic)

    override fun setupViews() {
    }

    override fun initData() {
        recyclerComic.adapter = comicAdapter
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            listComicVM = viewModel
        }
        viewModel.getComicsByType(args.type, args.id)
    }

    override fun initActions() {
        toolBarBack.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun clickItemComic(comic: Comic) {
        val action = ListComicFragmentDirections.actionListComicFragmentToDetailFragment(comic.id)
        findNavController().navigate(action)
    }
}
