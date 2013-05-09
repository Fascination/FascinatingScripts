package fascinatingFleshCrawler.traverse;

import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public enum LodestoneTravel {
    AL_KHARID(0),
    ARDOUGNE(1),
    BURTHROPE(2),
    CATHERBY(3),
    DRAYNOR(4),
    EDGEVILLE(5),
    FALADOR(6),
    LUMBRIDGE(7),
    PORT_SARIM(8),
    SEERS_VILLAGE(9),
    TAVERLY(10),
    VARROCK(11),
    YANILLE(12);
    private final int shift;
    private int widgetChild = -1;

    private LodestoneTravel(final int shift) {
        this.shift = shift;
        if (shift <= 12)
            widgetChild = 40 + shift;
    }

    public boolean isActivated() {
        return (Settings.get(3) >> shift & 1) == 1;
    }

    public WidgetChild getWidgetChild() {
        return Widgets.get(1092, widgetChild);
    }

    public void teleport() {
        final WidgetChild SKILL_TAB = Widgets.get(275, 16);
        if (SKILL_TAB.validate() && !SKILL_TAB.visible()) {
            final WidgetChild OPEN_SKILL_TAB = Widgets.get(548, 114);
            if (OPEN_SKILL_TAB.validate()
                    && OPEN_SKILL_TAB.interact("Ability Book")) {
                Task.sleep(300, 600);
            }
        }
        final WidgetChild MAGIC_TAB = Widgets.get(275, 62);
        if (MAGIC_TAB.validate() && !MAGIC_TAB.visible()) {
            final WidgetChild OPEN_MAGIC_TAB = Widgets.get(275, 40);
            if (OPEN_MAGIC_TAB.validate() && OPEN_MAGIC_TAB.interact("Magic")) {
                Task.sleep(300, 600);
            }
        }
        final WidgetChild TELEPORT_TAB = Widgets.get(275, 38);
        if (TELEPORT_TAB.validate() && !TELEPORT_TAB.visible()) {
            final WidgetChild OPEN_TELEPORT_TAB = Widgets.get(275, 46);
            if (OPEN_TELEPORT_TAB.validate()
                    && OPEN_TELEPORT_TAB.interact("Teleport-spells")) {
                Task.sleep(300, 600);
            }
        }
        final WidgetChild LODESTONE_BUTTON = Widgets.get(275, 16).getChild(155);
        if (LODESTONE_BUTTON.validate() && LODESTONE_BUTTON.visible())
            if (LODESTONE_BUTTON.interact("Cast")) {
                Task.sleep(800, 1200);
            }
        final WidgetChild DESTINATION_CHOOSE = Widgets.get(1092, 0);
        if (DESTINATION_CHOOSE.validate() && DESTINATION_CHOOSE.visible()) {
            final WidgetChild DESTINATION_BUTTON = getWidgetChild();
            if (DESTINATION_BUTTON.validate() && DESTINATION_BUTTON.visible()) {
                if (DESTINATION_BUTTON.interact("Teleport")) {
                    Task.sleep(2000, 3000);
                    final Timer TIMEOUT = new Timer(15000);
                    while (TIMEOUT.isRunning() && !Players.getLocal().isIdle()) {
                        Task.sleep(50, 100);
                    }
                }
            }
        }
    }
}