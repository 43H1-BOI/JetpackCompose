package com.the43h1.jetpackcompose.N_Loading_Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircLoading() {
    var inProgress by remember {
        mutableStateOf(true)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(50.dp)
        ) {
            Button(
                onClick = {
                    inProgress = true
                },
                enabled = !inProgress
            ) {
                Text("Start Loading")
            }

            if (inProgress) {
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    trackColor = MaterialTheme.colorScheme.primary
                )
            }

            Button(
                onClick = {
                    inProgress = false
                },
                enabled = inProgress
            ) {
                Text("Stop Loading")
            }
        }
    }
}

@Composable
fun LinearLoading() {
    var inProgress by remember {
        mutableStateOf(true)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(50.dp)
        ) {
            Button(
                onClick = {
                    inProgress = true
                },
                enabled = !inProgress
            ) {
                Text("Start Loading")
            }

            if (inProgress) {
                LinearProgressIndicator(
                    modifier = Modifier.width(200.dp),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.onPrimary
                )
            }

            Button(
                onClick = {
                    inProgress = false
                },
                enabled = inProgress
            ) {
                Text("Stop Loading")
            }
        }
    }
}

@Composable
fun LinearLoadingWithCount() {
    var inProgress by remember {
        mutableStateOf(false)
    }

    var count by remember {
        mutableIntStateOf(0)
    }

    if (count !in 0..5) {
        count = 0
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(50.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        inProgress = true
                    },
                    enabled = !inProgress
                ) {
                    Text("Start Loading")
                }

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Button(
                        onClick = { count++ },
                        enabled = count >= 0 && inProgress,
                        modifier = Modifier
                            .padding(5.dp)
                    ) {
                        Icon(Icons.Default.KeyboardArrowUp, "Remove Progress")
                    }

                    Button(
                        onClick = { count-- },
                        enabled = count > 0 && inProgress,
                        modifier = Modifier
                            .padding(5.dp)
                    ) {
                        Icon(Icons.Default.KeyboardArrowDown, "Add Progress")
                    }
                }
            }


            if (inProgress) {
                LinearProgressIndicator(
                    progress = {
                        when (count) {
                            0 -> 0f
                            1 -> 0.2f
                            2 -> 0.4f
                            3 -> 0.6f
                            4 -> 0.8f
                            5 -> 1f
                            else -> 0f
                        }
                    },
                    modifier = Modifier.width(200.dp),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.onPrimary,
                    strokeCap = StrokeCap.Butt,
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (count >= 0)
                    Text(
                        "Count = $count",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                Button(
                    onClick = {
                        inProgress = false
                    },
                    enabled = inProgress
                ) {
                    Text("Stop Loading")
                }
            }
        }
    }
}

@Composable
fun EverythingCombined() {
    var inProgress by remember {
        mutableStateOf(false)
    }

    var count by remember {
        mutableIntStateOf(0)
    }

    if (count !in 0..5) {
        count = 0
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(50.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        inProgress = true
                    },
                    enabled = !inProgress
                ) {
                    Text("Start Loading")
                }

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Button(
                        onClick = { count++ },
                        enabled = count >= 0 && inProgress,
                        modifier = Modifier
                            .padding(5.dp)
                    ) {
                        Icon(Icons.Default.KeyboardArrowUp, "Remove Progress")
                    }

                    Button(
                        onClick = { count-- },
                        enabled = count > 0 && inProgress,
                        modifier = Modifier
                            .padding(5.dp)
                    ) {
                        Icon(Icons.Default.KeyboardArrowDown, "Add Progress")
                    }
                }
            }


            if (inProgress) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(64.dp),
                        color = MaterialTheme.colorScheme.onPrimary,
                        trackColor = MaterialTheme.colorScheme.primary
                    )

                    LinearProgressIndicator(
                        modifier = Modifier.width(200.dp),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.onPrimary
                    )

                    LinearProgressIndicator(
                        progress = {
                            when (count) {
                                0 -> 0f
                                1 -> 0.2f
                                2 -> 0.4f
                                3 -> 0.6f
                                4 -> 0.8f
                                5 -> 1f
                                else -> 0f
                            }
                        },
                        modifier = Modifier.width(200.dp),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.onPrimary,
                        strokeCap = StrokeCap.Butt,
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (count >= 0)
                    Text(
                        "Count = $count",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                Button(
                    onClick = {
                        inProgress = false
                    },
                    enabled = inProgress
                ) {
                    Text("Stop Loading")
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun CircPreview() {
//    CircLoading()
//    LinearLoading()
//    LinearLoadingWithCount()
    EverythingCombined()
}