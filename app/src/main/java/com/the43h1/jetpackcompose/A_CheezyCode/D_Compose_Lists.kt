package com.the43h1.jetpackcompose.A_CheezyCode

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the43h1.jetpackcompose.R

@Composable
fun BlogContent(
    imgId: Int,
    imgDesc: String? = null,
    title: String,
    subtitle: String,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray, shape = RectangleShape)
                .padding(8.dp)
        ) {
            // Image of Contact
            Image(
                painter = painterResource(imgId),
                contentDescription = imgDesc,
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
            BlogDetails(
                title, subtitle,
                Modifier.padding(start = 8.dp)
            )
        }
    }
}

fun getCategoryItems(): MutableList<CategoryItem> {
    var items = mutableListOf<CategoryItem>()

    items.add(CategoryItem(R.drawable.pfp_4_car, "Car 4", "Car 4", "Car 4 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_44_car, "Car 44", "Car 44", "Car 44 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_48_car, "Car 48", "Car 48", "Car 48 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_40_super, "Super 40", "Super 40", "Super 40 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_24_car, "Car 24", "Car 24", "Car 24 - Subtitle"))

    items.add(CategoryItem(R.drawable.pfp_4_car, "Car 4", "Car 4", "Car 4 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_44_car, "Car 44", "Car 44", "Car 44 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_48_car, "Car 48", "Car 48", "Car 48 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_40_super, "Super 40", "Super 40", "Super 40 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_24_car, "Car 24", "Car 24", "Car 24 - Subtitle"))

    items.add(CategoryItem(R.drawable.pfp_4_car, "Car 4", "Car 4", "Car 4 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_44_car, "Car 44", "Car 44", "Car 44 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_48_car, "Car 48", "Car 48", "Car 48 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_40_super, "Super 40", "Super 40", "Super 40 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_24_car, "Car 24", "Car 24", "Car 24 - Subtitle"))

    items.add(CategoryItem(R.drawable.pfp_4_car, "Car 4", "Car 4", "Car 4 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_44_car, "Car 44", "Car 44", "Car 44 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_48_car, "Car 48", "Car 48", "Car 48 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_40_super, "Super 40", "Super 40", "Super 40 - Subtitle"))
    items.add(CategoryItem(R.drawable.pfp_24_car, "Car 24", "Car 24", "Car 24 - Subtitle"))

    return items
}

data class CategoryItem(
    var imgId: Int,
    var imgDesc: String?,
    var title: String,
    var subtitle: String
)

@Composable
fun BlogDetails(title: String, subtitle: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        // Title of Blog
        Text(
            title,
            style = MaterialTheme.typography.titleMedium,
        )
        // Subtitle of Blog
        Text(
            subtitle,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Light,
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewBlog() {
    // Not a Good Practice As it may render all elements of UI at Once
    // Means will reduce performance od system
    /*
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        getCategoryItems().map { item ->
            item.apply {
                BlogContent(
                    title = title,
                    subtitle = subtitle,
                    imgId = imgId,
                    imgDesc = imgDesc,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
    */

    // Considered as a Good Practice
    // B'Coz only +1 item get loaded when UI renders and makes it resource friendly
    val itemsList = remember { getCategoryItems() }

    LazyColumn {
        items(itemsList.count()) { index ->
            itemsList[index].apply {
                BlogContent(
                    imgId = imgId,
                    imgDesc = imgDesc,
                    title = title,
                    subtitle = subtitle,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }

}