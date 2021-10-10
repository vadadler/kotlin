
class SomeClass {
    private val heavyObject: HeavyClass by lazy {
        println("Heavy Object initialised")
        HeavyClass()
    }

    fun accessObject() {
        println(heavyObject)
    }
}

class HeavyClass {

}

fun main() {
    val someClass = SomeClass()
    println("SomeClass initialised")
    someClass.accessObject()
    someClass.accessObject()
}