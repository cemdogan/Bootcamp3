package org.kodluyoruz.bootcamp3;


import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTests {

    @BeforeAll
    public static void setupAll(){
        System.out.println("setups before all tests");
    }

    @BeforeEach
    public void setupTest(){
        System.out.println("setups each test");
    }

    @AfterAll
    public static void cleanupAll(){
        System.out.println("clean up after all tests");
    }

    @AfterEach
    public void cleanupEach(){
        System.out.println("clean up each test");
    }

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
