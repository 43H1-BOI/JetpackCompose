package com.the43h1.jetpackcompose.C_Core_Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// For User Interaction

@Composable
fun SelectableText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        SelectionContainer() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("This is 1st Text")
                Text("This is 2nd Text")
                Text("This is 3rd Text")
                Text("This is 4th Text")
                Text("This is 5th Text")

                // This Text is Non Selectable
                DisableSelection {
                    Text("This is 1st Unselectable Text")
                    Text("This is 2nd Unselectable Text")
                    Text("This is 3rd Unselectable Text")
                }
            }
        }
    }
}

@Composable
fun WorkingLinks() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        var uriHandler = LocalUriHandler.current

        Text(
            buildAnnotatedString {
                append("Follow us on ")

                val link = LinkAnnotation.Url(
                    "",
                    TextLinkStyles(
                        SpanStyle(
                            color = colorResource(R.color.mera_color)
                        )
                    )
                ) {
                    val url = (it by LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }


            }
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewScreen() {
    SelectableText()
}

