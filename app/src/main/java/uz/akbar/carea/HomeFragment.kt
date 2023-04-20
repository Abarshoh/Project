package uz.akbar.carea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import uz.akbar.carea.adapters.CarsAdapter
import uz.akbar.carea.adapters.DealsCategoriesAdapter
import uz.akbar.carea.adapters.OfferCarsAdapter
import uz.akbar.carea.dataClass.CarsData
import uz.akbar.carea.dataClass.OfferCarsInfo
import uz.akbar.carea.databinding.FragmentHomeBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var ChoosedCarsList: MutableList<CarsData>

    lateinit var CarsList: MutableList<CarsData>
    lateinit var offerCarsAdapter: OfferCarsAdapter
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        CarsList = mutableListOf()
        ChoosedCarsList = mutableListOf()
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        Cars()
        setOnboardingItems()
        setIndicators()
        CheckIndicator(0)

        //Menu change




        //Related to Top Deals RecyclerView
        val dealsCategoriesAdapter = DealsCategoriesAdapter(Categories(), object : DealsCategoriesAdapter.ChoosedTopic{
            override fun Topic(string: String) {
                if (string=="All"){
                    val carsAdapter = CarsAdapter(CarsList, object : CarsAdapter.OnPressed{
                        override fun onPressed(carsData: CarsData) {
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, CarDetailsFragment.newInstance(carsData))
                                .commit()
                        }
                    }, object :CarsAdapter.OnSelected{
                        override fun onSelect(carsData: CarsData) {
                            if (carsData.status){
                                ChoosedCarsList.add(carsData)
                            }else{
                                ChoosedCarsList.remove(carsData)
                            }
                        }
                    })
                    val layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.carsrecyclerview.layoutManager = layoutManager
                    binding.carsrecyclerview.adapter = carsAdapter
                }
                if (string=="BMW"){
                    val carsAdapter = CarsAdapter(BMWCars(), object : CarsAdapter.OnPressed{
                        override fun onPressed(carsData: CarsData) {
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, CarDetailsFragment.newInstance(carsData))
                                .commit()
                        }
                    }, object :CarsAdapter.OnSelected{
                        override fun onSelect(carsData: CarsData) {
                            if (carsData.status){
                                ChoosedCarsList.add(carsData)
                            }else{
                                ChoosedCarsList.remove(carsData)
                            }
                        }
                    })
                    val layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.carsrecyclerview.layoutManager = layoutManager
                    binding.carsrecyclerview.adapter = carsAdapter
                }

                if (string=="Mercedes"){
                    val carsAdapter = CarsAdapter(MercedesCars(), object : CarsAdapter.OnPressed{
                        override fun onPressed(carsData: CarsData) {
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, CarDetailsFragment.newInstance(carsData))
                                .commit()
                        }
                    }, object :CarsAdapter.OnSelected{
                        override fun onSelect(carsData: CarsData) {
                            if (carsData.status){
                                ChoosedCarsList.add(carsData)
                            }else{
                                ChoosedCarsList.remove(carsData)
                            }
                        }
                    })

                    val layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.carsrecyclerview.layoutManager = layoutManager
                    binding.carsrecyclerview.adapter = carsAdapter
                }

                if (string=="Tesla"){
                    val carsAdapter = CarsAdapter(TeslaCars(), object : CarsAdapter.OnPressed{
                        override fun onPressed(carsData: CarsData) {
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, CarDetailsFragment.newInstance(carsData))
                                .commit()
                        }
                    }, object :CarsAdapter.OnSelected{
                        override fun onSelect(carsData: CarsData) {
                            if (carsData.status){
                                ChoosedCarsList.add(carsData)
                            }else{
                                ChoosedCarsList.remove(carsData)
                            }
                        }
                    })

                    val layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.carsrecyclerview.layoutManager = layoutManager
                    binding.carsrecyclerview.adapter = carsAdapter
                }

                if (string=="Toyota"){
                    val carsAdapter = CarsAdapter(ToyotaCars(), object : CarsAdapter.OnPressed{
                        override fun onPressed(carsData: CarsData) {
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, CarDetailsFragment.newInstance(carsData))
                                .commit()
                        }
                    }, object :CarsAdapter.OnSelected{
                        override fun onSelect(carsData: CarsData) {
                            if (carsData.status){
                                ChoosedCarsList.add(carsData)
                            }else{
                                ChoosedCarsList.remove(carsData)
                            }
                        }
                    })

                    val layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.carsrecyclerview.layoutManager = layoutManager
                    binding.carsrecyclerview.adapter = carsAdapter
                }

                if (string=="Volvo"){
                    val carsAdapter = CarsAdapter(VolvoCars(), object : CarsAdapter.OnPressed{
                        override fun onPressed(carsData: CarsData) {
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, CarDetailsFragment.newInstance(carsData))
                                .commit()
                        }
                    }, object :CarsAdapter.OnSelected{
                        override fun onSelect(carsData: CarsData) {
                            if (carsData.status){
                                ChoosedCarsList.add(carsData)
                            }else{
                                ChoosedCarsList.remove(carsData)
                            }
                        }
                    })

                    val layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.carsrecyclerview.layoutManager = layoutManager
                    binding.carsrecyclerview.adapter = carsAdapter
                }

                if (string=="Bugatti"){
                    val carsAdapter = CarsAdapter(BugattiCars(), object : CarsAdapter.OnPressed{
                        override fun onPressed(carsData: CarsData) {
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, CarDetailsFragment.newInstance(carsData))
                                .commit()
                        }
                    }, object :CarsAdapter.OnSelected{
                        override fun onSelect(carsData: CarsData) {
                            if (carsData.status){
                                ChoosedCarsList.add(carsData)
                            }else{
                                ChoosedCarsList.remove(carsData)
                            }
                        }
                    })

                    val layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.carsrecyclerview.layoutManager = layoutManager
                    binding.carsrecyclerview.adapter = carsAdapter
                }

                if (string=="Honda"){
                    val carsAdapter = CarsAdapter(HondaCars(), object : CarsAdapter.OnPressed{
                        override fun onPressed(carsData: CarsData) {
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, CarDetailsFragment.newInstance(carsData))
                                .commit()
                        }
                    }, object :CarsAdapter.OnSelected{
                        override fun onSelect(carsData: CarsData) {
                            if (carsData.status){
                                ChoosedCarsList.add(carsData)
                            }else{
                                ChoosedCarsList.remove(carsData)
                            }
                        }
                    })

                    val layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.carsrecyclerview.layoutManager = layoutManager
                    binding.carsrecyclerview.adapter = carsAdapter
                }
            }
        })
        binding.dealsRecyclerview.adapter = dealsCategoriesAdapter

        //Related to Cars RecyclerView
        val carsAdapter = CarsAdapter(CarsList, object : CarsAdapter.OnPressed{
            override fun onPressed(carsData: CarsData) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, CarDetailsFragment.newInstance(carsData))
                    .commit()
            }
        }, object :CarsAdapter.OnSelected{
            override fun onSelect(carsData: CarsData) {
                if (carsData.status){
                    ChoosedCarsList.add(carsData)
                }else{
                    ChoosedCarsList.remove(carsData)
                }
            }
        })

        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.carsrecyclerview.layoutManager = layoutManager
        binding.carsrecyclerview.adapter = carsAdapter

        //Related to Offer Cars
        binding.SeeAllSO.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, SpecialOffersFragment())
                .commit()
        }

        //Related to Search
//        binding.search.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.fragmentContainerView, SearchFragment())
//                .commit()
//        }

        return binding.root
    }
    private fun Cars() {
        CarsList.add(CarsData(R.drawable.bmw_x8_m, "BMW X8 M", "155 000$", "4.9", "BMW",false))
        CarsList.add(CarsData(R.drawable.bmw_8_series, "BMW 8 Series", "155 000$", "4.7", "Mercedes",false))
        CarsList.add(CarsData(R.drawable.bmw_x1_specs, "BMW M4 Series", "155 000$", "4.5", "Toyota",false))
        CarsList.add(CarsData(R.drawable.bmw_i8, "BMW i8 Specs", "155 000$", "4.4", "Tesla",false))
        CarsList.add(CarsData(R.drawable.bmw_x6, "BMW X6 M", "155 000$", "4.8", "Honda",false))
        CarsList.add(CarsData(R.drawable.bmw_m4_series, "BMW M4 Series", "155 000$", "4.5", "Volvo",false))
    }

    private fun MercedesCars():MutableList<CarsData>{
        val list = mutableListOf<CarsData>()
        for (i in 0..CarsList.size-1){
            if (CarsList[i].toifa=="Mercedes"){
                list.add(CarsList[i])
            }
        }
        return list
    }

    private fun BMWCars():MutableList<CarsData>{
        val list = mutableListOf<CarsData>()
        for (i in 0..CarsList.size-1){
            if (CarsList[i].toifa=="BMW"){
                list.add(CarsList[i])
            }
        }
        return list
    }

    private fun TeslaCars():MutableList<CarsData>{
        val list = mutableListOf<CarsData>()
        for (i in 0..CarsList.size-1){
            if (CarsList[i].toifa=="Tesla"){
                list.add(CarsList[i])
            }
        }
        return list
    }
    private fun ToyotaCars():MutableList<CarsData>{
        val list = mutableListOf<CarsData>()
        for (i in 0..CarsList.size-1){
            if (CarsList[i].toifa=="Toyota"){
                list.add(CarsList[i])
            }
        }
        return list
    }

    private fun VolvoCars():MutableList<CarsData>{
        val list = mutableListOf<CarsData>()
        for (i in 0..CarsList.size-1){
            if (CarsList[i].toifa=="Volvo"){
                list.add(CarsList[i])
            }
        }
        return list
    }

    private fun BugattiCars():MutableList<CarsData>{
        val list = mutableListOf<CarsData>()
        for (i in 0..CarsList.size-1){
            if (CarsList[i].toifa=="Bugatti"){
                list.add(CarsList[i])
            }
        }
        return list
    }

    private fun HondaCars():MutableList<CarsData>{
        val list = mutableListOf<CarsData>()
        for (i in 0..CarsList.size-1){
            if (CarsList[i].toifa=="Honda"){
                list.add(CarsList[i])
            }
        }
        return list
    }

    private fun Categories(): MutableList<String> {
        val s = mutableListOf<String>()
        s.add("All")
        s.add("Mercedes")
        s.add("Tesla")
        s.add("BMW")
        s.add("Toyota")
        s.add("Volvo")
        s.add("Bugatti")
        s.add("Honda")
        return s
    }

    private fun setOnboardingItems() {
        offerCarsAdapter = OfferCarsAdapter(
            listOf(
                OfferCarsInfo("20%", "Week Deals!", "Get a new car discount, only valid this week", R.drawable.mercedescar),
                OfferCarsInfo("20%", "Week Deals!", "Get a new car discount, only valid this week", R.drawable.mercedescar),
                OfferCarsInfo("20%", "Week Deals!", "Get a new car discount, only valid this week", R.drawable.mercedescar),
                OfferCarsInfo("20%", "Week Deals!", "Get a new car discount, only valid this week", R.drawable.mercedescar),
                OfferCarsInfo("20%", "Week Deals!", "Get a new car discount, only valid this week", R.drawable.mercedescar),
                OfferCarsInfo("20%", "Week Deals!", "Get a new car discount, only valid this week", R.drawable.mercedescar)
            ) as MutableList<OfferCarsInfo>
        )
        binding.offersViewpager.adapter = offerCarsAdapter
        binding.offersViewpager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    CheckIndicator(position)
                }
            }
        )
        (binding.offersViewpager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
    }

    private fun setIndicators(){
        val indicators = arrayOfNulls<ImageView>(offerCarsAdapter.itemCount)
        val layoutParams: LinearLayoutCompat.LayoutParams =
            LinearLayoutCompat.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices){
            indicators[i] = ImageView(requireContext())
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator2
                    )
                )
                it.layoutParams = layoutParams
                binding.indicatorLayout.addView(it)
            }
        }
    }

    private fun CheckIndicator(position: Int){
        val childCount = binding.indicatorLayout.childCount
        for (i in 0..childCount-1){
            val imageView = binding.indicatorLayout.getChildAt(i) as ImageView
            if (i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator
                    )
                )
            } else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator2
                    )
                )
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}