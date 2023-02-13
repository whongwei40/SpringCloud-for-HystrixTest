import entity.option;

import java.util.*;

public class Game {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    static ArrayList<String> options = new ArrayList<String>();
    //大小结果映射 小于12是小  大于12是大
    static HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<Integer, Integer>();
    static ArrayList<option> selectedOptions = new ArrayList<option>();
    static double balance = 0.0;
    static double totalEarnings = 0.0;
    static {
        // 添加12个选项
        //初始化大小映射关系
        for (int i = 1; i <= 12; i++) {
            options.add(String.valueOf(i));
            integerIntegerHashMap.put(i,i);
        }
        for (int i = 13; i <= 24; i++) {
            integerIntegerHashMap.put(i, i-12);

        }
    }
    public static void main(String[] args) {
        //初始化金额
        rechargeGoldCoins();
        // 游戏开始
        while (true) {
            //下注
            bet();
            // 开始游戏
            System.out.println("游戏开始！");
            gameMain();
            // 显示余额和累计收益
            System.out.println("当前余额为：" + balance);
            System.out.println("累计收益为：" + totalEarnings);
            // 游戏结束，清空选择选项列表
            selectedOptions.clear();
        }
    }

    /**
     * 充值金币
     * @param
     * @return
     * @author dongjunzi
     * @date 2023/02/13 01:18
     */
    static public void rechargeGoldCoins(){
        // 玩家充值金额
        System.out.print("请输入充值金额：");
        balance += input.nextDouble();
    }

    /**
     * 下注
     * @param
     * @return
     * @author dongjunzi
     * @date 2023/02/13 01:23
     */
    static public void bet(){
        if (balance <= 0) {
            System.out.println("余额不足，请充值！");
            return;
        }
        // 玩家选择选项
        while (true) {
            System.out.print("请选择任意数量的选项（输入0开始游戏）：");
            String selectedOption = input.next();
            if (selectedOption.equals("0")) {
                break;
            } else if (options.contains(selectedOption)) {
                option option = new option(Integer.valueOf(selectedOption), 0);
                if (selectedOptions.contains(option)){
                    selectedOptions.forEach(v->{
                        if (Objects.equals(v.getName(), Integer.valueOf(selectedOption))) {
                            v.setCount(v.getCount()+1);
                        }
                    });
                }else {
                    selectedOptions.add(option);
                }
                balance -= 1.0; // 消耗一个金额
                System.out.println("你目前的下注是");
                selectedOptions.forEach(System.out::println);
            } else {
                System.out.println("无效选项，请重新选择！");
            }
        }

    }

    /**
     * 游戏主要流程判断逻辑
     * @param
     * @return
     * @author dongjunzi
     * @date 2023/02/13 01:51
     */
    static public void gameMain(){

        int randomOption = random.nextInt(25); // 生成0-24之间的随机结果
        if (randomOption == 0 || randomOption == 24) {
            System.out.println("你被吃了");
        } else {
            Integer mapResult = integerIntegerHashMap.get(randomOption);
            option option = new option(mapResult, 0);
            if (randomOption <= 12) {
                System.out.println("结果是小" + mapResult);
                if (selectedOptions.contains(option)) {
                    // 小的1-6的收益倍数是8倍
                    double earnings = 8.0* Objects.requireNonNull(selectOption(mapResult)).getCount();
                    totalEarnings += earnings;
                    balance += earnings;
                    System.out.println("恭喜你中奖了，收益为：" + earnings);
                } else {
                    System.out.println("很遗憾，你没有中奖。");
                }
            } else {
                System.out.println("结果是大" + mapResult);
                if (selectedOptions.contains(option)) {
                    // 大的1-6的收益倍数是20倍
                    double earnings = 20.0* Objects.requireNonNull(selectOption(mapResult)).getCount();
                    totalEarnings += earnings;
                    balance += earnings;
                    System.out.println("恭喜你中奖了，收益为：" + earnings);
                } else {
                    System.out.println("很遗憾，你没有中奖。");
                }
            }
        }

    }

    private static  option selectOption(Integer selectedOption){
        for (option option : selectedOptions) {
            if (Objects.equals(option.getName(), selectedOption)) {
                return option;
            }
        }
        return null;
    }

}
