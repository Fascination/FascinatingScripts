package fascinatingFleshCrawler.combat.foodCheck;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import fascinatingFleshCrawler.Variables;



public class EatFood extends Node{

	@Override
	public boolean activate() {
		return
				Players.getLocal().getHealthPercent() < 50 && Inventory.contains(Variables.food_monk);
	}

	@Override
	public void execute() {
		if(Inventory.getItem(Variables.food_monk) != null){
			if(Inventory.contains(Variables.food_monk)){
				Inventory.getItem(Variables.food_monk).getWidgetChild().interact("Eat");
			}
		}
		
	}

}
