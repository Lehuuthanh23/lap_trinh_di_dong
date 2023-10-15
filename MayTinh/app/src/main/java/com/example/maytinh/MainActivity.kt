package com.example.maytinh
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.maytinh.ui.theme.MayTinhTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MayTinhTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MayTinhScreen()
                }
            }
        }
    }
}
@Composable
fun KeyFunction(
    label: String,
    containerColor: Color= Color.LightGray,
    onClick:(String) -> Unit,
    modifier: Modifier= Modifier
){
    Button(
        onClick = { onClick(label) },
        modifier = modifier
            .size(70.dp, 70.dp)
            .clip(shape = CircleShape),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = Color.Red
        )
    )
    {
        Text(text = label,modifier=modifier.fillMaxSize(),
            color = Color.Red,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
            )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MayTinhScreen(modifier: Modifier = Modifier) {
    var _expression by remember {
        mutableStateOf(""
        )
    }
    var _result by remember {
        mutableStateOf(""
        )
    }
    var lstKeys = listOf<String>("C","DEL", "%", "/",
        "7","8","9","x",
        "4","5","6","-",
        "1","2","3","+",
        "Ans","0",".","="
        )
    Scaffold(
        modifier = modifier.padding(5.dp),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        text = "Máy tính đơn giản",
                        fontWeight = FontWeight.ExtraBold
                    )
                },
            )
        }
    ) { it ->
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
        ) {
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, top = 20.dp),
                singleLine=true,
                readOnly=true,
                value =_expression,
                onValueChange = {
                    _expression=it
                },
                textStyle= TextStyle(
                    fontSize = 45.sp,
                    textAlign= TextAlign.Right
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Blue,
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )

            )
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, top = 20.dp),
                singleLine=true,
                readOnly=true,
                value =_result,
                onValueChange = {
                    _result=it
                },
                textStyle= TextStyle(
                    fontSize = 45.sp,
                    textAlign= TextAlign.Right
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Blue,
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )

            )
            Divider(
                modifier=modifier.padding(top=10.dp, bottom=10.dp),
                color = Color.LightGray
            )
            LazyVerticalGrid(
                modifier= modifier
                    .fillMaxSize()
                    .padding(top = 40.dp, start = 12.dp, end = 12.dp),
                verticalArrangement=Arrangement.SpaceEvenly,
                horizontalArrangement=Arrangement.SpaceEvenly,
                columns = GridCells.Fixed(4),
                content = {
                    items(lstKeys.count()){
                        Text(text = lstKeys[it])
                    }
                }
            )

        }
    }
}
/*
* package com.example.tinhbmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tinhbmi.ui.theme.TinhBMITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TinhBMITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BMIScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BMIScreen(modifier: Modifier = Modifier){
    var cao by remember {
        mutableStateOf("")
    }
    var nang by remember {
        mutableStateOf("")
    }
    var ketqua by remember {
        mutableStateOf("")
    }
    Scaffold(
        modifier= modifier.padding(5.dp),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        text = "BMI Calculator",
                        fontWeight = FontWeight.ExtraBold) },
                )
        }
    ) {
        it->
        Column (modifier= modifier
            .padding(it)
            .fillMaxSize()){
            TextField(modifier= modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, top = 20.dp),value = cao, onValueChange ={cao=it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                trailingIcon = { Text(text = "Cm", color = Color.Gray) },
                label = { Text(text = "Chiều cao")}
                )
            TextField(modifier= modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),value = nang, onValueChange ={nang=it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                trailingIcon = { Text(text = "Kg", color = Color.Gray) },
                label = { Text(text = "Cân nặng")}
            )
            Box(modifier = modifier.padding(bottom = 20.dp)){
                Text(
                    text = "BMI: ${ketqua}",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Red
                )
            }
            Button(
                onClick = {
                          try {
                              ketqua= ""
                              var c=cao.toDouble()
                              var n= nang.toDouble()
                              var kq = n/Math.pow(c/100,2.0)
                              ketqua+="${String.format("%.2f",kq)}."
                              ketqua+=if(kq<18.5){
                                  "Bạn gầy hơn so với chuẩn"
                              }
                              else if(kq>25){
                                  "Bạn nặng hơn so với chuẩn"
                              }
                              else{
                                  "Hoàn toàn bình thường"
                              }
                          }
                          catch (e: Exception){
                                ketqua="Nhập dữ liệu sai"
                          }
                },
                modifier=modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Tính", fontWeight = FontWeight.Bold)
            }
        }
    }
}


* */