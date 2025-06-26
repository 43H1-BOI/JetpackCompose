package com.the43h1.jetpackcompose.A_Designs

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the43h1.jetpackcompose.ui.theme.Black
import com.the43h1.jetpackcompose.ui.theme.White

@Composable
fun SignUpEx(modifier: Modifier = Modifier) {
    var buttonTapped by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            onClick = { buttonTapped = !buttonTapped },
            modifier = Modifier
                .padding(5.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonColors(
                containerColor = White,
                contentColor = Color.Unspecified,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.LightGray
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(2.dp),
            border = BorderStroke(0.5f.dp, Black),
            contentPadding = ButtonDefaults.TextButtonWithIconContentPadding
        ) {
            Icon(Icons.Default.Email, "Email")

            Spacer(Modifier.width(4.dp))

            Text(text = if (!buttonTapped) "Sign Up With Email" else "Creating Account...")
            if (
                buttonTapped
            ) {
                Spacer(Modifier.width(8.dp))

                CircularProgressIndicator(
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.size(18.dp),
                )
            }
        }
    }
}

@Preview
@Composable
private fun SignupPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        SignUpEx()
    }
}