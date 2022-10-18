package controller;

import model.Game;
import view.View;


/**
 * Scenario controller for playing the game.
 */
public class Player {

  /**
   * Runs the play use case.

   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play(Game game, View view) {
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    // int input = view.getInput();
    EnumEvent input = view.getInput();

    // System.out.println("TEST " + input);

    if (input == EnumEvent.NewGame) {
      game.newGame();
    } else if (input == EnumEvent.Hit) {
      game.hit();
    } else if (input == EnumEvent.Stand) {
      game.stand();
    }

    return input != EnumEvent.Quit;
  }
}