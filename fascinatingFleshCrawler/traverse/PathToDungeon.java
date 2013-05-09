package fascinatingFleshCrawler.traverse;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

import fascinatingFleshCrawler.Variables;

public class PathToDungeon extends Node{

	@Override
	public boolean activate() {
		
		
		return
				 !Misc.dungEntranceArea.contains(Players.getLocal().getLocation())
							&& !Inventory.isFull();
	}

	@Override
	public void execute() {
		
		
		Walking.newTilePath(Misc.pathToDungeon).traverse();
		
		
	
		
	}

}
