package com.example.sleeptrackerapp

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text



import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.emoji2.text.EmojiCompat


@Composable
fun AppBar(
    title: String,
    onBackNavClicked: () -> Unit= {}
) {
    val emojiString = "\uD83D\uDCA4 $title \uD83D\uDCA4"
    val processedEmoji = EmojiCompat.get().process(emojiString)
    TopAppBar(
        title = {
            Text(
                text = processedEmoji.toString(),
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp)
            )
        },
        elevation = 4.dp,
        backgroundColor = colorResource(id =R.color.white),
        navigationIcon = {
            IconButton(onClick = onBackNavClicked) {
                Icon(imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back")
            }
        },
    )
}