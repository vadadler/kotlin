package lambdas

/*
 Lambda functions ("lambdas") are a simple way to create functions ad-hoc.
 Lambdas expression and Anonymous function both are function literals means these functions are not declared but
 passed immediately as an expression.


 Syntax: val lambda_name : Data_type = { argument_List -> code_body }

 A lambda expression is always surrounded by curly braces, argument declarations go inside curly braces and have
 optional type annotations, the code_body goes after an arrow -> sign. If the inferred return type of the lambda is not
 Unit, then the last expression inside the lambda body is treated as return value.
 */
fun main() {
    // Everything is explicitly typed.
    // Pattern: (Input) -> Output
    val upperCase1: (String) -> String = { input: String -> input.uppercase() }

    //
    val upperCase2: (String) -> String = { input -> input.uppercase()}

    println(upperCase1("hahaha"))
    println(upperCase2("hahaha"))

    // Using lambda expressions to filter and map collections.
    val fruits = listOf("Apple", "Pear", "Apricot", "Banana", "Cherry")

    functionChain(fruits)
}

fun functionChain(listofFruits: List<String>) {
    listofFruits
        .filter { it.startsWith("A") }
        .sorted()
        .map { it.uppercase() }
        .forEach {println(it)}
}