package fascinatingDemonSlayer.Node.traversalNode;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import fascinatingDemonSlayer.Variables;

public class TeleportToDraynor extends Node{

	@Override
	public boolean activate() {
		return
				Inventory.getCount(Variables.food_monk) == 0 && !Variables.downLesser.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		Widgets.get(548, 131).click(true);
		Task.sleep(1000, 1200);
		Widgets.get(275, 41).click(true);
		Task.sleep(1000,1200);
		Widgets.get(275, 46).click(true);
		Task.sleep(1000, 1200);
		Widgets.get(275, 16).click(true);
		Task.sleep(1000, 1200);
		Widgets.get(1092, 44).click(true);
		
	}

}
