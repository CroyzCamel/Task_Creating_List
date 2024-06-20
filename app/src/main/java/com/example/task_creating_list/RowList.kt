package com.example.task_creating_list

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun RowList() {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxHeight(),
    ) {
        Row(
            Modifier.horizontalScroll(scrollState)
        ) {
            repeat(50) {
                Text(
                    text = "$it",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
        Row(

        ) {
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            }) {
                Text(text = "Start")
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(scrollState.maxValue)
                }
            }) {
                Text(text = "End")
            }
        }
    }

}