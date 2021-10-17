package com.example.interfacepractices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), MyCustomDialogInterface {

    val TAG : String ="로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity - onCreate() called()")
    }
    fun onDialogBtnClicked(view : View){
        Log.d(TAG, "MainActivity - onDialogBtnClicked() called()")

        val myCustomDialog = MyCustomDialog(this,this)

        myCustomDialog.show()
    }

    // 구독 버튼 클릭
    override fun onSubscribeBtnClicked() {
        Log.d(TAG, "MainActivity - onSubscribeBtnClicked() called()")
        Toast.makeText(this,"구독 버튼 클릭", Toast.LENGTH_SHORT).show()
    }
    // 좋아요 버튼 클릭
    override fun onLikeBtnClicked() {
        Log.d(TAG, "MainActivity - onLikeBtnClicked() called()")
        Toast.makeText(this,"좋아요 버튼 클릭", Toast.LENGTH_SHORT).show()
    }
}