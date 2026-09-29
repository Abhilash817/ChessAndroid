package com.example.offlinechess.ChessBoardComposables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.offlinechess.DataModels.ChessPiece
import com.example.offlinechess.DataModels.PieceColor
import com.example.offlinechess.DataModels.PieceType
import com.example.offlinechess.DataModels.Position
import com.example.offlinechess.R
import io.github.alluhemanth.chess.core.move.Move
import io.github.alluhemanth.chess.core.piece.Piece


@Composable
fun ChessBoardComposable(
    blackPiecesList: List<ChessPiece>,
    whitePiecesList: List<ChessPiece>
) {
    val chessViewModel: ChessViewModel= viewModel()
    var selectedRank by remember { mutableIntStateOf(-1) }
    var selectedFile by remember { mutableIntStateOf(-1) }
    val chessBoard by chessViewModel.boardFlow.collectAsStateWithLifecycle()
    var selectedSquare by remember { mutableStateOf<Position?>(null) }
    val legalMoves by chessViewModel.legalMovesFlow.collectAsStateWithLifecycle()
    var movesForSelectedPiece: List<Move>? by remember { mutableStateOf(null)}
    Card(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            for (rank in 1..8) {
                Row(modifier = Modifier.weight(1f)) {
                    for (file in 1..8) {
                        val isDarkBox = (rank + file) % 2 == 0
                        val boxColor = if (isDarkBox) colorResource(R.color.primary) else colorResource(R.color.white)
                        val isSelected = selectedRank == rank && selectedFile == file
                        val highlightColor = if (isSelected) Color.Yellow.copy(alpha = 0.5f) else Color.Transparent
                        val piece = findPiece(fen = chessBoard,file=file,rank=rank)
                        ChessBox(
                            boxColor = boxColor,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clickable {
                                    selectedRank = rank
                                    selectedFile = file
                                    selectedSquare= Position(rank,file)
//                                    movesForSelectedPiece=legalMoves.filter{move->
//                                        move.from==
//                                    }

                                }
                        ){
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(highlightColor),
                                contentAlignment = Alignment.Center
                            ) {
                                // Find if there's a piece at this position
//                                val piece = (whitePiecesList + blackPiecesList).find {
//                                    it.position.rank == rank && it.position.file == file
//                                }
//


                                if (piece != null) {
                                    ChessPieceComposable(
                                        modifier = Modifier.fillMaxSize(),
                                        piece = piece
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ChessBox(
    boxColor: Color,
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.background(color = boxColor)) {
        content()
    }
}

fun findPiece(fen: String, file: Int, rank: Int): ChessPiece? {
    val boardPart = fen.split(" ")[0]
    val ranks = boardPart.split("/")

    // FEN ranks are 8 to 1. ranks[0] is rank 8, ranks[7] is rank 1.
    if (rank !in 1..8) return null
    val targetRankString = ranks[8 - rank]

    var currentFile = 1
    for (char in targetRankString) {
        if (char.isDigit()) {
            currentFile += char.digitToInt()
        } else {
            if (currentFile == file) {
                val color = if (char.isUpperCase()) PieceColor.White else PieceColor.Black
                val type = when (char.lowercaseChar()) {
                    'p' -> PieceType.Pawn
                    'n' -> PieceType.Knight
                    'b' -> PieceType.Bishop
                    'r' -> PieceType.Rook
                    'q' -> PieceType.Queen
                    'k' -> PieceType.King
                    else -> return null
                }
                return ChessPiece(type, color, Position(file, rank))
            }
            currentFile++
        }
        if (currentFile > file) break
    }
    return null
}
