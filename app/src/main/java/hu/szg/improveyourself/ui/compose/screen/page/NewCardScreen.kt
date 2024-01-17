package hu.szg.improveyourself.ui.compose.screen.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import hu.szg.improveyourself.R
import hu.szg.improveyourself.models.CardModel
import hu.szg.improveyourself.ui.compose.screen.page.viewModel.NewCardViewModel
import hu.szg.improveyourself.ui.theme.ImproveYourselfTheme

@Composable
fun NewCardScreen(
    viewModel: NewCardViewModel = hiltViewModel()
) {
    val cards by viewModel.getCards().observeAsState()
//    val cards by viewModel.getCardsFlow().collectAsState(initial = emptyList())

    ImproveYourselfTheme {
        Column {
            TextFieldView(viewModel)
            cards?.let { Recycler(cards = it) }
        }
    }
}

@Composable
fun TextFieldView(viewModel: NewCardViewModel) {
    var content by remember { mutableStateOf(viewModel.content) }
    var meaning by remember { mutableStateOf(viewModel.meaning) }
    var explanation by remember { mutableStateOf(viewModel.explanation) }
    var example by remember { mutableStateOf(viewModel.example) }

    Box(
        modifier = Modifier
            .padding(10.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            TextField(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                value = content,
                onValueChange = {
                    content = it
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.card_content))
                }
            )
            TextField(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                value = meaning,
                onValueChange = {
                    meaning = it
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.card_meaning))
                }
            )
            TextField(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                value = explanation,
                onValueChange = {
                    explanation = it
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.card_explanation))
                }
            )
            TextField(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                value = example,
                onValueChange = {
                    example = it
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.card_example))
                }
            )
            ElevatedButton(
                modifier = Modifier
                    .align(Alignment.End),
                shape = RoundedCornerShape(5.dp),
                onClick = {
                    viewModel.saveCard(CardModel(
                        content =  content,
                        meaning =  meaning,
                        explanation = explanation,
                        example = example
                    ))
                }
            ) {
                Text(text = stringResource(id = R.string.card_save))
            }
        }
    }
}

@Composable
fun Recycler(cards : List<CardModel>) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = cards) { card ->
            ListItem(card = card)
        }
    }
}


@Composable
fun ListItem(card: CardModel) {
    val type = card.type?.type?.let { stringResource(id = it) } ?: "Nincs megadva"
    val content = card.content ?: "Nincs megadva"
    val meaning = card.meaning ?: "Nincs megadva"
    val explanation = card.explanation ?: "Nincs megadva"
    val example = card.example ?: "Nincs megadva"

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onBackground
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(color = MaterialTheme.colorScheme.onPrimary)
                        .clip(RoundedCornerShape(5.dp))
                ) {
                    Text(text = "${stringResource(id = R.string.card_type)}: $type", color = MaterialTheme.colorScheme.primary)
                    Text(text = "${stringResource(id = R.string.card_content)}: $content", color = MaterialTheme.colorScheme.primary)
                    Text(text = "${stringResource(id = R.string.card_meaning)}: $meaning", color = MaterialTheme.colorScheme.primary)
                    Text(text = "${stringResource(id = R.string.card_explanation)}: $explanation", color = MaterialTheme.colorScheme.primary)
                    Text(text = "${stringResource(id = R.string.card_example)}: $example", color = MaterialTheme.colorScheme.primary)
                }
            }

        }
    }
}

//@Composable
//@Preview
//fun Preview() {
//    NewCardScreen()
//}