package com.the43h1.jetpackcompose.I_Dialog_Box

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.the43h1.jetpackcompose.R

// TODO : Learn Dialog Box
@Composable
fun DialogBoxLayout(
    onDismissRequest: () -> Unit,
    onDismissText: String,
    onConfirmation: () -> Unit,
    onConfirmationText: String,
    painter: Painter? = null,
//    icon: Icon? = null,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        if (painter != null) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(160.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

        Text(
            "This is the Dialog",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextButton(
                onClick = { onConfirmation },
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Bottom)
            ) {
                Text(onConfirmationText)
            }

            TextButton(
                onClick = { onDismissRequest },
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Bottom)

            ) {
                Text(onDismissText)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DialogBoxPreview() {
    var context = LocalContext.current

    var isDialogEnabled by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Button(
            onClick = {
                isDialogEnabled = !isDialogEnabled
            }
        ) { Text("Toggle Button") }

        Dialog(
            onDismissRequest = { isDialogEnabled = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = true
            )
        ) {

            DialogBoxLayout(
                onDismissRequest = {
                    isDialogEnabled = false
                    Toast.makeText(context, "You Dismissed the Request", Toast.LENGTH_SHORT).show()
                },
                onDismissText = "Dismiss",
                onConfirmation = {
                    isDialogEnabled = false
                    Toast.makeText(context, "You Confirmed the Request", Toast.LENGTH_SHORT).show()
                },
                onConfirmationText = "Confirm",
                painter = painterResource(R.drawable.github_icon),
                modifier = Modifier
                    .size(300.dp, 500.dp)
                    .padding(15.dp)

            )
        }
    }
}