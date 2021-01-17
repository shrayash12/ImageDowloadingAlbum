package com.example.myimagedownloadingalbum;

import com.example.myimagedownloadingalbum.com.example.myimagedownloadingalbum.view.Something;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SomethingTest {

    Something something;

    @Before
    public void setUp() {
        something = new Something();
    }

    @Test
    public void factTest() {

        int ans = something.fact(5);

        Assert.assertEquals(120, ans);
    }
}
