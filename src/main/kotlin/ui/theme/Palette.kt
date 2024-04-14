package ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Stable
class AppThemeColors(
    // 主色调
    primary: Color,
    secondary: Color,
    tertiary: Color,
    neutral: Color,

    // 背景色
    background: Color,
    background1: Color,
    background2: Color,

    // 文本和图标色
    text: Color,
    text1: Color,
    text2: Color,
    icon: Color,
    icon1: Color,
    icon2: Color,

    // 交互状态色
    selected: Color,
    hover: Color,
    disabled: Color,

    // 辅助色
    success: Color,
    warning: Color,
    error: Color
) {
    var primary by mutableStateOf(primary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var tertiary by mutableStateOf(tertiary)
        private set
    var neutral by mutableStateOf(neutral)
        private set
    var background by mutableStateOf(background)
        private set
    var background1 by mutableStateOf(background1)
        private set
    var background2 by mutableStateOf(background2)
        private set
    var text by mutableStateOf(text)
        private set
    var text1 by mutableStateOf(text1)
        private set
    var text2 by mutableStateOf(text2)
        private set
    var icon by mutableStateOf(icon)
        private set
    var icon1 by mutableStateOf(icon1)
        private set
    var icon2 by mutableStateOf(icon2)
        private set
    var selected by mutableStateOf(selected)
        private set
    var hover by mutableStateOf(hover)
        private set
    var disabled by mutableStateOf(disabled)
        private set
    var success by mutableStateOf(success)
        private set
    var warning by mutableStateOf(warning)
        private set
    var error by mutableStateOf(error)
        private set
}

val AppLightColorPalette = AppThemeColors(
    primary = primary50,
    secondary = secondary50,
    tertiary = secondary50,
    neutral = neutral50,
    background = neutral100,
    background1 = neutral98,
    background2 = neutral90,
    text = Color.Black,
    text1 = neutral40,
    text2 = neutral35,
    icon = secondary50,
    icon1 = neutral15,
    icon2 = neutral10,
    selected = secondary50,
    hover = neutral25,
    disabled = neutral50,
    success = success50,
    warning = warning50,
    error = error50
)

val AppDarkColorPalette = AppThemeColors(
    primary = primary50,
    secondary = secondary50,
    tertiary = secondary50,
    neutral = neutral50,
    background = neutral100,
    background1 = neutral98,
    background2 = neutral90,
    text = Color.White,
    text1 = neutral40,
    text2 = neutral35,
    icon = secondary50,
    icon1 = neutral15,
    icon2 = neutral10,
    selected = secondary50,
    hover = neutral25,
    disabled = neutral50,
    success = success50,
    warning = warning50,
    error = error50
)

val AppUndefinedColorPalette = AppThemeColors(
    primary = primary50,
    secondary = secondary50,
    tertiary = secondary50,
    neutral = neutral50,
    background = neutral100,
    background1 = neutral98,
    background2 = neutral90,
    text = Color.Red,
    text1 = neutral40,
    text2 = neutral35,
    icon = secondary50,
    icon1 = neutral15,
    icon2 = neutral10,
    selected = secondary50,
    hover = neutral25,
    disabled = neutral50,
    success = success50,
    warning = warning50,
    error = error50
)