package model.rules;
 
import model.Card;
import model.Player;
 
/**
 * SoftHitStrategy class.
 * 
 */
public class SoftHitStrategy implements HitStrategy {
  private static final int hitLimit = 17;
 
  @Override
  public boolean doHit(Player dealer) {
    int numberOfAcesInHand = 0;

    if (dealer.calcScore() < hitLimit) {
      return true;
    } else if (dealer.calcScore() == hitLimit) {
      Iterable<Card> dealerCards = dealer.getHand();

      for (Card card : dealerCards) {
        if (card.getValue() == Card.Value.Ace) {
          numberOfAcesInHand += 1;         
        }
      }
    }
    if (numberOfAcesInHand == 1) {
      int[] cardScores = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
      assert (cardScores.length == Card.Value.Count.ordinal())
          : "Card Scores array size does not match number of card values";

      int valueOfHand = 0;
      for (Card card : dealer.getHand()) {
        if (card.getValue() != Card.Value.Ace) {        
          valueOfHand += cardScores[card.getValue().ordinal()];
        }
      }

      if (valueOfHand == 6) {
        return true;
      }
    }
    return false;
  }
}
