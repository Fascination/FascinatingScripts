package fascinatingDemonSlayer.Node.combatNode;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import fascinatingDemonSlayer.Method.action.ActionBar;
import fascinatingDemonSlayer.Node.Actionbar;
import fascinatingDemonSlayer.Node.Percentages;
import fascinatingDemonSlayer.Variables;


public class UseThresholdAbility extends Node {

	@Override
	public boolean activate() {
		NPC demon = NPCs.getNearest(Variables.LesserDemon);
		
		return Percentages.getHealthPercent(Players.getLocal().get()) > 30
				
				&& Players.getLocal().getInteracting() != null
				&& Players.getLocal().getInteracting().equals(demon)
				
				&& Actionbar.getAdrenalinPercent() >= 50
				&& Actionbar.getAdrenalinPercent() < 100
				&& !Players.getLocal().isMoving()
				&& hasUsableThresholds();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if ((Settings.get(689) & 0x400) != 0x400) {
			for (int i = 0; i < 12; i++) {
				if (ActionBar.isReady(i) && ActionBar.getAbilityInSlot(i).available()) {
					ActionBar.useSlot(i);
					break;
				}
			}
		} else {
			ensureActionBar(false);
		}
	}

	// Credits to HarryNoob :)
	private void ensureActionBar(boolean flag) {
		if (flag) {
			WidgetChild actionbar = Widgets.get(640, 6);
			if (actionbar != null && !actionbar.isOnScreen()) {
				WidgetChild abToggle = Widgets.get(640, 28);
				if (abToggle != null) {
					abToggle.interact("Expand");
				}
			}
		} else {
			WidgetChild actionbar = Widgets.get(640, 6);
			if (actionbar != null && actionbar.isOnScreen()) {
				WidgetChild abToggle = Widgets.get(640, 30);
				if (abToggle != null) {
					abToggle.interact("Minimise");
				}
			}
		}
	}
	
	private int getUltimateCount()
	{
		int j = 0;
		for(int i = 0; i < 12; i++)
		{
			if(Actionbar.getSlotStateAt(i).equals(Actionbar.SlotState.ABILITY) 
					&& Actionbar.getAbilityAt(i) != null
					&& Actionbar.getAbilityAt(i).getAbilityType().equals(Actionbar.AbilityType.THRESHOLD))
					j++;
		}
		return j;
	}
	
	public boolean hasUsableThresholds()
	{
		Actionbar.Ability[] thresholds = getUltimateCount() > 0 ? new Actionbar.Ability[getUltimateCount()] : null;
		byte j = 0x0;
		for(int i = 0; i < 12; i++)
		{
			if(Actionbar.getAbilityAt(i) != null && Actionbar.getAbilityAt(i).getAbilityType() == Actionbar.AbilityType.THRESHOLD)
			{
				thresholds[j] = Actionbar.getAbilityAt(i);
				j++;
			}
		}
		boolean b = false;
		for(Actionbar.Ability a : thresholds)
		{
			if(Actionbar.getSlotWithAbility(a).getCooldownWidget() == null || (Actionbar.getSlotWithAbility(a).getCooldownWidget() != null && (!Actionbar.getSlotWithAbility(a).getCooldownWidget().validate() || !Actionbar.getSlotWithAbility(a).getCooldownWidget().isOnScreen())))
			{
				b = true;
				break;
			}
		}
		return getUltimateCount() > 0
				&& b;

}
}
