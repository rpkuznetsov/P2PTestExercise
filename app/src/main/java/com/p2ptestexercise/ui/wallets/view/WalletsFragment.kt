package com.p2ptestexercise.ui.wallets.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.p2ptestexercise.R
import com.p2ptestexercise.databinding.FragmentWalletsBinding
import com.p2ptestexercise.model.ui.WalletUiModel
import com.p2ptestexercise.ui.setVisible
import com.p2ptestexercise.ui.wallets.presenter.WalletsPresenter
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class WalletsFragment : Fragment(R.layout.fragment_wallets), WalletsView {

    private lateinit var binding: FragmentWalletsBinding
    private val presenter by inject<WalletsPresenter>()
    private val adapter = WalletsAdapter(get())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWalletsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.walletsRecyclerView.adapter = adapter
        presenter.getWallets()
    }

    override fun showLoading(isLoading: Boolean) {
        binding.progressBar.setVisible(isLoading)
    }

    override fun renderWallets(wallets: List<WalletUiModel>) {
        adapter.items.addAll(wallets)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}