package iee.yh.hxds.mis.api.db.dao;


import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface PermissionDao {
    public ArrayList<HashMap> searchAllPermission();
}




