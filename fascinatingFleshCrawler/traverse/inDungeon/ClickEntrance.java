package fascinatingFleshCrawler.traverse.inDungeon;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import fascinatingFleshCrawler.Utilities;
import fascinatingFleshCrawler.Variables;
import fascinatingFleshCrawler.traverse.Misc;

public class ClickEntrance extends Node{

	@Override
	public boolean activate() {
		SceneObject entrance = SceneEntities.getNearest(16154);
		return 
				entrance != null && Inventory.contains(Variables.food_monk) && 
					Misc.varrock.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		SceneObject entrance = SceneEntities.getNearest(16154);
		if(entrance != null){
			if(Utilities.isOnScreen(entrance)){
				entrance.interact("Climb-down");
				Task.sleep(2000, 2500);
			} else {
				Camera.turnTo(entrance);
			}
		}
		
	}

}
