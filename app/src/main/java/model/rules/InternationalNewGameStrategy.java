package model.rules;

import model.Dealer;
import model.Player;


class InternationalNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Dealer dealer, Player player) {
    dealer.hit(player, true);
    dealer.hit(dealer, true);
    dealer.hit(player, true);

    return true;
  }
}