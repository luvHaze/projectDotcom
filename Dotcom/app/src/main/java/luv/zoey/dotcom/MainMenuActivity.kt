package luv.zoey.dotcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        var fm = supportFragmentManager
        var adapter = MainMenuAdapter(fm)

        adapter.addItem(BlankFragment())

        mainMenu_ViewPager.adapter=adapter

    }

    private inner class MainMenuAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm){

        var fragList = ArrayList<Fragment>()

        fun addItem(frag : Fragment){
            fragList.add(frag)
        }

        override fun getItem(position: Int): Fragment {
            return fragList[position]
        }

        override fun getCount(): Int {
            return fragList.size
        }

    }
}

