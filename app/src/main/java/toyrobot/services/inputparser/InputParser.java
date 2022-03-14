package toyrobot.services.inputparser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import toyrobot.client.command.GameCommandFactory;
import toyrobot.client.command.IGameCommand;
import toyrobot.domains.game.IGame;

public class InputParser implements IInputParser {

    private static final String REGEX_PATTERN = "([A-Z]+)( (\\S+),(\\S+),(\\S+))?$";
    private static final int COMMAND_WORD_GROUP_INDEX = 1;
    private static final int PARAM_START_INDEX = 3;

    @Override
    public IGameCommand parseCommand(String input, IGame game) {
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String command = matcher.group(COMMAND_WORD_GROUP_INDEX);
            ArrayList<String> paramList = new ArrayList<>();
            for (int i = PARAM_START_INDEX;i <= matcher.groupCount();i++) {
                if (matcher.group(i) == null) {
                    paramList.clear();
                    break;
                }
                paramList.add(matcher.group(i));
            }
            return GameCommandFactory.createGameCommand(game, command, paramList.toArray());
        }
        return null;
    }
    
}
