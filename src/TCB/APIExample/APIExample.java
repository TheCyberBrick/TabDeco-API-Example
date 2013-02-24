package TCB.APIExample;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class APIExample extends JavaPlugin 
{
	public static Logger log;
	
	@Override 
    public void onEnable()
	{
		//Initializing the logger
		log = this.getLogger();
		
		//Registering the plugin enable listener
		getServer().getPluginManager().registerEvents(new PluginEnableListener(this), this);
	}
}