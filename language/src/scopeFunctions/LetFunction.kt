package scopeFunctions

/*
Context object : it
Return value   : lambda result
Use case       : let function is often used to provide null safety calls. Use safe call operator(?.) with ‘let’ for
                 null safety. It executes the block only with the non-null value.
 */
class LetFunction {
}

fun main() {
    var v1: Int? = null
    v1?.let { println("v1 is null and $v1 will not be printed. NPE is avoided.") }

    v1 = 22
    v1?.let { println("v1 isn not null: v1=$v1") }
}