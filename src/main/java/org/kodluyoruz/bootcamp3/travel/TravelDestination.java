package org.kodluyoruz.bootcamp3.travel;

import java.util.Objects;

public class TravelDestination {

    private String name;

    public TravelDestination(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        if(getClass() == o.getClass()){
            TravelDestination otherDestination = (TravelDestination) o;
            return Objects.equals(name, otherDestination.name);
        }
        if(o.getClass() == String.class){
            return Objects.equals(name, o);
        }
        return false;
    }
}
