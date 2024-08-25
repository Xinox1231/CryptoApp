package com.example.mycrypto.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mycrypto.databinding.FragmentCoinListBinding
import com.example.mycrypto.presentation.adapters.CoinAdapter
import javax.inject.Inject


class CoinListFragment : Fragment() {

    private var _binding: FragmentCoinListBinding? = null
    private val binding: FragmentCoinListBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinListBinding == null")

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
        _binding = FragmentCoinListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coinAdapter = CoinAdapter(requireContext())

        binding.rvCoinInfoList.adapter = coinAdapter
        binding.rvCoinInfoList.itemAnimator = null
        viewModel.coinInfoList.observe(viewLifecycleOwner) {
            Log.d("TAG", it.toString())
            coinAdapter.submitList(it)
        }
        coinAdapter.onItemClickListener = {
            launchCoinDetailsFragment(it.fromSymbol)
        }

    }

    private fun launchCoinDetailsFragment(fSyms: String) {
        findNavController().navigate(
            CoinListFragmentDirections.actionCoinListFragmentToCoinDetailsFragment(
                fSyms
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}