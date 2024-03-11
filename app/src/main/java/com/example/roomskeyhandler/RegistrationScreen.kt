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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(viewModel: GeneralViewModel = viewModel()) {
    val nameState by viewModel.nameRegistration.collectAsState("")
    val phoneState by viewModel.phoneRegistration.collectAsState("")
    val passwordState by viewModel.passwordRegistration.collectAsState("")
    val passwordRepeatState by viewModel.passwordRepeatRegistration.collectAsState("")
    val registrationResponseState by viewModel.registrationResponse.collectAsState()
    val registrationResponseErrorState by viewModel.registrationResponseError.collectAsState()

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
                    modifier = Modifier.fillMaxWidth().onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            viewModel.clearRegistrationResponseErrorState()
                        }
                    },
                    value = nameState,
                    onValueChange = { viewModel.setNameRegistration(it) },
                    textStyle = TextStyle(brush = brush)
                )

                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "Телефон"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            viewModel.clearRegistrationResponseErrorState()
                        }
                    },
                    value = phoneState,
                    onValueChange = { viewModel.setPhoneRegistration(it) },
                    textStyle = TextStyle(brush = brush)
                )

                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "Пароль"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            viewModel.clearRegistrationResponseErrorState()
                        }
                    },
                    value = passwordState,
                    onValueChange = { viewModel.setPasswordRegistration(it) },
                    textStyle = TextStyle(brush = brush),
                    visualTransformation = PasswordVisualTransformation()
                )

                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "Повторите пароль"
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            viewModel.clearRegistrationResponseErrorState()
                        }
                    },
                    value = passwordRepeatState,
                    onValueChange = { viewModel.setPasswordRepeatRegistration(it) },
                    textStyle = TextStyle(brush = brush),
                    visualTransformation = PasswordVisualTransformation()
                )

                if (registrationResponseErrorState != null) {
                    Text(
                        text = "Ошибка регистрации",
                        color = Color.Red
                    )
                }

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        CoroutineScope(Dispatchers.IO).launch {
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
