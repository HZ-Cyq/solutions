package mobinusi.service;

import mobinusi.Equip;
import mobinusi.Player;

public class EquipService {
    public static void equip(Player player, int pos, String equipCardId) {
        Equip equip = player.getEquip();
        System.out.println(pos);
        System.out.println(equip);
    }
}
