package model;

/**
 * Observable interface.
 *
 */
public interface Observable {
  public void add(Observer theObserver);

  public void remove(Observer theObserver);
  
  public void notifyObserver();
}
