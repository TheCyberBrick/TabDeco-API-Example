package APITest.APITest;

import org.bukkit.entity.Player;

import TCB.TabDeco.API.TabDecoSetting;

public class APITestClass extends TabDecoSetting
{
	//The function that returns the text in the slot
	@Override
	public String getSlotText(Player player, String inputText) 
	{
		//This just returns the name of the player with 'Test ' in
		//front of it. You can do whatever you want in this function.
		//For example getting information from the internet or
		//make a timer.
		String text = "Test " + player.getDisplayName();
		return text;
	}
}
