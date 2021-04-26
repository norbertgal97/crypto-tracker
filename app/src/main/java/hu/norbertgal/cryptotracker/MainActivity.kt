package hu.norbertgal.cryptotracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import hu.norbertgal.cryptotracker.ui.ChangeFragmentListener
import hu.norbertgal.cryptotracker.ui.about.AboutFragment
import hu.norbertgal.cryptotracker.ui.cryptodetails.CryptoDetailsFragment
import hu.norbertgal.cryptotracker.ui.cryptos.CryptoListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var frameLayout: FrameLayout

    private val cryptoListFragment: Fragment =
        CryptoListFragment(object : ChangeFragmentListener {
            override fun onSwitchToNextFragment(id: Long) {
                replaceFragment(CryptoDetailsFragment(id))
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = tabs
        frameLayout = frameLayoutXml

        replaceFragment(cryptoListFragment)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var fragment: Fragment = cryptoListFragment

                if (tab != null) {
                    when (tab.position) {
                        0 -> fragment = cryptoListFragment
                        1 -> fragment = AboutFragment()
                    }
                }

                replaceFragment(fragment)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                var fragment: Fragment = cryptoListFragment

                if (tab != null) {
                    when (tab.position) {
                        0 -> fragment = cryptoListFragment
                        1 -> fragment = AboutFragment()
                    }
                }

                replaceFragment(fragment)
            }

        })
    }

    private fun replaceFragment(fragment: Fragment) {
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.frameLayoutXml, fragment)
        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        trans.commit()
    }
}