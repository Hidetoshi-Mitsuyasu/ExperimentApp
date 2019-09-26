package com.example.hmitsuyasu.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.hmitsuyasu.myapplication.models.DegitObserver
import com.example.hmitsuyasu.myapplication.models.GraphObserver
import com.example.hmitsuyasu.myapplication.models.RandomNumberGenerator
import com.example.hmitsuyasu.myapplication.models.TestModel
import com.example.hmitsuyasu.myapplication.service.TestService
import com.example.hmitsuyasu.myapplication.service.TestService.Companion.INTENT_EXTRA_GENERATOR
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val TAG: String = javaClass.simpleName
    val generator = RandomNumberGenerator()
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home          -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard     -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        this.button1.setOnClickListener {
            Log.d(TAG, String.format("id:%s,name:%s,%s回目 Start", this.button1.id, this.button1.text, 1))
            startNewService(TestModel("001", "Start"))
            Log.d(TAG, String.format("id:%s,name:%s,%s回目 Finish", this.button1.id, this.button1.text, 1))
        }
        this.button2.setOnClickListener {
            //            startNewService(TestModel("002","Change"))
            val degitObserver = DegitObserver().also { }
            generator.addObserver(degitObserver)

        }
        this.button3.setOnClickListener {
            //            startNewService(TestModel("002","Change"))
            val graphObserver = GraphObserver()
            generator.addObserver(graphObserver)
        }
    }

    private fun startNewService(model: TestModel) {
        Intent(applicationContext, TestService::class.java).also {
            it.action = TestService.INTENT_ACTION_START
            it.putExtra(TestService.INTENT_EXTRA_TEST_MODEL, model)


            it.putExtra(INTENT_EXTRA_GENERATOR, generator)
            startService(it)
        }
    }
}
