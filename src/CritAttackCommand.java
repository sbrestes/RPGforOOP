public class CritAttackCommand extends Command
{
    final private Character attacker;
    final private Character defender;
    final private boolean ifCrit;

    public CritAttackCommand(Character attacker, Character defender)
    {
        this.attacker = attacker;
        this.defender = defender;
        if(Math.random()<=attacker.getcritChance())
        {
            ifCrit=true;
        }
        else
        {
            ifCrit=false;
        }
    }
    public boolean ifCrit()
    {
        return ifCrit;
    }
    public int dmgDealt()
    {
        if(ifCrit) return attacker.getcritDmg();
        return 0;
    }
    public void perform(Scene scene)
    {
        if(ifCrit)
        {
            int actualDealtDamage = defender.dealDamage(attacker.getcritDmg());
            scene.displayMessage(actualDealtDamage + " CRITICAL DAMAGE to " + defender.getName());
            Global.getInstance().reportDamage(actualDealtDamage);
        }
    }
}