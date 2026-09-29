package com.example.offlinechess.Auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AuthTextField(
    placeholder:String
){

  TextField(
      rememberTextFieldState(placeholder),
      textStyle = TextStyle(
          color=Color.Black,
          fontWeight=FontWeight.Normal
      ),
      modifier= Modifier.height(50.dp).fillMaxWidth(0.8f),
      shape=RoundedCornerShape(20.dp)
  )
}