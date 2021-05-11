package hu.norbertgal.cryptotracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import hu.norbertgal.cryptotracker.ui.ChangeFragmentListener
import hu.norbertgal.cryptotracker.ui.about.AboutFragment
import hu.norbertgal.cryptotracker.ui.cryptodetails.CryptoDetailsFragment
import hu.norbertgal.cryptotracker.ui.cryptos.CryptoListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var frameLayout: FrameLayout
    private lateinit var firebaseAnalytics: FirebaseAnalytics

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
        firebaseAnalytics = Firebase.analytics

        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.METHOD, "facebook")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, bundle)

        replaceFragment(cryptoListFragment)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var fragment: Fragment = cryptoListFragment

                if (tab != null) {
                    when (tab.position) {
                        0 -> {
                            fragment = cryptoListFragment
                            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
                                param(FirebaseAnalytics.Param.ITEM_ID, 1)
                                param(FirebaseAnalytics.Param.ITEM_NAME, "CryptoList")
                                param(FirebaseAnalytics.Param.CONTENT_TYPE, "Tab")
                            }
                        }
                        1 -> {
                            fragment = AboutFragment()
                            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
                                param(FirebaseAnalytics.Param.ITEM_ID, 2)
                                param(FirebaseAnalytics.Param.ITEM_NAME, "About")
                                param(FirebaseAnalytics.Param.CONTENT_TYPE, "Tab")
                            }
                            throw Exception()
                        }
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
                        0 -> {
                            fragment = cryptoListFragment
                            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
                                param(FirebaseAnalytics.Param.ITEM_ID, 1)
                                param(FirebaseAnalytics.Param.ITEM_NAME, "CryptoList")
                                param(FirebaseAnalytics.Param.CONTENT_TYPE, "Tab")
                            }
                        }
                        1 -> {
                            fragment = AboutFragment()
                            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
                                param(FirebaseAnalytics.Param.ITEM_ID, 2)
                                param(FirebaseAnalytics.Param.ITEM_NAME, "About")
                                param(FirebaseAnalytics.Param.CONTENT_TYPE, "Tab")
                            }
                        }
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