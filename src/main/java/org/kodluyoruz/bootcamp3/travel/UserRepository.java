package org.kodluyoruz.bootcamp3.travel;

import org.kodluyoruz.bootcamp3.User;

import java.util.List;

public interface UserRepository {
    List<TravelDestination> getVisitedDestinations(User user);
}
