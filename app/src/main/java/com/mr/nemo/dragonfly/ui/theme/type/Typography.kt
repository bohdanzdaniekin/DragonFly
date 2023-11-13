package com.mr.nemo.dragonfly.ui.theme.type

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mr.nemo.dragonfly.R

data class Typography(
    val header1: WeightableTextStyle = WeightableTextStyle.Default,
    val header2: WeightableTextStyle = WeightableTextStyle.Default,
    val subtitle1: WeightableTextStyle = WeightableTextStyle.Default,
    val subtitle2: WeightableTextStyle = WeightableTextStyle.Default,
    val button: TextStyle = TextStyle.Default,
    val card: TextStyle = TextStyle.Default,
    val text1: WeightableTextStyle = WeightableTextStyle.Default,
    val text2: WeightableTextStyle = WeightableTextStyle.Default,
    val caption: WeightableTextStyle = WeightableTextStyle.Default
)

val LocalTypography = staticCompositionLocalOf {
    Typography()
}

val typography = Typography(
    header1 = WeightableTextStyle(
        regular = TextStyle(
            fontSize = 32.sp,
            lineHeight = 48.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_regular)),
            fontWeight = FontWeight(400)
        ),
        medium = TextStyle(
            fontSize = 32.sp,
            lineHeight = 48.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_medium)),
            fontWeight = FontWeight(500)
        ),
        bold = TextStyle(
            fontSize = 32.sp,
            lineHeight = 48.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_semibold)),
            fontWeight = FontWeight(600)
        )
    ),
    header2 = WeightableTextStyle(
        regular = TextStyle(
            fontSize = 24.sp,
            lineHeight = 36.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_regular)),
            fontWeight = FontWeight(400)
        ),
        medium = TextStyle(
            fontSize = 24.sp,
            lineHeight = 36.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_medium)),
            fontWeight = FontWeight(500)
        ),
        bold = TextStyle(
            fontSize = 24.sp,
            lineHeight = 36.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_semibold)),
            fontWeight = FontWeight(600)
        )
    ),
    subtitle1 = WeightableTextStyle(
        regular = TextStyle(
            fontSize = 20.sp,
            lineHeight = 30.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_regular)),
            fontWeight = FontWeight(400)
        ),
        medium = TextStyle(
            fontSize = 20.sp,
            lineHeight = 30.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_medium)),
            fontWeight = FontWeight(500)
        ),
        bold = TextStyle(
            fontSize = 20.sp,
            lineHeight = 30.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_semibold)),
            fontWeight = FontWeight(600)
        )
    ),
    subtitle2 = WeightableTextStyle(
        regular = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_regular)),
            fontWeight = FontWeight(400)
        ),
        medium = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_medium)),
            fontWeight = FontWeight(500)
        ),
        bold = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_semibold)),
            fontWeight = FontWeight(600)
        )
    ),
    button = TextStyle(
        fontSize = 14.sp,
        lineHeight = 21.sp,
        fontFamily = FontFamily(Font(R.font.font_montserrat_semibold)),
        fontWeight = FontWeight(500)
    ),
    card = TextStyle(
        fontSize = 10.sp,
        lineHeight = 15.sp,
        fontFamily = FontFamily(Font(R.font.font_ocr_a_regular)),
        fontWeight = FontWeight(500)
    ),
    text1 = WeightableTextStyle(
        regular = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_regular)),
            fontWeight = FontWeight(400)
        ),
        medium = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_medium)),
            fontWeight = FontWeight(500)
        ),
        bold = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_semibold)),
            fontWeight = FontWeight(600)
        )
    ),
    text2 = WeightableTextStyle(
        regular = TextStyle(
            fontSize = 12.sp,
            lineHeight = 18.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_regular)),
            fontWeight = FontWeight(400)
        ),
        medium = TextStyle(
            fontSize = 12.sp,
            lineHeight = 18.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_medium)),
            fontWeight = FontWeight(500)
        ),
        bold = TextStyle(
            fontSize = 12.sp,
            lineHeight = 18.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_semibold)),
            fontWeight = FontWeight(600)
        )
    ),
    caption = WeightableTextStyle(
        regular = TextStyle(
            fontSize = 10.sp,
            lineHeight = 15.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_regular)),
            fontWeight = FontWeight(400)
        ),
        medium = TextStyle(
            fontSize = 10.sp,
            lineHeight = 15.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_medium)),
            fontWeight = FontWeight(500)
        ),
        bold = TextStyle(
            fontSize = 10.sp,
            lineHeight = 15.sp,
            fontFamily = FontFamily(Font(R.font.font_montserrat_semibold)),
            fontWeight = FontWeight(600)
        )
    )
)
