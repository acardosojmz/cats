package dev.cardoso.cats.ui.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CatFactButton(codeForOnClick: () -> Unit){
    Button(onClick = codeForOnClick) {
        Text(text = "Get a Cat Fact!")
    }
}