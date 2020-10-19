package dolik

import com.raylib.Raylib.*

object Renderer {
    inline fun square(x: Int, y: Int, width: Int, height: Int, color: Color) {
        DrawRectangle(x, y, width, height, color.color)
    }
}

val render = Renderer