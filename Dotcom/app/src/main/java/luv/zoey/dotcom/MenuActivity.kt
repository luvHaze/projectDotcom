package luv.zoey.dotcom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import luv.zoey.dotcom.fragment.Fragment_CaseSharing
import luv.zoey.dotcom.fragment.Fragment_Matching
import luv.zoey.dotcom.fragment.Fragment_RepairShop
import luv.zoey.dotcom.fragment.menuFragmentAdapter

class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    val fragmentAdapter by lazy { menuFragmentAdapter(supportFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        init()
    }

    private fun init() {
        // [액션바] 초기화 단계
        setSupportActionBar(toolbar)

        toolbar_menu.setOnClickListener {
            drawer_parent.openDrawer(Gravity.LEFT)
        }

        // [페이지뷰] 초기화 단계
        fragmentAdapter.apply {
            addItem(Fragment_Matching())
            addItem(Fragment_CaseSharing())
            addItem(Fragment_RepairShop())
        }

        mainMenu_ViewPager.adapter = fragmentAdapter
        mainMenu_Indicator.setupWithViewPager(mainMenu_ViewPager, true)

        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
        }



    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.myEstimate_navMenu -> {
                Toast.makeText(this, "${item.itemId} Clicked", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.myRepair_navMenu -> {
                Toast.makeText(this, "${item.itemId} Clicked", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.selfCheck_navMenu -> {
                Toast.makeText(this, "${item.itemId} Clicked", Toast.LENGTH_LONG).show()
                return true
            }
        }

        return true
    }

}
