package fascinatingFleshCrawler.looting;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.GroundItem;

import fascinatingFleshCrawler.Utilities;
import fascinatingFleshCrawler.Variables;
import fascinatingFleshCrawler.traverse.Misc;

public class LootValuables extends Node{

	/*public boolean lootCheck(){
		GroundItem Loots = GroundItems.getNearest(Variables.loots);
		if(Variables.killCount % 3 == 1 && Loots != null && Loots.isOnScreen()){
			return true;
		}
		
		return false;
		
		
	}*/
	
	@Override
	public boolean activate() {
		
		GroundItem Loots = GroundItems.getNearest(Variables.loots);
		if(!Variables.GUIFinished){
			return false;
		}
		return
				Misc.fleshcrawlersArea.contains(Players.getLocal().getLocation())
					&& Players.getLocal().getInteracting() == null
						&& Loots !=  null;
	}

	@Override
	public void execute() {
		GroundItem Loots = GroundItems.getNearest(Variables.loots);
		String nameLoot = Loots.getGroundItem().getName();
		if(Loots != null){
			if(Utilities.isOnScreen(Loots)){
				Variables.status = "Taking " + nameLoot;
				Mouse.setSpeed(Mouse.Speed.VERY_FAST);
				Loots.interact("Take", nameLoot);
				Task.sleep(300);
			} else {
				Camera.turnTo(Loots);
			}
		}
		
	}

}
