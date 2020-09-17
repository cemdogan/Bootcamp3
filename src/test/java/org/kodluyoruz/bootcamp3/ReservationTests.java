package org.kodluyoruz.bootcamp3;

import org.assertj.core.api.Java6Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ReservationTests {

    @Test
    public void canBeCancelledBy_WhenUserIsAdmin_ShouldReturnsTrue() {
        //Arrange
        Reservation reservation = new Reservation();
        LocalDateTime now = LocalDateTime.now();
        User user = new User();
        user.setAdmin(true);

        //Act
        boolean result = reservation.canBeCancelledBy(user, now.plus(Period.ofDays(4)));

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    public void canBeCancelledBy_WhenUserIsMadeByAndDateIsSuitable_ShouldReturnsTrue() {
        //Arrange
        Reservation reservation = new Reservation();
        LocalDateTime now = LocalDateTime.now();
        User user = new User();
        user.setAdmin(false);
        reservation.setMadeBy(user);

        //Act
        boolean result = reservation.canBeCancelledBy(user, now.plus(Period.ofDays(4)));

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    public void canBeCancelledBy_TrueStory() {
        //Arrange
        Reservation reservation = new Reservation();
        LocalDateTime now = LocalDateTime.now();
        User user = new User();
        user.setAdmin(false);

        //Act
        boolean result = reservation.canBeCancelledBy(user, now.plus(Period.ofDays(4)));

        //Assert
        assertThat(result).isFalse();
    }

    @Test
    public void canBeCancelledBy_WhenUserOrDateIsNull_ShouldThrowIllegalArgumentException() {
        //Arrange
        Reservation reservation = new Reservation();

        //Act
        Throwable throwable = Java6Assertions.catchThrowable(() -> reservation.canBeCancelledBy(null, null));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("User or date must not be null!!");
    }


    @Test
    public void canBeCancelledBy_WhenUserIsNotAdminAndDateIsNotSuitable_ShouldReturnsFalse() {
        //Arrange
        Reservation reservation = new Reservation();
        LocalDateTime now = LocalDateTime.now();
        User user = new User();
        user.setAdmin(false);

        //Act
        boolean result = reservation.canBeCancelledBy(user, now.minus(Period.ofDays(1)));

        //Assert
        assertThat(result).isFalse();
    }

}
