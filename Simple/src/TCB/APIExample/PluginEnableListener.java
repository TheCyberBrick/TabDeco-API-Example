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
	        		
	        		//Registering the setting playerName
	        		//TabDeco automatically adds brackets
	        		//This setting would look like this in the configuration: [playerName]
	        		TabDecoRegistry.registerNewSetting("playerName", new MySettings(), this.plugin);
	        		
	        		//Registering the setting playerHealth
	        		//TabDeco automatically adds brackets
	        		//This setting would look like this in the configuration: [playerHealth]
	        		TabDecoRegistry.registerNewSetting("playerHealth", new MySettings(), this.plugin);
	        		
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
