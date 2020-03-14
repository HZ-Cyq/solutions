package designpattern.behavioral.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class ConcreteSubject implements  Subject {
    List<Observer> observers = new LinkedList<Observer>();
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Message message) {
        observers.forEach(observer -> observer.update(message));
    }
}
