package hu.norbertgal.cryptotracker.ui.cryptos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.norbertgal.cryptotracker.R
import hu.norbertgal.cryptotracker.model.CryptoPreview
import hu.norbertgal.cryptotracker.ui.ChangeFragmentListener
import kotlinx.android.synthetic.main.card_crypto.view.*

class CryptoAdapter(
    val context: Context,
    var cryptoList: List<CryptoPreview>,
    var changeFragmentListener: ChangeFragmentListener
) : RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_crypto, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crypto = cryptoList[position]

        holder.tvCryptoSymbol.text = crypto.symbol
        holder.tvCryptoName.text = crypto.name

        holder.itemView.setOnClickListener {
            changeFragmentListener.onSwitchToNextFragment(crypto.coinMarketCapId)
        }
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    inner class ViewHolder(cryptoView: View) : RecyclerView.ViewHolder(cryptoView) {
        var tvCryptoSymbol: TextView = cryptoView.tvCryptoSymbol
        var tvCryptoName: TextView = cryptoView.tvCryptoName
    }

}