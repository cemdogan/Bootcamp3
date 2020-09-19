package org.kodluyoruz.bootcamp3.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FakeFriendRepository implements FriendRepository  {

    private List<TravelDestination> destinations;

    public FakeFriendRepository(){
        destinations = new ArrayList<>();
        destinations.add(new TravelDestination(FakeData.NEW_YORK));
        destinations.add(new TravelDestination(FakeData.PARIS));
        destinations.add(new TravelDestination(FakeData.ROME));
        destinations.add(new TravelDestination(FakeData.ISTANBUL));
        destinations.add( new TravelDestination(FakeData.ATHENS));
        destinations.add(new TravelDestination(FakeData.SOFIA));
    }

    @Override
    public List<TravelDestination> getTopDestinations(int skip, int pageSize) {
        return destinations.stream().skip(skip).limit(pageSize).collect(Collectors.toList());
    }
}
