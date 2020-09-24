package com.example.project.ui.debtors

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project.R

class AddAuthorDialogFragment : Fragment() {

    companion object {
        fun newInstance() = AddAuthorDialogFragment()
    }

    private lateinit var viewModel: AddAuthorDialogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_author_dialog_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddAuthorDialogViewModel::class.java)
        // TODO: Use the ViewModel
    }

}