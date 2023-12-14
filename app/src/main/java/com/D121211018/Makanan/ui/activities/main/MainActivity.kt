package com.makassar.newsappcompose.ui.activities.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211018.Makanan.data.models.Ingredient
import com.D121211018.Makanan.ui.activities.main.MainUiState
import com.D121211018.Makanan.ui.activities.main.MainViewModel
import com.D121211018.Makanan.ui.theme.D121211018MakananTheme
import com.makassar.newsappcompose.data.models.Article
import com.makassar.newsappcompose.ui.activities.detail.DetailActivity
import com.makassar.newsappcompose.ui.theme.NewsAppComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D121211018MakananTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "List News") },
                            )
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = {}) {
                                Icon(Icons.Default.Add, contentDescription = "Add")
                            }
                        }
                    ) {
                        Column(modifier = Modifier.padding(it)) {
                            val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                            ListIngredientScreen(mainViewModel.mainUiState)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ListIngredientScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when (mainUiState) {
            is MainUiState.Success -> {
                // Implement your UI logic for successful state here
                val makananList = mainUiState.makanan
                // Use makananList to display UI
            }
            is MainUiState.Error -> {
                // Implement your UI logic for error state here
                Text("Error occurred while fetching data.")
            }
            is MainUiState.Loading -> {
                // Implement your UI logic for loading state here
                CircularProgressIndicator(modifier = Modifier.align(LineHeightStyle.Alignment.Center))
            }
        }
    }


    private fun IngredientList(Ingredient: List<Ingredient>) {

    }

    private fun CenterText(text: String) {
        TODO("Not yet implemented")
    }

    @Composable
    private fun ErrorText() {
        Text(text = "ERROR")
    }

    @Composable
    fun LoadingBar() {
        Text(text = "SEDANG LOADING")
    }

    @Composable
    private fun ListNews(articles: List<Ingredient>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(articles) { article ->
                NewsCard(ingredient = Ingredient)
            }
        }
    }

    private fun NewsCard(ingredient: Ingredient.Companion) {

    }

    @Composable
    private fun NewsCard(ingredient: Ingredient, modifier: Modifier = Modifier) {
        Card(modifier = Modifier.clickable {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("NEWS", article)
            startActivity(intent)
        }) {
            Column {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(article.urlToImage)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Ini gambar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = article.title ?: "Ini title")
            }
        }
    }

}
