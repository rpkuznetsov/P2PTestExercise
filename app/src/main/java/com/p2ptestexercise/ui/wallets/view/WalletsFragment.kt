package com.p2ptestexercise.ui.wallets.view

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.p2ptestexercise.R
import com.p2ptestexercise.databinding.FragmentWalletsBinding
import com.p2ptestexercise.model.ui.WalletUiModel
import com.p2ptestexercise.ui.authorization.view.AuthorizationFragment
import com.p2ptestexercise.ui.setVisible
import com.p2ptestexercise.ui.wallets.presenter.WalletsPresenter
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class WalletsFragment : Fragment(), WalletsView {

    private lateinit var binding: FragmentWalletsBinding
    private val presenter by inject<WalletsPresenter<WalletsView>>()
    private val adapter = WalletsAdapter(get())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
        binding.swipeToRefreshLayout.setOnRefreshListener { presenter.updateWallets() }
        presenter.updateWallets()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.wallets_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menu_log_out -> presenter.onLogOutClick()
        else -> super.onOptionsItemSelected(item)
    }

    override fun showLoading(isLoading: Boolean) = binding.run {
        when {
            swipeToRefreshLayout.isRefreshing -> swipeToRefreshLayout.isRefreshing = isLoading
            else -> progressBar.setVisible(isLoading)
        }
    }

    override fun renderWallets(wallets: List<WalletUiModel>) {
        binding.noWalletsTextView.setVisible(wallets.isEmpty())
        adapter.setItems(wallets)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun routeToAuthorization() {
        activity?.supportFragmentManager?.commit {
            replace(R.id.fragment_container_view, AuthorizationFragment())
            remove(this@WalletsFragment)
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
