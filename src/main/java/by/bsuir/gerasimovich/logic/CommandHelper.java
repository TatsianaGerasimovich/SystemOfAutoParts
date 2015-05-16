package by.bsuir.gerasimovich.logic;

import by.bsuir.gerasimovich.logic.command.*;

import java.util.EnumMap;
import java.util.Map;


public class CommandHelper {
    private static CommandHelper requestHelper;
    Map<CommandName,ICommand> commands = new EnumMap<CommandName,ICommand>(CommandName.class);

    private CommandHelper(){
        commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
        commands.put(CommandName.DO_LIST_OF_ALL_FILTER, new ListOfAllByBrand());
        commands.put(CommandName.DO_LIST_OF_ALL_WITH_SORT, new ListOfAllWithSort());
        commands.put(CommandName.DO_SEARCH, new Search());
        commands.put(CommandName.OPERATION_WITH_BRANDS, new OperationWithBrands());
        commands.put(CommandName.OPERATION_WITH_MODEL, new OperationWithModel());
        commands.put(CommandName.OPERATION_WITH_AGENT, new OperationWithAgent());
        commands.put(CommandName.GENERATION_REPORT, new GenerationReport());
        commands.put(CommandName.ENTER_NEW_ITEMS, new EnterNewItems());
        commands.put(CommandName.REMOVE_ITEMS, new RemoveItems());
    }
    public static CommandHelper getInstance(){
        if(requestHelper == null )
            requestHelper = new CommandHelper();
        return requestHelper;
    }

    public ICommand getCommand(String commandName){
        CommandName action = CommandName.valueOf(commandName.toUpperCase());
        ICommand ICommand;
        if(action==null) {
             ICommand = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        else {
            ICommand = commands.get(action);
        }
        return ICommand;

    }
}
