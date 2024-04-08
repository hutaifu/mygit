package com.jxd.bank.dao.impl;

import com.jxd.bank.dao.IAccountDao;
import com.jxd.bank.model.Account;
import com.jxd.bank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.DuplicateFormatFlagsException;

/**
 * @ClassName AccounDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class AccounDaoImpl implements IAccountDao {
    /**
     * 添加账户信息
     *
     * @param account 添加的账户
     * @return 是否添加成功
     */
    @Override
    public boolean insert(Account account) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "insert into account (Customername,Password,Balance,Opendate) values (?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, account.getCustomername());
            pst.setString(2, account.getPassword());
            pst.setDouble(3, account.getBalance());
            pst.setString(4, account.getOpendate());
            int num = pst.executeUpdate();
            if (num > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, null);
        }

        return isSuccess;
    }

    /**
     * 修改账户余额
     *
     * @param d 要修改的金额
     * @return 是否修改成功
     */
    @Override
    public boolean update(int num, double d) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;
        ResultSet rs = null;

        String sql = "select Balance from account where Cardid = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, num);
            rs = pst.executeQuery();
            double balance = 0;
            if (rs.next()) {
                balance = rs.getDouble("Balance");
            }
            if (d + balance >= 0) {
                String sql1 = "update account set Balance = ?";
                pst = conn.prepareStatement(sql1);
                pst.setDouble(1, d + balance);
                int num1 = pst.executeUpdate();
                if (num1 > 0) {
                    isSuccess = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return isSuccess;
    }

    /**
     * 转帐
     *
     * @param give  给出的账号
     * @param get   转到的账号
     * @param money 要转的金额
     * @return 是否成功
     */
    @Override
    public boolean tran(int give, String password, int get, double money) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean isSuccess = false;

            String  password1 = chekpwt(give);
            double d = show(give);

            try {
                 if (password.equals(password1) && d >= money) {
                    String sql1 = "update account set Balance = Balance - ? where Cardid = ?";
                    String sql2 = "update account set Balance = Balance + ? where Cardid = ?";
                    conn.setAutoCommit(false);
                    pst = conn.prepareStatement(sql1);
                    pst.setDouble(1,money);
                    pst.setInt(2, give);
                    int num = pst.executeUpdate();
                    pst = conn.prepareStatement(sql2);
                    pst.setDouble(1, money);
                    pst.setInt(2, get);
                    int num1 = pst.executeUpdate();
                    conn.commit();
                    isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return isSuccess;
    }

    /**
     * 查询账余额
     *
     * @param num 需要查询的账号
     */
    @Override
    public double show(int num) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        double d = 0;

        String sql = "select Balance from account where Cardid = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, num);
            rs = pst.executeQuery();
            if (rs.next()) {
                d = rs.getDouble("Balance");
                System.out.println("当前余额为：" + d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return d;
    }

    /**
     * 查询交易信息
     *
     * @param num 查询的账号
     */
    @Override
    public void showdealdate(int num) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "select transType,transMoney,transDate from daterecord where cardId = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, num);
            rs = pst.executeQuery();
            while (rs.next()) {
                int num1 = 1;
                System.out.print(num1 + "\t");
                num1++;
                System.out.print(num + " ");
                System.out.print(rs.getString("transType") + "\t" + "交易金额");
                System.out.print(rs.getDouble("transMoney") + "元" + "\t" + "日期：");
                System.out.println(rs.getString("transDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }


    }

    /**
     * 修改账号的密码
     *
     * @param num 账号
     * @param pwt 新密码
     * @return 是否成功
     */
    @Override
    public boolean changepwt(int num, String pwt) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;

        String sql = "update account set Password = ? where Cardid = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, pwt);
            pst.setInt(2, num);
            int num1 = pst.executeUpdate();
            if (num1 > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    /**
     * 删除账户
     *
     * @param num 删除的账户账号
     * @param pwt 密码
     * @return 是否删除成功
     */
    @Override
    public boolean delete(int num, String pwt) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        boolean isSuccess = false;
        ResultSet rs = null;

        String sql1 = "delete from account where Cardid = ?";
        try {
            String password1 = chekpwt(num);
            if (password1.equals(pwt)) {
                pst = conn.prepareStatement(sql1);
                pst.setInt(1, num);
                int num2 = pst.executeUpdate();
                if (num2 > 0) {
                    isSuccess = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return isSuccess;
    }

    /**
     * 查看密码
     *
     * @param num 查看密码的账号
     * @return 返回密码
     */
    @Override
    public String chekpwt(int num) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String pwt = "";

        String sql = "select Password from account where Cardid = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, num);
            rs = pst.executeQuery();
            if (rs.next()) {
                pwt = rs.getString("Password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return pwt;
    }

    /**
     * 插入旧密码信息
     *
     * @param oldpwt 旧密码
     * @param num 账号
     */
    @Override
    public void addoldpwt(String oldpwt,int num) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;

        String sql = "update account set Oldpassword = ? where Cardid = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, oldpwt);
            pst.setInt(2,num);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, null);
        }
    }

    /**
     * 得到最大的账号
     *
     * @return 返回最大账号
     */
    @Override
    public int getmaxaccount() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int num = 0;

        String sql = "select max(Cardid) max_caidId from account";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                num = rs.getInt("max_caidId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return num;
    }

    /**
     * 得到账号姓名
     *
     * @param num 账号
     * @return 返回姓名
     */
    @Override
    public String getname(int num) {

        Connection conn = DBUtil.getConn();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String name = "";

        String sql = "select Customername from account where Cardid = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,num);
            rs = pst.executeQuery();
            if (rs.next()) {
                name = rs.getString("Customername");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, pst, rs);
        }
        return name;
    }
}


