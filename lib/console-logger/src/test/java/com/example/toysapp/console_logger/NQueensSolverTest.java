package com.example.toysapp.console_logger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class NQueensSolverTest {

    private NQueensSolver solver = new NQueensSolver();

    @Test
    public void testSolveNQueensFor1x1Board() {
        List<List<String>> solutions = solver.solveNQueens(1);
        assertEquals(1, solutions.size());
        assertEquals("Q", solutions.get(0).get(0));
    }

    @Test
    public void testSolveNQueensFor2x2Board() {
        List<List<String>> solutions = solver.solveNQueens(2);
        assertEquals(0, solutions.size());
    }

    @Test
    public void testSolveNQueensFor3x3Board() {
        List<List<String>> solutions = solver.solveNQueens(3);
        assertEquals(0, solutions.size());
    }

    @Test
    public void testSolveNQueensFor4x4Board() {
        List<List<String>> solutions = solver.solveNQueens(4);
        assertEquals(2, solutions.size());
        
        List<String> expectedSolution1 = List.of(
            ".Q..",
            "...Q",
            "Q...",
            "..Q."
        );
        
        List<String> expectedSolution2 = List.of(
            "..Q.",
            "Q...",
            "...Q",
            ".Q.."
        );
        
        assertTrue(solutions.contains(expectedSolution1));
        assertTrue(solutions.contains(expectedSolution2));
    }

    @Test
    public void testSolveNQueensFor8x8Board() {
        List<List<String>> solutions = solver.solveNQueens(8);
        assertEquals(92, solutions.size());
    }

    @Test
    public void testNoTwoQueensThreatenEachOther() {
        List<List<String>> solutions = solver.solveNQueens(5);
        for (List<String> solution : solutions) {
            assertTrue(isValidSolution(solution));
        }
    }

    private boolean isValidSolution(List<String> board) {
        int n = board.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board.get(i).charAt(j) == 'Q') {
                    // Check row and column
                    for (int k = 0; k < n; k++) {
                        if (k != j && board.get(i).charAt(k) == 'Q') return false;
                        if (k != i && board.get(k).charAt(j) == 'Q') return false;
                    }
                    // Check diagonals
                    for (int k = 1; k < n; k++) {
                        if (i+k < n && j+k < n && board.get(i+k).charAt(j+k) == 'Q') return false;
                        if (i-k >= 0 && j-k >= 0 && board.get(i-k).charAt(j-k) == 'Q') return false;
                        if (i+k < n && j-k >= 0 && board.get(i+k).charAt(j-k) == 'Q') return false;
                        if (i-k >= 0 && j+k < n && board.get(i-k).charAt(j+k) == 'Q') return false;
                    }
                }
            }
        }
        return true;
    }
}