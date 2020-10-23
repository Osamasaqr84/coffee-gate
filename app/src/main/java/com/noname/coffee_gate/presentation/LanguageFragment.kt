package com.noname.coffee_gate.presentation

import android.content.res.Resources
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.noname.coffee_gate.BaseFragment

import com.noname.coffee_gate.R
import com.noname.coffee_gate.local.PreferenceHelper
import kotlinx.android.synthetic.main.language_fragment.*
import java.util.*

class LanguageFragment : BaseFragment() {

    companion object {
        fun newInstance() = LanguageFragment()
    }

    private lateinit var viewModel: LanguageViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (PreferenceHelper.getCurrentLang() == "ar")
            arabic.isChecked = true
        else
            english.isChecked = true

        arabic.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                changeLanguage("ar")
            }
        }

        english.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                changeLanguage("en")
            }
        }
    }

    private fun changeLanguage(lang: String) {
        val resources: Resources = this.requireContext().resources
        val displayMetrics = resources.displayMetrics
        val configuration = resources.configuration
        configuration.setLocale(Locale(lang, "US"))
        resources.updateConfiguration(configuration, displayMetrics)

        PreferenceHelper.getROOMID()
        val intent = requireActivity().intent
        requireActivity().finish()
        requireActivity().startActivity(intent)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LanguageViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun layoutId(): Int {
        return R.layout.language_fragment
    }

}
