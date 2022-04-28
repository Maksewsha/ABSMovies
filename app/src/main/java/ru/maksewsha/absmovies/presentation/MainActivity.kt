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
import ru.maksewsha.absmovies.presentation.fragments.RegistrationFragment
import ru.maksewsha.absmovies.presentation.fragments.SearchFragment
import ru.maksewsha.absmovies.presentation.fragments.StartFragment
import ru.maksewsha.absmovies.presentation.viewmodelfactories.SearchViewModelFactory
import ru.maksewsha.absmovies.presentation.viewmodels.SearchViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView
    private var backCount = 0

    private lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        searchViewModel = ViewModelProvider(this, SearchViewModelFactory())[SearchViewModel::class.java]

        bottomNav = viewBinding.appBottomNav
//        bottomNav.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.app_menu_btn_search -> {
//                    if (supportFragmentManager.findFragmentById(R.id.fragment))
//                }
//                R.id.app_menu_btn_favorite -> {
//
//                }
//                R.id.app_menu_btn_settings -> {
//
//                }
//            }
//        }

        //bottomNav.visibility = View.INVISIBLE
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SearchFragment(), "SearchFragment")
            .commit()
    }
}
