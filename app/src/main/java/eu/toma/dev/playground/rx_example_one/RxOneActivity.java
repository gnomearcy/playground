package eu.toma.dev.playground.rx_example_one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

import eu.toma.dev.playground.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import warcraft.mounts.MountService;

public class RxOneActivity extends AppCompatActivity
{
    private MountService service;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        multithreadingTests();
    }

    private void multithreadingTests()
    {
        setContentView(R.layout.multithread_layout);
    }

    private void testingOperators()
    {
        setContentView(R.layout.activity_rx_one);
        RX.test1();
        sleep();
        RX.test2();
    }

    private int testnr = 1;
    private void sleep(){
        try
        {
            Log.d(RX_APP.TAG, "[RxOneActivity] - [sleep]: sleeping before test " + testnr + 1);
            Thread.sleep(1500);
            Log.d(RX_APP.TAG, "[RxOneActivity] - [sleep]: executing test " + testnr + 1);
            testnr++;
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void repeatOperator()
    {
        Observable.interval(1, TimeUnit.SECONDS)
                .repeat(20)
                .subscribe(new Observer<Long>()
                {
                    @Override
                    public void onSubscribe(@NonNull Disposable d)
                    {

                    }

                    @Override
                    public void onNext(@NonNull Long aLong)
                    {
            Log.d(RX_APP.TAG, "[RxOneActivity] - [onNext]: " + aLong);
                    }

                    @Override
                    public void onError(@NonNull Throwable e)
                    {

                    }

                    @Override
                    public void onComplete()
                    {

                    }
                });
    }

    private boolean kickStartedMoreThreads = false;
    private Disposable referenceToKill;
    public void periodicEmission(View view)
    {
        Log.d(RX_APP.TAG, "[RxOneActivity] - [periodicEmission]: CLICKED!");

        if(kickStartedMoreThreads){
            return;
        }
        kickStartedMoreThreads = true;

        final long timenow = System.currentTimeMillis();
        Observable<Integer> periodicalNumbers = Observable.zip(Observable.range(1, 20),
                                                               Observable.interval(2000,
                                                                                   TimeUnit.MILLISECONDS),
                                                               new BiFunction<Integer, Long, Integer>()
                                                               {
                                                                   @Override
                                                                   public Integer apply(@NonNull Integer integer,
                                                                                        @NonNull Long aLong) throws Exception
                                                                   {
                                                                       // Ignore this
                                                                       return integer;
                                                                   }
                                                               }).doOnNext(new Consumer<Integer>()
        {
            @Override
            public void accept(@NonNull Integer integer) throws Exception
            {
                Log.d(RX_APP.TAG,
                      "[RxOneActivity] - [accept]: " + (System.currentTimeMillis() - timenow));
                Log.d(RX_APP.TAG, "[RxOneActivity] - [accept]: " + integer);
            }
        });

        periodicalNumbers.subscribe(new Observer<Integer>()
        {
            @Override
            public void onSubscribe(@NonNull Disposable d)
            {
                referenceToKill = d;
                Log.d(RX_APP.TAG, "[RxOneActivity] - [onSubscribe]: attached to periodical numbers");
            }

            @Override
            public void onNext(@NonNull Integer integer)
            {
                if(integer > 10)
                {
                    Log.d(RX_APP.TAG, "[RxOneActivity] - [onNext]: num bigger than 10, stopping here");
                    referenceToKill.dispose();
                    onError(null);
                }
                else{
                    Log.d(RX_APP.TAG, "[RxOneActivity] - [onNext]: got the value - " + integer);
                }
            }

            @Override
            public void onError(@NonNull Throwable e)
            {
                // Called from "onNext" if the number is bigger than some value
                if(e == null){
                    referenceToKill.dispose();
                    referenceToKill = null;
                } else {
                    Log.d(RX_APP.TAG, "[RxOneActivity] - [onError]: " + e.getMessage());
                }
                onComplete();
            }

            @Override
            public void onComplete()
            {
                Log.d(RX_APP.TAG, "[RxOneActivity] - [onComplete]: finished with periodic numbers");
                kickStartedMoreThreads = false;
            }
        });
    }
}
