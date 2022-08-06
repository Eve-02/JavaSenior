package com.ihihr.dao_.dao;

import com.ihihr.dao_.domain.news;

public class newsDAO extends BasicDAO<news> {
    // 1.有了BasicDAO的方法
    // 2.根据业务需求，可以编写特有的方法

    // 修改news其中一条记录
    public int ModifyNews_content(int id,String content){
        String sql = "update news set content = ? where id = ?";
        int update = super.update(sql, content, id);
        return update;
    }
}
