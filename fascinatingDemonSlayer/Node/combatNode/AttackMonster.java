package fascinatingDemonSlayer.Node.combatNode;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.interactive.NPC;

import fascinatingDemonSlayer.Variables;

public class AttackMonster extends Node{

	@Override
	public boolean activate() {
		return Players.getLocal().isIdle() && Inventory.getCount(Variables.food_monk) >= 1;
	}

	@Override
	public void execute() {
		NPC demon = NPCs.getNearest(Variables.LesserDemon);
	if(Variables.downLesser.contains(Players.getLocal().getLocation())){
		if(Calculations.distanceTo(demon) > 5){
			Walking.walk(demon);
		} else {
			if( demon != null && !demon.isInCombat()){
				Camera.turnTo(demon);
				demon.interact("Attack");
			}
		}
		
	}
	}	

}
