package com.tarun.demoapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tarun.demoapplication.model.Response
import com.tarun.demoapplication.network.APIInterface
import com.tarun.demoapplication.network.WebAPI
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.create

class CustomDataViewModel : ViewModel() {

    internal var liveData: MutableLiveData<Response> = MutableLiveData<Response>()
    internal var retrofit = WebAPI?.getClient()
    internal var apiInterface = retrofit?.create<APIInterface>()

    fun getData(): LiveData<Response> {

//        if (liveData == null) {
        var observable: Observable<Response>? = apiInterface?.getData()
        observable?.subscribeOn(Schedulers.newThread())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<Response> {
                override fun onComplete() {
                    Log.e("test", "complete")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.e("test", "subscribe")
                }

                override fun onNext(t: Response) {
                    Log.e("test", "next")
                    liveData.value = t
                }

                override fun onError(e: Throwable) {
                    Log.e("test", "error")
//                        liveData.value = null
                }

            })
//        }

        return liveData
    }

}