package com.example.team12_sportfields;

import android.content.Context;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class RegisterActivityTest {

    @Mock
    Context context;

    RegisterActivity registerActivity = new RegisterActivity(context);

    //working test
    @Test
    public void registerTestOne() {

        assertEquals(true, registerActivity.test());
    }

    //failing test
    @Test
    public void registerTestTwo() {

        assertEquals(false, registerActivity.test());
    }


}