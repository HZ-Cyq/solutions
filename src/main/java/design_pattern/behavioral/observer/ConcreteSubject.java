package design_pattern.behavioral.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author playcrab_chenyuqun
 */
public class ConcreteSubject implements  Subject {
    List<Observer> observers = new LinkedList<Observer>();
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        System.out.println("remove observer: " + observer);
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        observers.forEach(observer -> observer.update(message));
    }
}
