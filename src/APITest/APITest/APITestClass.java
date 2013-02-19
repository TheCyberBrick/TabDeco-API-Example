package APITest.APITest;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import TCB.TabDeco.API.TabDecoSetting;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;

public class APITestClass extends TabDecoSetting
{
	//The function that returns the text in the slot
	@Override
	public String getSlotText(Player player, String inputText) 
	{
		//Getting the location of the player
		Location playerLocation = player.getLocation();
		//Getting the faction at the location of the player
		Faction faction = Board.getFactionAt(new FLocation(playerLocation));
		//Returning the faction name
		return faction.getTag();
	}
}
