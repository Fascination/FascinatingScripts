package fascinatingMagician.Alcher.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Equipment.Slot;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.bot.Context;

import fascinatingMagician.Variables;
import fascinatingMagician.Alcher.misc.Methods;

public class BankNode extends Node{

	
	@Override
	public boolean activate() {
		if(!Variables.GUIFinished){
			return false;
		}
		
		if(Variables.HighAlch == true){
			return true;
		} 
		
		if (Variables.LowAlch == true){
			return true;
		}
		
		return !Inventory.contains(new int[] {Variables.idToAlch}) &&
				 (Variables.HighAlch || Variables.LowAlch) ;
	}

	@Override
	public void execute() {
		final Item item = Inventory.getItem(Variables.idToAlch);
		final Item nats = Inventory.getItem(Variables.NATURE_RUNE);
		
	if(!Inventory.contains(Variables.idToAlch)){
		if(!Bank.isOpen()){
			Bank.open();
		}
		} else {
			Bank.withdraw(Variables.idToAlch, 0);
			Task.sleep(500);
			if(Inventory.contains(Variables.idToAlch)){
				Bank.close();
			}
		}
	
		
	
		
		
		
	}

}
