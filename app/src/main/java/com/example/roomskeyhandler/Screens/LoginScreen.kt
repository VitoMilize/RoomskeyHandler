package com.example.roomskeyhandler.Screens

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomskeyhandler.GeneralViewModel
import com.example.roomskeyhandler.R

@Preview
@Composable
fun LoginScreen(viewModel: GeneralViewModel = viewModel()) {
    val phoneState by viewModel.phoneLogin.collectAsState("")
    val passwordState by viewModel.passwordLogin.collectAsState("")
    val loginResponseState by viewModel.loginResponse.collectAsState()
    val loginResponseErrorState by viewModel.loginResponseError.collectAsState()

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
                    text = "Телефон"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            viewModel.clearLoginResponseErrorState()
                        }
                    },
                    value = phoneState,
                    onValueChange = { viewModel.setPhoneLogin(it) },
                    textStyle = TextStyle(brush = brush)
                )
                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "Пароль"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            viewModel.clearLoginResponseErrorState()
                        }
                    },
                    value = passwordState,
                    onValueChange = { viewModel.setPasswordLogin(it) },
                    textStyle = TextStyle(brush = brush),
                    visualTransformation = PasswordVisualTransformation()
                )

                if (loginResponseErrorState != null) {
                    Text(
                        text = "Ошибка входа",
                        color = Color.Red
                    )
                }

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        viewModel.onLoginClick()
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
            Text(text = "Еще нет аккаунта?")
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Зарегистрируйтесь")
            }
        }
    }
}