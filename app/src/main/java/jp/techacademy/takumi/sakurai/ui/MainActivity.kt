package jp.techacademy.takumi.sakurai.ui

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog //← ここを追加
import android.view.View //← ここを追加
import android.app.DatePickerDialog // ← ここを追加
import kotlinx.android.synthetic.main.activity_main.* // ← ここを追加


class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button1 -> textView.text = editText.text.toString()
            R.id.button2 -> showAlertDialog()
            R.id.button3 -> showTimePickerDialog()
            R.id.button4 -> showDatePickerDialog()
        }
    }


    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("タイトル")
        alertDialogBuilder.setMessage("メッセージ")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("肯定") { dialog, which ->
            Log.d("UI_PARTS", "肯定ボタン")
        }

        // 中立ボタンに表示される文字列、押したときのリスナーを設定する
        // 使わない引数の場合は「_」と記述するのがkotlinの慣習
        alertDialogBuilder.setNeutralButton("中立") { _, _ ->
            Log.d("UI_PARTS", "中立ボタン")
        }

        // 否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton("否定") { _, _ ->
            Log.d("UI_PARTS", "否定ボタン")
        }

        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun showTimePickerDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{ view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
            },
            13, 0, true)
        timePickerDialog.show()
    }

    private fun showDatePickerDialog(){
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener(){ view, year, month, dayOfMonth->
                Log.d("UI_PARTS", "$year/${month+1}/$dayOfMonth")
            },
            2021,7,1)
        datePickerDialog.show()
    }
}