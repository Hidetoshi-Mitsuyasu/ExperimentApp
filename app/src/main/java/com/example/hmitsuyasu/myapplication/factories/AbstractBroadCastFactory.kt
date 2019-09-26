package com.example.hmitsuyasu.myapplication.factories

abstract class AbstractBroadCastFactory {
    val TAG = "AbstractBroadCastFactory"
    var 系統番号: String = ""
    fun setRouteCode(code: String) {
        系統番号 = code
    }
}