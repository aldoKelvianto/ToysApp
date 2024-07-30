package com.example.toysapp.consolelogger

class NQueensSolver {
    fun solveNQueens(n: Int): List<List<String>> {
        val solutions = mutableListOf<List<String>>()
        val board = Array(n) { CharArray(n) { '.' } }

        backtrack(board, 0, solutions)
        return solutions
    }

    private fun backtrack(board: Array<CharArray>, row: Int, solutions: MutableList<List<String>>) {
        if (row == board.size) {
            solutions.add(constructSolution(board))
            return
        }

        for (col in board.indices) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q'
                backtrack(board, row + 1, solutions)
                board[row][col] = '.'
            }
        }
    }

    private fun isValid(board: Array<CharArray>, row: Int, col: Int): Boolean {
        for (i in 0 until row) {
            if (board[i][col] == 'Q') {
                return false
            }
        }

        for (i in row - 1 downTo 0) {
            if (col - (row - i) >= 0 && board[i][col - (row - i)] == 'Q') {
                return false
            }
            if (col + (row - i) < board.size && board[i][col + (row - i)] == 'Q') {
                return false
            }
        }

        return true
    }

    private fun constructSolution(board: Array<CharArray>): List<String> = board.map { String(it) }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solver = NQueensSolver()
            val solutions = solver.solveNQueens(4)

            println("Solutions for 4-Queens problem:")
            for ((index, solution) in solutions.withIndex()) {
                println("Solution ${index + 1}:")
                for (row in solution) {
                    println(row)
                }
                println()
            }
        }
    }
}
