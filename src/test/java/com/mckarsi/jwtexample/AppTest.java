package com.mckarsi.jwtexample;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void mainTest() {
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        System.setOut(out);
        App.main(new String[]{});
        System.out.flush();
        System.setOut(old);
        String s = baos.toString(Charset.defaultCharset());
        assertNotNull(s);
        assertEquals(3, s.split("\\.").length);
    }
}