package com.app.presentation.utils.extension


object BottomSheetFormatter {

    private const val BULLET = "• "
    private const val ARROW = " -> "

    fun Char.formatBottomSheetItem(): String {
        return BULLET.plus(this.toString()).plus(ARROW)
    }
}
