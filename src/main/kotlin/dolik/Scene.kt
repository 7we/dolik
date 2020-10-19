package dolik

abstract class Scene {
    val components = object : AddRemoveObject<Component> {
        private val list = mutableListOf<Component>()

        override fun add(value: Component): Boolean {
            value.load()
            return list.add(value)
        }

        override fun remove(value: Component): Boolean {
            value.unload()
            return list.remove(value)
        }

        override fun iterator(): MutableIterator<Component> {
            return list.iterator()
        }
    }

    abstract fun load()

    protected abstract fun work()

    abstract fun unload()

    internal fun workAll() {
        work()
        components.forEach(Component::work)
    }
}