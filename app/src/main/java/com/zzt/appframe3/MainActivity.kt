package com.zzt.appframe3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zzt.mylibrary2.ActDemo
import com.zzt.mylibrary2.DemosAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.LinkedHashMap


class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    var mapSource: LinkedHashMap<String, String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建1-10数组：Array(10,i->i+1)
        //i代表元素的索引值从0开始

        val demoList: Array<ActDemo> = arrayOf<ActDemo>(
            ActDemo("Messenger 多进程通信", "Messenger 使用", ActivityAutoButton::class.java)
        )
        DemosAdapter.setAdapterData(rv_list, demoList)

        Thread(Runnable {
            for (index in 0..1000) {
                addMap();
//                Thread.sleep((Math.random() * 100).toLong())
                Thread.sleep(4 * 1000)
            }
        }).start()

        Thread(Runnable {
            Thread.sleep(10 * 1000)
//            getMap(mapSource, 999)
            for (index in 999 downTo 0) {
                getMap(mapSource, index)
                Thread.sleep(5 * 1000)
            }
        }).start()
    }

    var iii: Int = 0
    fun addMap() {
        Thread(Runnable {
            if (mapSource == null) {
                mapSource = LinkedHashMap()

            }
            mapSource?.clear()
            Log.e(TAG, "清理数据 ${iii}  ")
            for (i in 0..100) {
                mapSource?.put("Key $i", "Value $i 清理的数据${iii}")
                Thread.sleep(5)
            }
            Collections.synchronizedMap(mapSource)
            iii++
        }).start()
    }

//    @Synchronized
    fun getMap(mapOld: LinkedHashMap<String, String>?, loop: Int) {
        val des: LinkedHashMap<String, String> = LinkedHashMap()
        try {
            mapOld?.let { des.putAll(it) }
        } catch (e: Exception) {
            e.printStackTrace()
//            val alertDialog = android.app.AlertDialog.Builder(this@MainActivity)
//            alertDialog.setTitle("这个地方报错了")
//            alertDialog.setMessage(e.message)
//            alertDialog.show()
        }

//        Thread(Runnable {
        if (des != null) {
            synchronized(des) {
                for ((key, entry) in des) {
                    Log.d(TAG, "获取数据 ${loop} key:${key} - value:${entry}")
                    Thread.sleep(100)
                }
            }
        }
//        }).start()
    }


}