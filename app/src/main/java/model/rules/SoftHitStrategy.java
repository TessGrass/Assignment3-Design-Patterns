package model.rules;
 
import model.Card;
import model.Player;
 
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
      return true;
    }
    return false;
  }
}
