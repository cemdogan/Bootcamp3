package org.kodluyoruz.bootcamp3.travel;

import org.kodluyoruz.bootcamp3.User;

import java.util.ArrayList;
import java.util.List;

public class TravelAdvisor {

    private UserRepository userRepository;

    private FriendRepository friendRepository;

    public TravelAdvisor(UserRepository userRepository, FriendRepository friendRepository) {
        this.userRepository = userRepository;
        this.friendRepository = friendRepository;
    }

    public List<TravelDestination> adviceDestinationsFor(User user) {

        List<TravelDestination> result = new ArrayList<>();

        List<TravelDestination> usersAlreadyTravelledDestinations = userRepository.getVisitedDestinations(user);

        int skip = 0;
        List<TravelDestination> friendTopTravelledDestinations = friendRepository.getTopDestinations(skip, 5);

        while(result.size() < 3 && friendTopTravelledDestinations != null && friendTopTravelledDestinations.size() > 0){

            for (TravelDestination friendDestination: friendTopTravelledDestinations) {

                boolean visitedBefore = usersAlreadyTravelledDestinations.stream()
                        .anyMatch(myDestination -> myDestination.equals(friendDestination.getName()));

                if(!visitedBefore){
                    result.add(friendDestination);
                }

                if(result.size() == 3){
                    break;
                }
            }

            skip += 5;
            friendTopTravelledDestinations = friendRepository.getTopDestinations(skip, 5);
        }

        return result;
    }
}
