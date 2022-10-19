package model.rules;

public interface WinnerStrategy {
  
  boolean isDealerWinner(int dealerScore, int playerScore);
}
