package fascinatingFleshCrawler.combat;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.node.GroundItem;
import org.powerbot.game.api.wrappers.node.SceneObject;

import fascinatingFleshCrawler.Utilities;
import fascinatingFleshCrawler.Variables;
import fascinatingFleshCrawler.traverse.Misc;

public class KillMonster extends Node {

	/*public boolean lootCheck() {
		GroundItem Loots = GroundItems.getNearest(Variables.loots);
		if (Variables.killCount % 3 == 1 && Loots != null && Loots.isOnScreen()) {
			return true;
		}

		return false;

	}
	*/

	@Override
	public boolean activate() {
		if (!Variables.GUIFinished) {
			return false;
		}

		 GroundItem Loots = GroundItems.getNearest(Variables.loots);
		return Inventory.contains(Variables.food_monk)
				&& Players.getLocal().getInteracting() == null
				&& Misc.fleshcrawlersArea.contains(Players.getLocal()
						.getLocation()) && !Inventory.isFull() && Loots == null;
	}

	@Override
	public void execute() {
		
		NPC enemy = NPCs.getNearest(Variables.monster);
		if (enemy != null) {
			if (Utilities.isOnScreen(enemy)) {
				enemy.interact("Attack");
				Variables.status = "Attacking..";
				Variables.killCount++;
				Task.sleep(1000, 1200);
			} else {
				Variables.status = "Turning camera";
				Camera.turnTo(enemy);
			}

			
		} else {
			/*if (!Players.getLocal().isMoving()) {
				Variables.status = "Walking to centre of room";
				Walking.walk(new Tile(2040, 5190, 0)); // go to center of room
			}*/
		}

	}

}
