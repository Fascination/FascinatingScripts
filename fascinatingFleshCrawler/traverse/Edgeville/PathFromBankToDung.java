package fascinatingFleshCrawler.traverse.Edgeville;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

import fascinatingFleshCrawler.Variables;
import fascinatingFleshCrawler.traverse.Misc;



public class PathFromBankToDung extends Node{

	@Override
	public boolean activate() {
		return
				!Inventory.isFull() && Inventory.contains(Variables.food_monk) && !Misc.dungEntranceArea.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		
		
		
			Walking.newTilePath(Misc.pathFromEdgeToDung).traverse();
		
	}

}
