package hu.norbertgal.cryptotracker

import androidx.fragment.app.Fragment

val Fragment.injector: CryptoTrackerApplicationComponent
    get() {
        return (this.context!!.applicationContext as CryptoTrackerApplication).injector
    }