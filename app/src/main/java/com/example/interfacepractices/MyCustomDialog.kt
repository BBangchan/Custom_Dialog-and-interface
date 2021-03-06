package com.example.interfacepractices

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.custom_dialog.*

// MyCustomDialog가 Dialog를 상속으로 받아서 사용한다.
class MyCustomDialog(context: Context,
                    mycustomDialogInterface: MyCustomDialogInterface)
                    : Dialog(context), View.OnClickListener {

    val TAG : String ="로그"

    //
    private var mycustomDialogInterface : MyCustomDialogInterface? = null

    // 인터페이스 연결
    init {
        this.mycustomDialogInterface = mycustomDialogInterface
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.custom_dialog)
        Log.d(TAG, "MyCustomDialog - onCreate() called()")
        // 배경 투명
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        like_btn.setOnClickListener(this)
        subscribe_btn.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when(view){
            // 좋아요 버튼이 클릭 되었을때
            like_btn -> {
                Log.d(TAG, "MyCustomDialog - 좋아요 버튼 클릭!")
                this.mycustomDialogInterface?.onLikeBtnClicked()
            }

            // 구독 버튼이 클릭 되었을때
            subscribe_btn -> {
                Log.d(TAG, "MyCustomDialog - 구독 버튼 클릭!")
                this.mycustomDialogInterface?.onSubscribeBtnClicked()
            }
        }
    }

}