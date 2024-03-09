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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch

@Preview
@Composable
fun RegistrationScreen(viewModel: RegistrationViewModel = viewModel()) {
    val nameState by viewModel.nameText.collectAsState("")
    val phoneState by viewModel.phoneText.collectAsState("")
    val passwordState by viewModel.passwordText.collectAsState("")
    val passwordRepeatState by viewModel.passwordRepeatText.collectAsState("")
    val coroutineScope = rememberCoroutineScope()

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
                    .padding(bottom = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    modifier = Modifier.size(64.dp),
                    painter = painterResource(id = R.drawable.key_icon),
                    contentDescription = null
                )

                Text(
                    text = "Создание аккаунта в ключики"
                )

                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "Имя"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = nameState,
                    onValueChange = { viewModel.onNameChange(it) },
                    textStyle = TextStyle(brush = brush),
                )

                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "Телефон"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = phoneState,
                    onValueChange = { viewModel.onPhoneChange(it) },
                    textStyle = TextStyle(brush = brush)
                )

                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "Пароль"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = passwordState,
                    onValueChange = { viewModel.onPasswordChange(it) },
                    textStyle = TextStyle(brush = brush),
                    visualTransformation = PasswordVisualTransformation()
                )

                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "Повторите пароль"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = passwordRepeatState,
                    onValueChange = { viewModel.onPasswordRepeatChange(it) },
                    textStyle = TextStyle(brush = brush),
                    visualTransformation = PasswordVisualTransformation()
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        coroutineScope.launch {
                            viewModel.onRegistrationClick()
                        }
                    }
                ) {
                    Text(text = "Войти")
                }
            }
        }

        Row(
            Modifier.align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Уже есть аккакунт?")
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Войдите")
            }
        }
    }
}
