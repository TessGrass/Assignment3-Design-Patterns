package model;

/**
 * Observable interface.
 *
 */
public interface Observable {
  public void add(Observer theObserver);
  
  public void notifyObserver();
}
