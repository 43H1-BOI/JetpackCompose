package com.the43h1.jetpackcompose.B_Fundamentals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the43h1.jetpackcompose.R

@Composable
fun AccessResources(){
    // Kind of Container
    Box(
        // Used to modify layout
        // fill whole screen
        modifier = Modifier.fillMaxSize(),

        // to Align Content
        // where does the object is placed
        contentAlignment = Alignment.Center
    ){
        Text(text = "Owner Name = ${stringResource(R.string.owner)}",
            // Added Color
            color = colorResource(R.color.mera_color)
        )
    }
}

@Composable
fun AccessImages(){
    Box(modifier=Modifier.fillMaxHeight().padding(20.dp),
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(R.drawable.palm),
            // must give value else will give error
            contentDescription = null)
    }
}


// Using locale = "hi-rIN" for hindi string
@Preview(showSystemUi = true, locale = "hi-rIN")
@Composable
fun AccessResourcesPreview(){
   AccessResources()
//    AccessImages()
}