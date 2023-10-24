package application;

import Boardgame.Board;
import Boardgame.BoardException;
import Boardgame.Position;
import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                Application.UI.clearScreen();
                Application.UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = Application.UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = Application.UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}