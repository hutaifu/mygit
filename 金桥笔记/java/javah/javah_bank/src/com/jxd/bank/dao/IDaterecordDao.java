package com.jxd.bank.dao;

public interface IDaterecordDao {
    /**
     * 向操作记录表中添加记录
     * @param num 账号
     * @param transType  操作类型
     * @param transMoney  操作金额
     * @param transDate  操作时间
     */
    void insert(int num,String transType,Double transMoney,String transDate);

    /**
     * 删除一个账号所有信息
     * @param num 要删除的账号
     */
    void delete(int num);
}
