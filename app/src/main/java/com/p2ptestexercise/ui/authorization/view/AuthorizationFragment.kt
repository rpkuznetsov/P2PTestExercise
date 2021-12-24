package com.p2ptestexercise.ui.authorization.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.p2ptestexercise.R
import com.p2ptestexercise.databinding.FragmentAuthorizationBinding
import com.p2ptestexercise.ui.authorization.presenter.AuthorizationPresenter
import com.p2ptestexercise.ui.setVisible
import com.p2ptestexercise.ui.wallets.view.WalletsFragment
import org.koin.android.ext.android.inject

class AuthorizationFragment : Fragment(R.layout.fragment_authorization), AuthorizationView {

    private lateinit var binding: FragmentAuthorizationBinding
    private val presenter by inject<AuthorizationPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.authorizeButton.setOnClickListener {
            presenter.onAuthorizeClick(binding.seedPhraseTextInputEditText.text)
        }
    }

    override fun showLoading(isLoading: Boolean) {
        binding.authorizeButton.text = if (isLoading) null else getString(R.string.button_authorize_title)
        binding.progressBar.setVisible(isLoading)
    }

    override fun navigateToNextScreen() {
        activity?.supportFragmentManager?.commit {
            replace(R.id.fragment_container_view, WalletsFragment())
        }
    }

    override fun showAuthorizationError() {
        Toast.makeText(requireContext(), "Authorization error", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
