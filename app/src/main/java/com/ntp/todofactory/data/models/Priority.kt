package com.ntp.todofactory.data.models

import androidx.compose.ui.graphics.Color
import com.ntp.todofactory.ui.theme.HighPriorityColor
import com.ntp.todofactory.ui.theme.LowPriorityColor
import com.ntp.todofactory.ui.theme.MediumPriorityColor
import com.ntp.todofactory.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}