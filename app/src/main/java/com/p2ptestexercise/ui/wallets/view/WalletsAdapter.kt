package com.p2ptestexercise.ui.wallets.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.p2ptestexercise.R
import com.p2ptestexercise.databinding.ItemWalletBinding
import com.p2ptestexercise.model.ui.WalletUiModel
import com.p2ptestexercise.util.StringService

class WalletsAdapter(
    private val stringService: StringService
) : RecyclerView.Adapter<WalletsAdapter.WalletsViewHolder>() {

    val items = mutableListOf<WalletUiModel>()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWalletBinding.inflate(inflater, parent, false)
        return WalletsViewHolder(binding, stringService)
    }

    override fun onBindViewHolder(holder: WalletsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class WalletsViewHolder(
        private val binding: ItemWalletBinding,
        private val stringService: StringService
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(wallet: WalletUiModel) = binding.apply {
            publicKeyTextView.text = stringService.getString(R.string.public_key_title, wallet.publicKey)
            mintTextView.text = stringService.getString(R.string.mint_address_title, wallet.mintAddress)
            amountTextView.text = stringService.getString(R.string.amount_title, wallet.amount)
        }
    }
}
