package com.example.huan.db;

import com.example.huan.entity.ThreadInfo;

import java.util.List;

/**
 * 数据库接口
 */
public interface ThreadDAO {

    public void insertThread(ThreadInfo threadInfo);

    public void deleteThread(String url, int thread_id);

    public void updateThread(String url, int thread_id, int finished);

    public List<ThreadInfo> getThreads(String url);

    public boolean isExists(String url, int thread_id);

}
