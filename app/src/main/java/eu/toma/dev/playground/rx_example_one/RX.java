package eu.toma.dev.playground.rx_example_one;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class RX
{
    public static void test1(){
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>()
        {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception
            {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);

                e.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>()
        {
            @Override
            public void onSubscribe(@NonNull Disposable d)
            {
                Log.d(RX_APP.TAG, "[RxOneActivity] - [onSubscribe]: ");
            }

            @Override
            public void onNext(@NonNull Integer integer)
            {
                Log.d(RX_APP.TAG, "[RxOneActivity] - [onNext]: ");
            }

            @Override
            public void onError(@NonNull Throwable e)
            {
                Log.d(RX_APP.TAG, "[RxOneActivity] - [onError]: ");
            }

            @Override
            public void onComplete()
            {
                Log.d(RX_APP.TAG, "[RxOneActivity] - [onComplete]: ");
            }
        };

        observable.subscribe(observer);
    }

    public static void test2()
    {
        Observable<String> ob = Observable.just("one item emitted");

        final int firstInRange = 1;
        final Observable<Long> rangeSource = Observable.intervalRange(1,
                                                                      10,
                                                                      2000,
                                                                      1500,
                                                                      TimeUnit.MILLISECONDS);
        Observer<String> singleObserver = new Observer<String>()
        {
            @Override
            public void onSubscribe(@NonNull Disposable d)
            {
                Log.d(RX_APP.TAG, "[RX] - [onSubscribe]: attached to source of single string");
            }

            @Override
            public void onNext(@NonNull String s)
            {
                Log.d(RX_APP.TAG, "[RX] - [onNext]: got the single string - " + s);
            }

            @Override
            public void onError(@NonNull Throwable e)
            {
                Log.d(RX_APP.TAG, "[RX] - [onError]: error in single string emission");
            }

            @Override
            public void onComplete()
            {
                Log.d(RX_APP.TAG, "[RX] - [onComplete]: single string completed, starting next thing");

                // Start emission of range numbers;

                Observer<Long> rangeWatcher = new Observer<Long>()
                {
                    @Override
                    public void onSubscribe(@NonNull Disposable d)
                    {
                        Log.d(RX_APP.TAG, "[RX] - [onSubscribe]: attached to range emission!");
                    }

                    @Override
                    public void onNext(@NonNull Long integer)
                    {
                        Log.d(RX_APP.TAG, "[RX] - [onNext]: range emission - got - " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e)
                    {
                        Log.d(RX_APP.TAG, "[RX] - [onError]: range emission error - TERMINATING");
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.d(RX_APP.TAG, "[RX] - [onComplete]: range emission completed.");
                    }
                };
                Log.d(RX_APP.TAG, "[RX] - [test2]: starting range emission starting on " + firstInRange);
                rangeSource.subscribe(rangeWatcher);
            }
        };

        ob.subscribe(singleObserver);
    }
}
