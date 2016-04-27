package com.ninestairs.playlayout;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void typeShouldBeInt(){

        int key = new KeyGenerator(3).generate();

        assertEquals(2,key);
    }
}