package org.kodluyoruz.bootcamp3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTests {

    @Test
    public void getOutput_WhenInputIsDivisibleBy3And5_ShouldReturnFizzBuzz(){
        //Arrange
        FizzBuzz sut = new FizzBuzz();

        //Act
        String result = sut.getOutput(15);

        //Assert
        assertThat(result).isEqualTo("FizzBuzz");

    }

    @Test
    public void getOutput_WhenInputIsOnlyDivisibleBy3_ShouldReturnFizz(){
        //Arrange
        FizzBuzz sut = new FizzBuzz();

        //Act
        String result = sut.getOutput(3);

        //Assert
        assertThat(result).isEqualTo("Fizz");

    }

    @Test
    public void getOutput_WhenInputIsOnlyDivisibleBy5_ShouldReturnBuzz(){
        //Arrange
        FizzBuzz sut = new FizzBuzz();

        //Act
        String result = sut.getOutput(5);

        //Assert
        assertThat(result).isEqualTo("Buzz");

    }

    @Test
    public void getOutput_WhenInputIsNotDivisibleBy3Or5_ShouldReturnSameNumber(){
        //Arrange
        FizzBuzz sut = new FizzBuzz();

        //Act
        String result = sut.getOutput(2);

        //Assert
        assertThat(result).isEqualTo("2");

    }
}
