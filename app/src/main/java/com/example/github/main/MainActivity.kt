package com.example.github.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github.R
import com.example.github.main.adapter.RepositoryAdapter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    @Inject
    lateinit var viewModel: MainViewModel
    @Inject
    lateinit var adapter: RepositoryAdapter
    private lateinit var linearLayout: LinearLayoutManager

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = LinearLayoutManager(this).apply {
            this.isItemPrefetchEnabled = true
            this.initialPrefetchItemCount = 20
        }

        recyclerView.layoutManager = linearLayout
        recyclerView.adapter = adapter.apply {

        }

        viewModel.state.observe(this, Observer {
            adapter.submitList(it.uiItems)
        })
        viewModel.getRepository()
    }

}
