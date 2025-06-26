package com.the43h1.jetpackcompose.Z_Extras.Constraint_Layout

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.the43h1.jetpackcompose.ui.theme.Black
import com.the43h1.jetpackcompose.ui.theme.Blue
import com.the43h1.jetpackcompose.ui.theme.Green
import com.the43h1.jetpackcompose.ui.theme.Pink80
import com.the43h1.jetpackcompose.ui.theme.Red

@Composable
fun ConstraintsEx(modifier: Modifier = Modifier) {
    val redB = ConstrainedLayoutReference("Red")
    val greenB = ConstrainedLayoutReference("Green")
    val blueB = ConstrainedLayoutReference("Blue")
    val pinkB = ConstrainedLayoutReference("Pink")

    ConstraintLayout {
        Button(
            modifier = Modifier.constrainAs(redB) {
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.value(30.dp)
            },
            onClick = {},
            colors = ButtonColors(
                containerColor = Red,
                contentColor = Black,
                disabledContainerColor = Black,
                disabledContentColor = Red
            )
        ) {
            Text("Red")
        }


        Button(
            modifier = Modifier.constrainAs(greenB) {
                top.linkTo(redB.bottom)
                bottom.linkTo(blueB.top)
                width = Dimension.value(60.dp)
                height = Dimension.wrapContent
            },
            onClick = {},
            colors = ButtonColors(
                containerColor = Green,
                contentColor = Black,
                disabledContainerColor = Black,
                disabledContentColor = Green
            )
        ) {
            Text("Green")
        }


        Button(
            modifier = Modifier.constrainAs(blueB) {
                top.linkTo(blueB.bottom)
                bottom.linkTo(pinkB.top)
                width = Dimension.wrapContent
                height = Dimension.value(30.dp)
            },
            onClick = {},
            colors = ButtonColors(
                containerColor = Blue,
                contentColor = Black,
                disabledContainerColor = Black,
                disabledContentColor = Blue
            )
        ) {
            Text("Blue")
        }


        Button(
            modifier = Modifier.constrainAs(pinkB) {
                top.linkTo(pinkB.bottom)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
                height = Dimension.value(30.dp)
            },
            onClick = {},
            colors = ButtonColors(
                containerColor = Pink80,
                contentColor = Black,
                disabledContainerColor = Black,
                disabledContentColor = Pink80
            )
        ) {
            Text("Pink")
        }
    }
}

@Preview
@Composable
private fun ConstraintsPreview() {
    Surface {
        ConstraintsEx()
    }
}

/** Constraint Layout is Used To Link Elements to Each Other
 *      We Must Have to implement Dependency for Constraint Layout to use them
 *
 * -> Create reference using
 *      val ref = ConstrainedLayoutReference("refName")
 *
 * -> Add constrainAs(refName){
 *      // methods for constrain layout
 *       }
 *
 * -> use linkTo() property to link element
 *      - top
 *      - bottom
 *      - start
 *      - end
 *
 *
 * ->
 *
 *
 *
 */