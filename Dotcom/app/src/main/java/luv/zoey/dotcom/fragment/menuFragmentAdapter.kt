package luv.zoey.dotcom.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

private const val NUM_PAGES = 3

class menuFragmentAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

    private var fragList = arrayListOf<Fragment>()

    override fun getItem(position: Int): Fragment {
        return fragList[position]
    }

    override fun getCount(): Int {
        return NUM_PAGES
    }

    fun addItem(fragment:Fragment){
        fragList.add(fragment)
    }
}