package fascinatingFleshCrawler.banking;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import fascinatingFleshCrawler.Variables;
import fascinatingFleshCrawler.traverse.Misc;

public class WithdrawFood extends Node{

	@Override
	public boolean activate() {
		if(!Variables.GUIFinished){
			return false;
		}
		return
				!Misc.dungEntranceArea.contains(Players.getLocal().getLocation()) && !Inventory.contains(Variables.food_monk);
	}

	@Override
	public void execute() {
		if(Bank.isOpen()){
			if (Bank.getItem(Variables.food_monk) != null){
				Bank.withdraw(Variables.food_monk, 2);
				if(Inventory.contains(Variables.food_monk)){
					Bank.close();
				}
			}
		} else {
			Bank.open();
		}
		
		
		
	}

}
