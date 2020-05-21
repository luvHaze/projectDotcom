package luv.zoey.dotcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_menu.*
import luv.zoey.dotcom.fragment.Fragment_CaseSharing
import luv.zoey.dotcom.fragment.Fragment_Matching
import luv.zoey.dotcom.fragment.Fragment_RepairShop
import luv.zoey.dotcom.fragment.menuFragmentAdapter

class MenuActivity : AppCompatActivity() {

    val toolbar by lazy {
        findViewById<Toolbar>(R.id.toolbar)
    }
    val fragmentAdapter by lazy {
        menuFragmentAdapter(supportFragmentManager)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        init()

    }

    private fun init(){
        // [액션바] 초기화 단계
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        supportActionBar?.setDisplayShowTitleEnabled(false)


        // [페이지뷰] 초기화 단계
        fragmentAdapter.apply {
            addItem(Fragment_Matching())
            addItem(Fragment_CaseSharing())
            addItem(Fragment_RepairShop())
        }

        mainMenu_ViewPager.adapter=fragmentAdapter
        mainMenu_Indicator.setupWithViewPager(mainMenu_ViewPager,true)
    }
}
