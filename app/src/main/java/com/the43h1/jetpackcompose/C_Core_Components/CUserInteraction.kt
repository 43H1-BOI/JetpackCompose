package com.the43h1.jetpackcompose.C_Core_Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import com.the43h1.jetpackcompose.R

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
    // Url Handler
    val urlHandler = LocalUriHandler.current

    // Links
    var urlLinkedIn = "https://www.linkedin.com/in/theabhiog/"
    var urlGithub = "https://github.com/43H1-BOI"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Text(
                text = "Follow Us On ",
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "LinkedIn",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable {
                    urlHandler.openUri(urlLinkedIn)
                }, color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )

            Text(
                text = " and ",
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Github",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable {
                    urlHandler.openUri(urlGithub)
                }, color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        }

    }

}


@Preview(showSystemUi = true)
@Composable
fun PreviewScreen() {
//    SelectableText()
    WorkingLinks()
}

