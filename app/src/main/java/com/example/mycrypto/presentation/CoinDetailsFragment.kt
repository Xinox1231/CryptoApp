package com.example.mycrypto.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mycrypto.R
import com.example.mycrypto.databinding.FragmentCoinDetailsBinding
import com.example.mycrypto.databinding.FragmentCoinListBinding
import javax.inject.Inject


class CoinDetailsFragment : Fragment() {

    private var _binding: FragmentCoinDetailsBinding? = null
    private val binding: FragmentCoinDetailsBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinDetailsBinding == null")

    private val args: CoinDetailsFragmentArgs by navArgs()

    val component by lazy {
        (requireActivity().application as CoinApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ApplicationViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDetailedInfo(args.fSyms).observe(viewLifecycleOwner) {
            with(binding) {
                tvPrice.text = it.price
                tvMinPrice.text = it.lowDay
                tvMaxPrice.text = it.highDay
                tvLastMarket.text = it.lastMarket
                tvLastUpdate.text = it.lastUpdate
                tvFromSymbol.text = it.fromSymbol
                tvToSymbol.text = it.toSymbol
                Glide.with(this@CoinDetailsFragment)
                    .load(it.imageUrl)
                    .into(ivLogoCoin)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
