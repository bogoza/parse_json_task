package com.example.jsonparsetask.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsonparsetask.Base.BaseFragment
import com.example.jsonparsetask.R
import com.example.jsonparsetask.adapter_recycler_view.BackgroundAdapter
import com.example.jsonparsetask.databinding.FragmentRegistrationBinding
import com.example.jsonparsetask.view_model.JsonViewModel
import org.json.JSONStringer

class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>(FragmentRegistrationBinding::inflate){

    private lateinit var backgroundAdapter : BackgroundAdapter

    private val jsonViewModel : JsonViewModel by viewModels()
    override fun start() {
        parseData()
        makeBackground()
    }

    private fun readJsonFile(resourceId: Int): String {
        val inputStream = resources.openRawResource(resourceId)
        return inputStream.bufferedReader().use { it.readText() }
    }
    private fun makeBackground(){
        backgroundAdapter = BackgroundAdapter()
        binding.registrationRv.layoutManager = LinearLayoutManager(requireContext())
    }
    private fun parseData(){
        val resourceId = resources.getIdentifier("data","raw",requireContext().packageName)
        val jsonString = readJsonFile(resourceId)

        jsonViewModel.parseJson(jsonString)

        jsonViewModel.parseData.observe(viewLifecycleOwner) { parsedData ->
        }

    }
}
