package hu.szg.improveyourself.ui.compose.screen.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import hu.szg.improveyourself.models.CardModel
import hu.szg.improveyourself.models.ui.CardItem
import hu.szg.improveyourself.models.ui.MenuItem
import hu.szg.improveyourself.ui.theme.ImproveYourselfTheme
import androidx.compose.material3.*

@Composable
fun CardScreen(navController: NavController) {
    ImproveYourselfTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                content = {
                    items(MenuItem.Items.list.size) { i ->
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color.Gray)
//                                .clickable(onClick = onClick)
                                .clickable { navController.navigate("new_card_screen") },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = stringResource(id = CardItem.Items.list[i].title),
                                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                }
            )
        }
    }
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Green),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = stringResource(id = R.string.menu_item_card),
//            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
//            fontWeight = FontWeight.Bold
//        )
//    }
}

