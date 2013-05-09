package fascinatingFleshCrawler.banking.edgeville;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import fascinatingFleshCrawler.Variables;
import fascinatingFleshCrawler.traverse.Misc;

public class BankingAll extends Node {

	@Override
	public boolean activate() {
		if(!Variables.GUIFinished){
			return false;
		}
		
		return
				Inventory.isFull() && Misc.edgeBankArea.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		if(Bank.isOpen()){
			Bank.depositInventory();
			
		} else {
			Bank.open();
		}
		
	}

}
