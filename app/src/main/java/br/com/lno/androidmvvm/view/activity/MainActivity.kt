package br.com.lno.androidmvvm.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lno.androidmvvm.R
import br.com.lno.androidmvvm.view.fragment.DataFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.main_content, DataFragment(), "DataFragment").commit()
    }
}