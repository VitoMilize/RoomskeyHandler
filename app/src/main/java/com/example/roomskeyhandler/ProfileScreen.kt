package com.example.roomskeyhandler

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.roomskeyhandler.ui.theme.GrayForFields
import com.example.roomskeyhandler.ui.theme.LightBlue
import com.example.roomskeyhandler.ui.theme.Sea
import com.example.roomskeyhandler.ui.theme.interFamily

@Preview
@Composable
fun ProfileScreen() {
    var nameValue by remember { mutableStateOf("Джон") }
    var phoneValue by remember { mutableStateOf("89999999999") }
    var emailValue by remember { mutableStateOf("test@test.test") }
    var avatarValue by remember { mutableStateOf("https://marketplace.canva.com/EAEjui-SkE4/2/0/1600w/canva-%D1%80%D0%BE%D0%B7%D0%BE%D0%B2%D1%8B%D0%B9-%D0%B8-%D0%B6%D0%B5%D0%BB%D1%82%D1%8B%D0%B9-%D0%BA%D0%BE%D1%88%D0%BA%D0%B0-%D1%81%D0%BE%D0%B2%D1%80%D0%B5%D0%BC%D0%B5%D0%BD%D0%BD%D1%8B%D0%B9-%D0%BD%D0%B0%D1%80%D0%B8%D1%81%D0%BE%D0%B2%D0%B0%D0%BD%D0%BD%D1%8B%D0%B9-%D0%BE%D1%82-%D1%80%D1%83%D0%BA%D0%B8-%D0%B0%D0%B1%D1%81%D1%82%D1%80%D0%B0%D0%BA%D1%82%D0%BD%D0%BE%D0%B5-%D0%B8%D0%B7%D0%BE%D0%B1%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B4%D0%BB%D1%8F-%D0%BF%D1%80%D0%BE%D1%84%D0%B8%D0%BB%D1%8F-%D0%B2-twitch-WsQ560IKaR0.jpg") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 32.dp)
                    .size(170.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Black, CircleShape),
                painter = rememberAsyncImagePainter(avatarValue),
                contentDescription = null
            )

            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 220.dp),
                text = "Имя",
                fontSize = 24.sp,
                fontFamily = interFamily,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 260.dp)
                    .clickable {

                    },
                text = "Выйти из аккаунта",
                fontSize = 15.sp,
                fontFamily = interFamily,
                fontWeight = FontWeight.Normal,
                color = LightBlue

            )

            Column(modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 310.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Имя",
                        fontFamily = interFamily
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth().clip(RoundedCornerShape(20.dp))
                            .background(GrayForFields),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = GrayForFields,
                            unfocusedBorderColor = GrayForFields,
                        ),
                        value = nameValue,
                        onValueChange = { nameValue = it },
                        maxLines = 1
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Номер телефона",
                        fontFamily = interFamily
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth().clip(RoundedCornerShape(20.dp))
                            .background(GrayForFields),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = GrayForFields,
                            unfocusedBorderColor = GrayForFields,
                        ),
                        value = phoneValue,
                        onValueChange = { phoneValue = it },
                        maxLines = 1
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Почта",
                        fontFamily = interFamily
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth().clip(RoundedCornerShape(20.dp))
                            .background(GrayForFields),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = GrayForFields,
                            unfocusedBorderColor = GrayForFields,
                        ),
                        value = emailValue,
                        onValueChange = { emailValue = it },
                        maxLines = 1
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Ссылка на аватар",
                        fontFamily = interFamily
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth().clip(RoundedCornerShape(20.dp))
                            .background(GrayForFields),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = GrayForFields,
                            unfocusedBorderColor = GrayForFields,
                        ),
                        value = avatarValue,
                        onValueChange = { avatarValue = it },
                        maxLines = 1
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor  = Sea),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Сохранить",
                            fontFamily = interFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Button(
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor  = Sea),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Отмена",
                            fontFamily = interFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}