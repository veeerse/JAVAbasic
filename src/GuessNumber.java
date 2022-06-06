import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        //创建输入
        Scanner in = new Scanner(System.in);

        //游戏设置
        int startnum = 0;
        int endnum = 0;
        //限制开始结束数字的范围
        while (startnum <= 0) {
            System.out.println("请输入开始数字（大于0的整数）：");
            startnum = in.nextInt();
        }
        while (endnum <= 0 || endnum <= startnum) {
            System.out.println("请输入结束数字（大于0的整数）：");
            endnum = in.nextInt();
        }
        int mod = endnum - startnum;
        int totalguess = 5;

        //游戏统计
        int guessleft = totalguess;
        int currectcount = 0;

        //是否结束游戏
        boolean stopgame = false;

        while (!stopgame) {
            double randomNumber = Math.random();
            int num = (int) ((randomNumber * endnum * 100) % mod);
            num += startnum;
            if (num <= startnum) {
                num += 1;
            }
            if (num >= endnum) {
                num -= 1;
            }
            System.out.println("---------------------------------------------\n" + "请输入你猜测的数字。 " + "数字范围是" + startnum + "到" + endnum + "之间，且不包括这两个数字。 " + "你共有" + totalguess + "次机会，" + "目前还剩余" + guessleft + "此机会。");
            System.out.println("答案是：" + num);
            while (guessleft > 0) {
                System.out.println("请输入猜测的数字，输入-1退出游戏。");
                int guessnum = in.nextInt();
                if (guessnum == num) {
                    System.out.println("你猜对了！");
                    guessleft = totalguess;
                    currectcount += 1;
                    break;
                }
                guessleft -= 1;
                if (guessleft == 0) {
                    System.out.println("你太菜了，自动退出游戏。\n" + "共猜对了：" + currectcount + "次数字。");
                    stopgame = true;
                    break;
                }
                //退出游戏
                if (guessnum < 0) {
                    System.out.println("退出游戏。\n" + "共猜对了：" + currectcount + "次数字。");
                    stopgame = true;
                    break;
                }
                //比大小
                if (guessnum < num) {
                    System.out.println("你猜得小了，还剩余" + guessleft + "次机会。");
                } else if (guessnum > num) {
                    System.out.println("你猜得大了，还剩余" + guessleft + "次机会。");
                }
            }
        }
    }
}
