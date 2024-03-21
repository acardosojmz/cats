package dev.cardoso.cats.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import dev.cardoso.cats.domain.models.CatFactStates
import dev.cardoso.cats.presentation.ui.composables.CatFactCard


@Composable
fun CatFactScreen(
    catFact: LiveData<CatFactStates>,
    onClick: () -> Unit
) {
    val catFactStates: CatFactStates
            by catFact.observeAsState(initial = CatFactStates.Loading)

    when (catFactStates) {
        is CatFactStates.Loading -> CatFactCard(
            text = "Click to Get a Cat Fact!",
            onClick = onClick)
        is CatFactStates.CatFactData -> CatFactCard(
            text = (catFactStates as CatFactStates.CatFactData).fact.text,
            onClick = onClick)
        else -> CatFactCard(text = "Nothing to show", onClick={})
    }
}

