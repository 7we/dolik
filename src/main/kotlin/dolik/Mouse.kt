package dolik

import com.raylib.Raylib
import com.raylib.Raylib.*

enum class MouseButton(val code: Int) {
    LEFT(0),
    MIDDLE(1),
    RIGHT(2);

    inline val isDown
        get() = IsMouseButtonDown(code)

    inline val isPressed
        get() = IsMouseButtonPressed(code)

    inline val isReleased
        get() = IsMouseButtonReleased(code)

    inline val isUp
        get() = IsMouseButtonUp(code)

    inline fun maskDown(x: Int, y: Int, width: Int, height: Int, block: () -> Unit) {
        mask(x, y, width, height, MouseButton::isDown, block)
    }

    inline fun maskPressed(x: Int, y: Int, width: Int, height: Int, block: () -> Unit) {
        mask(x, y, width, height, MouseButton::isPressed, block)
    }

    inline fun maskReleased(x: Int, y: Int, width: Int, height: Int, block: () -> Unit) {
        mask(x, y, width, height, MouseButton::isReleased, block)
    }

    inline fun maskUp(x: Int, y: Int, width: Int, height: Int, block: () -> Unit) {
        mask(x, y, width, height, MouseButton::isUp, block)
    }

    inline fun mask(x: Int, y: Int, width: Int, height: Int, function: (MouseButton) -> Boolean, block: () -> Unit) {
        if (function(this) && mouseX in x..x + width && mouseY in y..y + height) {
            block()
        }
    }
}

inline val mouseX
    get() = GetMouseX()

inline val mouseY
    get() = GetMouseY()