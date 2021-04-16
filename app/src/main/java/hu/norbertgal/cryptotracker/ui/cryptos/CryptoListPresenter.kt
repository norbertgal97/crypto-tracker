package hu.norbertgal.cryptotracker.ui.cryptos

import hu.norbertgal.cryptotracker.interactor.crypto.CryptoInteractor
import hu.norbertgal.cryptotracker.interactor.crypto.event.GetCryptosEvent
import hu.norbertgal.cryptotracker.model.CryptoPreview
import hu.norbertgal.cryptotracker.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class CryptoListPresenter @Inject constructor(private val executor: Executor, private val cryptoInteractor: CryptoInteractor) : Presenter<CryptoListScreen>() {

    override fun attachScreen(screen: CryptoListScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshCryptos(limit: Long) {
        executor.execute {
            cryptoInteractor.getCryptoPreviews(100)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetCryptosEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.cryptos != null) {
                    screen?.showCryptos(event.cryptos as MutableList<CryptoPreview>)
                }
            }
        }
    }
}