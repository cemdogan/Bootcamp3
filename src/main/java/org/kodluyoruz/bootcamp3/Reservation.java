package org.kodluyoruz.bootcamp3;

import java.time.LocalDateTime;
import java.time.Period;

public class Reservation {

    private User madeBy;

    public boolean canBeCancelledBy(User user, LocalDateTime reservationDate) {

        if(user == null || reservationDate == null){
            throw new IllegalArgumentException("User or date must not be null!!");
        }

        LocalDateTime now = LocalDateTime.now();

        if (user.isAdmin()) {
            return true;
        }

        if(reservationDate.minus(Period.ofDays(3)).isBefore(now)){
            return false;
        }

        if (madeBy == user) {
            return true;
        }

        return false;
    }

    public void setMadeBy(User madeBy) {
        this.madeBy = madeBy;
    }
}

