package com.example.project.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.project.R
import com.example.project.databinding.ActivityLoginBinding
import com.example.project.databinding.ActivityMainBinding
import com.example.project.ui.Auth.AuthViewModel
import com.example.project.ui.Auth.AuthViewModelFactory
import com.example.project.ui.Auth.LoginActivity
import com.example.project.utils.Coroutines
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Job
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    private lateinit var job: Job
    private lateinit var viewModel: AuthViewModel
    private lateinit var binding: ActivityMainBinding

    private val factory: AuthViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.lifecycleOwner = this


        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        val navController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupWithNavController(nav_view, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.fragment),
            drawer_layout
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.action_logout -> {
                AlertDialog.Builder(this).also { alertDialogBuilder ->
                    alertDialogBuilder.setTitle("Are you sure you want to Logout?")
                    alertDialogBuilder.setPositiveButton("Yes") { _, _ ->
                        job = Coroutines.io {
                            viewModel.logout()

                            viewModel.getCurrentUser().observe(this, Observer {
                                if (it == null)
                                    Intent(this@MainActivity, LoginActivity::class.java).also {
                                        it.flags =
                                            Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                        startActivity(it)
                                    }
                            })

                        }
                    }
                    alertDialogBuilder.setNegativeButton("Cancel") { _, _ -> }
                }.create().show()
                return true
            }
            else -> {
                return false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::job.isInitialized) job.cancel()
    }

}