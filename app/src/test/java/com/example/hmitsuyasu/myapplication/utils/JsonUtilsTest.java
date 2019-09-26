package com.example.hmitsuyasu.myapplication.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by hmitsuyasu on 2019/03/26.
 */
public class JsonUtilsTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * getJsonArray()
     * <p>Case
     * <br>
     * <p>期待値
     * <br>
     */
    @Test
    public void test_getJsonArray_001() throws Exception {
        String[] result = JsonUtils.getJsonArray("mst_table/mst_dia.json");
        assertNotNull(result);
        assertThat(result.length, is(6));
        assertThat(result[0], is("1001"));
        assertThat(result[1], is("1002"));
        assertThat(result[2], is("1003"));
        assertThat(result[3], is("2001"));
        assertThat(result[4], is("2002"));
        assertThat(result[5], is("3002"));
    }

    /**
     * getJsonArray()
     * <p>Case
     * <br>Json形式に不正がある場合
     * <p>期待値
     * <br>null
     */
    @Test
    public void test_getJsonArray_e001() throws Exception {
        String[] result = JsonUtils.getJsonArray("mst_table/mst_dia_e001.json");
        assertNull(result);
    }

    /**
     * getJsonArray()
     * <p>Case
     * <br>存在しないファイルからは取得できない。
     * <p>期待値
     * <br>null
     */
    @Test
    public void test_getJsonArray_e002() throws Exception {
        String[] result = JsonUtils.getJsonArray("mst_table/mst_dia_.json");
        assertNull(result);
    }

    /**
     * getJsonArray()
     * <p>Case
     * <br>存在しないファイルからは取得できない。
     * <p>期待値
     * <br>null
     */
    @Test
    public void test_getJsonArray_e003() throws Exception {
        String[] result = JsonUtils.getJsonArray("mst_table/mst_dia_e003.json");
        assertThat(result.length, is(0));
    }
}