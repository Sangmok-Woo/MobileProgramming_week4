package com.example.test.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoCheckBox(
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Checkbox(
        checked = isChecked,
        onCheckedChange = onCheckedChange,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun TodoCheckBoxPreview() {
    TodoCheckBox(isChecked = true)
}
