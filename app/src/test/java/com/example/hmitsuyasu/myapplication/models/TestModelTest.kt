package com.example.hmitsuyasu.myapplication.models

import com.example.hmitsuyasu.myapplication.utils.FileUtils
import com.google.gson.Gson
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class TestModelTest {
    var model = TestModel()
    @Before
    fun setUp() {
        var gson = Gson()
        model = gson.fromJson(FileUtils.readFile("d1001.json"), TestModel::class.java)
    }

    @Test
    fun getOrdinary() {
        assertThat(model.ordinary?.size, `is`(9))
        assertThat(model.links?.size, `is`(8))
        val list = model.createRoute()
        assertThat(list?.size, `is`(17))
        assertThat(list?.get(0)?.lat, `is`(123.100))
        assertThat(list?.get(1)?.lat, `is`(234.100))
        assertThat(list?.get(2)?.lat, `is`(123.100))
        assertThat(list?.get(3)?.lat, `is`(234.100))
        assertThat(list?.get(4)?.lat, `is`(123.100))
        assertThat(list?.get(5)?.lat, `is`(234.100))
        assertThat(list?.get(6)?.lat, `is`(123.100))
        assertThat(list?.get(7)?.lat, `is`(234.100))
        assertThat(list?.get(8)?.lat, `is`(123.100))
        assertThat(list?.get(9)?.lat, `is`(234.100))
        assertThat(list?.get(10)?.lat, `is`(123.100))
        assertThat(list?.get(11)?.lat, `is`(234.100))
        assertThat(list?.get(12)?.lat, `is`(123.100))
        assertThat(list?.get(13)?.lat, `is`(234.100))
        assertThat(list?.get(14)?.lat, `is`(123.100))
        assertThat(list?.get(15)?.lat, `is`(234.100))
        assertThat(list?.get(16)?.lat, `is`(123.100))

        assertThat(list?.get(0)?.lng, `is`(123.101))
        assertThat(list?.get(1)?.lng, `is`(234.101))
        assertThat(list?.get(2)?.lng, `is`(123.102))
        assertThat(list?.get(3)?.lng, `is`(234.102))
        assertThat(list?.get(4)?.lng, `is`(123.103))
        assertThat(list?.get(5)?.lng, `is`(234.103))
        assertThat(list?.get(6)?.lng, `is`(123.104))
        assertThat(list?.get(7)?.lng, `is`(234.104))
        assertThat(list?.get(8)?.lng, `is`(123.105))
        assertThat(list?.get(9)?.lng, `is`(234.105))
        assertThat(list?.get(10)?.lng, `is`(123.106))
        assertThat(list?.get(11)?.lng, `is`(234.106))
        assertThat(list?.get(12)?.lng, `is`(123.107))
        assertThat(list?.get(13)?.lng, `is`(234.107))
        assertThat(list?.get(14)?.lng, `is`(123.108))
        assertThat(list?.get(15)?.lng, `is`(234.108))
        assertThat(list?.get(16)?.lng, `is`(123.109))
    }

    @Test
    fun setOrdinary() {
    }

    @Test
    fun getLinks() {
    }

    @Test
    fun setLinks() {
    }
}