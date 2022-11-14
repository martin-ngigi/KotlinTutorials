package com.example.kotlintutorials.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorials.R
import com.example.kotlintutorials.models.ModelTodo
import kotlinx.android.synthetic.main.row_todo.view.*

class AdapterTodo(var todos: List<ModelTodo>): RecyclerView.Adapter<AdapterTodo.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            tv_title_todo.text = todos[position].title
            cbTodo.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return  todos.size
    }
}