package model.rules;

/**
 * PlayerAdvantageStrategy class.
 *
 */
public class PlayerAdvantageStrategy implements WinnerStrategy {

  @Override
  public boolean isDealerWinner(int dealerScore, int playerScore) {

    if (playerScore >= dealerScore) {
      return false;
    }
    return true;
  } 
}
