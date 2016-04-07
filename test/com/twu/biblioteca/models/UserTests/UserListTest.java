package com.twu.biblioteca.models.UserTests;

import com.twu.biblioteca.models.user.User;
import com.twu.biblioteca.models.user.UserList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserListTest {

    @Test
    public void shouldHaveUserOnUsersList() {
        List<User> users = UserList.VALUES;
        String expected = users.get(0).getName();
        String actual = "Klaus";
        assertEquals(expected, actual);
    }
}