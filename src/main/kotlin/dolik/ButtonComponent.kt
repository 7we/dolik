package dolik

abstract class ButtonComponent(
    var x: Int,
    var y: Int,
    var width: Int,
    var height: Int,
    val mouseButton: MouseButton = MouseButton.LEFT
) : Component {
    override fun load() {}

    override fun work() {
        render()
        mouseButton.mask(x, y, width, height, MouseButton::isDown, this::onDown)
        mouseButton.mask(x, y, width, height, MouseButton::isReleased, this::onRelease)
    }

    override fun unload() {}

    abstract fun render()

    open fun onDown() {}

    abstract fun onRelease()
}