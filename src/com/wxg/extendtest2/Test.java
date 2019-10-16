package com.wxg.extendtest2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by wuxg-a on 2019/3/29.
 */
public class Test {
    public static void main(String[] args) {
        ForkJoinPool BATCH_AUTHORIZE_WORKSPACE_POOL = new ForkJoinPool();
        List<String> testList = new ArrayList<>();
        for(int i=0;i<10;i++) {
            testList.add(String.valueOf(i));
        }

//        List<String> test2List = new ArrayList<>();
//        for(int i=0;i<5;i++) {
//            test2List.add(String.valueOf(i));
//        }
//        testList.removeAll(test2List);
//        System.out.println();

        BATCH_AUTHORIZE_WORKSPACE_POOL.submit(new WorkspaceAuthorizeTask(0, testList.size(), testList));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class WorkspaceAuthorizeTask extends RecursiveTask<Boolean> {
        private int start;
        private int end;
        private List<String> list;

        public WorkspaceAuthorizeTask(int start, int end, List<String> list) {
            this.start = start;
            this.end = end;
            this.list = list;
        }

        @Override
        protected Boolean compute() {
            if(end - start == 1) {
                List<String> workspaceAuthorizeRequest = list.subList(start, end);
                System.out.println(start + "->" + end + ":" + workspaceAuthorizeRequest.size());
                throw new RuntimeException("test exception");
            } else {
                int mid = (end + start) / 2;
                WorkspaceAuthorizeTask left = new WorkspaceAuthorizeTask(start, mid, list);
                WorkspaceAuthorizeTask right = new WorkspaceAuthorizeTask(mid, end, list);
                left.fork();
                right.fork();
            }
            return Boolean.TRUE;
        }
    }
}
