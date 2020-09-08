package org.kodluyoruz.bootcamp3;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTests {

    @Test
    public void sayHello_WhenCall_ShouldReturnHelloWorldString() {
        //Arrange
        Sample sample = new Sample();
        String str = "kodluyoruz";
        //Act
        String result = sample.sayHello(str);
        //Assert
        assertEquals(result, "Merhaba " + str);
        assertThat(result).isEqualTo("Merhaba "+ str);
    }
}
