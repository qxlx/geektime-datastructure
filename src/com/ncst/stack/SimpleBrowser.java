package com.ncst.stack;

import java.util.List;

/**
 * @author i
 * @create 2019/12/19 21:34
 * @Description
 *  使用前后栈实现浏览器的前进后退
 *
 *  思路:创建两个栈空间 一个用来存储前后的页面goBackStack，一个用来记录后退的页面goForwardStack。一个属性记录当前页currentPage;
 *      1.第一种情况 用户第一次点击baidu.com 这个时候只需要直接显示用户查看的页面。
 *          1.1.用户在原有基础上点击了souhu.com  这个时候 需要用goBackStack记录用户之前点击的baidu.com
 *          1.2.用户回退 查看当前goBackStack栈是否为空 不为空 可以回退原页面。否则报错。
 *              回退的时候，需要将当前的页面 保存在goForwardStack
 *          1.3 当用户每点击一次新的页面，goForwarsStack栈都需要清除掉之前保存的数据。
 */
public class SimpleBrowser {

    private LinkedListBasedStack goBackStack;//回退栈
    private LinkedListBasedStack goForwardStack;//前进栈
    private String currentPage;//当前页

    //初始化
    public SimpleBrowser(){
        goBackStack = new LinkedListBasedStack();
        goForwardStack = new LinkedListBasedStack();
    }

    //openBrowser
    public void open(String url){
        if (currentPage!=null){
            //如果在原有页面打开 需要保存当前页面
            goBackStack.push(this.currentPage);
            //用户每点击一个新页面 都需要清理掉之前保存的页面
            goForwardStack.clear();
        }
        openUrl(url,"open");
    }

    private void openUrl(String url,String fix){
        System.out.println(fix+" == currentPage => "+ url);
        this.currentPage = url;
    }

    //后退
    public String goBack(){
        if (isCanBack()){
            //回退操作 需要保存当前页面保存到goForwardStack栈中
            goForwardStack.push(this.currentPage);
            String backPage = goBackStack.pop();
            openUrl(backPage,"---goBack---");
            return backPage;
        }
        System.out.println("goBackStack is empty!");
        return null;
    }

    //前进
    public String goForward(){
        if (isCanForward()){
            //前进操作需要将当前页面添加到goBackStack栈中
            goBackStack.push(this.currentPage);
            String forwardPage = goForwardStack.pop();
            openUrl(forwardPage,"---goForward---");
            return forwardPage;
        }
        System.out.println("goForwardStack is empty!");
        return null;
    }

    //isCanBack
    private boolean isCanBack(){
        return this.goBackStack.size>0;
    }

    //isForward
    private boolean isCanForward(){
        return this.goForwardStack.size>0;
    }


    public static void main(String[] args) {
        SimpleBrowser browser = new SimpleBrowser();
        browser.open("www.baidu.com");
        browser.open("www.baidu.com/news");
        browser.open("www.baidu.com/pan");

        browser.goBack();
//        browser.goBack();

        browser.goForward();

    }


    private static class LinkedListBasedStack{

        private Integer size = 0;
        private Node top;

        //创建一个结点
        public Node createNode(String value,Node next){
            return new Node(value,next);
        }

        //入栈操作
        public void push(String data){
            if (top==null){
                top = createNode(data,null);
                size++;
                return;
            }

            Node cur = createNode(data,top);
            top = cur;
            size++;
        }

        //出栈操作
        public String pop(){
            if (top==null){
                throw new NullPointerException("stack is empty!");
            }
            String value = top.data;
            top = top.next;
            size--;
            return value;
        }

        //遍历
        public void printfAll(){
            Node cur = this.top;
            if (cur == null){
                return;
            }

            while (cur!=null){
                System.out.print(cur.data+",");
                cur = cur.next;
            }
        }

        //当出现回退到a页面时 直接点击了d页面 就无法回退到a页面之后页面 这个时候就需要将栈中的数据直接清除
        public void clear(){
            size = 0;
            top = null;
        }

        //获取栈顶数据
        public String getTop(){
            Node cur = this.top;
            if (cur==null){
                return null;
            }
            return cur.data;
        }

        public int size(){
            return size;
        }

        public static void main(String[] args) {
            LinkedListBasedStack stack = new LinkedListBasedStack();
            stack.push("1");
            stack.push("2");
            stack.push("3");

            stack.printfAll();
            System.out.println("-----------");
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());

        }

    }

    private static class Node{
        private String data;//数据
        private Node next;

        public Node(String data){
            this(data,null);
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
