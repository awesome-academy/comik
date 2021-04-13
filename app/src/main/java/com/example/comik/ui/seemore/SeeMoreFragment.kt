package com.example.comik.ui.seemore

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.comik.R
import com.example.comik.base.BaseFragment
import com.example.comik.data.model.*
import com.example.comik.databinding.FragmentSeemoreBinding
import com.example.comik.ui.adapter.*
import com.example.comik.utils.BUNDLE.BUNDLE_CHARACTER
import com.example.comik.utils.BUNDLE.BUNDLE_EVENT
import com.example.comik.utils.BUNDLE.BUNDLE_SERIES
import com.example.comik.utils.BUNDLE.BUNDLE_STORY
import kotlinx.android.synthetic.main.fragment_seemore.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SeeMoreFragment : BaseFragment<FragmentSeemoreBinding>() {
    override val layoutResources get() = R.layout.fragment_seemore
    override val viewModel by viewModel<SeeMoreViewModel>()

    private val args: SeeMoreFragmentArgs by navArgs()

    override fun setupViews() {
    }

    override fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            seeMoreVM = viewModel
        }
        val multiTypeAdapter = when (args.type) {
            BUNDLE_CHARACTER -> MultiTypeAdapter(::clickItemCharacter)
            BUNDLE_SERIES -> MultiTypeAdapter(::clickItemSeries)
            BUNDLE_EVENT -> MultiTypeAdapter(::clickItemEvent)
            BUNDLE_STORY -> MultiTypeAdapter(::clickItemStory)
            else -> MultiTypeAdapter(::clickItemCreator)
        }
        recyclerSeeMore.adapter = multiTypeAdapter
        viewModel.getSeeMore(args.type)
    }

    override fun initActions() {
        imageButtonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun clickItemCharacter(character: Character) {
    }

    private fun clickItemEvent(event: Event) {
    }

    private fun clickItemStory(story: Story) {
    }

    private fun clickItemCreator(creator: Creator) {
    }

    private fun clickItemSeries(series: Series) {
    }
}
