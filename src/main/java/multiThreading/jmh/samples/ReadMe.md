01_HelloWorld: 如何运行一个需要测试的方法（基准方法），使用 @Benchmark 标记，jmh框架生成测试代码，尽可能可靠地给出测试结果。 
02_BenchmarkModes: 
 + 好的测试需要持续的跟进，通过反复检查生成的代码来跟进测试。
 + 四个测量维度: 通过Mode注释，可以任意组合。
    1.Throughput: 吞吐量，在有限时间内持续调用一个方法，记录调用的次数。
    2.AverageTime: 平均时间，其实是吞吐量的倒数
    3.SampleTime: 采样时间，计算的是某些benchmark时间,[是一个benchmark方法里的某些代码呢？还是某些benchmark方法呢]
    4.SingleShotTime: 只启动一次的时间。
