package com.p2ptestexercise.interactor.wallets

import com.p2ptestexercise.R
import com.p2ptestexercise.data.authorization.AuthorizationRepository
import com.p2ptestexercise.data.wallets.WalletsRepository
import com.p2ptestexercise.model.api.Value
import com.p2ptestexercise.model.ui.WalletUiModel
import com.p2ptestexercise.model.ui.WalletsResult
import com.p2ptestexercise.util.StringService

class WalletsInteractorImpl(
    private val authorizationRepository: AuthorizationRepository,
    private val walletsRepository: WalletsRepository,
    private val stringService: StringService
) : WalletsInteractor {

    override suspend fun getWallets(): WalletsResult {
        val defaultError =
            WalletsResult.Error(stringService.getString(R.string.default_error_message))

        val authorizationData =
            authorizationRepository.getPubicKey() ?: return defaultError

        val response = walletsRepository.fetchWallets(authorizationData)
        return when {
            response.result != null -> WalletsResult.Success(response.result.value.map(::map))
            response.error != null -> WalletsResult.Error(response.error.message)
            else -> defaultError
        }
    }

    override suspend fun logOut() {
        authorizationRepository.removePublicKey()
    }

    private fun map(value: Value) = WalletUiModel(
        publicKey = value.pubkey,
        mintAddress = value.account.data.parsed.info.mint,
        amount = value.account.data.parsed.info.tokenAmount.uiAmountString
    )
}
