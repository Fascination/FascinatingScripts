package fascinatingMagician;

import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.wrappers.widget.WidgetChild;
 
/**
 * Created with IntelliJ IDEA.
 * User: Sharon
 * Date: 11/24/12
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
 
public class ActionBar
{
    private static final int ID_SETTINGS_ITEM_BASE = 811;
    private static final int ID_SETTINGS_ABILITY_BASE = 727;
    private static final int ID_SETTINGS_ADRENALIN = 679;
 
    private static final int ID_WIDGET_ACTION_BAR = 640;
 
    public static SlotState getSlotStateAt(final int index)
    {
        final int item = Settings.get(ID_SETTINGS_ITEM_BASE + index);
        if(item > -1)
            return SlotState.ITEM;
        return Settings.get(ID_SETTINGS_ABILITY_BASE + index) > -1 ? SlotState.ABILITY : SlotState.EMPTY;
    }
 
    public static int getItemIdAt(final int index)
    {
        return Settings.get(ID_SETTINGS_ITEM_BASE + index);
    }
 
    public static Ability getAbilityAt(final int index)
    {
        final int id = Settings.get(ID_SETTINGS_ABILITY_BASE + index);
        if(id == -1)
            return null;
 
        for(Ability ability : Attack_Abilities.values())
            if(ability.getId() == id)
                return ability;
 
        for(Ability ability : Strength_Abilities.values())
            if(ability.getId() == id)
                return ability;
 
        for(Ability ability : Ranged_Abilities.values())
            if(ability.getId() == id)
                return ability;
 
        for(Ability ability : Magic_Abilities.values())
            if(ability.getId() == id)
                return ability;
 
        for(Ability ability : Defence_Abilities.values())
            if(ability.getId() == id)
                return ability;
 
        for(Ability ability : Constitution_Abilities.values())
            if(ability.getId() == id)
                return ability;
 
        return null;
    }
 
    public static Slot getSlotWithId(final int id)
    {
        for(int i = 0; i < 12; i++)
            if(Settings.get(ID_SETTINGS_ITEM_BASE + i) == id)
                return Slot.values()[i];
        return null;
    }
 
    public static Slot getSlotWithAbility(final Ability ability)
    {
        for(int i = 0; i < 12; i++)
            if(Settings.get(ID_SETTINGS_ABILITY_BASE + i) == ability.getId())
                return Slot.values()[i];
        return null;
    }
 
    public static boolean isAbilityAvailable(final int index)
    {
        if(!getSlotStateAt(index).equals(SlotState.ABILITY))
            return false;
 
        final Slot slot = Slot.values()[index];
 
        if(slot != null)
        {
            final WidgetChild available = slot.getAvailableWidget();
            final WidgetChild cooldown = slot.getCooldownWidget();
 
            if(available != null && available.validate() && cooldown != null && cooldown.validate())
            {
                return cooldown.getTextureId() == 14521 && available.getTextColor() == 16777215;
            }
        }
 
        return false;
    }
 
    public static Slot getSlot(final int index)
    {
        return Slot.values()[index];
    }
 
    public static int getAdrenalinPercent()
    {
        return Settings.get(ID_SETTINGS_ADRENALIN) / 10;
    }
 
    public enum Slot
    {
        ONE(0, 32, 36, 70),
        TWO(1, 72, 73, 75),
        THREE(2, 76, 77, 79),
        FOUR(3, 80, 81, 83),
        FIVE(4, 84, 85, 87),
        SIX(5, 88, 89, 91),
        SEVEN(6, 92, 93, 95),
        EIGHT(7, 96, 97, 99),
        NINE(8, 100, 101, 103),
        TEN(9, 104, 105, 107),
        ELEVEN(10, 108, 109, 111),
        TWELVE(11, 112, 113, 115);
 
        private int index;
        private int widgetChildAvailable;
        private int widgetChildCoolDown;
        private int widgetChildText;
 
        Slot(final int index, final int widgetChildAvailable, final int widgetChildCoolDown, final int widgetChildText)
        {
            this.index = index;
            this.widgetChildAvailable = widgetChildAvailable;
            this.widgetChildCoolDown = widgetChildCoolDown;
            this.widgetChildText = widgetChildText;
        }
 
        public int getIndex()
        {
            return this.index;
        }
 
        public int getWidgetChildAvailable()
        {
            return this.widgetChildAvailable;
        }
 
        public int getWidgetChildCoolDown()
        {
            return this.widgetChildCoolDown;
        }
 
        public int getWidgetChildText()
        {
            return this.widgetChildText;
        }
 
        public WidgetChild getAvailableWidget()
        {
            return Widgets.get(ID_WIDGET_ACTION_BAR, widgetChildAvailable);
        }
 
        public WidgetChild getCooldownWidget()
        {
            return Widgets.get(ID_WIDGET_ACTION_BAR, widgetChildCoolDown);
        }
 
        public boolean isAvailable()
        {
            final WidgetChild available = getAvailableWidget();
 
            return available != null && available.validate() && available.getTextColor() == 16777215;
        }
 
        public SlotState getSlotState()
        {
            final int item = Settings.get(ID_SETTINGS_ITEM_BASE + index);
            if(item > -1)
                return SlotState.ITEM;
            return Settings.get(ID_SETTINGS_ABILITY_BASE + index) > -1 ? SlotState.ABILITY : SlotState.EMPTY;
        }
 
        public boolean activate(boolean sendKey)
        {
            final WidgetChild widgetChild = Widgets.get(ID_WIDGET_ACTION_BAR, widgetChildAvailable);
 
            if(!widgetChild.validate())
                return false;
 
            if(sendKey)
            {
                Keyboard.sendKey(Widgets.get(ID_WIDGET_ACTION_BAR, widgetChildText).getText().charAt(0));
                return true;
            }
            else
            {
                return widgetChild.click(true);
            }
        }
    }
 
    public enum SlotState
    {
        EMPTY,
        ABILITY,
        ITEM
    }
 
    public enum AbilityType
    {
        BASIC,
        THRESHOLD,
        ULTIMATE
    }
 
    public interface Ability
    {
        public int getId();
 
        public String getName();
 
        public int getCoolDown();
 
        public AbilityType getAbilityType();
    }
 
    public enum Attack_Abilities implements Ability
    {
        SLICE(17, "Slice", 5, AbilityType.BASIC),
        SLAUGHTER(113, "Slaughter", 30, AbilityType.THRESHOLD),
        OVERPOWER(161, "Overpower", 30, AbilityType.ULTIMATE),
        HAVOC(65, "Havoc", 10, AbilityType.BASIC),
        BACKHAND(97, "BAckhand", 15, AbilityType.BASIC),
        SMASH(81, "Smash", 10, AbilityType.BASIC),
        BARGE(33, "Barge", 20, AbilityType.BASIC),
        FLURRY(129, "Flurry", 20, AbilityType.THRESHOLD),
        SEVER(49, "Sever", 30, AbilityType.BASIC),
        HURRICANE(145, "Hurricane", 20, AbilityType.THRESHOLD),
        MASSACRE(177, "Massacre", 60, AbilityType.ULTIMATE),
        METEOR_STRIKE(193, "Meteor Strike", 60, AbilityType.ULTIMATE);
 
        private int id;
        private String name;
        private int coolDown;
        private AbilityType abiltiyType;
 
        Attack_Abilities(final int id, final String name, final int coolDown, final AbilityType abiltiyType)
        {
            this.id = id;
            this.name = name;
            this.coolDown = coolDown;
            this.abiltiyType = abiltiyType;
        }
 
        @Override
        public int getId()
        {
            return this.id;
        }
 
        @Override
        public String getName()
        {
            return this.name;
        }
 
        @Override
        public int getCoolDown()
        {
            return this.coolDown;
        }
 
        @Override
        public AbilityType getAbilityType()
        {
            return this.abiltiyType;
        }
    }
 
    public enum Strength_Abilities implements Ability
    {
        KICK(34, "Kick", 15, AbilityType.BASIC),
        PUNISH(50, "Punish", 5, AbilityType.BASIC),
        DISMEMBER(18, "Dismember", 30, AbilityType.BASIC),
        FURY(66, "Fury", 20, AbilityType.BASIC),
        DESTROY(146, "Destroy", 20, AbilityType.THRESHOLD),
        QUAKE(130, "Quake", 20, AbilityType.THRESHOLD),
        BERSERK(162, "Berserk", 60, AbilityType.ULTIMATE),
        CLEAVE(98, "Cleave", 10, AbilityType.BASIC),
        ASSAULT(114, "Assault", 30, AbilityType.THRESHOLD),
        DECIMATE(82, "Decimate", 10, AbilityType.BASIC),
        PULVERISE(194, "Pulverise", 60, AbilityType.ULTIMATE),
        FRENZY(178, "Frenzy", 60, AbilityType.ULTIMATE);
 
        private int id;
        private String name;
        private int coolDown;
        private AbilityType abiltiyType;
 
        Strength_Abilities(final int id, final String name, final int coolDown, final AbilityType abiltiyType)
        {
            this.id = id;
            this.name = name;
            this.coolDown = coolDown;
            this.abiltiyType = abiltiyType;
        }
 
        @Override
        public int getId()
        {
            return this.id;
        }
 
        @Override
        public String getName()
        {
            return this.name;
        }
 
        @Override
        public int getCoolDown()
        {
            return this.coolDown;
        }
 
        @Override
        public AbilityType getAbilityType()
        {
            return this.abiltiyType;
        }
    }
 
    public enum Ranged_Abilities implements Ability
    {
        PIERCING_SHOT(21, "Piercing Shot", 5, AbilityType.BASIC),
        SNAP_SHOT(117, "Snap Shot", 20, AbilityType.THRESHOLD),
        DEADSHOT(197, "Deadshot", 30, AbilityType.ULTIMATE),
        SNIPE(89, "Snipe", 10, AbilityType.BASIC),
        BINDING_SHOT(37, "Binding Shot", 15, AbilityType.BASIC),
        FRAGMENTATION_SHOT(85, "Fragmentation Shot", 30, AbilityType.BASIC),
        ESCAPE(53, "Escape", 20, AbilityType.BASIC),
        RAPID_FIRE(133, "Rapid Fire", 20, AbilityType.THRESHOLD),
        RICOCHET(101, "Ricochet", 10, AbilityType.BASIC),
        BOMBARDMENT(149, "Bombardment", 30, AbilityType.THRESHOLD),
        INCENDIARY_SHOT(165, "Incendiary Shot", 60, AbilityType.ULTIMATE),
        UNLOAD(181, "Unload", 60, AbilityType.ULTIMATE);
 
        private int id;
        private String name;
        private int coolDown;
        private AbilityType abiltiyType;
 
        Ranged_Abilities(final int id, final String name, final int coolDown, final AbilityType abiltiyType)
        {
            this.id = id;
            this.name = name;
            this.coolDown = coolDown;
            this.abiltiyType = abiltiyType;
        }
 
        @Override
        public int getId()
        {
            return this.id;
        }
 
        @Override
        public String getName()
        {
            return this.name;
        }
 
        @Override
        public int getCoolDown()
        {
            return this.coolDown;
        }
 
        @Override
        public AbilityType getAbilityType()
        {
            return this.abiltiyType;
        }
    }
 
    public enum Magic_Abilities implements Ability
    {
        WRACK(22, "Wrack", 20, AbilityType.BASIC),
        ASPHYXIATE(118, "Asphyxiate", 5, AbilityType.THRESHOLD),
        OMNIPOWER(198, "Omnipower", 30, AbilityType.ULTIMATE),
        DRAGON_BREATH(102, "Dragon Breat", 10, AbilityType.BASIC),
        IMPACT(54, "Impact", 15, AbilityType.BASIC),
        COMBUST(86, "Combust", 10, AbilityType.BASIC),
        SURGE(38, "Surge", 20, AbilityType.BASIC),
        DETONATE(134, "Detonate", 30, AbilityType.THRESHOLD),
        CHAIN(70, "Chain", 10, AbilityType.BASIC),
        WILD_MAGIC(150, "Wild Magic", 20, AbilityType.THRESHOLD),
        METAMORPHOSIS(166, "Metamorphosis", 60, AbilityType.ULTIMATE),
        TSUNAMI(182, "Tsunami", 60, AbilityType.ULTIMATE);
 
        private int id;
        private String name;
        private int coolDown;
        private AbilityType abiltiyType;
 
        Magic_Abilities(final int id, final String name, final int coolDown, final AbilityType abiltiyType)
        {
            this.id = id;
            this.name = name;
            this.coolDown = coolDown;
            this.abiltiyType = abiltiyType;
        }
 
        @Override
        public int getId()
        {
            return this.id;
        }
 
        @Override
        public String getName()
        {
            return this.name;
        }
 
        @Override
        public int getCoolDown()
        {
            return this.coolDown;
        }
 
        @Override
        public AbilityType getAbilityType()
        {
            return this.abiltiyType;
        }
    }
 
    public enum Defence_Abilities implements Ability
    {
        ANTICIPATION(19, "Anticipation", 25, AbilityType.BASIC),
        BASH(99, "Bash", 15, AbilityType.BASIC),
        REVENGE(147, "Revenge", 20, AbilityType.THRESHOLD),
        PROVOKE(51, "Provoke", 10, AbilityType.BASIC),
        IMMORTALITY(195, "Immortality", 120, AbilityType.ULTIMATE),
        FREEDOM(35, "Freedom", 30, AbilityType.BASIC),
        REFLECT(115, "Reflect", 15, AbilityType.THRESHOLD),
        RESONANCE(67, "Resonance", 30, AbilityType.BASIC),
        REJUVENATE(179, "Rejuvenate", 60, AbilityType.ULTIMATE),
        DEBILITATE(131, "Debilitate", 30, AbilityType.THRESHOLD),
        PREPARATION(83, "Preparation", 5, AbilityType.BASIC),
        BARRICADE(163, "Barricade", 60, AbilityType.ULTIMATE);
 
        private int id;
        private String name;
        private int coolDown;
        private AbilityType abiltiyType;
 
        Defence_Abilities(final int id, final String name, final int coolDown, final AbilityType abiltiyType)
        {
            this.id = id;
            this.name = name;
            this.coolDown = coolDown;
            this.abiltiyType = abiltiyType;
        }
 
        @Override
        public int getId()
        {
            return this.id;
        }
 
        @Override
        public String getName()
        {
            return this.name;
        }
 
        @Override
        public int getCoolDown()
        {
            return this.coolDown;
        }
 
        @Override
        public AbilityType getAbilityType()
        {
            return this.abiltiyType;
        }
    }
 
    public enum Constitution_Abilities implements Ability
    {
        REGENERATE(20, "Regenerate", 0, AbilityType.BASIC),
        MOMENTUM(116, "Momentum", 0, AbilityType.ULTIMATE),
        INCITE(36, "Incite", 0, AbilityType.BASIC),
        SINGLE_WAY_WILDERNESS(132, "Single-way Wilderness", 10, AbilityType.BASIC);
 
        private int id;
        private String name;
        private int coolDown;
        private AbilityType abiltiyType;
 
        Constitution_Abilities(final int id, final String name, final int coolDown, final AbilityType abiltiyType)
        {
            this.id = id;
            this.name = name;
            this.coolDown = coolDown;
            this.abiltiyType = abiltiyType;
        }
 
        @Override
        public int getId()
        {
            return this.id;
        }
 
        @Override
        public String getName()
        {
            return this.name;
        }
 
        @Override
        public int getCoolDown()
        {
            return this.coolDown;
        }
 
        @Override
        public AbilityType getAbilityType()
        {
            return this.abiltiyType;
        }
    }
}
