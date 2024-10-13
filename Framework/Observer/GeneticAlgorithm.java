package Framework.Observer;

import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithm implements Subject {
    private List<Observer> observers;
    private String status;

    public GeneticAlgorithm() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registrarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.atualizar(status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notificarObservers();
    }

    
}
