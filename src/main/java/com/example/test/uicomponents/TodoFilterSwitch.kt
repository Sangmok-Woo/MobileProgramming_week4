package com.example.test.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TodoFilterSwitch(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    // 바깥 Row는 전체 라인을 오른쪽으로 정렬
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.End, // 👉 오른쪽 정렬!
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        // 안쪽 Row는 텍스트와 스위치를 가깝게 배치
        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Text(text = "미완료된 항목만 보기")
            Spacer(modifier = Modifier.width(8.dp)) // 약간 간격
            Switch(
                checked = isChecked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun TodoFilterSwitchPreview() {
    TodoFilterSwitch(isChecked = true,onCheckedChange = {})
}
