package com.twu.biblioteca.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class InventoryTest {

    @Test
    public void shouldListBeEqualToInventory() {
        boolean expected = false;
        Inventory inventory = mock(Inventory.class);
        boolean actual = inventory.isListEqualToInventory();
        assertEquals(expected, actual);
    }

}