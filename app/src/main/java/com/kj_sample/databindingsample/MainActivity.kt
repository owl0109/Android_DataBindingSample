package com.kj_sample.databindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.format
import androidx.databinding.DataBindingUtil.setContentView
import com.kj_sample.databindingsample.databinding.ActivityMainBinding
import java.lang.String.format
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Bindingオブジェクトを取得
        //後ろの :Activityが大事
        val binding:ActivityMainBinding = setContentView(this,R.layout.activity_main)
        //バインディングにユーザーセット。viewに反映させる
        binding.user = User("Kijima",24)
        val df = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val date = Date()
        binding.textTime.setText(df.format(date))
    }
}