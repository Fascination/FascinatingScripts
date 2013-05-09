package fascinatingDemonSlayer.Node.traversalNode;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.interactive.Player;

import fascinatingDemonSlayer.Variables;

public class PathToShip extends Node{

	@Override
	public boolean activate() {
		return
				Inventory.contains(new int[] {Variables.food_monk}) && !Variables.karamjaArea.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		NPC seamen = NPCs.getNearest(377, 376, 378);
		
		Walking.newTilePath(Variables.pathFromBankToShip).traverse();
		
			if(seamen != null){
				if(seamen.isOnScreen()){
					seamen.interact("Pay-fare");
				} else {
					Camera.turnTo(seamen);
				}
			}
		
	}

}
