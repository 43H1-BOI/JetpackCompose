package com.the43h1.jetpackcompose.O_Search_Bar_In

import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun SimpleSearchBar(modifier: Modifier = Modifier) {
    var searchBarState = rememberTextFieldState()

    var searchResults = remember {
        mutableStateListOf<String>("")
    }

    var onSearch: (String) -> Unit = { query ->
        searchResults.addAll(
            listOf(
                "result 1 of $query",
                "result 2 of $query",
                "result 3 of $query"
            )
        )
    }

}