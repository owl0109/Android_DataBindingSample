# DataBindingのやり方～Kotlin編～
## build.gradleに「dataBinding」を追加する
```
andriod{
  //dataBinding,enabled=trueが結構重要
  dataBinding{
    enabled = true
  }
}

```

## data class を作成する
```
//これdata class にしないとバグ起きる
data class User(var nameString: String, var ageInt: Int) {
  //このObservableのフィールドは、値に変更があった場合に対応するレイアウトに変更できる
    var name = ObservableField<String>()
    var age = ObservableField<String>()
    var likes = ObservableInt()
    var btnTxt = ObservableField<String>()
    var result = false
    var loading = ObservableField<Boolean>()
    ~~~~省略。下には処理内容が続く~~~~
}
```

## layoutファイルに記述する
```
<!-- Layoutではなくlayout。間違えてバグが出たよ(笑 -->
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <!-- Userクラスにバインドする -->
    <data>
        <import type="android.view.View"/>
        <variable
            name="user"
            type="com.kj_sample.databindingsample.User" />
    </data>
~~~~~省略~~~~~~~
<!-- "@{user.○○}"でバインドした内容を反映する  -->
  <Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@{user.btnTxt}"
    android:onClick="@{user::btnClick}"
     />
 <ProgressBar
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:visibility="@{user.loading ? View.VISIBLE : View.INVISIBLE}"
     />
~~~~~省略~~~~~~
</layout>
```

## ActivityにてdataBindingの設定をする
```
//後ろの:ActivityMainBindingが何気に大事。ないとエラー
val binding:ActivityMainBinding = setContentView(this,R.layout.activity_main)
//バインドのユーザをセットする。Userはデータクラス
binding.setUser = User("kijima",24)
//layoutファイルにてIdを設定しているとここで宣言できる
binding.textTime.setText(○○○○)

```

参考サイト: https://riptutorial.com/ja/android/example/16219/model-view-presenter-mvp-%E3%83%91%E3%82%BF%E3%83%BC%E3%83%B3%E3%81%AE%E3%83%AD%E3%82%B0%E3%82%A4%E3%83%B3%E4%BE%8B
