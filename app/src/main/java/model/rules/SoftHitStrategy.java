package model.rules;
 
import model.Card;
import model.Player;
 
public class SoftHitStrategy implements HitStrategy {
  private static final int hitLimit = 17;
 
  @Override
  public boolean doHit(Player dealer) {

    if (dealer.calcScore() < hitLimit) {
      return true;

    } else if (dealer.calcScore() == hitLimit) {
      System.out.println("Har träffat 17");
      Iterable<Card> dealerCards = dealer.getHand();
      
      for (Card card : dealerCards) {
        if (card.getValue() == Card.Value.Ace) {
          System.out.println("Har ett ess");
          return true;
            
        }
      }
    }
    return false;
  }
}
