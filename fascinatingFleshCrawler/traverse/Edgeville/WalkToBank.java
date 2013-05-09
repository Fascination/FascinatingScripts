package fascinatingFleshCrawler.traverse.Edgeville;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import fascinatingFleshCrawler.traverse.Misc;

public class WalkToBank extends Node{

	@Override
	public boolean activate() {
		return
				!Misc.edgeBankArea.contains(Players.getLocal().getLocation())
						&& Inventory.isFull();
	}

	@Override
	public void execute() {
		Walking.newTilePath(Misc.pathFromLodeToBank).traverse();
		
	}

}
