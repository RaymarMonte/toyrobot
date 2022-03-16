package toyrobot.services.inputparser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import toyrobot.client.command.command.IGameCommand;
import toyrobot.client.command.factory.GameCommandFactory;
import toyrobot.domains.game.IGame;

public class InputParser implements IInputParser {

    @Override
    public IGameCommand parseCommand(String input, IGame game) {
        for (String strPattern : GameCommandFactory.getValidPatterns()) {
            Pattern pattern = Pattern.compile(strPattern);
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                ArrayList<String> paramList = new ArrayList<>();
                for (int i = 1;i <= matcher.groupCount();i++) {
                    paramList.add(matcher.group(i));
                }
                return GameCommandFactory.createGameCommand(
                    strPattern, game, paramList.toArray(String[]::new));
            }
        }
        return null;
    }
    
}
