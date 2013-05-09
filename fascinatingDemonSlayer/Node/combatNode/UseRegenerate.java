package fascinatingDemonSlayer.Node.combatNode;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.interactive.Players;

import fascinatingDemonSlayer.Method.action.ActionBar;



public class UseRegenerate extends Node{

	@Override
	public boolean activate() {
		return !Players.getLocal().isInCombat();
	}

	@Override
	public void execute() {
		if(ActionBar.isReady(6)){
			Keyboard.sendKey('6');
			Task.sleep(2000, 3000);
		}
		
	}

}
