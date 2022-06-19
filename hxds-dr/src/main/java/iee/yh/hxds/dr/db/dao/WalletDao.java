package iee.yh.hxds.dr.db.dao;

import iee.yh.hxds.dr.db.pojo.WalletEntity;

import java.util.HashMap;
import java.util.Map;

public interface WalletDao {
    /**
     * 添加司机钱包记录
     * @param entity
     * @return
     */
    int insert(WalletEntity entity);
}




