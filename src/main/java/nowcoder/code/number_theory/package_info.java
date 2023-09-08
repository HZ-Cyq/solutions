package nowcoder.code.number_theory;

/** 参考：<a href="https://blog.csdn.net/qq_45933509/article/details/122556441">...</a>
 * 带余除法定理: 设a,b是两个整数，且b!=0,则存在唯一整数q, r(0 <= r < |b}), 使得 a = b * q + r
 * 证明（todo 待验证是否正确，自测是正确的）
 *    1、证存在性 令q = a / b, r = a mod b, 满足条件
 *    2、证唯一性 假设存在两个或两个以上的q,r则：
 *    q1 * b + r1 = q2 * b + r2  --> (q1 - q2) * b = r2 - r1 --> b 整除 r2 - r1
 *    因为 0 <= r < |b|, 所以 -|b| < r2 - r1 < b, 所以r2 - r1 = 0, 即 r1 = r2
 *
 * 最大公约数(gcd)和最小公倍数(lcm)
 *    性质0：gcd(m, n) = gcd(m, m - n);
 *    性质1：gcd(k*m, k*n) = k * gcd(m, n)
 *    互质：如果gcd(m, n) = 1, 则称这两个数互质
 *
 * 唯一分解定理（算术基本定理）
 * 任何一个大于1的数都可以被唯一分解成有限个质数乘积的形式
 *
 * 约数
 *
 * 欧拉函数
 *
 * 快速幂
 *
 * 同余
 *    若整数a和整数b除以m的余数相等，则称a,b模m同余，记为 a = b(mod m)
 *
 */
public class package_info {
}
