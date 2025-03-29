package com.example.test.model

object TodoItemFactory {
    fun makeTodoList() = mutableListOf(
        Item("아침 명상하기", "02-01 05:30", TodoStatus.COMPLETED),
        Item("오전 운동", "02-01 06:30", TodoStatus.PENDING),
    )
}

