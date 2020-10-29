package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.contactcommands.AddCommand;
import seedu.address.logic.commands.contactcommands.DeleteCommand;
import seedu.address.logic.commands.contactcommands.EditCommand;
import seedu.address.logic.commands.contactcommands.FindCommand;
import seedu.address.logic.commands.contactcommands.ListCommand;
import seedu.address.logic.commands.contactcommands.SortCommand;
import seedu.address.logic.commands.tagcommands.LinkAddCommand;
import seedu.address.logic.commands.tagcommands.LinkDeleteCommand;
import seedu.address.logic.commands.tagcommands.TagAddCommand;
import seedu.address.logic.commands.tagcommands.TagDeleteCommand;
import seedu.address.logic.commands.tagcommands.TagEditCommand;
import seedu.address.logic.commands.tagcommands.TagFindCommand;
import seedu.address.logic.commands.tagcommands.TagListCommand;
import seedu.address.logic.commands.tagcommands.TagSortCommand;
import seedu.address.logic.commands.taskcommands.TaskAddCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class ProjactParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case SortCommand.COMMAND_WORD:
            return new SortCommand();

        case TagAddCommand.COMMAND_WORD:
            return new TagAddCommandParser().parse(arguments);

        case TagListCommand.COMMAND_WORD:
            return new TagListCommand();

        case TagFindCommand.COMMAND_WORD:
            return new TagFindCommandParser().parse(arguments);

        case TagEditCommand.COMMAND_WORD:
            return new TagEditCommandParser().parse(arguments);

        case TagDeleteCommand.COMMAND_WORD:
            return new TagDeleteCommandParser().parse(arguments);

        case TagSortCommand.COMMAND_WORD:
            return new TagSortCommand();

        case LinkAddCommand.COMMAND_WORD:
            return new LinkAddCommandParser().parse(arguments);

        case LinkDeleteCommand.COMMAND_WORD:
            return new LinkDeleteCommandParser().parse(arguments);

        case TaskAddCommand.COMMAND_WORD:
            return new TaskAddCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
