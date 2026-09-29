package com.example.offlinechess.Auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.offlinechess.R

@Preview()
@Composable
fun LoginScreen(vm: AuthViewModel = viewModel()) {
    Scaffold(
       Modifier.fillMaxSize().background(
           color=colorResource(R.color.primary))
           .systemBarsPadding(),
    ){paddingValues->
        LazyColumn(
            modifier=Modifier.fillMaxSize().padding(paddingValues)
                .background(color=colorResource(R.color.black)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment=Alignment.CenterHorizontally
        ){
            item{
                Spacer(modifier=Modifier.height(30.dp))
            }
            item{
                Icon(painter = painterResource(id = R.drawable.chessicon),
                    contentDescription = "Chess Icon",
                    modifier=Modifier.size(100.dp),
//                tint= colorResource(R.color.white)
                )
            }

            item{
                Spacer(modifier=Modifier.height(10.dp))
            }

            item{
                Text(
                    text = "GrandMasterChess", style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        color = colorResource(R.color.white),
                        textAlign = TextAlign.Center
                    )
                )
            }

            item{
                Spacer(modifier=Modifier.height(10.dp))
            }

            item{
                Text(
                    text = "Log In To Continue Your Journey", style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        color = colorResource(R.color.white),
                        textAlign = TextAlign.Center
                    )
                )

            }

            item{
                Spacer(modifier=Modifier.height(10.dp))
            }

            item{
                Card(
                    modifier=Modifier.fillMaxWidth(0.8f).height(400.dp),
                    colors= CardDefaults.cardColors(containerColor = colorResource(R.color.primary)),
                    shape= RoundedCornerShape(20.dp)
                ){
                    Column(
                        modifier=Modifier.fillMaxSize(),
                        horizontalAlignment=Alignment.CenterHorizontally,
                        verticalArrangement=Arrangement.spacedBy(20.dp)
                    ){
                        Spacer(modifier=Modifier.height(20.dp))
                        AuthTextField("UserName")
                        AuthTextField("Password")
                    }

                }
            }

        }

    }
}