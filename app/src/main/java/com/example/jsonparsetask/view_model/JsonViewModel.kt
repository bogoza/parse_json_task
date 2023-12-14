package com.example.jsonparsetask.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jsonparsetask.data_model.Input
import com.example.jsonparsetask.data_model.InputList
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.Exception

class JsonViewModel:ViewModel() {

    private val _parseData = MutableLiveData<List<List<Input>>>()
    val parseData: LiveData<List<List<Input>>> get() = _parseData
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val inputListAdapter: JsonAdapter<InputList> =
        moshi.adapter(InputList::class.java)

    fun parseJson(jsonString: String){
        try {
            val inputList: InputList? = inputListAdapter.fromJson(jsonString)
            _parseData.value = inputList?.inputs
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}