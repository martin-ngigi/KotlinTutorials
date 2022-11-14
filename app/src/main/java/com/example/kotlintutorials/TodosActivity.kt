package com.example.kotlintutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintutorials.adapters.AdapterTodo
import com.example.kotlintutorials.models.ModelTodo
import kotlinx.android.synthetic.main.activity_todos.*
import kotlinx.android.synthetic.main.row_todo.*

class TodosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos)

        //data to be added
        var todosList = mutableListOf(
            ModelTodo("Following Android Devs", false),
            ModelTodo("Following Android Devs 1", false),
            ModelTodo("Following Android Devs 2", true),
            ModelTodo("Following Android Devs 3", false),
            ModelTodo("Following Android Devs 4", true),
            ModelTodo("Following Android Devs 5" , false),
            ModelTodo("Following Android Devs 6", true),
        )

        //set adapter
        val adapter = AdapterTodo(todosList)
        rv_todo.adapter = adapter
        //rv_todo.layoutManager = LinearLayoutManager(this)

        //handle btn_add_todo click listener
        btn_add_todo.setOnClickListener {
            val title = et_todo.text.toString()
            val todo = ModelTodo(title, false)
            todosList.add(todo)
            //refresh changes
            //adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todosList.size - 1)
        }
    }
}