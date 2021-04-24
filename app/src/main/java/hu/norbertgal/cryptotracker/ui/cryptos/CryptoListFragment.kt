package hu.norbertgal.cryptotracker.ui.cryptos

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import hu.norbertgal.cryptotracker.R
import hu.norbertgal.cryptotracker.injector
import hu.norbertgal.cryptotracker.model.CryptoPreview
import hu.norbertgal.cryptotracker.ui.ChangeFragmentListener
import hu.norbertgal.cryptotracker.ui.cryptos.adapter.CryptoAdapter
import kotlinx.android.synthetic.main.fragment_crypto_list.*
import javax.inject.Inject

class CryptoListFragment(private val changeFragmentListener: ChangeFragmentListener) : Fragment(),
    CryptoListScreen {

    @Inject
    lateinit var cryptoListPresenter: CryptoListPresenter
    lateinit var cryptoAdapter: CryptoAdapter
    private val displayedCryptos: MutableList<CryptoPreview> = mutableListOf()

    override fun onResume() {
        super.onResume()
        cryptoListPresenter.refreshCryptos(100)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_crypto_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewCryptos.layoutManager = llm

        cryptoAdapter = CryptoAdapter(requireContext(), displayedCryptos, changeFragmentListener)
        recyclerViewCryptos.adapter = cryptoAdapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        cryptoListPresenter.attachScreen(this)
        Log.d("CryptoListFragment", "onAttach")
    }

    override fun onDetach() {
        Log.d("CryptoListFragment", "onDetach")
        cryptoListPresenter.detachScreen()
        super.onDetach()
    }

    override fun showCryptos(cryptoList: List<CryptoPreview>?) {
        displayedCryptos.clear()
        if (cryptoList != null) {
            displayedCryptos.addAll(cryptoList)
        }
        cryptoAdapter.notifyDataSetChanged()
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}