package day09;

/**
 * @ClassName Good
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Good {
    String[] names = new String[5];
    double[] fee = new double[5];

    public void show(){
        System.out.println("*********欢迎进入商品批发城*******");
        for (int i = 0; i < names.length && names[i] != null; i++) {
            String fee1 = "" + fee[i];
            int num3 = fee1.indexOf(".");
            StringBuffer str3 = new StringBuffer(fee1);
            if (i != 0) {
                str3.insert(num3 - 1, ",");
            }
                System.out.println("编号\t\t商品\t\t价格");
            System.out.println((i+1)+"\t\t\t"+names[i]+"\t\t"+str3);
        }
    }

    public void change(int order,int num){
        double allfee = fee[order - 1] * num;
        String allfee1 = "" + allfee;
        StringBuffer allfee2 = new StringBuffer(allfee1);
        int num4 = allfee2.indexOf(".");
        for (int i = num4-3; i > 0; i -= 3) {
            allfee2 = allfee2.insert(i,",");
        }
        System.out.println("你需要付款：" + allfee2);
    }
 }
