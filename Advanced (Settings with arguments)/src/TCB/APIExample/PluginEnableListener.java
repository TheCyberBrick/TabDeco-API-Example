package TCB.APIExample;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

import TCB.TabDeco.API.TabDecoRegistry;

public class PluginEnableListener implements Listener
{
	private Plugin plugin;
	
	public static boolean mySettingsLoaded = false;

	public PluginEnableListener(Plugin plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPluginEnable(PluginEnableEvent event)
	{
		try
		{
			//Check if TabDeco has been loaded
			Plugin tabDeco = plugin.getServer().getPluginManager().getPlugin("TabDeco");
	        if (tabDeco != null) 
	        {
	        	//Check if the settings already have been loaded
	        	//This event loads multiple times for each plugin
	        	if(!mySettingsLoaded){
	        		
	        		//Registering the setting playerPosX(playername)
	        		//TabDeco automatically adds brackets
	        		//This setting would look like this in the configuration: [playerPosX(player name with lenght from 1 - n)]
	        		//This is some rather complicated stuff with regex
	        		//Here you can find a good tutorial on java regex: http://www.vogella.com/articles/JavaRegularExpressions/article.html
	        		//For settings using regex you need a new class for each new setting
	        		TabDecoRegistry.registerNewSetting("playerPosX\\([a-zA-Z]{1,}\\)", new MySettings(this.plugin), this.plugin);
	        		
	        		//Let the user of the plugin know that everything worked
	        		APIExample.log.info("Registered settings for TabDeco");
	        		
	        		//Set mySettingsLoaded to true to prevent multiple registrations of the settings
	        		mySettingsLoaded = true;
	        	}
	        }
		}
		catch(Exception ex)
		{
			//Let the user know that something didn't work as it should and
			//print out the error
			APIExample.log.severe("Couldn't load settings for TabDeco");
			ex.printStackTrace();
		}
	}
}
