package fascinatingMagician.Alcher.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Equipment;
import org.powerbot.game.api.methods.tab.Equipment.Slot;

import fascinatingMagician.Variables;

public class CheckEquipment extends Node{

	@Override
	public boolean activate() {
		
		if(!Variables.GUIFinished){
			return false;
		}
		
		return 
				Equipment.getItem(Slot.AMMO).getId() == Variables.idToAlch;
	}

	@Override
	public void execute() {
		if(Equipment.getItem(Slot.AMMO).getId() == Variables.idToAlch){
			
			if(!Tabs.EQUIPMENT.isOpen()){
				Tabs.EQUIPMENT.open();
			} else {
				
				Widgets.get(387, 35).click(true);
				
			}
			
		} else if (!Tabs.INVENTORY.isOpen()) {
			Tabs.INVENTORY.open();
		}
		
	}

}
