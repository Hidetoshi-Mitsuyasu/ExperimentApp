package com.example.hmitsuyasu.myapplication.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.hmitsuyasu.myapplication.models.NumberGenerator
import com.example.hmitsuyasu.myapplication.models.TestModel
import kotlinx.coroutines.*

class TestService : Service() {
    private val TAG: String = javaClass.simpleName
    private val supervisorJob = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Default + supervisorJob)
    private var isRunning = false

    var model: TestModel? = null
    var generator: NumberGenerator? = null

    companion object {
        val INTENT_ACTION_START = "INTENT_ACTION_START"
        val INTENT_ACTION_CHANGE = "INTENT_ACTION_CHANGE"
        val INTENT_ACTION_FINISH = "INTENT_ACTION_FINISH"
        val INTENT_EXTRA_TEST_MODEL = "INTENT_EXTRA_TEST_MODEL"
        val INTENT_EXTRA_GENERATOR = "INTENT_EXTRA_GENERATOR"
    }

    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        model = intent?.getSerializableExtra(INTENT_EXTRA_TEST_MODEL) as TestModel?
        generator = intent?.getSerializableExtra(INTENT_EXTRA_GENERATOR) as NumberGenerator
        if (isRunning) {
            return START_STICKY
        }
        loopTask01()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun loopTask01() = scope.launch {
        isRunning = true
        scope.launch {
            for (i in 1..5000) {
                Log.d(
                    TAG, String.format(
                        "id:%s,name:%s,%s回目", model?.id ?: "", model?.name
                            ?: "", i
                    )
                )
                generator?.execute()
                delay(3000L)
            }
            isRunning = false
            stopSelf()
        }
    }
}