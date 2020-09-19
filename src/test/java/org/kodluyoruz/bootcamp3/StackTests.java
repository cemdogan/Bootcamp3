package org.kodluyoruz.bootcamp3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackTests {
    @Test
    public void push_WhenArgIsNull_ShouldThrowNullPointerException() {
        //Arrange
        Stack<String> stack = new Stack<String>();
        //Act

        //Assert
        Assertions.assertThrows(NullPointerException.class, () ->{stack.push(null);});
    }

    @Test
    public void push_WhenValidArg_ShouldAddTheObjectToTheStack() {
        //Arrange
        Stack<String> stack = new Stack<String>();
        //Act
        stack.push("deneme");
        //Assert
        assertThat(stack.count()).isEqualTo(1);
    }

    @Test
    public void count_WhenEmptyStack_ShouldReturnZero() {
        //Arrange
        Stack<String> stack = new Stack<String>();
        //Act
        int result = stack.count();
        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void pop_WhenArgIsNull_ShouldThrowIllegalStateException() {
        //Arrange
        Stack<String> stack = new Stack<String>();
        //Act

        //Assert
        Assertions.assertThrows(IllegalStateException.class, () ->{stack.pop();});
    }

    @Test
    public void pop_WhenStackWithAFewObjects_ShouldReturnObjectOnTheTop() {
        //Arrange
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        //Act
        String result = stack.pop();
        //Assert
        assertThat(result).isEqualTo("c");

    }

    @Test
    public void pop_WhenStackWithAFewObjects_ShouldRemoveObjectOnTheTop() {
        //Arrange
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        //Act
        String result = stack.pop();
        //Assert
        assertThat(stack.count()).isEqualTo(2);
    }

    @Test
    public void peek_WhenEmptyStack_ShouldThrowIllegalStateException() {
        //Arrange
        Stack<String> stack = new Stack<String>();
        //Act

        //Assert
        Assertions.assertThrows(IllegalStateException.class, () ->{stack.peek();});
    }

    @Test
    public void peek_WhenStackWithObjects_ShouldReturnObjectOnTopOfTheStack() {
        //Arrange
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        //Act
        String result = stack.peek();
        //Assert
        assertThat(result).isEqualTo("c");
    }

    @Test
    public void peek_WhenStackWithObjects_ShouldDoesNotRemoveTheObjectOnTopOfTheStack() {
        //Arrange
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        //Act
        String result = stack.peek();
        //Assert
        assertThat(stack.count()).isEqualTo(3);
    }
}
