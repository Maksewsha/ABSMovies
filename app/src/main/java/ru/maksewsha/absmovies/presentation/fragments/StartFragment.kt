package ru.maksewsha.absmovies.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.maksewsha.absmovies.R
import ru.maksewsha.absmovies.databinding.FragmentStartBinding

class StartFragment : Fragment(R.layout.fragment_start) {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    private lateinit var btnReg: Button
    private lateinit var btnLog: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnReg = binding.btnRegister
        btnLog = binding.btnLogin

        btnReg.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RegistrationFragment(), "RegistrationFragment")
                .addToBackStack("RegistrationFragment").commit()
        }

        btnLog.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AuthFragment(), "AuthFragment")
                .addToBackStack("AuthFragment").commit()
        }

        super.onViewCreated(view, savedInstanceState)
    }
}