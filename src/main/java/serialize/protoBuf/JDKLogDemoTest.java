package serialize.protoBuf;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;

public class JDKLogDemoTest {
    /**
     * 序列化和反序列一个简单的proto结构
     * 执行这个方法之前，需要先执行执行protoc命令，根据Cmd.proto文件生成Cmd.java文件
     * 注意protoc命令和maven里的proto的版本需要一致，不然生成的cmd.java文件可能会报错
     * protoc --java_out=. Cmd.proto
     */
    @Test
    public void test1() throws InvalidProtocolBufferException {
        // 构建一个Cmd_Act_Get结构
        Cmd.Cmd_Act_Get.Builder builder = Cmd.Cmd_Act_Get.newBuilder();
        builder.setRid("123");
        builder.setActId(1);
        Cmd.Cmd_Act_Get build = builder.build();
        System.out.println(build);
        byte[] bytes = build.toByteArray();
        // 通过byte[]数组反序列化一个Cmd_Act_Get结构
        Cmd.Cmd_Act_Get cmd_act_get = Cmd.Cmd_Act_Get.parseFrom(bytes);
        System.out.println(cmd_act_get);
    }

    /**
     * 测试嵌套类型
     */
    @Test
    public void test2() throws InvalidProtocolBufferException {
        Cmd.Cmd_3 cmd_3 = Cmd.Cmd_3.newBuilder().setB(4).build();
        Cmd.Cmd_2 cmd_2 = Cmd.Cmd_2.newBuilder().setA(1).setB(1).setC(cmd_3).build();
        System.out.println(cmd_2);
        byte[] bytes = cmd_2.toByteArray();
        Cmd.Cmd_2 cmd_21 = Cmd.Cmd_2.parseFrom(bytes);
        System.out.println(cmd_21);
    }

    /**
     * 测试数组类型
     */
    @Test
    public void test3() {
        Cmd.Cmd_4 cmd_4 = Cmd.Cmd_4.newBuilder().addA(1).addA(2).addA(3).build();
        System.out.println(cmd_4);
    }

    /**
     * 测试嵌套类型，从其他文件中导入的类型
     */
    @Test
    public void test4() {
        Msg.Msg1 msg1 = Msg.Msg1.newBuilder().setA(1).setB(1).build();
        Cmd.Cmd_otherProto cmd_otherProto = Cmd.Cmd_otherProto.newBuilder().setMsg1(msg1).build();
        System.out.println(cmd_otherProto);
    }

    /**
     * 测试map类型
     */
    @Test
    public void test5() {
        Cmd.Cmd_5 cmd_5 = Cmd.Cmd_5.newBuilder().putMap(1, "1").putMap(2, "2").build();
        System.out.println(cmd_5);
        System.out.println(cmd_5.getMapMap().get(1));
    }
}
