package com.example.hmitsuyasu.myapplication.models

import java.io.Serializable

class TestModel : Serializable {
    var id: String
    var name: String
    var ordinary: Array<Ordinary>? = null
    var links: Array<Links>? = null

    fun createRoute(): MutableList<Location>? {
        val list: ArrayList<Location> = arrayListOf()
        var i = 0
        ordinary?.forEach {
            list.add(Location(it.lat, it.lng))
            if (ordinary!!.lastIndex != i) {
                links?.let {
                    list.add(Location(it.get(i).lat, it.get(i).lng))
                }
            }
            i++
        }
        return list
    }

    fun method001() {
        //コンフリクトする
    }

    class Route(links: Links, ordinary: Ordinary) {

    }

    class Location(var lat: Double, var lng: Double) {
    }

    class Links {
        var lat: Double = 0.0
        var lng: Double = 0.0
    }

    class Ordinary {
        var lat: Double = 0.0
        var lng: Double = 0.0
    }

    constructor() {
        this.id = ""
        this.name = ""
    }

    constructor(id: String, name: String) {
        this.id = id
        this.name = name
    }
}