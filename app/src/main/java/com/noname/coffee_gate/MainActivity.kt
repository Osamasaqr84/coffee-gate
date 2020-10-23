package com.noname.coffee_gate

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.noname.coffee_gate.local.PreferenceHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.custom_toolbare_layout.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var currentNavController: NavController

    private var appBarConfiguration: AppBarConfiguration? = null
    private var drawerLayout: DrawerLayout? = null
    ///  private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        currentNavController = findNavController(R.id.nav_host_container)
        drawerLayout = findViewById(R.id.drawer_layout)
        nav_view.setNavigationItemSelectedListener(this)

        val myNavHostFragment: NavHostFragment = nav_host_container as NavHostFragment
        val inflater = myNavHostFragment.navController.navInflater
        var graph: NavGraph? = null
        if (PreferenceHelper.getUserGroupId() == 2) {
            graph = inflater.inflate(R.navigation.order_reports)
            hideUserActions()
            cart.visibility = View.GONE
        } else
            graph = inflater.inflate(R.navigation.home)

        myNavHostFragment.navController.graph = graph

        menu.setOnClickListener {
            if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                drawerLayout!!.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout!!.openDrawer(GravityCompat.START)
            }
        }

        cart.setOnClickListener {

            findNavController(R.id.nav_host_container).navigate(R.id.cart)
        }

        back.setOnClickListener {

            currentNavController.popBackStack()
        }

    }

    private fun hideUserActions() {
        val menu: Menu = nav_view.getMenu()
     //   menu.findItem(R.id.nav_menus).isVisible = false
        menu.findItem(R.id.nav_favorites).isVisible = false
        menu.findItem(R.id.nav_cart).isVisible = false
        menu.findItem(R.id.nav_profile).isVisible = false

    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        menuItem.setChecked(true)
        drawerLayout?.closeDrawers()
        val id = menuItem.getItemId()

        when (id) {
            R.id.nav_home -> {
                if (PreferenceHelper.getUserGroupId() == 2)
                    currentNavController.popBackStack(R.id.order_reports, true)
                else
                    currentNavController.popBackStack(R.id.home, true)
            }
            R.id.nav_cart ->
                currentNavController.navigate(R.id.cart)
            R.id.nav_favorites ->
                currentNavController.navigate(R.id.favorites)
            R.id.nav_notifications ->
                currentNavController.navigate(R.id.notifications)
            R.id.nav_contact_us ->
                currentNavController.navigate(R.id.contact_us)
            R.id.nav_profile ->
                currentNavController.navigate(R.id.profile)
            R.id.nav_terms_conditions ->
                currentNavController.navigate(R.id.termes)
            R.id.nav_login ->
                currentNavController.navigate(R.id.login)
            R.id.nav_orders -> {
                if (PreferenceHelper.getUserGroupId() == 2)
                    currentNavController.popBackStack(R.id.order_reports, false)
                else
                    currentNavController.popBackStack(R.id.orders, false)
            }
            R.id.nav_settings ->
                currentNavController.navigate(R.id.language)
            R.id.nav_logout ->
                showLogoutConfirmationDialog()

            else ->
                Snackbar.make(this.nav_view, "Not Supported".toString(), Snackbar.LENGTH_SHORT)
        }

        return true
    }


    private fun showLogoutConfirmationDialog() {

        val builder = Dialog(this)
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.setCancelable(true)
        builder.setContentView(R.layout.logout_dialog)
        builder.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val confirmButton = builder.findViewById(R.id.confirmButton) as TextView
        val dismissButton = builder.findViewById(R.id.dismissButton) as TextView
        val close = builder.findViewById(R.id.close) as ImageView
        builder.setTitle("")
        confirmButton.setOnClickListener {
            builder.dismiss()
            PreferenceHelper.setUserGroupId(1)
            val intent = intent
            finish()
            startActivity(intent)
            //viewModel.logout()
        }
        dismissButton.setOnClickListener {
            builder.dismiss()
        }
        close.setOnClickListener {
            builder.dismiss()
        }
        builder.show()
    }


}
