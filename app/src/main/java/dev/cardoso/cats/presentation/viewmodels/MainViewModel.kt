package dev.cardoso.cats.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.cardoso.cats.domain.models.CatFactStates
import dev.cardoso.cats.domain.models.Fact
import dev.cardoso.cats.domain.usecases.GetCatRandomFactUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCatRandomFactUseCase: GetCatRandomFactUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<CatFactStates>(CatFactStates.Init)
    val uiState: StateFlow<CatFactStates> = _uiState

    init {
        getCatFact()
    }
    fun getCatFact() = viewModelScope.launch {
         val uiStates = getCatRandomFactUseCase().first()
        withContext(Dispatchers.IO) {
            when (uiStates) {
                is CatFactStates.Init -> notifyInitState()
                is CatFactStates.Loading -> notifyLoadingState()
                is CatFactStates.CatFactData -> notifyCatFactState(uiStates.fact)
                is CatFactStates.Error -> notifyErrorState(uiStates.error)

            }
        }
    }

    private fun notifyInitState() {
        _uiState.value= CatFactStates.Init
    }
    private fun notifyLoadingState() {
        _uiState.value = CatFactStates.Loading
    }

    private fun notifyCatFactState(fact: Fact) {
        _uiState.value= CatFactStates.CatFactData(fact)
    }

    private fun notifyErrorState(error: Throwable) {
        _uiState.value= CatFactStates.Error(error)
    }

}