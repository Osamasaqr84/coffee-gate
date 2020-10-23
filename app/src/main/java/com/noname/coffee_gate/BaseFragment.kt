package com.noname.coffee_gate

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


abstract class BaseFragment : Fragment() {



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    abstract fun layoutId(): Int

    /* val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
         (activity?.application as App).appComponent
     }
     */


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(layoutId(), container, false)

    open fun onBackPressed() {}

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val destination = findNavController().currentDestination?.id
//        if (destination in Constants.HOME_FRAGMENTS) {
//            val appBarConfiguration = AppBarConfiguration
//                .Builder(destination!!)
//                .build()
//            toolbar?.setupWithNavController(findNavController(), appBarConfiguration)
//            tv_title?.text = toolbar.title
//        } else {
//            destination?.let { dest ->
//                if (dest !in Constants.CUSTOM_TOOLBAR_FRAGMENTS) {
//                    val appBarConfiguration = AppBarConfiguration
//                        .Builder(dest)
//                        .build()
//                    toolbar?.setupWithNavController(findNavController(), appBarConfiguration)
//                    tv_title?.text = toolbar.title
//                    iv_back?.setSafeOnClickListener { findNavController().popBackStack() }
//                }
//            }
//
//        }

    }



//    protected fun setProgress(visibility: Int) {
//        progress?.visibility = visibility
//    }



    protected fun showErrorDialog(view: View, message: String) {
//        try {
//            val intent = Intent(activity, ErrorHandlingAct::class.java)
//            intent.putExtra(ErrorHandlingAct.MESSAGE_HOLDER, message)
//            startActivity(intent)
//        } catch (e: Exception) {
//            println("Error in showErrorDialog : " + e.message)
//        }
    }

//    protected fun showCustomTopMessage(message: String, mMessageType: DialogUtil.MessageType) {
//        if (activity != null) DialogUtil().showCustomDialog(activity!!, true, message, mMessageType)
//    }

}