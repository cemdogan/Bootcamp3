package org.kodluyoruz.bootcamp3.travel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kodluyoruz.bootcamp3.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TravelAdvisorFakeTests {

    private TravelAdvisor sut;
    private User me;

    @BeforeEach
    public void setup(){
        sut = new TravelAdvisor(new FakeUserRepository(), new FakeFriendRepository());
        me = new User("kutlu");
    }

    @Test
    public void adviceDestinationFor_whenFriendDestinationsAreAlreadyVisited_shouldExcludeVisitedDestinations() {
        //Act
        List<TravelDestination> destinations = sut.adviceDestinationsFor(me);

        //Assert
        assertThat(destinations).hasSize(3);

        assertThat(destinations).anyMatch(destination -> destination.equals(FakeData.NEW_YORK))
                .anyMatch(destination -> destination.equals(FakeData.PARIS))
                .anyMatch(destination -> destination.equals(FakeData.ROME));
    }
}
