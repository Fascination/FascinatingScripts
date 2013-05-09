package fascinatingDemonSlayer.Node.healthNode;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import fascinatingDemonSlayer.Variables;

public class EatFood extends Node{

	@Override
	public boolean activate() {
		return Players.getLocal().getHealthPercent() < 50;
	}

	@Override
	public void execute() {
		if(Inventory.getItem(Variables.food_monk) != null && Inventory.getCount() > 1){
			Inventory.getItem(Variables.food_monk).getWidgetChild().interact("Eat");
		}
		
	}

}
