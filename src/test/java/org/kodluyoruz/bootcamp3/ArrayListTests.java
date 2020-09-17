package org.kodluyoruz.bootcamp3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTests {


    @Test
    public void add_trueStory(){
        //Arrange
        ArrayList sut = new ArrayList();
        String newElement = "yavuz";

        sut.add(newElement);

        //Assert
        assertThat(sut).hasSize(1);
    }

    @Test
    public void remove_trueStory() {
        //Arrange
        ArrayList sut = new ArrayList();
        sut.add("kutlu");
        sut.add("cem");

        //Act
        sut.remove("kutlu");

        //Assert
        assertEquals(1, sut.size());
    }

    @Test
    public void sort_trueStory() {
        //Arrange
        ArrayList sut = new ArrayList();
        sut.add("kutlu");
        sut.add("cem");
        sut.add("mustafa");

        //Act
        sut.sort(Comparator.naturalOrder());

        //Assert
        String[] expected = {"cem", "kutlu", "mustafa"};
        assertArrayEquals(sut.toArray(), expected);
    }

    @Test
    public void set_trueStory() {
        //Arrange
        ArrayList sut = new ArrayList();
        sut.add("kutlu");
        sut.add("cem");
        sut.add("mustafa");

        final String replacementElement = "yavuz";

        //Act
        sut.set(1, replacementElement);

        //Assert
        assertFalse(sut.contains("cem"));
        assertTrue(sut.contains(replacementElement));
        assertEquals(sut.get(1), replacementElement);
    }


}
