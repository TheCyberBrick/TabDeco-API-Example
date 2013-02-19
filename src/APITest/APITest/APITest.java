package APITest.APITest;

import org.bukkit.plugin.java.JavaPlugin;

public class APITest extends JavaPlugin 
{
	@Override 
    public void onEnable()
	{
		//Registering the listener that contains the PluginEnableEvent to check if
		//TabDeco and factions have been loaded
		getServer().getPluginManager().registerEvents(new PluginEnableListener(this), this);
	}
}
