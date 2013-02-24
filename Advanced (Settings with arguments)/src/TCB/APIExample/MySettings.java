package TCB.APIExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import TCB.TabDeco.API.TabDecoSetting;

public class MySettings extends TabDecoSetting
{
	public Plugin plugin;
	
	public MySettings(Plugin plugin)
	{
		this.plugin = plugin;
	}
	
	//This function contains the code that returns the String for the slot
	//The first argument (player) is the player that is looking at the menu
	//The second argument (inputText) is the whole input text from the configuration of TabDeco
	//Add System.out.println(inputText); if you want to understand further what it is for
	//The last argument (settingName) is the name of the setting. This allows to register multiple
	//settings with only 1 setting class
	//The update function ([@]) is already built in. You don't have to do anything for automatic updating.
	@Override
	public String getSlotText(Player player, String inputText, String settingName) {
		
		//Here we can't use a check if the setting name is right, because we used
		//some regex stuff. You'll need a class like that for every setting using regex
		
		try
		{
			//First getting the player by the name and then return the x position of the player
			return "" + plugin.getServer().getPlayer(getPlayerName(inputText)).getLocation().getBlockX();
		}
		catch(Exception ex)
		{
			//Something went wrong, either the player is not online, or maybe the configuration is wrong.
		}
		
		return "";
	}
	
	public String getPlayerName(String inputString)
	{
		//This is the regex for a string with the lenght 1-n
		//The regex for a number with a lenght from 1-n would look like this: [0-9]{1,}
		String playerNameRegex = "[a-zA-Z]{1,}";
		//Compiling a pattern to get the player name
		Pattern regex = Pattern.compile("\\[playerName\\(" + playerNameRegex + "\\)\\]");
		Matcher regexMatcher = regex.matcher(inputString);
		while (regexMatcher.find()) 
		{
			//Here it replaces all the text before the player name
			String playerName = regexMatcher.group().replaceAll("\\[playerName\\(", "");
			//Here it replaces all the text behind the player name
			playerName = playerName.replaceAll("\\)\\]", "");
			return playerName;
		} 
		return "";
	}
}
