package luv.zoey.dotcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_menu.*
import luv.zoey.dotcom.fragment.Fragment_CaseSharing
import luv.zoey.dotcom.fragment.Fragment_Matching
import luv.zoey.dotcom.fragment.Fragment_RepairShop
import luv.zoey.dotcom.fragment.menuFragmentAdapter

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        var fragmentAdapter = menuFragmentAdapter(supportFragmentManager)
            .apply {
            addItem(Fragment_CaseSharing())
            addItem(Fragment_Matching())
            addItem(Fragment_RepairShop())
            }
        mainMenu_ViewPager.adapter=fragmentAdapter

    }
}
