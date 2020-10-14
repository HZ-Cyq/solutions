参考：https://developer.ibm.com/zh/articles/j-understanding-functional-programming-3/
Consumer<T>：接受一个输入，没有输出。抽象方法为 void accept(T t)。
Supplier<T>：没有输入，一个输出。抽象方法为 T get()。
Predicate<T>：接受一个输入，输出为 boolean 类型。抽象方法为 boolean test(T t)。
UnaryOperator<T>：接受一个输入，输出的类型与输入相同，相当于 Function<T, T>。
BinaryOperator<T>：接受两个类型相同的输入，输出的类型与输入相同，相当于 BiFunction<T,T,T>。
BiPredicate<T, U>：接受两个输入，输出为 boolean 类型。抽象方法为 boolean test(T t, U u)。
