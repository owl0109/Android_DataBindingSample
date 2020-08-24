package com.kj_sample.databindingsample

import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt


data class User(var nameString: String, var ageInt: Int) {
    //このObservableのフィールドは、値に変更があった場合に対応するレイアウトに変更できる
    var name = ObservableField<String>()
    var age = ObservableField<String>()
    var likes = ObservableInt()
    var btnTxt = ObservableField<String>()
    var result = false
    var loading = ObservableField<Boolean>()

    init {
        name.set(nameString)
        age.set(ageInt.toString())
        likes.set(0)
        btnTxt.set("グルグルを表示する")
        loading.set(false)
    }

    fun onClickLike(view: View?) {
        //この時点でsetOnClickListenerを設定する必要がなくなった
        likes.set(likes.get() + 1)
    }

    fun btnClick(view:View?){
        if (result) {
            btnTxt.set("ぐるぐるを表示する")
            loading.set(false)
            result = false
        }else{
            btnTxt.set("ぐるぐるを消す")
            loading.set(true)
            result = true
        }
    }
}
