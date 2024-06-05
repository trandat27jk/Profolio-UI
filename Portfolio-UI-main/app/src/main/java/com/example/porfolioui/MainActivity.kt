package com.example.porfolioui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.porfolioui.data.Person
import com.example.porfolioui.data.listPeople
import com.example.porfolioui.ui.theme.PorfolioUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PorfolioUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun CreateInfo(modifier: Modifier = Modifier){
    Column(modifier){
        Text(
            text = stringResource(id = R.string.name),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 10.dp),
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = stringResource(id = R.string.job),
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Text(
            text = stringResource(id = R.string.info_contact),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}

@Composable
fun AvatarProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(16.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, color = Color.LightGray),
        shadowElevation = 5.dp

    ) {
        Image(
            painterResource(id = R.drawable.baseline_person_120),
            contentDescription = null,
            modifier = Modifier
                .size(130.dp)
                .padding(10.dp)
        )
    }
}

@Composable
fun CardProfile(person: Person, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
        colors = CardDefaults.cardColors(Color.Transparent),
        border = BorderStroke(1.dp, Color.LightGray)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Surface(
                modifier = Modifier.padding(end = 16.dp),
                shape = CircleShape,
                border = BorderStroke(0.5.dp, color = Color.LightGray),
                shadowElevation = 5.dp
            ) {
                Image(
                    painterResource(id = R.drawable.baseline_person_pin_120),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = stringResource(id = person.name),
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = stringResource(id = person.description),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Composable
fun ListProfiles(people: List<Person>, modifier: Modifier = Modifier){
    LazyColumn {
        items(people) { person ->
            CardProfile(person, modifier)
        }
    }
}


@Composable
fun PortfolioApp(modifier: Modifier = Modifier) {
    var showMore by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AvatarProfile(
                modifier = Modifier.padding(bottom = 16.dp)
            )
            CreateInfo(
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = {},
                modifier = Modifier.padding(bottom = 16.dp)
            ){
                Text("Show More")
            }

            ListProfiles(listPeople)
        }

    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PorfolioUITheme {
//        CreateInfo()
        PortfolioApp()
//        CardProfile(Person(R.string.project_1, R.string.project_description))
    }
}