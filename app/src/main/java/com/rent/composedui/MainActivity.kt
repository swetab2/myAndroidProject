@file:OptIn(ExperimentalMaterial3Api::class)

package com.rent.composedui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rent.composedui.ui.theme.ComposedUITheme

import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposedUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Greeting("Android")
                        EditableText()
                        RadioButtonSample()
                        SwitchSample()
                        SimpleList()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", style = MaterialTheme.typography.bodyLarge)
}

@Composable
fun EditableText() {
    var textValue by remember { mutableStateOf("") }

    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text("Enter text") },
        modifier = Modifier.fillMaxWidth()
    )
}



@Composable
fun RadioButtonSample() {
    var selectedOption by remember { mutableStateOf(0) }

    Column {
        Text(text = "Choose an option:")
        Spacer(modifier = Modifier.height(8.dp))

        val options = listOf("Option 1", "Option 2", "Option 3")
        options.forEachIndexed { index, text ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = selectedOption == index,
                    onClick = { selectedOption = index },
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Composable
fun SwitchSample() {
    var isChecked by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "Switch: $isChecked")
    }
}



@Composable
fun SimpleList() {
    val items = List(20) { index -> "Item $index" }

    LazyColumn {
        items(items.size) { index ->
            Text(
                text = items[index],
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposedUITheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Greeting("Android")
            EditableText()
            RadioButtonSample()
            SwitchSample()
            SimpleList()
        }
    }
}