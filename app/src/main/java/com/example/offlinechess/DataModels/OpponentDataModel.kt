package com.example.offlinechess.DataModels

data class OpponentDataModel(
    val opponentName:String,
    val status:Boolean,
    val time:String,
    val changeInPts:Int
)