package seriliazer.protoBuf.main;

import com.google.protobuf.InvalidProtocolBufferException;
import seriliazer.protoBuf.Cmd;

public class Main {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        byte[] bytes = new byte[10];
        Cmd.Cmd_Act_Get cmd_act_get = Cmd.Cmd_Act_Get.parseFrom(bytes);
        int actId = cmd_act_get.getActId();

    }
}
