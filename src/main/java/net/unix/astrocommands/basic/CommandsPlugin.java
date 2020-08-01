package net.unix.astrocommands.basic;

import net.unix.astrocommands.command.CustomCommand;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandsPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        final ConfigurationSection configurationSection = this.getConfig().getConfigurationSection("commands");

        configurationSection
                .getKeys(false)
                .stream()
                .map(configurationSection::getConfigurationSection)
                .forEachOrdered(c -> {
                    final String name = c.getString("name");
                    this.getServer().getCommandMap().register(name, new CustomCommand(name, c.getString("description"), c.getStringList("aliases"), c.getStringList("messages")));
                });
    }
}