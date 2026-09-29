package com.example.offlinechess.ChessBoardComposables


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.offlinechess.DataModels.ChessPiece
import com.example.offlinechess.DataModels.PieceColor
import com.example.offlinechess.DataModels.PieceType
import com.example.offlinechess.DataModels.Position
import com.example.offlinechess.R

@Composable
fun ChessScreen(
    goBackToHomeScreen:()->Unit
){
    val blackPiecesList = mutableListOf<ChessPiece>().apply {
        // Major Pieces
        add(ChessPiece(PieceType.Rook, PieceColor.Black, Position(1, 8)))
        add(ChessPiece(PieceType.Knight, PieceColor.Black, Position(2, 8)))
        add(ChessPiece(PieceType.Bishop, PieceColor.Black, Position(3, 8)))
        add(ChessPiece(PieceType.Queen, PieceColor.Black, Position(5, 8)))
        add(ChessPiece(PieceType.King, PieceColor.Black, Position(4, 8)))
        add(ChessPiece(PieceType.Bishop, PieceColor.Black, Position(6, 8)))
        add(ChessPiece(PieceType.Knight, PieceColor.Black, Position(7, 8)))
        add(ChessPiece(PieceType.Rook, PieceColor.Black, Position(8, 8)))
        // Pawns
        for (i in 1..8) {
            add(ChessPiece(PieceType.Pawn, PieceColor.Black, Position(i, 7)))
        }
    }

    val whitePiecesList = mutableListOf<ChessPiece>().apply {
        // Major Pieces
        add(ChessPiece(PieceType.Rook, PieceColor.White, Position(1, 1)))
        add(ChessPiece(PieceType.Knight, PieceColor.White, Position(2, 1)))
        add(ChessPiece(PieceType.Bishop, PieceColor.White, Position(3, 1)))
        add(ChessPiece(PieceType.Queen, PieceColor.White, Position(5, 1)))
        add(ChessPiece(PieceType.King, PieceColor.White, Position(4, 1)))
        add(ChessPiece(PieceType.Bishop, PieceColor.White, Position(6, 1)))
        add(ChessPiece(PieceType.Knight, PieceColor.White, Position(7, 1)))
        add(ChessPiece(PieceType.Rook, PieceColor.White, Position(8, 1)))
        // Pawns
        for (i in 1..8) {
            add(ChessPiece(PieceType.Pawn, PieceColor.White, Position(i, 2)))
        }
    }
    Scaffold(
        modifier=Modifier.fillMaxSize().background(color =colorResource(R.color.primary) )
            .systemBarsPadding(),
        containerColor = colorResource(R.color.tertiary)
    ){paddingValues ->
      Column(modifier = Modifier.fillMaxSize().padding(paddingValues),
          verticalArrangement = Arrangement.Top,
          horizontalAlignment = Alignment.CenterHorizontally){
          Text(text="GrandMaster Chess",style= TextStyle(
              fontSize=20.sp,
              fontWeight= FontWeight.Bold,
              fontFamily=FontFamily.SansSerif,
              color=colorResource(R.color.black),
              textAlign = TextAlign.Center
          ),
              modifier = Modifier.clickable(true,onClick={
                  goBackToHomeScreen.invoke()
              }))
          Spacer(modifier=Modifier.height(20.dp))
          ChessBoardComposable(
              blackPiecesList,
              whitePiecesList
          )
      }

    }
}