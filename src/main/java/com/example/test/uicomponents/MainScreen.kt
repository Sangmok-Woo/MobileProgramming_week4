package com.example.test.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.model.Item
import com.example.test.model.TodoItemFactory
import com.example.test.model.TodoStatus

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
        mutableStateListOf<Item>().apply {
            addAll(TodoItemFactory.makeTodoList())
        }
    }
    var showIncompleteOnly by remember { mutableStateOf(false) }


    val filteredList = remember(todoList, showIncompleteOnly) {
        if (showIncompleteOnly) {
            todoList.filter { it.status != TodoStatus.COMPLETED }
        } else {
            todoList
        }
    }

    Column(modifier = modifier.padding(16.dp)) {
        TodoListTitle()

        TodoFilterSwitch(
            isChecked = showIncompleteOnly,
            onCheckedChange = { showIncompleteOnly = it }
        )

        TodoItemInput(todoList = todoList)

        TodoList(
            todoList = filteredList,
            onItemCheckedChange = { index, isChecked ->
                val targetItem = filteredList[index]
                val realIndex = todoList.indexOf(targetItem)
                if (realIndex != -1) {
                    todoList[realIndex] = targetItem.copy(
                        status = if (isChecked) TodoStatus.COMPLETED else TodoStatus.PENDING
                    )
                }
            }
        )

    }
}


@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
