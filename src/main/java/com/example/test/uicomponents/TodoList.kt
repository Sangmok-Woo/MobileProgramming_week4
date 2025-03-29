package com.example.test.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.model.Item
import com.example.test.model.TodoStatus

@Composable
fun TodoList(
    todoList: List<Item>,
    onItemCheckedChange: (index: Int, isChecked: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        todoList.forEachIndexed { index, item ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Checkbox(
                        checked = item.status == TodoStatus.COMPLETED,
                        onCheckedChange = { isChecked ->
                            onItemCheckedChange(index, isChecked)
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    TodoItem(item)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Composable
fun TodoItem(item: Item) {
    Text(
        text = "${item.content} (${item.time})",
        textDecoration = if (item.status == TodoStatus.COMPLETED)
            TextDecoration.LineThrough
        else
            TextDecoration.None
    )
}

@Preview(showBackground = true)
@Composable
private fun TodoListPreview() {
    val sampleList = listOf(
        Item("아침 명상하기", "02-01 05:30", TodoStatus.COMPLETED),
        Item("오전 운동", "02-01 06:30", TodoStatus.PENDING),
        Item("책 읽기", "02-01 08:30", TodoStatus.PENDING)
    )
    TodoList(
        todoList = sampleList,
        onItemCheckedChange = { _, _ -> }
    )
}
