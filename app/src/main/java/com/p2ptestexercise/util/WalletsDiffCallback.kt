package com.p2ptestexercise.util

import androidx.recyclerview.widget.DiffUtil
import com.p2ptestexercise.model.ui.WalletUiModel

class WalletsDiffCallback(
    private val oldItems: List<WalletUiModel>,
    private val newItems: List<WalletUiModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition].publicKey == newItems[newItemPosition].publicKey

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldItems[oldItemPosition] == newItems[newItemPosition]
}
