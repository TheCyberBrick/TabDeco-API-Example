package APITest.APITest;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

import TCB.TabDeco.API.TabDecoRegistry;

public class PluginEnableListener implements Listener
{
	private APITest plugin;
	
	public PluginEnableListener(APITest plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPluginEnable(PluginEnableEvent event)
	{
		try
		{
			Plugin tabDeco = plugin.getServer().getPluginManager().getPlugin("TabDeco");
	
			//Checking if TabDeco has been loaded
	        if (tabDeco != null) 
	        {
	        	//If TabDeco has been loaded, then register your new setting
	        	//1 Argument is the name of the setting in the configuration
	        	//2 Argument is your class extending TabDecoSetting, which contains
	        	//the function that sets the text of the slot
	        	TabDecoRegistry.registerNewSetting("apitest", new APITestClass());
	        }
		}
		catch(Exception ex)
		{
			
		}
	}
}