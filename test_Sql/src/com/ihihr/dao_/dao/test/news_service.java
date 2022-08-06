package com.ihihr.dao_.dao.test;

import com.ihihr.dao_.dao.newsDAO;

public class news_service {

    // 在 news_service测试，修改新闻id为7的新闻内容
    public static void test(){
        newsDAO n = new newsDAO();
        int id = 7;
        String content = "新的内容";
        int result = n.ModifyNews_content(7,content);
        System.out.println(result>0?"修改成功":"修改不成功");
    }

    public static void main(String[] args) {
        test();
    }
}
