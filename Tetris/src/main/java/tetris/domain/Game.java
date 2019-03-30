package tetris.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private Board board;
  private List<Piece> pieces;
  
  public Game(int height, int width) {
    this.board = new Board(height, width);
    this.pieces = new ArrayList<>();
  }
  
  public void addPiece() {
    System.out.println(board);
    
    this.pieces.add(new PieceI(3));
    this.board.setPiece(this.pieces.get(0));
    
    System.out.println("******************");
    for (Piece piece : pieces) {
      piece.print();
    }
    System.out.println(board);
    
    for (int i = 0; i < 5; i++) {
      for (Piece piece : pieces) {
        piece.moveDown();
      }
    }
    
    System.out.println("*******************");
    board.resetBoard();
    
    for (Piece piece : pieces) {
      piece.print();
      board.setPiece(piece);
    }
    System.out.println(board);
    
    this.pieces.add(new PieceT(3));
    
    System.out.println("*******************");
    board.resetBoard();
    
    for (Piece piece : pieces) {
      piece.print();
      board.setPiece(piece);
    }
    System.out.println(board);
    
    for (int i = 0; i < 5; i++) {
      for (Piece piece : pieces) {
        piece.moveDown();
      }
    }
    
    System.out.println("********************");
    board.resetBoard();
    
    for (Piece piece : pieces) {
      piece.print();
      board.setPiece(piece);
    }
    System.out.println(board);
  }
  
}
