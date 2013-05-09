package fascinatingDemonSlayer.Method.action.ability;

import org.powerbot.game.api.wrappers.widget.WidgetChild;

import fascinatingDemonSlayer.Method.action.Ability;
import fascinatingDemonSlayer.Method.general.Completion;
import fascinatingDemonSlayer.Method.tab.MainTabs;
import fascinatingDemonSlayer.Method.tab.Tab;

public enum Prayer implements Ability {
	;

	@Override
	public boolean show() {
		return false;
	}

	@Override
	public boolean isVisible() {
		return false;
	}

	@Override
	public boolean available() {
		return false;
	}

	public Tab getTab() {
		return MainTabs.PRAYER;
	}

	@Override
	public WidgetChild getChild() {
		return null;
	}

	@Override
	public Completion getChange() {
		return null;
	}

	@Override
	public int getAbilityId() {
		return 0;
	}

}
