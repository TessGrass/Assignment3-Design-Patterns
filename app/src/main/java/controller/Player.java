package controller;

import model.Game;
import model.Observer;
import view.View;


/**
 * Scenario controller for playing the game.
 *
 */
public class Player implements Observer {
  private View view;
  private Game game;


  public Player(View view, Game game) {
    this.view = view;
    this.game = game;
  }

  /**
   * Runs the play use case.
   *
   * @return True as long as the game should continue.
   */
  public boolean play() {
    view.displayWelcomeMessage();

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    EnumEvent input = view.getInput();

    if (input == EnumEvent.NewGame) {
      game.newGame();
    } else if (input == EnumEvent.Hit) {
      game.hit();
    } else if (input == EnumEvent.Stand) {
      game.stand();
    }

    return input != EnumEvent.Quit;
  }

  @Override
  public void update() {
    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());
    view.printLineBetweenTurn();
    try {
      setApplicationToSleep();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Set application to sleep.
   *
   * @throws InterruptedException - Throws an exception if thread is interupted.
   */
  public void setApplicationToSleep() throws InterruptedException {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
