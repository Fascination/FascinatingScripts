package fascinatingFleshCrawler.traverse.Edgeville;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;


import fascinatingFleshCrawler.traverse.LodestoneTravel;
import fascinatingFleshCrawler.traverse.Misc;

public class TeleportTo extends Node{

	@Override
	public boolean activate() {
		return
				Misc.fleshcrawlersArea.contains(Players.getLocal().getLocation())
				&& Inventory.isFull();
	}

	@Override
	public void execute() {
		Tabs.ABILITY_BOOK.open();
		LodestoneTravel.EDGEVILLE.teleport();
		Task.sleep(1000);
		
	}

}
