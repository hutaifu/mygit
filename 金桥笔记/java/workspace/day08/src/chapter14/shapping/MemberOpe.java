package chapter14.shapping;

/**
 * @ClassName MemberOpe
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class MemberOpe {
    public Meber add(int num,int score){
        Meber meber = new Meber();
        meber.num = num;
        meber.socres = score;
        return meber;
    }
    public void show(Meber meber){
        System.out.println("***会员列表**8");
        System.out.println("编号\t\t\t积分");
        System.out.println(meber.num+"\t\t\t"+meber.socres);
    }
    public int found(int num,Meber[] mebers){
       int score01=0;
        for (int i = 0; i < mebers.length; i++) {
            if (num == mebers[i].num){
                score01 = mebers[i].socres;
                break;
            }
        }
        return score01;
    }
}
