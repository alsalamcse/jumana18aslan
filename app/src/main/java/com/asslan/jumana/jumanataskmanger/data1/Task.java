package com.asslan.jumana.jumanataskmanger.data1;

public class Task
{
    private String key;
    private String title;
    private String sub;
    private String prio;

    public Task() {

    }



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;//kj,hmjgbmnhgbhnmgh
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getPrio() {
        return prio;
    }

    public void setPrio(String prio) {
        this.prio = prio;
    }



    @Override
    public String toString() {
        return "Task{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", sub='" + sub + '\'' +
                ", prio='" + prio + '\'' +
                '}';
    }
}


