package com.example.jsonparsetask.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.jsonparsetask.Base.BaseFragment
import com.example.jsonparsetask.R
import com.example.jsonparsetask.databinding.FragmentRegistrationBinding
import com.example.jsonparsetask.view_model.JsonViewModel
import org.json.JSONStringer

class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>(FragmentRegistrationBinding::inflate){
    private val jsonViewModel : JsonViewModel by viewModels()
    override fun start() {
        val resourceId = resources.getIdentifier("data","raw",requireContext().packageName)
        val jsonString = readJsonFile(resourceId)

        jsonViewModel.parseJson(jsonString)

        jsonViewModel.parseData.observe(viewLifecycleOwner) { parsedData ->
        }


    }

    private fun readJsonFile(resourceId: Int): String {
        val inputStream = resources.openRawResource(resourceId)
        return inputStream.bufferedReader().use { it.readText() }
    }
}
