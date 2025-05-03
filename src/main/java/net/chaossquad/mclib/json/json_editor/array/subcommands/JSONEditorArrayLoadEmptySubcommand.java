package net.chaossquad.mclib.json.json_editor.array.subcommands;

import net.chaossquad.mclib.command.TabCompletingCommandExecutor;
import net.chaossquad.mclib.json.json_editor.array.JSONEditorArraySubcommand;
import net.chaossquad.mclib.json.json_editor.JSONEditorCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

import java.util.List;

/**
 * {@link JSONEditorCommand}.
 */
public class JSONEditorArrayLoadEmptySubcommand implements TabCompletingCommandExecutor {
    @NotNull private final JSONEditorArraySubcommand parent;

    /**
     * Creates the object.
     * @param parent parent
     */
    public JSONEditorArrayLoadEmptySubcommand(@NotNull JSONEditorArraySubcommand parent) {
        this.parent = parent;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        this.parent.getManager().setJSONArrayEditable(sender, new JSONArray());
        sender.sendMessage("§aEmpty json array loaded successfully");
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        return List.of();
    }

    /**
     * Returns the parent
     * @return parent
     */
    public @NotNull JSONEditorArraySubcommand getParent() {
        return parent;
    }
}
