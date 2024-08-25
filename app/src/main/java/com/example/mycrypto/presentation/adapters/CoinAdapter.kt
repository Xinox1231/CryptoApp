package com.example.mycrypto.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.mycrypto.R
import com.example.mycrypto.databinding.ItemCoinInfoBinding
import com.example.mycrypto.domain.model.CoinInfo

class CoinAdapter(
    private val context: Context
) : ListAdapter<CoinInfo, CoinViewHolder>(CoinItemDiffCallback()) {

    var onItemClickListener: ((CoinInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding =
            ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            with(item) {
                val symbolsTemplate = context.resources.getString(R.string.symbols_template)
                val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
                tvSymbols.text = String.format(
                    symbolsTemplate,
                    fromSymbol,
                    toSymbol
                )
                tvPrice.text = price
                tvLastUpdate.text = String.format(lastUpdateTemplate, lastUpdate)
                root.setOnClickListener {
                    onItemClickListener?.invoke(this)
                }
                Glide.with(context)
                    .load(imageUrl)
                    .into(ivLogoCoin);
            }
        }
    }
}