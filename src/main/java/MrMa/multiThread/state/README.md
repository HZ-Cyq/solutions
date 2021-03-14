![线程状态迁移图](线程状态.png)

interrupt, 有一个线程sleep很久，然后在某个时候要打断这个线程，
这个时候可以用interrupt,在sleep的时候catch interrupt 异常

join:等另一个线程结束
