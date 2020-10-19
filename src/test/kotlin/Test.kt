import dolik.*
import java.awt.Color.black
import kotlin.system.exitProcess

fun main() = game("Game") {
    scene = object : Scene() {
        override fun load() {
            println("Scene has loaded!")
        }

        override fun work() {
            components.add(object : ButtonComponent(50, 50, 100, 100) {
                override fun render() {
                    render.square(x, y, width, height, Color.black)
                }

                override fun onRelease() {
                    stop()
                }

                override fun onDown() {
                    render.square(x, y, width, height, Color(130, 130, 130, 255))
                }
            })
        }

        override fun unload() {
            println("Scene has unloaded!")
        }
    }
}.start()