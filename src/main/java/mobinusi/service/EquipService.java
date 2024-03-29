package mobinusi.service;

import exception.ErrorCode;
import exception.MyException;
import mobinusi.Equip;
import mobinusi.Player;
import test.A;

import java.util.concurrent.atomic.AtomicInteger;

public class EquipService {
    public static AtomicInteger integer = new AtomicInteger(0);

    public static void equip(Player player, int pos, String equipCardId) {
        Equip equip = player.getEquip();
        System.out.println(pos);
        System.out.println(equipCardId);
        integer.getAndIncrement();
    }

    public static void takeOff() throws MyException {
        throw new MyException(ErrorCode.ERROR1, "hello, {}" ,"world");
    }
}
