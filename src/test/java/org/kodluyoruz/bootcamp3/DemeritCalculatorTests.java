package org.kodluyoruz.bootcamp3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemeritCalculatorTests {


    @Tag(value="important")
    @Test
    public void calculateDemeritPoints_whenSpeedIsNegative_shouldThrowIllegalArgumentException() {

        //Arrange
        DemeritPointsCalculator calculator = new DemeritPointsCalculator();

        //Act
        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateDemeritPoints(-1);
        });
    }

    @Test
    public void calculateDemeritPoints_whenSpeedIsOverMaxSpeed_shouldThrowIllegalArgumentException() {
        //Arrange
        DemeritPointsCalculator calculator = new DemeritPointsCalculator();
        //Act
        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateDemeritPoints(DemeritPointsCalculator.MAX_SPEED + 1);
        });
    }

    @DisplayName("When speed is in legal boundaries, it should return zero")
    @ParameterizedTest
    @MethodSource("provideLegalSpeedData")
    public void calculateDemeritPoints_whenSpeedIsInLegalBoundaries_shouldReturnZero(int speed, int expectedResult){

        //Arrange
        DemeritPointsCalculator calculator = new DemeritPointsCalculator();

        //Act
        int points = calculator.calculateDemeritPoints(speed);

        //Assert
        Assertions.assertEquals(points, expectedResult);
    }

    private static Stream<Arguments> provideLegalSpeedData() {
        return Stream.of(
                Arguments.of(60, 0),
                Arguments.of(50, 0),
                Arguments.of(64, 0));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/illegalDemeritPointsData.csv")
    public void calculateDemeritPoints_whenSpeedIsAboveLegalBoundaries_shouldReturnCalculatedFine(int speed, int expectedResult){

        //Arrange
        DemeritPointsCalculator calculator = new DemeritPointsCalculator();

        //Act
        int points = calculator.calculateDemeritPoints(speed);

        //Assert
        Assertions.assertEquals(points, expectedResult);
    }

    @Test
    public void failing_test(){
        assertTrue(true);
    }

}
