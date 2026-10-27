package com.example.lessonandroidstart

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lessonandroidstart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Создание объекта viewBinding для обращения ко всем UI элементам
    private lateinit var binding: ActivityMainBinding

    // Метод onCreate запускается самым первым и отвечает за СОЗДАНИЕ элементов
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Метод, позволяющий растянуть экран на весь экран устройства
        enableEdgeToEdge()

        // Инициализация viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Метод, передающий макет экрана в код
        setContentView(binding.main)

        // Метод, увеличивающий пространство для кликабельных элементов на экране
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Устаревший способ обращения к элементам
        // Связь между макетом и кодом
        val textView: TextView = findViewById(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        // Работа с текстом
        textView.text = "Привет, я TextView"
        textView.setTextColor(Color.GREEN)

        // Работа с кнопкой
        button.text = "Я кнопка"
        button.setOnClickListener {
            button.text = "Я нажата"
            textView.text = "На меня нажали"
            // Запрет нажатия на кнопку НЕЯВНЫЙ
            button.isClickable = false
            // Запрет нажатия на кнопку ЯВНЫЙ(Кнопка поменяет цвет)
            button.isEnabled = false
        }

        // Работа со Switch
        binding.switch1.setOnClickListener {
            if (binding.switch1.isChecked)
                binding.switch1.text = "Кнопка нажата"
            else
                binding.switch1.text = "Кнопка не нажата"
        }

        // Работа с ImageButton
        binding.imageButton?.setOnClickListener {
            binding.imageButton?.setImageResource(R.drawable.ic_launcher_foreground)
            binding.imageButton?.minimumWidth
        }

        // Работа с полем для ввода текста
        binding.editTextTextEmailAddress.text

        // Отслеживание изменений в поле для ввода текста
        binding.editTextTextEmailAddress.addTextChangedListener(object : TextWatcher {
            // Выполняться ПОСЛЕ ввода текста
            override fun afterTextChanged(p0: Editable?) {
                println(p0.toString())
            }

            // Выполняться ДО ввода текста
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
                println(p0.toString())
            }

            // Выполняться во время ввода текста
            override fun onTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
                // Вывод через println
                println(p0.toString())
                println(p1.toString())
                println(p2.toString())
                println(p3.toString())

                // Вывод через Log
                Log.d("P0", p0.toString())
                Log.d("P1", p1.toString())
                Log.d("P2", p2.toString())
                Log.d("P3", p3.toString())
            }
        })

        // Работа с WebView
        binding.webView.loadUrl("https://google.com")
    }

    // Метод, запускающийся ПОСЛЕ onCreate и показывающий экран приложения
    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart")
    }

    // Метод, запускающийся ПОСЛЕ onStart и позволяющий пользователю работать с элементами
    override fun onResume() {
        super.onResume()
        Log.e("onResume", "onResume")
    }

    // Метод, запускающийся ПОСЛЕ onResume и позволяющий пользователю выйти из приложения
    override fun onPause() {
        super.onPause()
        Log.e("onPause", "onPause")
    }

    // Метод, запускающийся ПОСЛЕ onPause и позволяющий пользователю выйти из приложения и
    // ограничивающий потребление ресурсов телефона
    override fun onStop() {
        super.onStop()
        Log.e("onStop", "onStop")
    }

    // Метод, запускающийся после onStop и позволяющий пользователю вернуться в приложение
    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart", "onRestart")
    }

    // Метод, запускаемый после onStop и подготовливает приложение к закрытию
    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "onDestroy")
    }
}

// Пример класса Активности
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}