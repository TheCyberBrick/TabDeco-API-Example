package TCB.APIExample;

import org.bukkit.entity.Player;

import TCB.TabDeco.API.TabDecoSetting;

public class MySettings extends TabDecoSetting
{
	//This function contains the code that returns the String for the slot
	//The first argument (player) is the player that is looking at the menu
	//The second argument (inputText) is the whole input text from the configuration of TabDeco
	//Add System.out.println(inputText); if you want to understand further what it is for
	//The last argument (settingName) is the name of the setting. This allows to register multiple
	//settings with only 1 setting class
	//The update function ([@]) is already built in. You don't have to do anything for automatic updating.
	@Override
	public String getSlotText(Player player, String inputText, String settingName) {
		
		//Checking if the setting name is playerName
		if(settingName.equals("playerName")){
			//Checking if the player is online
			if(player.isOnline()){
				//Returning the display name of the player
				return player.getDisplayName();
			}
		}
		//Checking if the setting name is playerHealth
		else if(settingName.equals("playerHealth")){
			//Checking if the player is online
			if(player.isOnline()){
				//Returning the health of the player as a string
				return "" + player.getHealth();
			}
		}
		
		return "";
	}
}
