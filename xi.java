package homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class xi {

    public static void main(String[] args) {
        useless x =new useless();
        System.out.println("hello");
    }

}

class useless {
    JFrame frame;//框架的顶层类
    JPanel p1, p2;
    JTextField t1, t2;//单行文本框
    JButton b1, b2, b3,b4;
    JLabel hint1, hint2;

    public useless() {
        frame = new JFrame("Password");
        frame.setSize(600, 300);//整个框的大小为300*300


        t1 = new JTextField(15);//宽度为15个字的文本条
        t2 = new JTextField(15);
        StringBuilder s2= new StringBuilder();


        hint1 = new JLabel("请输入分数");
        hint2 = new JLabel("运算结果");
        p1 = new JPanel();//上半部分


        p1.add(hint1);
        p1.add(t1);
        p1.add(hint2);
        p1.add(t2);

        p2 = new JPanel();//下半部分

        b1 = new JButton("由小到大");
        b2 = new JButton("由大到小");
        b3 = new JButton("加法计算");
        b4 = new JButton("乘法计算");

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);


        frame.add(p1, BorderLayout.NORTH);
        frame.add(p2, BorderLayout.CENTER);
        frame.pack();//设置合理的范围
        frame.setLocationRelativeTo(null);//居中
        frame.setVisible(true);

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().matches(".*[^,0-9/-].*")){
                    t2.setText("输入错误");
                }
                else{//
                    if(!t1.getText().contains(",")){
                        try {
                            new Rational(t1.getText());
                        }catch (Exception b){
                            t2.setText("输入错误");
                        }
                    }
                    String s1temp[] = t1.getText().split(",");
                    //
                    Rational [] s1= new Rational[s1temp.length];
                    //提取分母和分子
                    for (int i=0; i<s1.length; i++) {
                        String []s2temp = s1temp[i].split("/");

                        try{
                            int num=Integer.parseInt(s2temp[0]);
                            int den=Integer.parseInt(s2temp[1]);
                            if(den==0){
                                int b = 1/0;
                            }
                            s1[i] = new Rational(num,den);
                        } catch (ArithmeticException | NumberFormatException|ArrayIndexOutOfBoundsException e2) {
                            t2.setText("输入错误");
                        }


                    }

                    //判断字符
                    try{
                        Arrays.sort(s1, new Comparator<Rational>() {
                                    @Override
                                    public int compare(Rational o1, Rational o2) {

                                        return o1.compareTo(o2);

                                    }
                                }
                        );
                        //删除之前的数组
                        s2.delete(0,s2.length());
                        //去除重复
                        Set<Rational> uniqueNumbers = new LinkedHashSet<>(Arrays.asList(s1));
                        for(Rational i : uniqueNumbers){
                            //将字符串数组转化为字符串
                            s2.append(i.num+"/"+i.den+" ");
                        }
                        //设置第二个面板
                        t2.setText(s2.toString());

                    }catch (Exception e1){
                        t2.setText("输入错误");
                    }
                }




            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().matches(".*[^,0-9/-].*")||t1.getText()==null){
                    t2.setText("输入错误");
                }
                else{//
                    if(!t1.getText().contains(",")){
                        try {
                            new Rational(t1.getText());
                        }catch (Exception b){
                            t2.setText("输入错误");
                        }
                    }
                    String s1temp[] = t1.getText().split(",");
                    //
                    Rational [] s1= new Rational[s1temp.length];
                    //提取分母和分子
                    for (int i=0; i<s1.length; i++) {
                        String []s2temp = s1temp[i].split("/");
                        try{
                            int num=Integer.parseInt(s2temp[0]);
                            int den=Integer.parseInt(s2temp[1]);
                            if(den==0){
                                int b = 1/0;
                            }
                            s1[i] = new Rational(num,den);
                        } catch (ArithmeticException | NumberFormatException|ArrayIndexOutOfBoundsException e2) {
                            t2.setText("输入错误");
                        }
                    }
                    //判断字符
                    try{
                        Arrays.sort(s1, new Comparator<Rational>() {
                                    @Override
                                    public int compare(Rational o1, Rational o2) {

                                        return -o1.compareTo(o2);

                                    }
                                }
                        );
                        //删除之前的数组
                        s2.delete(0,s2.length());
                        Set<Rational> uniqueNumbers = new LinkedHashSet<>(Arrays.asList(s1));
                        for(Rational i : uniqueNumbers){
                            //将字符串数组转化为字符串
                            s2.append(i.num+"/"+i.den+" ");
                        }
                        //设置第二个面板
                        t2.setText(s2.toString());

                    }catch (Exception e1){
                        t2.setText("输入错误");
                    }
                }




            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().matches(".*[^,0-9/-].*")||t1.getText()==null){
                    t2.setText("输入错误");
                }
                else{//
                    if(!t1.getText().contains(",")){
                        try {
                            new Rational(t1.getText());
                        }catch (Exception b){
                            t2.setText("输入错误");
                        }
                    }
                    String s1temp[] = t1.getText().split(",");
                    //
                    Rational [] s1= new Rational[s1temp.length];
                    //提取分母和分子
                    for (int i=0; i<s1.length; i++) {
                        String []s2temp = s1temp[i].split("/");

                        try{
                            int num=Integer.parseInt(s2temp[0]);
                            int den=Integer.parseInt(s2temp[1]);
                            if(den==0){
                                int b = 1/0;
                            }
                            s1[i] = new Rational(num,den);
                        } catch (ArithmeticException | NumberFormatException | ArrayIndexOutOfBoundsException e2) {
                            t2.setText("输入错误");
                        }
                    }

                    //判断字符
                    try{

                        //加法运算
                        for(int i=1;i<s1.length;i++){
                            s1[0]=s1[0].add(s1[i]);
                        }
                        //删除之前的数组
                        s2.delete(0,s2.length());
                        //设置第二个面板
                        if(s1[0].num==0){
                            t2.setText(String.valueOf(s1[0].num));
                        }else {
                            t2.setText(s1[0].toString());
                        }


                    }catch (Exception e1){
                        t2.setText("输入错误");
                    }
                }


            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().matches(".*[^,0-9/-].*")||t1.getText()==null){
                    t2.setText("输入错误");
                }
                else{//
                    if(!t1.getText().contains(",")){
                        try {
                            new Rational(t1.getText());
                        }catch (Exception b){
                            t2.setText("输入错误");
                        }
                    }
                    String s1temp[] = t1.getText().split(",");
                    //
                    Rational [] s1= new Rational[s1temp.length];
                    //提取分母和分子
                    for (int i=0; i<s1.length; i++) {
                        String []s2temp = s1temp[i].split("/");

                        try{
                            int num=Integer.parseInt(s2temp[0]);
                            int den=Integer.parseInt(s2temp[1]);
                            if(den==0){
                                int b = 1/0;
                            }
                            s1[i] = new Rational(num,den);
                        } catch (ArithmeticException | NumberFormatException|ArrayIndexOutOfBoundsException e2) {
                            t2.setText("输入错误");
                        }


                    }

                    //判断字符
                    try{

                        //加法运算
                        for(int i=1;i<s1.length;i++){
                            s1[0]=s1[0].muti(s1[i]);
                        }
                        //删除之前的数组
                        s2.delete(0,s2.length());
                        //设置第二个面板
                        if(s1[0].num==0){
                            t2.setText(String.valueOf(s1[0].num));
                        }else {
                            t2.setText(s1[0].toString());
                        }


                    }catch (Exception e1){
                        t2.setText("输入错误");
                    }
                }


            }
        });
    }


}
class Rational {
    int num;
    int den;
    Rational(){

    }

    Rational(String o){
        //提取分母和分子

        int a = o.indexOf("/");//获取反斜杠位置
        String o1 = o.substring(0,a);
        String o2 = o.substring(a+1);
        this.num = Integer.parseInt(o1);
        this.den = Integer.parseInt(o2);


    }
    Rational(int num, int den){
        this.num = num;
        this.den = den;


        //这一段实现分母为负数的时候符号的调换
        if((this.den<0)&&(this.num>0)){
            this.setDen(-this.den);
            this.setNum(-this.num);
        }
        int a1=this.num;
        int b1=this.den;
        int a = num;
        int b = den;
        if(a<0){
            a = -a;
        }
        if(b<0){
            b=-b;
        }
        if(a == 0){

        }
        else {
            if(a<b) {
            int c = a;
            a = b;
            b = c;
        }
            int r1 = a % b;
            while (r1 != 0) {
                a = b;
                b = r1;//b为最大公约数
                r1 = a % b;
            }
            this.setNum(a1 / b);
            this.setDen(b1 / b);
        }
    }

    public int getDen() {return den;}

    public void setDen(int den) {

        this.den = den;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public Rational f(Rational r){//约分函数
        Rational result = new Rational();
        int a1 = r.getNum();
        int b1 = r.getDen();
        int a = a1;
        int b = b1;
        if(a == 0){
            return r;
        }
        if(a < b){
            int c = a;
            a = b;
            b = c;
        }
        int r1 = a%b;
        while (r1!=0){
            a = b;
            b = r1;//b为最大公约数
            r1 = a%b;
        }
        result.setNum(a1/b);
        result.setDen(b1/b);
        //这一段实现分母为负数的时候符号的调换
        if((result.den<0)&&(result.num>0)){
            result.setDen(-result.den);
            result.setNum(-result.num);
        }
        return result;
    }
    public Rational add(Rational r){//加法运算
        int a = r.getNum();
        int b = r.getDen();
        int newNum = num*b + den*a;
        int newDen = den*b;
        Rational result = new Rational();
        result.setNum(newNum);
        result.setDen(newDen);
        result = result.f(result);//约分
        return result;
    }
    public Rational sub(Rational r){//减法
        int a = r.getNum();
        int b = r.getDen();
        int newNum = b*num - a*den;
        int newDen = b*den;
        Rational result = new Rational(newNum, newDen);
        result = result.f(result);
        return result;
    }
    public Rational muti(Rational r){
        int a = r.getNum();
        int b = r.getDen();
        int newNum = a*num;
        int newDen = b*den;
        Rational result = new Rational(newNum, newDen);
        result = result.f(result);//约分
        return result;
    }
    public Rational div(Rational r){
        int a = r.getNum();
        int b = r.getDen();
        int newNum = num*b;
        int newDen = den*a;
        Rational result = new Rational(newNum, newDen);
        result = result.f(result);//约分
        return result;
    }
    public int compareTo(Rational r){
        //调用减法
        int a = num*r.den-den*r.num;
        //若分母为0，抛出异常
        try{
            if(den==0||r.den==0){
                int b = 1/0;
         }
        } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        }
        if(a==0){
            return 0;
        } else if (a<0) {
            return -1;
        }
        else {
            return 1;
        }


    }
    public void exchange(Rational r1, Rational r2){
        Rational mid = new Rational();
        mid.setNum(r1.getNum());
        mid.setDen(r1.getDen());
        r1.setNum(r2.getNum());
        r1.setDen(r2.getDen());
        r2.setNum(mid.getNum());
        r2.setDen(mid.getDen());
    }
    public String toString(){
        return num+"/"+den;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return num == rational.num && den == rational.den;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }
}
