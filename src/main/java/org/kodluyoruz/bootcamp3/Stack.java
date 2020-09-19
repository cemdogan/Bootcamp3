package org.kodluyoruz.bootcamp3;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private final List<T> _list = new ArrayList<>();

    public int count() {
        return _list.size();
    }

    public void push(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }

        _list.add(obj);
    }

    public T pop() {
        if (_list.size() == 0) {
            throw new IllegalStateException();
        }

        int index = _list.size() - 1;
        T result = _list.get(index);
        _list.remove(index);

        return result;
    }

    public T peek() {
        if (_list.size() == 0) {
            throw new IllegalStateException();
        }

        int index = _list.size() - 1;
        return _list.get(index);
    }
}
