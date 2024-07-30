package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var rvTodoItems: RecyclerView
    private lateinit var btnAddTodo: Button
    private lateinit var elTodoTitle: EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views
        rvTodoItems = findViewById(R.id.rvTodoItems)
        btnAddTodo = findViewById(R.id.btnAddTodo)
        elTodoTitle = findViewById(R.id.elTodoTitle)

        // Set up RecyclerView
        rvTodoItems.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter(mutableListOf())
        rvTodoItems.adapter = todoAdapter

        // Handle edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set onClickListener for the button
        btnAddTodo.setOnClickListener {
            val todoTitle = elTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                elTodoTitle.text.clear()
            }
        }
    }
}