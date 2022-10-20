package model;

import java.util.ArrayList;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.RulesFactory;
import model.rules.WinnerStrategy;

/**
 * Represents a dealer player that handles the deck of cards and runs the game using rules.
 */
public class Dealer extends Player implements Observable {

  private ArrayList<Observer> observers = new ArrayList<>();
  private Deck deck;
  private NewGameStrategy newGameRule;
  private HitStrategy hitRule;
  private WinnerStrategy winnerRule;

  /**
   * Initializing constructor.

   * @param rulesFactory A factory that creates the rules to use.
   */
  public Dealer(RulesFactory rulesFactory) {

    newGameRule = rulesFactory.getNewGameRule();
    hitRule = rulesFactory.getHitRule();
    winnerRule = rulesFactory.getWinnerRule();
  }

  /**
   * Starts a new game if the game is not currently under way.

   * @param player The player to play agains.
   * @return True if the game could be started.
   */
  public boolean newGame(Player player) {
    if (deck == null || isGameOver()) {
      deck = new Deck();
      clearHand();
      player.clearHand();
      return newGameRule.newGame(this, player);
    }
    return false;
  }

  /**
   * Gives the player one more card if possible. I.e. the player hits.

   * @param player The player to give a card to.
   * @return true if the player could get a new card, false otherwise.
   */
  public boolean hit(Player player, boolean showCard) {
    if (deck != null && player.calcScore() < maxScore && !isGameOver()) {
      Card.Mutable c;
      c = deck.getCard();
      c.show(showCard);
      player.dealCard(c);
      notifyObserver();
      return true;
    }
    return false;
  }

  /**
   * Checks if the dealer is the winner compared to a player.

   * @param player The player to check agains.
   * @return True if the dealer is the winner, false if the player is the winner.
   */
  public boolean isDealerWinner(Player player) {
    if (player.calcScore() > maxScore) {
      return true;
    } else if (calcScore() > maxScore) {
      return false;
    }
    /* return calcScore() >= player.calcScore(); */
    boolean dealerWins = winnerRule.isDealerWinner(calcScore(), player.calcScore());
    return dealerWins;
  }

  /**
   * Checks if the game is over, i.e. the dealer can take no more cards.

   * @return True if the game is over.
   */
  public boolean isGameOver() {
    if (deck != null && hitRule.doHit(this) != true) {
      return true;
    }
    return false;
  }

  /**
   * The player has choosen to take no more cards, it is the dealers turn.
   */
  public boolean stand() {
    boolean hasDealerHit = false;
    System.out.println("STAND");

    if (deck == null) {
      return false;
    }

    this.showHand();
    while (hitRule.doHit(this) == true) {
      hasDealerHit = hit(this, true);
    }
    return hasDealerHit;
  }

  @Override
  public void add(Observer theObserver) {
    observers.add(theObserver);
  }

  @Override
  public void notifyObserver() {
    for (Observer o : observers) {
      o.update();
    }
  }
}
