package dev.cardoso.cats.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.cardoso.cats.domain.models.CatFactStates
import dev.cardoso.cats.domain.models.Fact
import dev.cardoso.cats.domain.usecases.GetCatRandomFactUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Objects
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCatRandomFactUseCase: GetCatRandomFactUseCase
): ViewModel() {

    private val mutableCatFact = MutableLiveData<CatFactStates>()
    val catFact: LiveData<CatFactStates>
        get() = mutableCatFact


    fun getCatFact() = viewModelScope.launch {
        val catFactStates = getCatRandomFactUseCase()
        withContext(Dispatchers.IO) {
            when (catFactStates) {
                is CatFactStates.Loading -> notifyLoadingState()
                is CatFactStates.CatFactData -> notifyCatFactState(catFactStates.fact)
                is CatFactStates.Error -> notifyErrorState(catFactStates.error)
            }
        }
    }

    private fun notifyLoadingState() {
        mutableCatFact.postValue(CatFactStates.Loading)
    }

    private fun notifyCatFactState(fact: Fact) {
        mutableCatFact.postValue(CatFactStates.CatFactData(fact))
    }

    private fun notifyErrorState(error: Throwable) {
        mutableCatFact.postValue(CatFactStates.Error(error))
    }

}