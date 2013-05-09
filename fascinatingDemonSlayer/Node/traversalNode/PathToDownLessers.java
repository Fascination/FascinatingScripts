package fascinatingDemonSlayer.Node.traversalNode;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import fascinatingDemonSlayer.Variables;

public class PathToDownLessers extends Node{

	@Override
	public boolean activate() {
		return Inventory.contains(new int[] {Variables.food_monk});
	}

	@Override
	public void execute() {
		if(!Variables.downLesser.contains(Players.getLocal().getLocation())){
			Walking.newTilePath(Variables.pathToDownLesser).traverse();
		}
		
	}

}
