package com.example.roomskeyhandler.Screens

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.roomskeyhandler.GeneralViewModel
import com.example.roomskeyhandler.ui.theme.GrayForFields
import com.example.roomskeyhandler.ui.theme.LightBlue
import com.example.roomskeyhandler.ui.theme.Sea
import com.example.roomskeyhandler.ui.theme.interFamily

@Preview
@Composable
fun ProfileScreen(viewModel: GeneralViewModel = viewModel()) {
    val nameState by viewModel.nameProfile.collectAsState("")
    val phoneState by viewModel.phoneProfile.collectAsState("")
    val emailState by viewModel.emailProfile.collectAsState("")
    val avatarLinkState by viewModel.avatarLinkProfile.collectAsState("")

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
                painter = rememberAsyncImagePainter(avatarLinkState),
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
                        viewModel.onLogoutClick()
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
                        value = nameState,
                        onValueChange = { viewModel.setNameProfile(it) },
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
                        value = phoneState,
                        onValueChange = { viewModel.setPhoneProfile(it) },
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
                        value = emailState,
                        onValueChange = { viewModel.setEmailProfile(it) },
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
                        value = avatarLinkState,
                        onValueChange = { viewModel.setAvatarLinkProfile(it) },
                        maxLines = 1
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor  = Sea),
                        onClick = {
                           viewModel.onSaveProfileClick()
                        }
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
                        onClick = {
                            viewModel.onDeclineChangesClick()
                        }
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