package model.rules;

public class PlayerAdvantageStrategy implements WinnerStrategy {

  @Override
  public boolean isDealerWinner() {
    return false;
  }
  
}
