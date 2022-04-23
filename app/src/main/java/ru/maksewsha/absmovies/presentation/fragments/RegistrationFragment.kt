package ru.maksewsha.absmovies.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import ru.maksewsha.absmovies.R
import ru.maksewsha.absmovies.databinding.FragmentRegBinding
import ru.maksewsha.absmovies.presentation.utils.checkValid
import ru.maksewsha.absmovies.presentation.viewmodels.RegistrationViewModel

class RegistrationFragment: Fragment(R.layout.fragment_reg) {
    private var _binding: FragmentRegBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: RegistrationViewModel

    private lateinit var btnReg: Button
    private lateinit var editEmail: EditText
    private lateinit var editPass: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
        btnReg = binding.btnRegister
        editEmail = binding.emailEditText
        editPass = binding.passwordEditText

        btnReg.setOnClickListener {
            if (!checkValid(editEmail, editPass)) Snackbar.make(binding.root, R.string.required_information, Snackbar.LENGTH_SHORT).show()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}