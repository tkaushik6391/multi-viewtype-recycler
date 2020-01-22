package com.tarun.demoapplication.main

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tarun.demoapplication.R
import com.tarun.demoapplication.adapter.DataRecyclerViewAdapter
import com.tarun.demoapplication.databinding.ActivityMainBinding
import com.tarun.demoapplication.model.Cars
import com.tarun.demoapplication.model.Celebrities
import com.tarun.demoapplication.model.Response
import com.tarun.demoapplication.model.ResultDto
import com.tarun.demoapplication.viewModel.CustomDataViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mContext = this@MainActivity

        getData()
    }

    var finalList: ArrayList<ResultDto> = ArrayList()
    fun getData() {
        try {
            val customDataViewModel: CustomDataViewModel =
                ViewModelProviders.of(this).get(CustomDataViewModel::class.java)
            customDataViewModel.getData().observe(this, object : Observer<Response> {
                override fun onChanged(t: Response) {
                    if (t != null) {
                        var celebs: Celebrities? = t.celebrities
                        var cars: Cars? = t.cars

                        var dto = ResultDto()
                        var celebHeader: String = celebs!!::class.java.simpleName
                        dto.type = 0
                        dto.name = celebHeader
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 1
                        dto.name = celebs.aarya!!::class.java.simpleName
                        dto.age = (celebs.aarya)?.age
                        dto.height = (celebs.aarya)?.height
                        dto.popularity = (celebs.aarya)?.popularity
                        dto.photo = (celebs.aarya)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 1
                        dto.name = celebs.cersie!!::class.java.simpleName
                        dto.age = (celebs.cersie)?.age
                        dto.height = (celebs.cersie)?.height
                        dto.popularity = (celebs.cersie)?.popularity
                        dto.photo = (celebs.cersie)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 1
                        dto.name = celebs.daenerys!!::class.java.simpleName
                        dto.age = (celebs.daenerys)?.age
                        dto.height = (celebs.daenerys)?.height
                        dto.popularity = (celebs.daenerys)?.popularity
                        dto.photo = (celebs.daenerys)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 1
                        dto.name = celebs.jaime!!::class.java.simpleName
                        dto.age = (celebs.jaime)?.age
                        dto.height = (celebs.jaime)?.height
                        dto.popularity = (celebs.jaime)?.popularity
                        dto.photo = (celebs.jaime)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 1
                        dto.name = celebs.jonSnow!!::class.java.simpleName
                        dto.age = (celebs.jonSnow)?.age
                        dto.height = (celebs.jonSnow)?.height
                        dto.popularity = (celebs.jonSnow)?.popularity
                        dto.photo = (celebs.jonSnow)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 1
                        dto.name = celebs.samwell!!::class.java.simpleName
                        dto.age = (celebs.samwell)?.age
                        dto.height = (celebs.samwell)?.height
                        dto.popularity = (celebs.samwell)?.popularity
                        dto.photo = (celebs.samwell)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 1
                        dto.name = celebs.tormund!!::class.java.simpleName
                        dto.age = (celebs.tormund)?.age
                        dto.height = (celebs.tormund)?.height
                        dto.popularity = (celebs.tormund)?.popularity
                        dto.photo = (celebs.tormund)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 1
                        dto.name = celebs.tyrion!!::class.java.simpleName
                        dto.age = (celebs.tyrion)?.age
                        dto.height = (celebs.tyrion)?.height
                        dto.popularity = (celebs.tyrion)?.popularity
                        dto.photo = (celebs.tyrion)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        var carHeader: String = cars!!::class.java.simpleName
                        dto.type = 0
                        dto.name = carHeader
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 2
                        dto.name = cars.suzuki!!::class.java.simpleName
                        dto.photo = (cars.suzuki)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 2
                        dto.name = cars.honda!!::class.java.simpleName
                        dto.photo = (cars.honda)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 2
                        dto.name = cars.tata!!::class.java.simpleName
                        dto.photo = (cars.tata)?.photo
                        finalList.add(dto)

                        dto = ResultDto()
                        dto.type = 2
                        dto.name = cars.toyota!!::class.java.simpleName
                        dto.photo = (cars.toyota)?.photo
                        finalList.add(dto)

                        var gridLayoutManager =
                            GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false)

                        gridLayoutManager.spanSizeLookup =
                            object : GridLayoutManager.SpanSizeLookup() {
                                override fun getSpanSize(position: Int): Int {
                                    return when (finalList[position].type) {
                                        1, 2 -> 1
                                        else -> 2
                                    }
                                }
                            }
                        binding.mRecycler.apply {
                            layoutManager = gridLayoutManager
                            addItemDecoration(
                                DividerItemDecoration(
                                    mContext,
                                    DividerItemDecoration.VERTICAL
                                )
                            )
                        }
                        binding.recyclerAdapter = DataRecyclerViewAdapter(mContext, finalList)
                    }else{

                        Toast.makeText(mContext, "Error in Response!!!", Toast.LENGTH_SHORT).show()
                    }
                }

            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
