package net.chaossquad.mclib.json.json_editor.object.subcommands;

import net.chaossquad.mclib.command.TabCompletingCommandExecutor;
import net.chaossquad.mclib.json.json_editor.JSONEditorCommand;
import net.chaossquad.mclib.json.json_editor.object.JSONEditorObjectSubcommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.util.List;

/**
 * {@link JSONEditorCommand}.
 */
public class JSONEditorObjectClearSubcommand implements TabCompletingCommandExecutor {
    @NotNull private final JSONEditorObjectSubcommand parent;

    /**
     * Creates the object
     * @param parent parent
     */
    public JSONEditorObjectClearSubcommand(@NotNull JSONEditorObjectSubcommand parent) {
        this.parent = parent;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        JSONObject editable = this.parent.getManager().getJSONObjectEditable(sender);
        if (editable == null) {
            sender.sendMessage(JSONEditorObjectSubcommand.NO_EDITABLE_MESSAGE);
            return true;
        }

        editable.clear();
        sender.sendMessage("§aCleared json object");
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
    public @NotNull JSONEditorObjectSubcommand getParent() {
        return parent;
    }
}
