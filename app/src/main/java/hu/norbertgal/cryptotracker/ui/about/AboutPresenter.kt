package hu.norbertgal.cryptotracker.ui.about

import hu.norbertgal.cryptotracker.model.About
import hu.norbertgal.cryptotracker.ui.Presenter

class AboutPresenter : Presenter<AboutScreen>() {

    fun getAbout() {
        val about = About("Gál Norbert", "TK4XI3", "App version: v4.0.0")
        screen?.showAbout(about)
    }

}