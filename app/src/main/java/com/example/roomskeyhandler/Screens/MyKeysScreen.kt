package com.example.roomskeyhandler.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomskeyhandler.GeneralViewModel
import com.example.roomskeyhandler.models.Key
import com.example.roomskeyhandler.models.User
import com.example.roomskeyhandler.ui.theme.Sea

@Composable
fun KeyItem(key: Key, userForKey: User?, viewModel: GeneralViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(83.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Green)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp),
            text = "Ключ: ${key.room}",
            fontSize = 20.sp
        )
        Button(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 20.dp)
                .size(width = 200.dp, height = 50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Sea),
            onClick = {
                if (userForKey != null) {
                    viewModel.onGiveKey(userForKey.id, key.id, viewModel.userForKey)
                }
            }
        ) {
            Text(text = "Передать")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyKeysScreen(viewModel: GeneralViewModel = viewModel()) {
    val keysListState by viewModel.myKeys.collectAsState()
    val usersState by viewModel.users.collectAsState()
    val userForKeyState by viewModel.userForKey.collectAsState()
    val expandedState by viewModel.expanded.collectAsState()


    LazyColumn(
        modifier = Modifier.padding(top = 65.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(keysListState) { key ->
            KeyItem(key, userForKeyState, viewModel)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expandedState,
            onExpandedChange = {
                viewModel.changeExpanded()
            }
        ) {
            userForKeyState?.let {
                TextField(
                    value = it.name,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedState) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
            }
            ExposedDropdownMenu(
                expanded = expandedState,
                onDismissRequest = { viewModel.changeExpanded() }
            ) {
                usersState.forEach { user ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = user.name
                            )
                        },
                        onClick = {
                            viewModel.setUserForKey(user)
                            viewModel.changeExpanded()
                        }
                    )
                }
            }
        }
    }
}