package fascinatingMagician.PlankMake;

import java.awt.event.KeyEvent;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.widget.WidgetChild;



import fascinatingMagician.Variables;
import fascinatingMagician.Alcher.misc.Methods;

public class CastPlankMake extends Node{

	public static final int WIDGET_TEXT = 548;
	public static final int WIDGETCHILD_TEXT = 435;
	
	@Override
	public boolean activate() {
		if(!Variables.GUIFinished){
			return false;
		}
		return Variables.plankmake && Inventory.contains(new int[] {Variables.logsToPlank})
				&& Inventory.contains(new int[] {Variables.astral}) && 
					Inventory.contains(new int[] {Variables.NATURE_RUNE});
	}

	@Override
	public void execute() {
	
		if(Variables.plankmake && Inventory.contains(new int[] {Variables.logsToPlank}) && !Bank.isOpen()){
			
			final WidgetChild widget = Widgets.get(WIDGET_TEXT,
					WIDGETCHILD_TEXT).getChild(0);
			
			final Item item = Inventory.getItem(Variables.logsToPlank);
		
			if(item != null){
				Mouse.setSpeed(Mouse.Speed.VERY_FAST);
				Methods.s(String.format("Casting Plank make on %s", item.getName()));
				Variables.status = "Casting..";
				if(!Widgets.get(137).getChild(56).getText().contains("[Press Enter to Chat]")) {
					Keyboard.sendKey((char) KeyEvent.VK_ESCAPE);
		
			}	
				Mouse.setSpeed(Mouse.Speed.VERY_FAST);
				Keyboard.sendKey((char) KeyEvent.VK_2);
				Task.sleep(10, 20);
				Inventory.getItem(Variables.logsToPlank).getWidgetChild().interact("Cast");
				Variables.logsCasted++;
				Variables.expGained = Variables.logsCasted * 90;
				Task.sleep(1800, 2000);
				
			
			if(Widgets.get(1179, 21).isOnScreen()){
				Variables.status = "Widget closing..";
				Mouse.setSpeed(Mouse.Speed.VERY_FAST);
				Widgets.get(1179, 29).click(true);
			}
			
			
			
		}
		
	}
		
		

}
	}

