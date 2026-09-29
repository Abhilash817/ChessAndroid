package com.example.offlinechess.Home


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.offlinechess.R

@Preview
@Composable
fun HomeScreenTopBar(vm: HomeScreenViewModel=viewModel()){
    Card(
        modifier= Modifier.fillMaxWidth().height(80.dp),
        colors=CardDefaults.cardColors(
            containerColor=colorResource(R.color.neutral)
        ),
        shape=RoundedCornerShape(0.dp,0.dp,20.dp,20.dp),
        border=BorderStroke(2.dp,colorResource(R.color.primary))
    ){
        Row(modifier=Modifier.fillMaxSize(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(20.dp)){
            Spacer(modifier=Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Default.Extension,
                contentDescription = "Extension",
                modifier=Modifier.size(30.dp),
                tint=colorResource(R.color.primary)
            )

            Text(text="GrandMaster Chess",style= TextStyle(
                fontSize=20.sp,
                fontWeight= FontWeight.Bold,
                fontFamily=FontFamily.SansSerif,
                color=colorResource(R.color.black)
            ))

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Extension",
                modifier=Modifier.size(30.dp),
                tint=colorResource(R.color.primary)
            )

            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Extension",
                modifier=Modifier.size(30.dp),
                tint=colorResource(R.color.black)
            )

        }
    }
}


///List Composable Home Screen
@Composable
fun HomeScreenListItem(
    opponentName:String,
    time:String,
    changedPts:Int,
    gameStatus:Boolean
){

    Card(
        modifier=Modifier.fillMaxWidth(0.8f).height(100.dp),
        colors=CardDefaults.cardColors(containerColor=colorResource(R.color.neutral)),
        shape=RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(20.dp)
    ){
        Row(modifier=Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            Row() {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Bot",
                    tint = colorResource(R.color.primary),
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text(
                        text = opponentName, style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = colorResource(R.color.black)
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = time, style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = colorResource(R.color.black)
                        )
                    )
                }
            }

            Column(){
                Text(
                    text = if(gameStatus) "WIN" else "LOST", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        color = if(gameStatus) colorResource(R.color.primary) else
                        Color.Red
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = if(gameStatus) "+${changedPts}" else "-${changedPts}", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        color = if(gameStatus) colorResource(R.color.primary) else
                            Color.Red
                    )
                )
            }
            Spacer(modifier=Modifier.width(1.dp))
            }

        }



    }
