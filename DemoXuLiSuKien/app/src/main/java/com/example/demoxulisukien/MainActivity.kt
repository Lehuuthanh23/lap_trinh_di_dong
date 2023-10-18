package com.example.demoxulisukien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoxulisukien.ui.theme.DemoXuLiSuKienTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoXuLiSuKienTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TestState()
                   }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestState(modifier: Modifier = Modifier) {
   Column(modifier= Modifier) {
       var hoState= remember {
           mutableStateOf<String>("")
       }
       var ten = remember {
           mutableStateOf<String>("")
       }
       var tenLot = remember {
           mutableStateOf<String>("")
       }
       Text(text = "Họ: ")
       TextField(
           value = hoState.value,
           onValueChange = { hoState.value = it },
           modifier.fillMaxWidth(),)
       Spacer(modifier.padding(12.dp))
       Text(text = "Tên: ")
       TextField(
           value = ten.value,
           onValueChange = { ten.value = it },
           modifier.fillMaxWidth(),)
       Spacer(modifier.padding(12.dp))
       Spacer(modifier.padding(12.dp))
       Text(text = "Tên lót: ")
       TextField(
           value = tenLot.value,
           onValueChange = { tenLot.value = it },
           modifier.fillMaxWidth(),)
       if(hoState.value.isNotEmpty() && ten.value.isNotEmpty()&& tenLot.value.isNotEmpty())
           Text(text = "Hello ${hoState.value} ${tenLot.value} ${ten.value}")
   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoXuLiSuKienTheme {
        TestState()
    }
}