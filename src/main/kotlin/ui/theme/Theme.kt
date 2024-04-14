package ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

private val ComposeIMThemeColorsProvider = compositionLocalOf {
    AppLightColorPalette
}

object ComposeIMTheme {
    val colors: AppThemeColors
        @Composable
        get() = ComposeIMThemeColorsProvider.current

    enum class Theme {
        Light, Dark, Undefined
    }
}

@Composable
fun AppTheme(
    theme: ComposeIMTheme.Theme = ComposeIMTheme.Theme.Light,
    content: @Composable () -> Unit
) {
    val targetColors = when (theme) {
        ComposeIMTheme.Theme.Light -> AppLightColorPalette
        ComposeIMTheme.Theme.Dark -> AppDarkColorPalette
        ComposeIMTheme.Theme.Undefined -> AppUndefinedColorPalette
    }

    val primary = animateColorAsState(targetColors.primary, TweenSpec(600))
    val secondary = animateColorAsState(targetColors.secondary, TweenSpec(600))
    val tertiary = animateColorAsState(targetColors.tertiary, TweenSpec(600))
    val neutral = animateColorAsState(targetColors.neutral, TweenSpec(600))
    val background = animateColorAsState(targetColors.background, TweenSpec(600))
    val background1 = animateColorAsState(targetColors.background1, TweenSpec(600))
    val background2 = animateColorAsState(targetColors.background2, TweenSpec(600))
    val text = animateColorAsState(targetColors.text, TweenSpec(600))
    val text1 = animateColorAsState(targetColors.text1, TweenSpec(600))
    val text2 = animateColorAsState(targetColors.text2, TweenSpec(600))
    val icon = animateColorAsState(targetColors.icon, TweenSpec(600))
    val icon1 = animateColorAsState(targetColors.icon1, TweenSpec(600))
    val icon2 = animateColorAsState(targetColors.icon2, TweenSpec(600))
    val selected = animateColorAsState(targetColors.selected, TweenSpec(600))
    val hover = animateColorAsState(targetColors.hover, TweenSpec(600))
    val disabled = animateColorAsState(targetColors.disabled, TweenSpec(600))
    val success = animateColorAsState(targetColors.success, TweenSpec(600))
    val warning = animateColorAsState(targetColors.warning, TweenSpec(600))
    val error = animateColorAsState(targetColors.error, TweenSpec(600))

    val colors = AppThemeColors(
        primary = primary.value,
        secondary = secondary.value,
        tertiary = tertiary.value,
        neutral = neutral.value,
        background = background.value,
        background1 = background1.value,
        background2 = background2.value,
        text = text.value,
        text1 = text1.value,
        text2 = text2.value,
        icon = icon.value,
        icon1 = icon1.value,
        icon2 = icon2.value,
        selected = selected.value,
        hover = hover.value,
        disabled = disabled.value,
        success = success.value,
        warning = warning.value,
        error = error.value
    )

    CompositionLocalProvider(ComposeIMThemeColorsProvider provides colors) {
        MaterialTheme(
            shapes = shapes,
            content = content
        )
    }
}