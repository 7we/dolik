package dolik

import com.raylib.Jaylib
import com.raylib.Jaylib.*
import com.raylib.Raylib
import com.raylib.Raylib.*

class DolikGame(
    title: String,
    width: Int,
    height: Int
) {
    var title = title
        set(value) {
            field = value
            Raylib.SetWindowTitle(title)
        }
    var width = width
        set(value) {
            field = value
            Raylib.SetWindowSize(width, height)
        }
    var height = height
        set(value) {
            field = value
            Raylib.SetWindowSize(width, height)
        }
    var scene: Scene = EmptyScene
        set(value) {
            scene.unload()
            field = value
            value.load()
        }
    val camera = Camera(Jaylib.Vector3(18F, 16F, 18F), Jaylib.Vector3(), Jaylib.Vector3(0F, 1F, 0F), 45F, 0)

    private var isRunning = true

    fun start(targetFps: Int = 60) {
        Raylib.SetTraceLogLevel(Raylib.LOG_NONE)
        InitWindow(width, height, title)
        SetTargetFPS(targetFps)

        SetCameraMode(camera, CAMERA_ORBITAL)

        while (!WindowShouldClose() && isRunning) {
            UpdateCamera(camera)
            BeginDrawing()
            ClearBackground(WHITE)

            scene.workAll()

            EndDrawing()
        }

        CloseWindow()
    }

    fun stop() {
        scene.unload()
        isRunning = false
    }
}

inline fun game(
    title: String,
    width: Int = 640,
    height: Int = 480,
    block: DolikGame.() -> Unit
): DolikGame {
    return DolikGame(title, width, height).apply(block)
}