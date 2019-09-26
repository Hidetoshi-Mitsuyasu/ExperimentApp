package com.example.hmitsuyasu.myapplication.models

interface Observer {
    abstract fun update(generator: NumberGenerator)
}