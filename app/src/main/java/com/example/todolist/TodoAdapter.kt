package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class TodoAdapter (
    //private val
    private val todos : MutableList<Todo>
) :RecyclerView.Adapter<TodoAdapter.TodoViewHolder> () {
    //inner class for view holder

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define the views
        val tvTodoTitle: TextView = itemView.findViewById(R.id.tvTodoTitle)
       // val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    }


//    private fun toggleStrikeThrough(tvTodoTitle : TextView, isChecked : Boolean) {
//        if(isChecked) {
//            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
//        } else{
//            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG
//        }
//    }

    fun addTodo(todo : Todo) {
        todos.add(todo)
       notifyItemInserted(todos.size -1)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_todo,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
     /// logic to view the list of items and and implement the string and is Checked
        val curTodo = todos[position] //indexing
        holder.tvTodoTitle.text = curTodo.title;

    }

    override fun getItemCount(): Int {
        //Return the todos list
        return todos.size
    }
}

