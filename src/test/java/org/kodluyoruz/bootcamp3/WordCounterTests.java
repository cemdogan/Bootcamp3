package org.kodluyoruz.bootcamp3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCounterTests {

    @Test
    public void add_whenAddEmptyString_shouldHasNoWords(){
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        sut.add("");

        //Assert
        assertThat(sut.getUniqueWordsCount()).isEqualTo(0);
    }

    @Test
    public void add_whenAddSingleString_shouldHasOneWord(){
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        sut.add("Hello");

        //Assert
        assertThat(sut.getUniqueWordsCount()).isEqualTo(1);
    }

    @Test
    public void add_whenAddTwoString_shouldHasTwoWords(){
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        sut.add("Hello");
        sut.add("World");

        //Assert
        assertThat(sut.getUniqueWordsCount()).isEqualTo(2);
    }

    @Test
    public void add_whenAddMultipleWordString_shouldHasCorrectWordCount(){
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        sut.add("one two three");

        //Assert
        assertThat(sut.getUniqueWordsCount()).isEqualTo(3);
    }

    @Test
    public void add_whenAddSeveralMultipleWordString_shouldHasCorrectWordCount(){
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        sut.add("one two three");
        sut.add("four five six");

        //Assert
        assertThat(sut.getUniqueWordsCount()).isEqualTo(6);
    }

    @Test
    public void add_whenSpaceOutMultipleWordString_shouldHasCorrectWordCount(){
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        sut.add("      one      two      three      ");

        //Assert
        assertThat(sut.getUniqueWordsCount()).isEqualTo(3);
    }

    @Test
    public void add_WhenInputWithDuplicates_ShouldCountsOnlyIndividualCases(){
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        sut.add("nine nine nine nine");

        //Assert
        assertThat(sut.getUniqueWordsCount()).isEqualTo(1);
    }

    @Test
    public void add_WhenInputWithMixedCaseDuplicates_ShouldCountsOnlyIndividualCases(){
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        sut.add("Nine nIne NINE niNE");

        //Assert
        assertThat(sut.getUniqueWordsCount()).isEqualTo(1);
    }

    @Test
    public void add_WhenInputWithPunctuation_ShouldStillSpotsDuplicates(){
        //Arrange
        WordCounter sut = new WordCounter();

        //Act
        sut.add("Nine.");
        sut.add("Nine ten.");
        sut.add("Nine, ten, eleven.");

        //Assert
        assertThat(sut.getUniqueWordsCount()).isEqualTo(3);
    }
}
