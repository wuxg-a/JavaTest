import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by wuxg-a on 2017/8/28.
 */
class GetUserInfoTask extends RecursiveTask<Long> {
    private int start;
    private int end;

    public GetUserInfoTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long sum = 0L;
        if(end -start < 10) {
            System.out.println(Thread.currentThread().getName() + ":" + this.start + "," + this.end);
            for(int i = start; i<=end; i++) {
                sum += i;
            }
        }else{
            System.out.println(Thread.currentThread().getName() + ":" + this.start + "," + this.end);
            int mid = (end + start)/2;
            GetUserInfoTask left = new GetUserInfoTask(start, mid);
            GetUserInfoTask right = new GetUserInfoTask(mid+1, end);
            left.fork();
            right.fork();
            Long lefRet = left.join();
            Long rightRet= right.join();

            sum += lefRet;
            sum += rightRet;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool  forkJoinPool = new ForkJoinPool();
        GetUserInfoTask task = new GetUserInfoTask(1, 100);
        Future<Long> ret = forkJoinPool.submit(task);
        Long result = ret.get();
        System.out.println("sum：" + ret.get());
    }


}
