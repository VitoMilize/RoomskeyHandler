package com.example.roomskeyhandler.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.roomskeyhandler.R

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean = false,
    val badgeCount: Int? = null
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun BidsScreen() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.TopStart)
                .clickable {

                },
            painter = rememberAsyncImagePainter("https://marketplace.canva.com/EAEjui-SkE4/2/0/1600w/canva-%D1%80%D0%BE%D0%B7%D0%BE%D0%B2%D1%8B%D0%B9-%D0%B8-%D0%B6%D0%B5%D0%BB%D1%82%D1%8B%D0%B9-%D0%BA%D0%BE%D1%88%D0%BA%D0%B0-%D1%81%D0%BE%D0%B2%D1%80%D0%B5%D0%BC%D0%B5%D0%BD%D0%BD%D1%8B%D0%B9-%D0%BD%D0%B0%D1%80%D0%B8%D1%81%D0%BE%D0%B2%D0%B0%D0%BD%D0%BD%D1%8B%D0%B9-%D0%BE%D1%82-%D1%80%D1%83%D0%BA%D0%B8-%D0%B0%D0%B1%D1%81%D1%82%D1%80%D0%B0%D0%BA%D1%82%D0%BD%D0%BE%D0%B5-%D0%B8%D0%B7%D0%BE%D0%B1%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B4%D0%BB%D1%8F-%D0%BF%D1%80%D0%BE%D1%84%D0%B8%D0%BB%D1%8F-%D0%B2-twitch-WsQ560IKaR0.jpg"),
            contentDescription = null
        )

        Icon(
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.TopEnd)
                .clickable {

                },
            painter = painterResource(R.drawable.ic_plus),
            contentDescription = null
        )
    }
    Column(
        modifier = Modifier.padding(top = 38.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(83.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Yellow)
        ) {
            Column(
                modifier = Modifier.padding(top = 4.dp, start = 8.dp)
            ) {
                Text(
                    text = "Корпус: 2",
                    fontSize = 15.sp
                )

                Text(
                    modifier = Modifier.padding(top = 6.dp),
                    text = "Аудитория: 111",
                    fontSize = 15.sp
                )

                Text(
                    modifier = Modifier.padding(top = 6.dp),
                    text = "Время бронирования: 12:25 - 14:00",
                    fontSize = 15.sp
                )
            }

            Icon(
                modifier = Modifier.align(Alignment.TopEnd).padding(5.dp).size(24.dp),
                painter = painterResource(id = R.drawable.ic_repeat),
                contentDescription = null)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray)
        ) {


        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray)
        ) {


        }
    }
}