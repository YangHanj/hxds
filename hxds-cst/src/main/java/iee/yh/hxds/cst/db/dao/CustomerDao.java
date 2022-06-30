package iee.yh.hxds.cst.db.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Map;

@Mapper
public interface CustomerDao {
    /**
     * 注册新乘客
     * @param param
     * @return
     */
    public int registerNewCustomer(Map param);

    /**
     * 查询乘客是否存在
     * @param param
     * @return
     */
    public long hasCustomer(Map param);

    /**
     * 查询乘客ID
     * @param openId
     * @return
     */
    public String searchCustomerId(String openId);

    /**
     * 登录
     * @param openId
     * @return
     */
    String login(String openId);
}
