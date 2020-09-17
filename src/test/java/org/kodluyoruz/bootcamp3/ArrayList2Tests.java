package org.kodluyoruz.bootcamp3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayList2Tests {

    private ArrayList sut = new ArrayList();
    private String[] allNames = {"cem", "kutlu", "mustafa", "kamil"};

    @BeforeEach
    public void setup() {
        sut.addAll(Arrays.asList(allNames));
    }

    @AfterEach
    public void cleanup() {
        sut.clear();
    }

    @Test
    public void add_trueStory_2(){
        //Arrange
        ArrayList sut = new ArrayList();
        String newElement = "yavuz";

        sut.add(newElement);

        //Assert
        assertThat(sut).hasSize(1);
    }

    @Test
    public void add_trueStory() {
        //Arrange
        int beforeSize = sut.size();
        String newElement = "yavuz";

        sut.add(newElement);

        //Assert
        assertEquals(beforeSize + 1, sut.size());
        assertTrue(sut.contains(newElement));
    }

    @Test
    public void remove_trueStory() {
        //Arrange
        int beforeSize = sut.size();
        String lastElement = (String) sut.get(sut.size() - 1);

        //Act
        sut.remove(lastElement);

        //Assert
        assertEquals(beforeSize - 1, sut.size());
        assertFalse(sut.contains(lastElement));
    }

    @Test
    public void sort_trueStory() {
        //Act
        sut.sort(Comparator.naturalOrder());

        //Assert
        String[] expected = Arrays.copyOf(allNames, allNames.length);
        Arrays.sort(expected);
        assertArrayEquals(sut.toArray(), expected);
    }

    @Test
    public void set_trueStory() {
        //Arrange
        String existingElementAtIndex1 = (String) sut.get(1);
        String replacementElementAtIndex1 = "nil";

        //Act
        sut.set(1, replacementElementAtIndex1);

        //Assert
        assertFalse(sut.contains(existingElementAtIndex1));
        assertTrue(sut.contains(replacementElementAtIndex1));
        assertEquals(sut.get(1), replacementElementAtIndex1);
    }

}
