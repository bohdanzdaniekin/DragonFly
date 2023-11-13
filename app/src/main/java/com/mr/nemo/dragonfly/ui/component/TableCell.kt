package com.mr.nemo.dragonfly.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float,
    modifier: Modifier = Modifier,
    style: TextStyle = DragonFlyTheme.typography.text2.regular,
    color: Color = DragonFlyTheme.colors.neutral5,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text,
        modifier = modifier
            .weight(weight),
        style = style,
        color = color,
        textAlign = textAlign
    )
}

@Preview(showBackground = true)
@Composable
private fun TableCellPreview() {
    DragonFlyTheme {
        Column {
            Row {
                TableCell(text = "Cell1", weight = 1f)
                TableCell(text = "Cell2", weight = 2f)
                TableCell(text = "Cell3", weight = 2f)
                TableCell(text = "Cell4", weight = 1f)
            }
            Row {
                TableCell(text = "Cell5", weight = 1f)
                TableCell(text = "Cell6", weight = 2f)
                TableCell(text = "Cell7", weight = 2f)
                TableCell(text = "Cell8", weight = 1f)
            }
            Row {
                TableCell(text = "Cell9", weight = 1f)
                TableCell(text = "Cell10", weight = 2f)
                TableCell(text = "Cell11", weight = 2f)
                TableCell(text = "Cell12", weight = 1f)
            }
        }
    }
}
