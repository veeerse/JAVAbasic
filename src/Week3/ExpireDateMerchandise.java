package Week3;

import java.util.Date;

public interface ExpireDateMerchandise {
    public static final int VAL_IN_INTERFACE = 999;

    /**
     * 截止到当前，商品的保质期天数是否超过传递的天数
     *
     * @param days 截止到当前，保质期超过这么多天
     * @return 截止到当前，true如果保质期剩余天数比参数长，false如果保质期不到这多天
     */
    boolean notExpireInDays(int days);

    /**
     * @return 商品生产日期
     */
    Date getProducedDate();

    /**
     * @return 商品保质期到期日
     */
    public abstract Date getExpireDate();

    /**
     * @return 截止到当前，剩余保质期还剩下总保质期长度的百分比
     */
    double leftDatePercentage();

    // >> TODO 接口里不能定义局部变量，定义的变量默认都是public static final的，这三个修饰符同样可以省略

    /**
     * 根据剩余的有效期百分比，得出商品现在实际的价值
     *
     * @param leftDatePercentage 剩余有效期百分比
     * @return 剩余的实际价值
     */
    double actualValueNow(double leftDatePercentage);

}
