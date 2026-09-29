package com.example.offlinechess.ChessBoardComposables

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.offlinechess.DataModels.ChessPiece
import com.example.offlinechess.DataModels.Position
import io.github.alluhemanth.chess.core.ChessGame
import io.github.alluhemanth.chess.core.board.Board
import io.github.alluhemanth.chess.core.move.Move
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlin.collections.emptyList

class ChessViewModel: ViewModel() {
    private val game= ChessGame()
   private val board=game.getBoard()
   private val fenGame=game.getFen()
    private val _boardFlow: MutableStateFlow<String> = MutableStateFlow(fenGame)
    val boardFlow =_boardFlow.asStateFlow()

    private val legalMove:MutableStateFlow<List<Move>> = MutableStateFlow(emptyList())
    val legalMovesFlow=legalMove.asStateFlow()


    fun makeMove(selectedMove:Move){
        game.makeMove(selectedMove)
        legalMove.value=game.getLegalMoves()

    }





}




