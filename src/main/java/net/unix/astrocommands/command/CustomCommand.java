package net.unix.astrocommands.command;

import net.unix.astrocommands.helper.MessageHelper;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class CustomCommand extends BukkitCommand {

    private final List<String> messages;

    public CustomCommand(String name, String description, List<String> aliases, @NotNull List<String> messages) {
        super(name, description, "", aliases);
        this.messages = messages
                .stream()
                .map(MessageHelper::fixColor)
                .collect(Collectors.toList());
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, String label, String[] args) {
        messages.forEach(sender::sendMessage);
        return true;
    }
}