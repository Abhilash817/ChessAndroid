package com.example.offlinechess.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalFlexBoxApi
import androidx.compose.foundation.layout.FlexAlignItems
import androidx.compose.foundation.layout.FlexBox
import androidx.compose.foundation.layout.FlexDirection
import androidx.compose.foundation.layout.FlexJustifyContent
import androidx.compose.foundation.layout.FlexWrap
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.systemGestures
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Person4
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.offlinechess.DataModels.OpponentDataModel
import com.example.offlinechess.R

@OptIn(ExperimentalFlexBoxApi::class)
@Preview
@Composable
fun HomeScreen(vm:HomeScreenViewModel=viewModel(),
               goToChessScreen:()-> Unit={}) {
    var viewAllState by remember {
        mutableStateOf(false)
    }
    val fullList = listOf<OpponentDataModel>(
        OpponentDataModel(
            "Hikaru",
            true,
            "2 hrs",
            +12
        ),
        OpponentDataModel(
            "Magnus",
            false,
            "4 hrs",
            12
        ), OpponentDataModel(
            "Alex_Main",
            true,
            "yesterday",
            +12
        ),
        OpponentDataModel(
            "Abhash",
            true,
            "2 days ago",
            +12
        )
    )
    val temporaryList = listOf<OpponentDataModel>(
        OpponentDataModel(
            "Hikaru",
            true,
            "2 hrs",
            +12
        ),
        OpponentDataModel(
            "Hikaru",
            true,
            "2 hrs",
            +12
        ), OpponentDataModel(
            "Hikaru",
            true,
            "2 hrs",
            +12
        )

    )
    var listState by remember {
        mutableStateOf(false)
    }
    var listStatus = remember {
        mutableListOf(temporaryList)
    }

    listState = if (viewAllState) {
        true
    }
    else{
        false
    }




    Scaffold(
        modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.primary))
            .systemBarsPadding(),
        topBar = { HomeScreenTopBar() },
        containerColor = colorResource(R.color.tertiary)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                Text(
                    text = "Welcome Back,Alex", style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        color = colorResource(R.color.black),
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.fillMaxWidth(0.8f).testTag("GreetingText")
                )
            }
            item {
                Spacer(modifier = Modifier.height(5.dp))
            }

            item {
                Text(
                    text = "Ready For Your Next Match", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        color = colorResource(R.color.black)
                    ),
                    modifier = Modifier.fillMaxWidth(0.8f).testTag("NextMatchText")
                )
            }
            item {
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {
                FlexBox(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    config = {
                        direction(FlexDirection.Row)
                        wrap(FlexWrap.NoWrap)
                        justifyContent(FlexJustifyContent.SpaceBetween)
                        gap(20.dp)
                    }
                ) {
                    Card(
                        modifier = Modifier.height(160.dp).flex { grow(1f) }.testTag("Card1")
                            .clickable(true,onClick={
                                goToChessScreen.invoke()
                            }),
                        colors = CardDefaults.cardColors(
                            containerColor = colorResource(R.color.neutral),
                            contentColor = colorResource(R.color.white)
                        ),
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(1.dp, colorResource(R.color.neutral)),
                        elevation = CardDefaults.cardElevation(10.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Computer,
                                contentDescription = "Bot",
                                tint = colorResource(R.color.primary),
                                modifier = Modifier.size(30.dp)
                            )

                            Text(
                                text = "Play vs Computer", style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.SansSerif,
                                    color = colorResource(R.color.black),
                                    textAlign = TextAlign.Center
                                )
                            )
                            Text(
                                text = "Challenge StockFish Offline", style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily.SansSerif,
                                    color = colorResource(R.color.black),
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }

                    Card(
                        modifier = Modifier.height(160.dp).flex { grow(1f) }.testTag("Card2"),
                        colors = CardDefaults.cardColors(
                            containerColor = colorResource(R.color.neutral),
                            contentColor = colorResource(R.color.white)
                        ),
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(1.dp, colorResource(R.color.neutral)),
                        elevation = CardDefaults.cardElevation(10.dp)

                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Bot",
                                tint = colorResource(R.color.primary),
                                modifier = Modifier.size(30.dp)
                            )

                            Text(
                                text = "Play with Friends", style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.SansSerif,
                                    color = colorResource(R.color.black),
                                    textAlign = TextAlign.Center
                                )
                            )
                            Text(
                                text = "pass and play on the device", style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily.SansSerif,
                                    color = colorResource(R.color.black),
                                    textAlign = TextAlign.Center
                                )
                            )
                        }

                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {

                Text(
                    text = "Continue Game ", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        color = colorResource(R.color.black),
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.padding(start = 10.dp).fillMaxWidth(0.8f)
                )

            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(0.8f).height(100.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(R.color.neutral)),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.Extension,
                            contentDescription = "Bot",
                            tint = colorResource(R.color.primary),
                            modifier = Modifier.size(50.dp)
                        )

                        Column() {
                            Text(
                                text = "Alex M. vs StockFish Lvl 5 ", style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily.SansSerif,
                                    color = colorResource(R.color.black)
                                )
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Card(
                                    modifier = Modifier.height(30.dp).width(80.dp).padding(5.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = colorResource(
                                            R.color.tertiary
                                        )
                                    ),
                                    shape = RoundedCornerShape(5.dp)
                                ) {
                                    Text(
                                        text = "Move 25 ", style = TextStyle(
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Normal,
                                            fontFamily = FontFamily.SansSerif,
                                            color = colorResource(R.color.black),
                                            textAlign = TextAlign.Center
                                        ),
                                        modifier = Modifier.fillMaxSize()
                                    )

                                }

                                Spacer(modifier = Modifier.width(3.dp))


                                Box(
                                    modifier = Modifier.size(10.dp).background(
                                        color = colorResource(R.color.primary),
                                        shape = CircleShape
                                    ).clip(shape = CircleShape)
                                )

                                Spacer(modifier = Modifier.width(5.dp))

                                Text(
                                    text = "Your Turn ", style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal,
                                        fontFamily = FontFamily.SansSerif,
                                        color = colorResource(R.color.primary)
                                    )
                                )

                            }

                        }

                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Bot",
                            tint = colorResource(R.color.primary),
                            modifier = Modifier.size(50.dp)
                        )

                    }


                }
            }
            item {
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "RECENT GAMES", style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = colorResource(R.color.neutral)
                        )
                    )
                    AssistChip(
                        onClick = {
                            viewAllState = !viewAllState
                        },
                        label = {
                            Text(
                                text =if(!listState) "View All" else "View Less", style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily.SansSerif,
                                    color = colorResource(R.color.primary)
                                )
                            )
                        }
                    )
                }


            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            if (listState) {
                items(fullList) { list ->
                    HomeScreenListItem(
                        list.opponentName,
                        list.time,
                        list.changeInPts,
                        list.status

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            } else {
                items(temporaryList) { list ->
                    HomeScreenListItem(
                        list.opponentName,
                        list.time,
                        list.changeInPts,
                        list.status

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }



        }

    }
}
