package fascinatingMagician.PlankMake.BankPlanks;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import fascinatingMagician.Variables;

public class CloseBank extends Node{

	@Override
	public boolean activate() {
		
		if(!Variables.GUIFinished){
			return false;
		}
		
		return 
				Inventory.contains(new int[]{Variables.logsToPlank}) && Bank.isOpen();
	}

	@Override
	public void execute() {
		
		if(Bank.isOpen()
				&& Inventory.contains(new int[] {Variables.logsToPlank})){
			Bank.close();
		}
			
		
	}

}
