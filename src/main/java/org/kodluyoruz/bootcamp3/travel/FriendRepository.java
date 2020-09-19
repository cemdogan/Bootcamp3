package org.kodluyoruz.bootcamp3.travel;

import java.util.List;

public interface FriendRepository {
    List<TravelDestination> getTopDestinations(int skip, int pageSize);
}
