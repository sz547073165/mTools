package com.marco.string;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringToolTest {
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;

    @Before
    public void setUp() throws Exception {
        str1 = null;
        str2 = "";
        str3 = " ";
        str4 = "abc";
        str5 = "abc ";
        str6 = " abc";
        str7 = "a b c";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(StringTool.isEmpty(str1));
        System.out.println(StringTool.isEmpty(str2));
        System.out.println(StringTool.isEmpty(str3));
        System.out.println(StringTool.isEmpty(str4));
        System.out.println(StringTool.isEmpty(str5));
        System.out.println(StringTool.isEmpty(str6));
        System.out.println(StringTool.isEmpty(str7));
    }

    @Test
    public void isNotEmpty() throws Exception {
        System.out.println(StringTool.isNotEmpty(str1));
        System.out.println(StringTool.isNotEmpty(str2));
        System.out.println(StringTool.isNotEmpty(str3));
        System.out.println(StringTool.isNotEmpty(str4));
        System.out.println(StringTool.isNotEmpty(str5));
        System.out.println(StringTool.isNotEmpty(str6));
    }

    @Test
    public void isBlank() throws Exception {
        System.out.println(StringTool.isBlank(str1));
        System.out.println(StringTool.isBlank(str2));
        System.out.println(StringTool.isBlank(str3));
        System.out.println(StringTool.isBlank(str4));
        System.out.println(StringTool.isBlank(str5));
        System.out.println(StringTool.isBlank(str6));
    }

    @Test
    public void isNotBlank() throws Exception {
        System.out.println(StringTool.isNotBlank(str1));
        System.out.println(StringTool.isNotBlank(str2));
        System.out.println(StringTool.isNotBlank(str3));
        System.out.println(StringTool.isNotBlank(str4));
        System.out.println(StringTool.isNotBlank(str5));
        System.out.println(StringTool.isNotBlank(str6));
    }

    @Test
    public void trimBlank() throws Exception {
        System.out.println(StringTool.trimBlank(str1));
        System.out.println(StringTool.trimBlank(str2));
        System.out.println(StringTool.trimBlank(str3));
        System.out.println(StringTool.trimBlank(str4));
        System.out.println(StringTool.trimBlank(str5));
        System.out.println(StringTool.trimBlank(str6));
        System.out.println(StringTool.trimBlank(str7));
    }

    @Test
    public void trimBlank2Null() throws Exception {
        System.out.println(StringTool.trimBlank2Null(str1));
        System.out.println(StringTool.trimBlank2Null(str2));
        System.out.println(StringTool.trimBlank2Null(str3));
        System.out.println(StringTool.trimBlank2Null(str4));
        System.out.println(StringTool.trimBlank2Null(str5));
        System.out.println(StringTool.trimBlank2Null(str6));
        System.out.println(StringTool.trimBlank2Null(str7));
    }

    @Test
    public void trimBlank2Empty() throws Exception {
        System.out.println(StringTool.trimBlank2Empty(str1));
        System.out.println(StringTool.trimBlank2Empty(str2));
        System.out.println(StringTool.trimBlank2Empty(str3));
        System.out.println(StringTool.trimBlank2Empty(str4));
        System.out.println(StringTool.trimBlank2Empty(str5));
        System.out.println(StringTool.trimBlank2Empty(str6));
        System.out.println(StringTool.trimBlank2Empty(str7));
    }

    @Test
    public void equals() throws Exception {
        System.out.println(StringTool.equals(str1, str2));
        System.out.println(StringTool.equals(str1, str3));
    }

}