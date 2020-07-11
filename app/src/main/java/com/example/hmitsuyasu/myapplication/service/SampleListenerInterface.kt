package com.example.hmitsuyasu.myapplication.service

import java.util.*

interface SampleListenerInterface : EventListener {

    /**
     * 文字が入力されていない状態を通知する
     */
    fun noInputText()


    /**
     * 文字が入力されている状態を通知する
     */
    fun inputText()
}
