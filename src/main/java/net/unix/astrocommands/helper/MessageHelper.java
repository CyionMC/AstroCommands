package net.unix.astrocommands.helper;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class MessageHelper {

    @Contract(pure = true)
    private MessageHelper() {
    }

    @NotNull
    public static String fixColor(@NotNull String text) {
        return ChatColor.translateAlternateColorCodes('&', text)
                .replace(">>", "»")
                .replace("<<", "«");
    }
}