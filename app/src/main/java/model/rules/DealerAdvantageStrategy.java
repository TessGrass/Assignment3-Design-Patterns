package model.rules;

public class DealerAdvantageStrategy implements WinnerStrategy {

  @Override
  public boolean isDealerWinner(int dealerScore, int playerScore) {

    if (dealerScore >= playerScore) {
      return true;
    }
    return false;
  } 
}
