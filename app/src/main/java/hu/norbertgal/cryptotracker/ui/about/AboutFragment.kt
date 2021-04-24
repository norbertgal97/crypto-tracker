package hu.norbertgal.cryptotracker.ui.about

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hu.norbertgal.cryptotracker.R
import hu.norbertgal.cryptotracker.injector
import hu.norbertgal.cryptotracker.model.About
import kotlinx.android.synthetic.main.fragment_about.*
import javax.inject.Inject

class AboutFragment : Fragment(), AboutScreen {

    @Inject
    lateinit var aboutPresenter: AboutPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        aboutPresenter.attachScreen(this)
        Log.d("AboutFragment", "onAttach")
    }

    override fun onDetach() {
        Log.d("AboutFragment", "onDetach")
        aboutPresenter.detachScreen()
        super.onDetach()
    }

    override fun onResume() {
        super.onResume()
        aboutPresenter.getAbout()
    }

    override fun showAbout(about: About) {
        tvName.text = about.name
        tvNeptun.text = about.neptun
        tvVersion.text = about.appVersion
    }

}