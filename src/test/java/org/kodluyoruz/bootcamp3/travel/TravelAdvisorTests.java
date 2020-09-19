package org.kodluyoruz.bootcamp3.travel;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kodluyoruz.bootcamp3.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class TravelAdvisorTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private FriendRepository friendRepository;

    @InjectMocks
    private TravelAdvisor sut;

    private User me;

    @BeforeEach
    public void setup(){
         me = new User("kutlu");
    }

    @Test
    public void adviceDestinationFor_shouldReturnMyFriendsMostStarredDestinations() {
        //Arrange
        when(userRepository.getVisitedDestinations(me)).thenReturn(Lists.emptyList());

        TravelDestination newYork = new TravelDestination(FakeData.NEW_YORK);
        when(friendRepository.getTopDestinations(0, 5)).thenReturn(Lists.list(newYork));

        //Act
        List<TravelDestination> destinations = sut.adviceDestinationsFor(me);

        //Assert
        assertThat(destinations).hasSize(1);

        assertThat(destinations).anyMatch(destination -> destination.equals(FakeData.NEW_YORK));
    }

    @Test
    public void adviceDestinationFor_whenFriendDestinationsAreAlreadyVisited_shouldExcludeVisitedDestinations() {
        //Arrange
        TravelDestination istanbul = new TravelDestination(FakeData.ISTANBUL);
        TravelDestination sofia = new TravelDestination(FakeData.SOFIA);
        TravelDestination athens = new TravelDestination(FakeData.ATHENS);

        when(userRepository.getVisitedDestinations(me)).thenReturn(Lists.list(istanbul, sofia, athens));

        TravelDestination newYork = new TravelDestination(FakeData.NEW_YORK);
        TravelDestination paris = new TravelDestination(FakeData.PARIS);
        TravelDestination rome = new TravelDestination(FakeData.ROME);

        when(friendRepository.getTopDestinations(0, 5)).thenReturn(Lists.list(newYork, paris, istanbul, athens, sofia));
        when(friendRepository.getTopDestinations(5, 5)).thenReturn(Lists.list(rome));

        //Act
        List<TravelDestination> destinations = sut.adviceDestinationsFor(me);

        //Assert
        assertThat(destinations).hasSize(3);

        assertThat(destinations).anyMatch(destination -> destination.equals(FakeData.NEW_YORK))
                .anyMatch(destination -> destination.equals(FakeData.PARIS))
                .anyMatch(destination -> destination.equals(FakeData.ROME));

        verify(friendRepository, times(1)).getTopDestinations(0, 5);
        verify(friendRepository, times(1)).getTopDestinations(5, 5);
    }


}
