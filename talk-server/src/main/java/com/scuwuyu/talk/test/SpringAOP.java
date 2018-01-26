package com.scuwuyu.talk.test;

/**
 * Created by wuyu on 2018/1/25.
 */
public class SpringAOP {
    public static void main(String[] args) {

        // spring aop 5种增强方式

//            环绕增强：缓存、性能、权限、事务管理
        try{
//            前置增强：权限控制，调用日志记录
            System.out.println("do something");
//            后置增加：统计分析结果数据
        }catch (Exception e){
//            异常增强：通过日志记录异常信息
        }finally {
//            最终增强：释放资源
        }
    }



}
