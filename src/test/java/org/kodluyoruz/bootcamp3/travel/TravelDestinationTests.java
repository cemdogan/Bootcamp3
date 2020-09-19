package org.kodluyoruz.bootcamp3.travel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TravelDestinationTests {


    @Test
    public void equal_whenNamesMatch_shouldReturnTrue(){

        //Arrange
        String cityName = "istanbul";
        TravelDestination sut = new TravelDestination(cityName);

        //Act
        boolean result = sut.equals(cityName);

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    public void equals_whenNamesMismatches_shouldReturnTrue(){

        //Arrange
        String cityName = "rome";
        TravelDestination sut = new TravelDestination(cityName);

        //Act
        boolean result = sut.equals("istanbul");

        //Assert
        assertThat(result).isFalse();
    }



}
