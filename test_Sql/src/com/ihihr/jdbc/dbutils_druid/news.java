package com.ihihr.jdbc.dbutils_druid;

public class news {

    private Integer id;
    private String content;

    public news(){
    }

    public news(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "news{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
