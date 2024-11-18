package com.lekciya.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.OnBackPressedCallback

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        val textViewMessage = findViewById<TextView>(R.id.textViewMessage)
        textViewMessage.text = message

        val btnBackToMain = findViewById<Button>(R.id.btnBackToMain)
        btnBackToMain.setOnClickListener {
           // finish() // Закрывает текущую Activity и возвращается на предыдущую
            this.onBackPressed()


        }

        // Добавляем обработчик нажатия "Назад"
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Здесь обрабатывается нажатие кнопки "Назад"
                // Например, показываем диалог или выполняем кастомное действие
                showExitConfirmationDialog()
            }
        })
    }

    private fun showExitConfirmationDialog() {
        // Пример: Показываем подтверждающий диалог перед выходом
        val dialog = android.app.AlertDialog.Builder(this)
            .setTitle("Выход")
            .setMessage("Вы уверены, что хотите выйти?")
            .setPositiveButton("Да") { _, _ ->
                finish() // Закрываем Activity
            }
            .setNegativeButton("Нет", null)
            .create()
        dialog.show()
    }
}