package br.com.lno.androidmvvm.presentation.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lno.androidmvvm.R
import br.com.lno.androidmvvm.presentation.view.fragment.ToDoFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.main_content, ToDoFragment(), "ToDoFragment").commit()
    }
}