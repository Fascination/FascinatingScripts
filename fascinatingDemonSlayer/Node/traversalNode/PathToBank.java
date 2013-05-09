package fascinatingDemonSlayer.Node.traversalNode;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import fascinatingDemonSlayer.Variables;

public class PathToBank extends Node{

	@Override
	public boolean activate() {
		return
				!Variables.dBankArea.contains(Players.getLocal().getLocation()) && !Inventory.contains(new int[] {Variables.food_monk});
	}

	@Override
	public void execute() {
		Walking.newTilePath(Variables.pathToBank).traverse();
		
	}

}
