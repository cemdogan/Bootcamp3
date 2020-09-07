package org.kodluyoruz.bootcamp3;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleTests {

    @Test
    public void sayHello_WhenCall_ShouldReturnHelloWorldString() {
        //Arrange
        Sample sample = new Sample();
        //Act
        String result = sample.sayHello("kodluyoruz");
        //Assert
        Assert.assertEquals(result, "Hello kodluyoruz");
        assertThat(result).isEqualTo("Hello kodluyoruz");
    }
}
