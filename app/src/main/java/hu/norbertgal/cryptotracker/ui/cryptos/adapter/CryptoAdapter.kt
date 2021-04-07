package hu.norbertgal.cryptotracker.ui.cryptos.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.norbertgal.cryptotracker.model.CryptoPreview

class CryptoAdapter(val context: Context) : RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {

    var cryptoList = mutableListOf<CryptoPreview>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    inner class ViewHolder(cryptoView: View) : RecyclerView.ViewHolder(cryptoView) {

    }

}