package ru.maksewsha.absmovies.presentation

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.maksewsha.absmovies.R
import ru.maksewsha.absmovies.databinding.ActivityMainBinding
import ru.maksewsha.absmovies.presentation.fragments.*
import ru.maksewsha.absmovies.presentation.viewmodelfactories.SearchViewModelFactory
import ru.maksewsha.absmovies.presentation.viewmodels.SearchViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView

    private lateinit var searchViewModel: SearchViewModel

    private var selectedItemBottomNav = R.id.app_menu_btn_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        bottomNav = viewBinding.appBottomNav

        searchViewModel =
            ViewModelProvider(this, SearchViewModelFactory())[SearchViewModel::class.java]

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, StartFragment(), "StartFragment")
            .commit()
        bottomNav.visibility = View.INVISIBLE

        bottomNav.setOnItemSelectedListener {
            selectedItemBottomNav = it.itemId
            when (it.itemId) {
                R.id.app_menu_btn_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SearchFragment(), "SearchFragment")
                        .addToBackStack("SearchFragment")
                        .commit()
                    true
                }
                R.id.app_menu_btn_favorite -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FavoriteFragment(), "FavoriteFragment")
                        .addToBackStack("FavoriteFragment")
                        .commit()
                    true
                }
                R.id.app_menu_btn_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SettingsFragment(), "SettingsFragment")
                        .addToBackStack("SettingsFragment")
                        .commit()
                    true
                }
                else -> {
                    true
                }
            }
        }


//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, SearchFragment(), "SearchFragment")
//            .commit()
    }
}
