package net.chaossquad.mclib.json.json_editor.array.subcommands;

import net.chaossquad.mclib.command.TabCompletingCommandExecutor;
import net.chaossquad.mclib.json.json_editor.array.JSONEditorArraySubcommand;
import net.chaossquad.mclib.json.json_editor.JSONEditorCommand;
import net.chaossquad.mclib.json.json_editor.object.JSONEditorObjectSubcommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link JSONEditorCommand}.
 */
public class JSONEditorArrayRemoveSubcommand implements TabCompletingCommandExecutor {
    @NotNull private final JSONEditorArraySubcommand parent;

    /**
     * Creates the object.
     * @param parent parent
     */
    @ApiStatus.Internal
    public JSONEditorArrayRemoveSubcommand(@NotNull JSONEditorArraySubcommand parent) {
        this.parent = parent;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        JSONArray editable = this.parent.getManager().getJSONArrayEditable(sender);
        if (editable == null) {
            sender.sendMessage(JSONEditorObjectSubcommand.NO_EDITABLE_MESSAGE);
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage("§cUsage: [...] " + label + " <index>");
            return true;
        }

        int index;
        try {
            index = Integer.parseInt(args[0]);
        } catch (IllegalArgumentException e) {
            sender.sendMessage("§cYou need to specify a valid index");
            return true;
        }

        try {
            Object value = editable.remove(index);

            if (value != null) {
                sender.sendMessage("§aSuccessfully removed " + index + " from the json array");
            } else {
                sender.sendMessage("§cNothing to remove: Key does not exist");
            }

        } catch (JSONException e) {
            sender.sendMessage("§cFailed to remove value of " + index + ": " + e.getMessage());
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1) {
            JSONArray editable = this.parent.getManager().getJSONArrayEditable(sender);
            if (editable == null || editable.isEmpty()) return List.of();

            List<String> result = new ArrayList<>();
            for (int i = 0; i < editable.length(); i++) {
                result.add(String.valueOf(i));
            }
            return result;
        }

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
