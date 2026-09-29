package com.example.offlinechess.ChessBoardComposables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.offlinechess.DataModels.ChessPiece
import com.example.offlinechess.DataModels.PieceColor
import com.example.offlinechess.DataModels.PieceType
import com.example.offlinechess.R

@Composable
fun ChessPieceComposable(modifier: Modifier, piece: ChessPiece){

  val image= when(piece.color){
        PieceColor.Black ->when(piece.type){
            PieceType.King->R.drawable.white_king
            PieceType.Queen -> R.drawable.white_queen
            PieceType.Rook -> R.drawable.white_rook
            PieceType.Bishop-> R.drawable.white_bishop
            PieceType.Knight->R.drawable.white_knight
            PieceType.Pawn->R.drawable.white_pawn
        }

        PieceColor.White->when(piece.type){
            PieceType.King->R.drawable.black_king
            PieceType.Queen->R.drawable.black_queen
            PieceType.Bishop->R.drawable.black_bishop
            PieceType.Knight->R.drawable.black_knight
            PieceType.Rook->R.drawable.black_rook
            PieceType.Pawn->R.drawable.black_pawn
        }
    }

    Image(
        painter = painterResource(image),
        contentDescription = "Chess Piece",
        modifier = modifier,
        alignment = Alignment.Center,
        contentScale= ContentScale.Fit
    )


}
