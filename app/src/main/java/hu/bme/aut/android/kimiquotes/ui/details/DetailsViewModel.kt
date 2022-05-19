package hu.bme.aut.android.kimiquotes.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Az applikáció Kimi Raikonnen legszellemesebb idézeteit tartalmazza. Készítette: Tóth Bence (GLVBSB)"
    }
    val text: LiveData<String> = _text
}