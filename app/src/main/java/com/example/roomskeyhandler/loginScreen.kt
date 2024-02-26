package com.example.roomskeyhandler

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun LoginScreen() {
    var loginTextValue by remember { mutableStateOf("") }
    var passwordTextValue by remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = listOf(Color.Green, Color.Gray, Color.Blue)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        IconButton(
            modifier = Modifier.align(Alignment.TopStart),
            onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
        }

        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {

            Column(
                Modifier
                    .align(Alignment.Center)
                    .padding(bottom = 200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    modifier = Modifier.size(64.dp),
                    painter = painterResource(id = R.drawable.key_icon),
                    contentDescription = null
                )

                Text(
                    text = "Вход в ключики")
                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "Почта"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = loginTextValue,
                    onValueChange = { loginTextValue = it },
                    textStyle = TextStyle(brush = brush)
                )
                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "Пароль"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = passwordTextValue,
                    onValueChange = { passwordTextValue = it },
                    textStyle = TextStyle(brush = brush),
                    visualTransformation = PasswordVisualTransformation()
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Войти")
                }
            }
        }

        Row(
            Modifier.align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Еще нет аккаунта?")
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Зарегистрируйтесь")
            }
        }
    }
}