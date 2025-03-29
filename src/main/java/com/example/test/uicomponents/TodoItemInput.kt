package com.example.test.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.model.Item
import com.example.test.model.TodoStatus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun getCurrentTime(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm")
    return current.format(formatter)
}

@Composable
fun TodoItemInput(todoList: MutableList<Item>, modifier: Modifier = Modifier) {
    var textfieldState by remember {
        mutableStateOf("")
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = textfieldState,
            onValueChange = { content -> textfieldState = content },
            placeholder = { Text("할 일을 입력하세요") }
        )

        Button(onClick = {
            if (textfieldState.isNotBlank()) {
                val newItem = Item(
                    content = textfieldState,
                    time = getCurrentTime(),
                    status = TodoStatus.PENDING
                )
                todoList.add(newItem)
                textfieldState = ""
            }
        }) {
            Text("추가")
        }

    }
}

@Preview
@Composable
private fun TodoItemInputPreview() {
    // TodoItemFactory.makeTodoList()가 어떻게 구현되었는지에 따라 다를 수 있습니다.
    // 예시로 빈 목록을 사용
    TodoItemInput(todoList = mutableListOf())
}
