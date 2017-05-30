package warcraft

open class Presenter<T> {
    protected var view: T? = null
    lateinit var a: String

    protected fun attachView(view: T) {
        this.view = view
    }

    protected fun releaseView() {
        this.view = null
    }
}
