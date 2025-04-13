package dev.thebjoredcraft.forceitembattle.paper.util

import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import kotlin.math.ceil
import kotlin.math.min

@DslMarker
annotation class PageableMessageBuilderDsl

@PageableMessageBuilderDsl
class PageableMessageBuilder(private val linesPerPage: Int = 10) {

    private val lines = mutableListOf<Component>()
    private var pageCommand = "An error occurred while trying to display the page."
    private var title: Component = Component.empty()

    companion object {
        operator fun invoke(block: PageableMessageBuilder.() -> Unit): PageableMessageBuilder {
            return PageableMessageBuilder().apply(block)
        }
    }

    fun withPageCommand(command: String): PageableMessageBuilder {
        pageCommand = command
        return this
    }

    fun addLine(component: Component): PageableMessageBuilder {
        lines.add(component)
        return this
    }

    fun withTitle(component: Component): PageableMessageBuilder {
        title = component
        return this
    }

    fun send(sender: Player, page: Int) {
        val totalPages = ceil(lines.size.toDouble() / linesPerPage).toInt().coerceAtLeast(1)
        if (page < 1 || page > totalPages) {
            sender.sendText(MessageBuilder().error("Seite ").variableValue(page.toString()).error(" existiert nicht."))
            return
        }

        val start = (page - 1) * linesPerPage
        val end = min(start + linesPerPage, lines.size)

        var message = MessageBuilder()
            .newLine()
            .component(title)
            .newLine()

        for (i in start until end) {
            message = message.component(lines[i]).newLine()
        }

        sender.sendRawText(message.component(paginationComponent(page, totalPages)).build())
    }

    private fun paginationComponent(page: Int, totalPages: Int): Component {
        val builder = MessageBuilder()

        fun navButton(label: String, targetPage: Int, enabled: Boolean) {
            val hoverText = MessageBuilder().info("Seite $targetPage anzeigen")

            if (enabled) {
                builder.command(
                    text = MessageBuilder().success(label),
                    hover = hoverText,
                    command = pageCommand.replace("%page%", targetPage.toString())
                )
            } else {
                builder.error(label)
            }
        }

        navButton("[<<] ", 1, page > 1)
        navButton("[<] ", page - 1, page > 1)
        builder.darkSpacer("Seite $page von $totalPages")
        navButton(" [>] ", page + 1, page < totalPages)
        navButton(" [>>]", totalPages, page < totalPages)

        return builder.build()
    }
}

