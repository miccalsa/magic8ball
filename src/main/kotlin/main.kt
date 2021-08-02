const val YES_ANSWER = "√"
const val NO_ANSWER = "X"
const val UNKNOWN_ANSWER = "?"

val answers = mapOf(
    "Yes" to  YES_ANSWER,
    "It is true" to  YES_ANSWER,
    "Totally" to  YES_ANSWER,
    "No doubt" to  YES_ANSWER,
    "Ask some other time" to  UNKNOWN_ANSWER,
    "Cannot tell at this moment" to  UNKNOWN_ANSWER,
    "May be yes, may be no" to  UNKNOWN_ANSWER,
    "Not gonnna happen" to  NO_ANSWER,
    "Don't count on it" to  NO_ANSWER,
    "Definitelly no" to  NO_ANSWER,
    "Don't think so" to  NO_ANSWER,
)

fun main(args: Array<String>) {
    println("Hello, I am your 8 ball. Which of these options would you like to do?")
    println("1. Ask a question")
    println("2. Check all answers")
    println("3. Exit")

    val input = readLine()

    when(input) {
        "1" -> askQuestion()
        "2" -> showAnswers()
        "3" -> exit()
        else -> showError()
    }
}

fun askQuestion() {
    println("Ask me anything")
    readLine()
    println("Alright, the answer to your question is:")
    val answer = answers.keys.random()
    println(answer)
}

fun showAnswers() {
    println("Select an option")
    println("1. See all answers")
    println("2. See all positive answers")
    println("3. See all unknown answers")
    println("4. See all negative answers")
    val input = readLine()
    when(input) {
        "1" -> showAnswersByType()
        "2" -> showAnswersByType(YES_ANSWER)
        "3" -> showAnswersByType(UNKNOWN_ANSWER)
        "4" -> showAnswersByType(NO_ANSWER)
        else -> println("Invalid answer. Bye")
    }
}

fun showAnswersByType(type: String = "ALL") {
    when(type) {
        "ALL" -> answers.keys.forEach { answer -> println(answer) }
        YES_ANSWER -> answers
            .filterValues { value -> value == YES_ANSWER }
            .also { yes -> println(yes.keys) }
        UNKNOWN_ANSWER -> answers
            .filterValues { value -> value == UNKNOWN_ANSWER }
            .also { unknown -> println(unknown.keys) }
        NO_ANSWER -> answers
            .filterValues { value -> value == NO_ANSWER }
            .also { no -> println(no.keys) }
    }
}

fun exit() {
    println("Bye")
}

fun showError() {
    println("Ops, seems you chose an invalid option")
}