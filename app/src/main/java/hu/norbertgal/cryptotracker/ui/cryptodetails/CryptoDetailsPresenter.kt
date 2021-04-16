package hu.norbertgal.cryptotracker.ui.cryptodetails

import hu.norbertgal.cryptotracker.interactor.crypto.CryptoInteractor
import hu.norbertgal.cryptotracker.interactor.crypto.event.GetCryptoDetailsEvent
import hu.norbertgal.cryptotracker.model.Crypto
import hu.norbertgal.cryptotracker.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class CryptoDetailsPresenter @Inject constructor(private val executor: Executor, private val cryptoInteractor: CryptoInteractor) : Presenter<CryptoDetailsScreen>() {

    override fun attachScreen(screen: CryptoDetailsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshCryptoDetails(id: Long) {
        executor.execute {
            cryptoInteractor.getCryptoDetails(id)
        }
    }

    fun deleteCryptoDetails(crypto : Crypto) {
        executor.execute {
            cryptoInteractor.deleteCryptoDetails(crypto)
        }
    }

    fun updateCryptoDetails(crypto : Crypto) {
        executor.execute {
            cryptoInteractor.updateCryptoDetails(crypto)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetCryptoDetailsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.crypto != null) {
                    screen?.showCryptoDetails(event.crypto)
                }
            }
        }
    }

}