package fascinatingFleshCrawler.banking.StrengthPotions;

import javax.swing.JOptionPane;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.bot.Context;

import fascinatingFleshCrawler.Variables;
import fascinatingFleshCrawler.traverse.Misc;

public class WithdrawSuperStrPot extends Node {

	@Override
	public boolean activate() {
		return Variables.useSuperStrPots;
	}

	@Override
	public void execute() {
		if (Variables.useSuperStrPots) {
			if (!Inventory.contains(Variables.superStrengthPots)) {
				if (Misc.edgeBankArea
						.contains(Players.getLocal().getLocation())) {
					if(Inventory.contains(Variables.food_monk)){
					if(!Bank.isOpen()){
						Bank.open();
					} else {
						if(Bank.getItemCount(Variables.superStrPot_4) == 0 && Bank.getItemCount(Variables.superStrPot_3) >= 1){
							Bank.withdraw(Variables.superStrPot_3, Variables.noOfStr);
							if(Inventory.contains(Variables.food_monk)){
								Bank.close();
							}
						} else {
							Bank.withdraw(Variables.superStrPot_4, Variables.noOfStr);
							if(Inventory.contains(Variables.food_monk)){
								Bank.close();
							}	
						}
					}
					
				}
			}

			if (Inventory.contains(Variables.superStrengthPots)
					&& Inventory.contains(Variables.food_monk) && Bank.isOpen()) {
				Bank.close();
			}

		}
	}
}
}
