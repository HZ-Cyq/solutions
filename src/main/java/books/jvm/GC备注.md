GC备注

GC信息

| 表头1                 | 表头2                  |
| ----------------------- | ------------------------ |
| -XX:+PrintFlagsInitial | 打印所有GC参数的默认值 |
| -XX:PrintGCDetails    | 打印GC的详细信息       |


堆栈信息

| 表头1            | 表头2                          |
| ------------------ | -------------------------------- |
| -Xms10M          | 堆内存10M                      |
| -Xmx20M          | 堆最大内存20M                  |
| -Xmn10M          | 新生代10M                      |
| -SurvivorRatio=8 | Eden区和一个Survivor区大小对比 |

查看gc日志
ps -ef | grep java （e:显示所有进程信息，f:加上命令行） PID(进程id) PPID(父进程id)
jstat -gcutil PID INTERVAL_MILLISECONDS(隔多少毫秒打印一次，如果有Could not attach to的报错，在前面加上sudo)

