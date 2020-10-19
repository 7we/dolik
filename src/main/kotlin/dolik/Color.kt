package dolik

import com.raylib.Raylib

class Color(
    val r: Int,
    val b: Int,
    val g: Int,
    val a: Int
) {
    val color = Raylib.Color().r(r.toByte()).g(g.toByte()).b(b.toByte()).a(a.toByte())

    companion object {
        val black = Color(0, 0, 0, 255)
    }
}