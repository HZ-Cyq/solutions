+ 《java网络程序设计》第二章：java语言基础
    + 补码：在计算机体系中，数值一直用补码来表示和存储。因为使用补码，符号位和数值域可以统一处理，加法和减法也可以统一处理。
        + 正数的补码是本身。
        + 负数的补码是：模的反码加1.
        + 比如1的补码是00000001, -1的补码是11111111, (-1 + 1) = 0 / 256;
        + 127的补码是11111111, -127的补码是00000001, (-127 + 127) = 0 / 256;
        + 0的补码是00000000, -128的补码是10000000， （-128 + 0） = 0 / 256;
        + 可以把0看成128。