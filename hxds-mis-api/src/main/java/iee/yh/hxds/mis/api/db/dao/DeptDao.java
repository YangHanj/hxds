package iee.yh.hxds.mis.api.db.dao;

import iee.yh.hxds.mis.api.db.pojo.DeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Mapper
public interface DeptDao {
    public ArrayList<HashMap> searchAllDept();

    public HashMap searchById(int id);

    public ArrayList<HashMap> searchDeptByPage(Map param);

    public long searchDeptCount(Map param);

    public boolean searchCanDelete(Integer[] ids);

    public int insert(DeptEntity dept);

    public int update(DeptEntity dept);

    public int deleteDeptByIds(Integer[] ids);
}




