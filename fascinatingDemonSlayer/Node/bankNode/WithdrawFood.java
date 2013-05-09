package fascinatingDemonSlayer.Node.bankNode;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import fascinatingDemonSlayer.Variables;

public class WithdrawFood extends Node{

	@Override
	public boolean activate() {
		return
				Variables.dBankArea.contains(Players.getLocal().getLocation()) && !Inventory.contains(new int[]{Variables.food_monk});
	}

	@Override
	public void execute() {
		if(Bank.isOpen()){
			Bank.withdraw(Variables.food_monk, 7);
			if(Inventory.contains(new int[] {Variables.food_monk})){
				Bank.close();
			}
		} else {
			Bank.open();
		}
		
	}

}
