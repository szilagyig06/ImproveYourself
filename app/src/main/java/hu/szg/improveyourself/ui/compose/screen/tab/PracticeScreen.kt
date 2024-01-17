package hu.szg.improveyourself.ui.compose.screen.tab

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import hu.szg.improveyourself.R
import hu.szg.improveyourself.models.CardModel
import hu.szg.improveyourself.ui.theme.ImproveYourselfTheme

@Composable
fun PracticeScreen() {

    ImproveYourselfTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(5.dp))
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {

//            Card()

//                Recycler()
        }
    }
}

@Composable
fun Recycler(cards : List<CardModel>) {

}


@Composable
fun ListItem(card: CardModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = card.content ?: "Nincs megadva")
                    Text(text = card.meaning ?: "Nincs megadva")
                }
            }

        }
    }
}

@Composable
fun Card() {
    val isFlipped = remember {
        mutableStateOf(false)
    }

    var text = Text(
        text = stringResource(id = R.string.menu_item_pracitce),
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        fontWeight = FontWeight.Bold
    )

    var box = Box(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 250.dp)
            .background(Color.Yellow)
            .clickable(onClick = {
                isFlipped.value = !isFlipped.value
            }),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.menu_item_pracitce),
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
    }

    val front = ObjectAnimator.ofFloat(box, "scaleX", 1f, 0f)
    val back = ObjectAnimator.ofFloat(box, "scaleX", 0f, 1f)

    if(isFlipped.value) {

    } else {

    }

    front.addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            super.onAnimationEnd(animation)

            back.start()
        }
    })
    front.start()
}
