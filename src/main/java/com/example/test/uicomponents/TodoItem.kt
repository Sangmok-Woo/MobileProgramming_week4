package com.example.test.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.model.Item
import com.example.test.model.TodoStatus

@Composable
fun TodoItem(item: Item, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = item.content,
            fontSize = 16.sp,
            textDecoration = if (item.status == TodoStatus.COMPLETED)
                TextDecoration.LineThrough
            else
                TextDecoration.None
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = item.time,
            fontSize = 10.sp
        )
    }
}

@Preview
@Composable
private fun TodoItemPreview() {
    Column {
        TodoItem(item = Item(content = "모프 공부하기1", time = "03-25 12:38"))
        TodoItem(item = Item(content = "모프 공부하기2", time = "03-25 12:38", status = TodoStatus.COMPLETED))
    }
}
