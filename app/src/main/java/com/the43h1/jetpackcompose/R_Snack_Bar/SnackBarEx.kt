package com.the43h1.jetpackcompose.R_Snack_Bar

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.InstallMobile
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun SnackbarEx0() {
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Message Deleted",
                        actionLabel = "Undo",
                        withDismissAction = true,
                        duration = SnackbarDuration.Short
                    )
                }
            }
        ) {
            Text("Show SnackBar")
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier,
            snackbar = { Text("Hello World") }
        )
    }
}

// Main Bar
@Composable
fun SnackBarEx(modifier: Modifier = Modifier) {
    var snackbarHostState = remember {
        SnackbarHostState()
    }

    val coroutineScope = rememberCoroutineScope()

    val context = LocalContext.current.applicationContext


    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        var result = snackbarHostState.showSnackbar(
                            message = "Installing",
                            actionLabel = "Undo",
                            withDismissAction = true,
                            duration = SnackbarDuration.Short
                        )

                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                Toast.makeText(
                                    context,
                                    "Cancelled Installation",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            SnackbarResult.Dismissed -> {
                                Toast.makeText(context, "Snackbar Closed", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                }
            ) {
                Icon(Icons.Default.InstallMobile, "")
                Spacer(modifier = Modifier.width(4.dp))
                Text("Install")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

        }
    }
}

@Preview
@Composable
private fun SnackBarPreview() {
    Surface {
        SnackBarEx()
    }
}