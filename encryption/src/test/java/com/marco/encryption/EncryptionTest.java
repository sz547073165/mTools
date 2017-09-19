package com.marco.encryption;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EncryptionTest {
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;

    @Before
    public void setUp() throws Exception {
        str1 = null;
        str2 = "";
        str3 = " ";
        str4 = "  ";
        str5 = "abc";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encodeByMD5WithLowerCase() throws Exception {
        System.out.println(Encryption.encodeByMD5WithLowerCase(str1));
        System.out.println(Encryption.encodeByMD5WithLowerCase(str2));
        System.out.println(Encryption.encodeByMD5WithLowerCase(str3));
        System.out.println(Encryption.encodeByMD5WithLowerCase(str4));
        System.out.println(Encryption.encodeByMD5WithLowerCase(str5));
    }

    @Test
    public void encodeByMD5() throws Exception {
        System.out.println(Encryption.encodeByMD5WithUpperCase(str1));
        System.out.println(Encryption.encodeByMD5WithUpperCase(str2));
        System.out.println(Encryption.encodeByMD5WithUpperCase(str3));
        System.out.println(Encryption.encodeByMD5WithUpperCase(str4));
        System.out.println(Encryption.encodeByMD5WithUpperCase(str5));
    }

}