package com.example.midterm_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.midterm_2.ui.theme.Midterm2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Midterm2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

class CounterViewModel : ViewModel() {
    var count by mutableStateOf(0)
        private set

    fun incrementCount() {
        count++
    }
}

@Composable
fun CounterScreen(modifier: Modifier, viewModel: CounterViewModel = viewModel()) {
    Column {
        Text("Count: ${viewModel.count}")
        Button(onClick = { viewModel.incrementCount() }) {
            Text("Increment")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    Midterm2Theme {
        CounterScreen(modifier = Modifier)
    }
}
