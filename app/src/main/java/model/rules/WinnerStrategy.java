package model.rules;

/**
 * WinnerStrategy interface.
 */
public interface WinnerStrategy {
  
  boolean isDealerWinner(int dealerScore, int playerScore);
}
