package services;

import java.util.ArrayList;
import java.util.List;

public class Pilha<T> {
    private List<T> elementos;

    public Pilha() {
        elementos = new ArrayList<>();
    }

    public void empilhar(T elemento) {
        elementos.add(elemento);
    }

    public T desempilhar() {
        if (elementos.isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        return elementos.remove(elementos.size() - 1);
    }

    public T visualizarUltimo() {
        if (elementos.isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        return elementos.get(elementos.size() - 1);
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}
