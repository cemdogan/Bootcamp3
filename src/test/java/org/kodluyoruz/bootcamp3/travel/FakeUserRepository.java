package org.kodluyoruz.bootcamp3.travel;

import org.kodluyoruz.bootcamp3.User;

import java.util.ArrayList;
import java.util.List;

public class FakeUserRepository implements  UserRepository {

    private List<TravelDestination> destinations;

    public FakeUserRepository(){
        destinations = new ArrayList() {{
            add(new TravelDestination(FakeData.ISTANBUL));
            add(new TravelDestination(FakeData.ATHENS));
            add(new TravelDestination(FakeData.SOFIA));
        }};
    }

    @Override
    public List<TravelDestination> getVisitedDestinations(User user) {
        return destinations;
    }
}
