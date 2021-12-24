package com.p2ptestexercise.interactor.wallets

import com.p2ptestexercise.data.authorization.AuthorizationRepository
import com.p2ptestexercise.data.wallets.WalletsRepository
import com.p2ptestexercise.model.api.Value
import com.p2ptestexercise.model.ui.WalletUiModel

class WalletsInteractorImpl(
    private val authorizationRepository: AuthorizationRepository,
    private val walletsRepository: WalletsRepository
) : WalletsInteractor {

    override suspend fun getWallets(): List<WalletUiModel> {
        val authorizationData = authorizationRepository.getAuthorizationData()
        val walletsResponse = walletsRepository.fetchWallets(authorizationData)
        return walletsResponse.result.value.map(::map)
    }

    private fun map(value: Value) = WalletUiModel(
        publicKey = value.pubkey,
        mintAddress = value.account.data.parsed.info.mint,
        amount = value.account.data.parsed.info.tokenAmount.uiAmountString
    )
}
