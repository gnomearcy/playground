package eu.span.dev.rxjava;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Callable;

public class AsyncTaskExecutor
{
    public static final String TAG = "AsyncTaskExecutor";
    private static class Unit
    {
        public static final int ERROR = 0;
        public static final int DATA = 1;

        protected final String tag;
        protected boolean executing;
        protected Handler backHandler;
        protected HandlerThread backThread;
        protected Handler uiHandler;

        private Unit()
        {
            this.tag = UUID.randomUUID().toString();
        }

        public String getTag()
        {
            return tag;
        }
    }

    /**
     *  Stuff that a single "asynchronous" call requires to execute some logic on the back-thread.
     */
    public static class ResultUnit<U> extends Unit
    {
        public interface Callback<T>
        {
            void onSuccess(T data);

            void onError(Exception e);
        }

        private Callback<U> callbackReference;
        private Callable<U> task;

        private ResultUnit(Callback<U> callback,
                           Callable<U> task) throws IllegalArgumentException
        {
            Utilities.nullCheck(callback, "callback == null");
            Utilities.nullCheck(task, "task == null");
            this.callbackReference = callback;
            this.executing = false;
            this.task = task;
        }

        protected void execute() throws Exception
        {
            try
            {
                if(executing)
                {
                    return;
                }
                executing = true;
//                this.backThread = new HandlerThread("async_back_task_" + callbackReference.hashCode());
                this.backThread = new HandlerThread("async_back_task_" + tag);
                this.backThread.start();
                this.backHandler = new Handler(this.backThread.getLooper());

                uiHandler = new Handler(Looper.getMainLooper())
                {
                    @Override
                    public void handleMessage(Message msg)
                    {
                        // Manually clear references got GC
                        backThread.quit();
                        backThread = null;
                        uiHandler = null;
                        backHandler = null;

                        switch(msg.what)
                        {
                            case DATA:
                                Log.e(TAG, "handleMessage: got the data");
                                if(callbackReference != null){
                                    Log.e(TAG, "handleMessage: callback is valid");
                                    callbackReference.onSuccess((U) msg.obj);
                                } else {
                                    Log.e(TAG, "handleMessage: callback is not valid");
                                }
                                break;
                            case ERROR:
                                if(callbackReference != null){
                                    callbackReference.onError((Exception) msg.obj);
                                }
                                break;
                            default:
                                Log.e(TAG, "Unsupported code in " + AsyncTaskExecutor.class.getSimpleName());
                        }
                    }
                };

                try
                {
                    backHandler.post(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                U result = task.call();
                                Message.obtain(uiHandler, DATA, result).sendToTarget();
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                                Message.obtain(uiHandler, ERROR, e).sendToTarget();
                            }
                        }
                    });
                }
                catch(Exception e)
                {
                    backThread.quit();
                    backThread = null;
                    uiHandler = null;
                    backHandler = null;
                    if(callbackReference != null){
                        callbackReference.onError(e);
                    }
                }
            }
            catch(Exception e)
            {
                Log.e(TAG,
                      String.format("[%s] - [%s] - execution general error",
                                    AsyncTaskExecutor.class.getSimpleName(),
                                    ResultUnit.class.getSimpleName()));
                if(callbackReference != null){
                    callbackReference.onError(e);
                }

//                throw e;
            }
            finally
            {
                executing = false;
            }
        }
    }

    /**
     *  Represents a task that returns no value to the caller.
     */
    public static final class OneTimeUnit extends Unit
    {
        public interface Callback
        {
            void onSuccess();

            void onError(Exception e);
        }

        private WeakReference<Callback> callbackReference;
        private Callable task;

        OneTimeUnit(@NonNull Callback callback,
                    @NonNull Callable task) throws IllegalArgumentException
        {
            Utilities.nullCheck(callback, "callback == null");
            Utilities.nullCheck(task, "task == null");
            this.callbackReference = new WeakReference<>(callback);
            this.task = task;
        }

        public void execute() throws Exception
        {
            try
            {
                if(executing)
                {
                    return;
                }
                executing = true;

                this.backThread = new HandlerThread("async_back_task_" + callbackReference.hashCode());
                this.backThread.start();
                this.backHandler = new Handler(this.backThread.getLooper());
                uiHandler = new Handler(Looper.getMainLooper())
                {
                    @Override
                    public void handleMessage(Message msg)
                    {
                        // Manually clear references got GC
                        backThread.quit();
                        backThread = null;
                        uiHandler = null;
                        backHandler = null;

                        switch(msg.what)
                        {
                            case DATA:
                                if(callbackReference != null)
                                {
                                    OneTimeUnit.Callback callback = callbackReference.get();
                                    if(callback != null)
                                    {
                                        callback.onSuccess();
                                    }
                                }
                                break;
                            case ERROR:
                                if(callbackReference != null)
                                {
                                    OneTimeUnit.Callback callback = callbackReference.get();
                                    if(callback != null)
                                    {
                                        callback.onError((Exception) msg.obj);
                                    }
                                }
                                break;
                            default:
                                Log.e(TAG, "Unsupported code in " + AsyncTaskExecutor.class.getSimpleName());
                        }
                    }
                };

                this.backHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                        /* Results are ignored */
                            task.call();
                            Message.obtain(uiHandler, DATA, null /* Nothing to send to Handler*/).sendToTarget();
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            Message.obtain(uiHandler, ERROR, e).sendToTarget();
                        }
                    }
                });
            }
            catch(Exception e)
            {
                Log.e(TAG,
                      String.format("[%s] - [%s] - execution general error",
                                    AsyncTaskExecutor.class.getSimpleName(),
                                    OneTimeUnit.class.getSimpleName()));
                if(callbackReference != null)
                {
                    Callback c = callbackReference.get();
                    if(c != null)
                    {
                        c.onError(e);
                    }
                }
            }
            finally
            {
                executing = false;
            }
        }
    }

    public static void execute(@NonNull OneTimeUnit.Callback callback, @NonNull final Callable task) throws Exception
    {
        Utilities.nullCheck(task, "task == null");
        Utilities.nullCheck(callback, "callback == null");
        OneTimeUnit unitOfWork = new OneTimeUnit(callback, task);
        unitOfWork.execute();
    }

    public static <T> void executeWithResult(@NonNull ResultUnit.Callback<T> callback, @NonNull final Callable<T> task) throws Exception
    {
        Utilities.nullCheck(task, "task == null");
        Utilities.nullCheck(callback, "callback == null");
        ResultUnit<T> unitOfWork = new ResultUnit<>(callback, task);
        unitOfWork.execute();
    }
}
