package com.example.kmp_firsttask.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmp_firsttask.CommonLogic

class MainActivity : ComponentActivity() {
    private val commonLogic = CommonLogic()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterScreen(commonLogic)
                }
            }
        }
    }
}

@Composable
fun CounterScreen(commonLogic: CommonLogic) {
    var value by remember { mutableStateOf(commonLogic.random()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Value: $value", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))
        Column {
            Button(onClick = { value = commonLogic.increment() }) {
                Text("Инкрементировать")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { value = commonLogic.decrement() }) {
                Text("Декрементировать")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { value = commonLogic.random() }) {
                Text("Установить рандомное значение от 0 до 100")
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CounterScreen(CommonLogic())
    }
}
