package com.example.offlinechess.DataModels

enum class PieceType{
    King,
    Queen,
    Rook,
    Bishop,
    Knight,
    Pawn
}

enum class PieceColor{
    Black,
    White
}

data class Position(
    val file:Int,
    val rank: Int
)

data class ChessPiece(
    val type: PieceType,
    val color: PieceColor,
    val position: Position
)
