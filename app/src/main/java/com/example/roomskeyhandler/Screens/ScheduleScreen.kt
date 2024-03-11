package com.example.roomskeyhandler.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomskeyhandler.GeneralViewModel


@Preview
@Composable
fun ScheduleScreen(viewModel: GeneralViewModel = viewModel()) {
    val dateState by viewModel.date.collectAsState("")
    val timeState by viewModel.time.collectAsState("")

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Дата"
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = dateState,
            onValueChange = { viewModel.setDate(it) }
        )
        Text(
            text = "Пара"
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = timeState,
            onValueChange = { viewModel.setTime(it) }
        )
    }
}