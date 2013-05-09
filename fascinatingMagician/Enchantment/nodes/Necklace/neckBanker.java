package fascinatingMagician.Enchantment.nodes.Necklace;

import java.awt.event.KeyEvent;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import fascinatingMagician.Variables;

public class neckBanker extends Node{

	@Override
	public boolean activate() {
		if(!Variables.GUIFinished){
			return false;
		}
		
		return Variables.necklace;
	}

	@Override
	public void execute() {
		if(Variables.necklace){
			
			if(Inventory.getItem(Variables.neckToEnchant) == null){
				if(!Bank.isOpen()){
					Bank.open();
				} else {
					
					if(Inventory.contains(new int[] {Variables.eSapNecklace})){
						Bank.deposit(Variables.eSapNecklace, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eEmeNecklace})){
						Bank.deposit(Variables.eEmeNecklace, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eRubNecklace})){
						Bank.deposit(Variables.eRubNecklace, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eDiaNecklace})){
						Bank.deposit(Variables.eDiaNecklace, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eDraNecklace})){
						Bank.deposit(Variables.eDraNecklace, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eOnyNecklace})){
						Bank.deposit(Variables.eOnyNecklace, 0);
						Task.sleep(500, 750);
					}
				
				
					if(Inventory.getItem(Variables.COSMIC_RUNE) == null){
						Bank.withdraw(Variables.COSMIC_RUNE, 0);
					}
					Bank.withdraw(Variables.neckToEnchant, 27); //232
					
					Bank.close();
					
					Keyboard.sendKey((char) KeyEvent.VK_ESCAPE, 50, 50);
					Keyboard.sendKey((char) KeyEvent.VK_ESCAPE, 25);
					System.out.println("OUT!");
					
					Task.sleep(1000, 2000);
				}
			}
			
		}
		
	}

}
