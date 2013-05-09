package fascinatingMagician.teleporting;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.bot.Context;

import fascinatingMagician.Variables;
import fascinatingMagician.Alcher.misc.Methods;

public class Teleporter extends Node{

	@Override
	public boolean activate() {
		if(Variables.Teleport == true){
			return true;
		}
		
		if(!Variables.GUIFinished){
			return false;
		}
		
		return Widgets.get(640, 32).isOnScreen();
	}

	@Override
	public void execute() {
		//Widget - 640, 32
		
		Item nats = Inventory.getItem(Variables.NATURE_RUNE);
	if(Variables.Teleport == true){	
		if(Widgets.get(640, 32).isOnScreen() && Inventory.contains(new int[] {Variables.NATURE_RUNE})){
			Mouse.hop(62, 367);
			Mouse.click(true);
			
			Task.sleep(2000, 3000);
			
		} else if (Inventory.contains(new int[] {Variables.NATURE_RUNE})) {
			Methods.s("Ran out of nature runes");
			Context.get().getScriptHandler().shutdown();
		}
		
	}
		
		
	}

}
