package hu.norbertgal.cryptotracker.ui.about

import hu.norbertgal.cryptotracker.model.About
import hu.norbertgal.cryptotracker.ui.Presenter

class AboutPresenter : Presenter<AboutScreen>() {

    fun getAbout() {
        val about = About("Norbert Gál", "TK4XI3", "v1.0.0")
        screen?.showAbout(about)
    }

}