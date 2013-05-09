package fascinatingDemonSlayer.Node.combatNode;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.interactive.Players;
import fascinatingDemonSlayer.Variables;
import fascinatingDemonSlayer.Node.Actionbar;

public class UseAbility extends Node {

	@Override
	public boolean activate() {
		return Players.getLocal().getInteracting() != null
				
				&& !Players.getLocal().isMoving();
	}

	@Override
	public void execute() {
		Variables.failsafeTimer = null;
        prepareAbility();
		for(int i = 0; i < 12; i++)
		{
			if(Actionbar.getSlot(i).isAvailable() 
					&& Actionbar.getAbilityAt(i) != null 
					&& Actionbar.getAbilityAt(i).getAbilityType() == Actionbar.AbilityType.BASIC
					&& Actionbar.getSlotStateAt(i).equals(Actionbar.SlotState.ABILITY)
					&& !Actionbar.getSlot(i).getCooldownWidget().isOnScreen())
			{
				
				Actionbar.getSlot(i).activate(true);
				Task.sleep(500);
				break;
			}
		}
	}

    private void prepareAbility()
    {
        if(Widgets.get(137, 56).isOnScreen() && !Widgets.get(137, 56).getText().equalsIgnoreCase("[Press Enter to Chat]"))
        {
            Keyboard.sendKey('\u001B');
            Task.sleep(400);
            Keyboard.sendKey('\u001B');
        }
    }


}
