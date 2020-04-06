package com.example.team12_sportfields;

import android.content.Context;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class LoginActivityTest {
    @Mock
    Context context;

    LoginActivity loginActivity = new LoginActivity(context);

    //working test
    @Test
    public void loginAccessOne() {
        assertEquals(true, loginActivity.test());
    }

    //failed test
    @Test
    public void loginAccessTwo() {
        assertEquals(false, loginActivity.test());
    }

    //working login test
    @Test
    public void LoginAccessThree() {
        assertEquals(true, loginActivity.loginAction("moshe159@gmail.com", "123456"));
    }

}